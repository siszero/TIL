from PyQt5 import QtCore
import can
import asyncio
import time

class Worker(QtCore.QThread, QtCore.QObject):  # Worker Thread
    def __init__(self, message_dic, bus):
        super().__init__()
        self.message_dic = message_dic
        self.select_gui_dic = None
        self.bus = bus

    def updateCanDBPath(self, candb):
        self.candb = candb
        # self.candb = cantools.database.load_file(self.candb)

    def SelectedGuiDataUpdate(self, selectedDic):
        self.select_gui_dic = selectedDic

    def run(self):
        asyncio.run(self.async_main(), debug=True)

    async def async_main(self):
        self.start = time.time()
        for i in [asyncio.create_task(self.signal_Can(key)) for key in self.message_dic.keys()
                  if (self.message_dic[key][11] == 'c' and self.message_dic[key][7] == 'Cyclic')]:
            await i

    async def signal_Can(self, key):
        while True:

            if self.select_gui_dic is not None:
                if key in self.select_gui_dic:
                    print(self.select_gui_dic[key][9])
                    # decode_msg = self.candb.decode_message(key, self.select_gui_dic[key][9])
                    # print("decode_msg : ", decode_msg)
                    if self.select_gui_dic[key][1] == 'ON':
                        self.bus.send(
                            can.Message(arbitration_id=self.message_dic[key][5], data=self.select_gui_dic[key][9], is_extended_id=False))
                        print(time.time() - self.start, key, self.message_dic[key][6] / 1000, self.select_gui_dic[key][9])

            await asyncio.sleep(self.message_dic[key][6] / 1000)
