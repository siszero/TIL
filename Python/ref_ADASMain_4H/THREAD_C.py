from PyQt5 import QtCore
import can
import cantools
import asyncio
import time
from crc import Calculator, Configuration

e_db_Dic = {}

# CRC-16
config_16 = Configuration(
        width=16,
        polynomial=0x1021,
        init_value=0xffff,
        final_xor_value=0x0,
        reverse_input=False,
        reverse_output=False,
    )
calculator_16 = Calculator(config_16)

# CRC-8
config_8 = Configuration(
    width=8,
    polynomial=0x1D,
    init_value=0x00,
    final_xor_value=0xFF,
    reverse_input=False,
    reverse_output=False,
)
calculator_8 = Calculator(config_8)


# framId : ID(DEC), alvCnt, length : 8,16,32 , bytedata : b'\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00'
def GetCRC16Val_HGM(framId, alvCnt, length, bytedata):
    new_data = bytearray(bytedata)[2:] + bytearray([0, 0])
    new_data[length - 1] = (framId + 0xF800) >> 8  # ID
    new_data[length - 2] = (framId + 0XF800) & 0xFF  # ID_H
    new_data[0] = alvCnt
    crcVal = calculator_16.checksum(new_data)
    print("new_data  ", new_data)
    print("new_data[length - 1]   ", new_data[length - 1])
    print("new_data[length - 2]  ", new_data[length - 2])
    print("new_data[0]   ", new_data[0])
    print("crcval    ", crcVal)
    return crcVal

def GetCRC8Val_HGM(framId, alvCnt, length, bytedata):
    new_data = bytearray([0, 0]) + bytearray(bytedata)[1:]
    new_data[0] = (framId + 0XF800) & 0xFF  # ID
    new_data[1] = (framId + 0xF800) >> 8  # ID_H
    new_data[2] = (alvCnt << 4)
    crcVal = calculator_8.checksum(new_data)

    return crcVal

# s_time = time.time()

class Worker(QtCore.QThread, QtCore.QObject):  # Worker Thread
    def __init__(self, message_dic, bus):
        super().__init__()
        self.message_dic = message_dic          # Model.data_dic
        self.select_gui_dic = None
        self.bus = bus
        self.db = None
    def SelectedGuiDataUpdate(self, selectedDic):
        self.select_gui_dic = selectedDic   # CONTROLLER.getSelectedGUIDic(name)
    def updateCanDBPath(self, candb):
        self.db = cantools.database.load_file(candb)

    def run(self):
        asyncio.run(self.async_main(), debug=True)

    async def async_main(self):
        while True:
            for i in [asyncio.create_task(self.signal_Can(key)) for key in self.message_dic.keys()
                      if (self.message_dic[key][11] == 'c' and self.message_dic[key][7] == 'Cyclic')]:
                await i

    async def signal_Can(self, key):
        while True:
            crcKey = None
            # crc, alvcnt 초기화
            for sig in self.message_dic[key][10]:
                if 'Crc' in sig and 'Val' in sig:
                    crcKey = sig
                    self.message_dic[key][12] = 0
                elif 'AlvCnt' in sig and 'Val' in sig:
                    self.message_dic[key][13] = 0

            boFind = False
            if self.select_gui_dic is not None:
                if key in self.select_gui_dic:
                    print("self.select_gui_dic : ", self.select_gui_dic)
                    boFind = True
            if boFind is True:
                if crcKey is not None:
                    print("self.select_gui_dic[key][9]  ", self.select_gui_dic[key][9])
                    # for gui in self.select_gui_dic[key].length:
                    newMsgDic = self.db.decode_message(self.message_dic[key][5], bytes(self.select_gui_dic[key][9]))

                    alvCntIdx= -1

                    for newKey, newItem in newMsgDic.items():
                        if 'AlvCnt' in newKey:
                            alvCntIdx = self.message_dic[key][13]
                            # newMsgDic[newKey] = alvCntIdx
                            if self.message_dic[key][8] == 8:
                                alvCntIdx = alvCntIdx + 1
                                if alvCntIdx == 16:
                                    alvCntIdx = 0
                            else:
                                alvCntIdx = alvCntIdx + 1
                                if alvCntIdx == 256:
                                    alvCntIdx = 0
                            newMsgDic[newKey] = alvCntIdx

                    for newKey, item in newMsgDic.items():
                        if 'Crc' in newKey and 'Val' in newKey:
                            if self.message_dic[key][8] == 8:
                                newMsgDic[newKey] = GetCRC8Val_HGM(self.message_dic[key][5], alvCntIdx, self.message_dic[key][8], bytes(self.select_gui_dic[key][9]))
                            else:
                                newMsgDic[newKey] = GetCRC16Val_HGM(self.message_dic[key][5], alvCntIdx, self.message_dic[key][8], bytes(self.select_gui_dic[key][9]))
                            encode_msg = self.db.encode_message(self.message_dic[key][5], newMsgDic)
                # print("newMSG   ", newMsgDic)
                print("key:   ", self.select_gui_dic[key])
                if self.select_gui_dic[key][1] == 'ON':
                    # encode_msg = self.db.encode_message(self.message_dic[key][5], newMsgDic)
                    # print("key:   ", self.select_gui_dic[key][1])
                    # print("9:  ", self.select_gui_dic[key][9])
                    self.bus.send(can.Message(arbitration_id=self.message_dic[key][5], data=encode_msg, is_extended_id=False, is_fd=True))
                    print(time.time() - self.start, key, self.message_dic[key][6] / 1000, self.select_gui_dic[key][9])
            else:
                None
            await asyncio.sleep(self.message_dic[key][6] / 1000)
