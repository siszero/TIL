import asyncio

import can
import cantools
import time
import copy
from crc import Calculator, Crc16, Configuration

config_16 = Configuration(
    width=16,
    polynomial=0x1021,
    init_value=0xffff,
    final_xor_value=0x0,
    reverse_input=False,
    reverse_output=False,
)
calculator_16 = Calculator(config_16)

config_8 = Configuration(
    width=8,
    polynomial=0x1D,
    init_value=0x00,
    final_xor_value=0xFF,
    reverse_input=False,
    reverse_output=False,
)
calculator_8 = Calculator(config_8)

e_db = cantools.database.load_file('20221212_STD_DB_CAR_2021_FD_E_CLU_v1.8.dbc')
#m_db = cantools.database.load_file('CAR_2021_HS_M.dbc')

bus1 = can.interface.Bus(bustype='vector', channel=0, app_name='CANalyzer', bitrate=500000, fd=True, data_bitrate=2000000)  # C-can
#bus2 = can.interface.Bus(bustype='vector', channel=1, app_name='CANalyzer', bitrate=500000)  # M-can

e_db_Dic = {}

for msg in e_db.messages:
    print("msg : ", msg)        # message('ALDC_01_100ms', 0x224, False, 32, {None: '[P] Periodic'})
    e_db_Dic[msg.frame_id] = {}
    print("msg.frame_id : ", msg.frame_id)     # id dec 값
    # msg.frame_id = message_dic[key][5]

    dic = e_db_Dic[msg.frame_id]
    dic['name'] = msg.name          # message_list에 있는 message 하나하나
    dic['length'] = msg.length      # 8비트인지 16비트인지 32비트인지
    dic['data'] = {}
    dic['AlvCnt'] = 0

    if msg.cycle_time is None:
        dic['cycle_time'] = None
    else:
        dic['cycle_time'] = msg.cycle_time / 1000
    for signal in msg.signals:
        dic['data'][signal.name] = 0
        # print("dicccc :  ", dic['data'][signal.name])
        #if( signal.name == 'ILCULH_System_Sta') or (signal.name == 'ILCULH_IFSOpt_Sta'):
         #   dic['data'][signal.name] = 1

def GetCRC16Val_HGM(framId, alvCnt, length, bytedata):
    print("bytedata: ", bytedata)
    new_data = bytearray(bytedata)[2:] + bytearray([0, 0])
    new_data[length - 1] = (framId + 0xF800) >> 8   # ID
    new_data[length - 2] = (framId + 0XF800) & 0xFF #ID_H
    new_data[0] = alvCnt
    crcVal = calculator_16.checksum(new_data)

    return crcVal

def GetCRC8Val_HGM(framId, alvCnt, length, bytedata):
    new_data = bytearray([0,0]) + bytearray(bytedata)[1:]
    new_data[0] = (framId + 0XF800) & 0xFF  # ID
    new_data[1] = (framId + 0xF800) >> 8 #ID_H
    new_data[2] = (alvCnt << 4)
    crcVal = calculator_8.checksum(new_data)

    return crcVal

async def sendMessage(msgId):   # msgId 는 0x65 임. 음 그러면 hex
    while True:
        IsCRCSig = False
        crcKey = None
        AlvCntKey = None

        for sig in e_db_Dic[msgId]['data']:
            if 'Crc' in sig and 'Val' in sig:
                crcKey = sig
                print("crckey : ", crcKey)
                e_db_Dic[msgId]['data'][crcKey] = 0
            elif 'AlvCnt' in sig and 'Val' in sig:
                AlvCntKey = sig
                e_db_Dic[msgId]['data'][AlvCntKey] = 0

        encode_msg = e_db.encode_message(msgId, e_db_Dic[msgId]['data'])
        print(e_db_Dic[msgId]['data'])
        if crcKey is not None:
            e_db_Dic[msgId]['data'][AlvCntKey] = e_db_Dic[msgId]['AlvCnt']
            print("alvcnt : ", e_db_Dic[msgId]['AlvCnt'])
            if e_db_Dic[msgId]['length'] == 8:
                e_db_Dic[msgId]['data'][crcKey] = GetCRC8Val_HGM(msgId, e_db_Dic[msgId]['AlvCnt'], e_db_Dic[msgId]['length'], encode_msg)
                e_db_Dic[msgId]['AlvCnt'] = e_db_Dic[msgId]['AlvCnt'] + 1 if e_db_Dic[msgId]['AlvCnt'] < 15 else 0
            else:
                e_db_Dic[msgId]['data'][crcKey] = GetCRC16Val_HGM(msgId, e_db_Dic[msgId]['AlvCnt'], e_db_Dic[msgId]['length'], encode_msg)
                e_db_Dic[msgId]['AlvCnt'] = e_db_Dic[msgId]['AlvCnt'] + 1 if e_db_Dic[msgId]['AlvCnt'] < 255 else 0

            encode_msg = e_db.encode_message(msgId, e_db_Dic[msgId]['data'])
        send_msg = can.Message(arbitration_id=msgId, data=encode_msg, is_extended_id=False, is_fd=True)
        bus1.send(send_msg)

        if e_db_Dic[msgId]['cycle_time'] is not None:
            await asyncio.sleep(e_db_Dic[msgId]['cycle_time'])


#send_msg = can.Message(arbitration_id=101, data=send_data, is_extended_id=False, is_fd=True, channel=0, bitrate_switch=True)
#bus1.send_periodic(send_msg, e_db_Cycle_Dic[101] / 1000)
#bus1.send(send_msg)
s_time = time.time()

async def foo1(val):
    print("_foo1:" + str(val))
    await asyncio.sleep(1)

async def foo_time(val):
    await asyncio.sleep(val * 10)
    print("_foo:" + str(val) + ', time:'+str(time.time() - s_time))


async def foo2(val):
    print("_foo2:" + str(val*10))
    await asyncio.sleep(2)

async def async_tasks():
    tasks = [asyncio.create_task(foo_time(i)) for i in range(0, 10)]
    for task in tasks:
        await task

async def async_main():
    val = 0
    while True:
        await foo1(val)
        await foo1(val*10)
        val += 1

asyncio.run(sendMessage(0x65))


#asyncio.run(async_tasks())
'''
while True:
    for key, item in e_db_Dic.items():
        try:
            send_data = e_db.encode_message(key, item)
        except:
            continue
        send_msg = can.Message(arbitration_id=key, data=send_data)
        if e_db_Cycle_Dic[key] is not None:
            bus1.send_periodic(send_msg, e_db_Cycle_Dic[key] / 1000)
            time.sleep(2)
        else:
            bus1.send(send_msg)
b = 0
    #bus1.send(msg)

while True:
    for msg in e_db.messages:
        if msg.senders[0] == 'CGW_CCU':
            message = can.Message(arbitration_id=msg.frame_id, data=)
            bus1.send(message)
'''
'''
for msg in bus1:
    print(e_db.decode_message(msg.arbitration_id, msg.data))


while True:
    msg = bus1.recv(1)
    print(msg)
    time.sleep(10)

for msg in e_db.messages:
    if msg.senders[0] == 'CGW_CCU':
        bus_msg = db.encode_message('Foo', {'Bar': 1, 'Fum': 5.0})
        #message = can.Message(arbitration_id=msg.frame_id, data=)
        bus1.send(msg)
'''