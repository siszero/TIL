import MODEL
import copy
import VIEW
import THREAD_C
import THREAD_M
import can

global data_dic
global save_dic
global message_table_list
global gui_list
global search_message_list

image_address = ''

def InitSetting():
    global data_dic
    global save_dic
    global message_table_list
    global image_address
    global search_message_list
    global gui_list

    # data_dic = {}
    save_dic = {}
    message_table_list = []
    image_address = ''
    search_message_list = []
    gui_list = []

def InitSetting_Reset():
    # data_dic[][0] = [0 for _ in data_dic[][0]]
    global message_table_list
    global search_message_list

    message_table_list = []
    search_message_list = []

def LoadDBCData(file_address, can_type):
    global data_dic
    data_dic = copy.deepcopy(MODEL.LoadDBC(file_address, can_type))

def LoadCSVData(file_address):
    global save_dic
    global gui_list

    save_dic = copy.deepcopy(MODEL.LoadCSV(file_address))
    gui_list = list(save_dic.keys())

def LoadGui(name):
    global image_address
    global message_table_list

    for message in list(set(data_dic.keys()) - set(save_dic[name].keys())):
        data_dic[message][0] = [0 for _ in data_dic[message][0]]
        data_dic[message][9] = [0 for _ in data_dic[message][9]]
        data_dic[message][1] = 'OFF'

    for message in save_dic[name].keys():
        data_dic[message] = copy.deepcopy(save_dic[name][message])
        image_address = save_dic[name][message][13]

    message_table_list = list(save_dic[name].keys())

def SaveCSV(file_address):
    MODEL.SaveCSV(file_address, save_dic)

def SaveGui(gui_name):
    save_dic[gui_name] = {}
    for message in message_table_list:
        save_dic[gui_name][message] = copy.deepcopy(data_dic[message])
        save_dic[gui_name][message][14] = image_address

# def SaveImageAddress(address):
#     global image_address
#     image_address = address

def GetMessageList():
    return list(data_dic.keys())

def GetSearchMessageList():
    return search_message_list

def GetMessageTableList():
    return message_table_list

def GetGuiList():
    return gui_list

def GetSignalList(message):
    return data_dic[message][10]

def GetSignalValueList(message):
    return data_dic[message][0]

def GetSignalState(message):
    return data_dic[message][1]

def GetImageAddress():
    return image_address

def CheckSearchMessageList(name):
    global search_message_list
    search_message_list = []
    for message in list(data_dic.keys()):
        if name.lower() in message.lower() or any([name.lower() in signal.lower() for signal in data_dic[message][10]]):
            search_message_list.append(message)

def CheckMessageTableList(content):
    if content not in message_table_list:
        message_table_list.append(content)
        return True
    else:
        return False

def CheckGuiName(name):
    if len(name) == 0:
        return False, 'Please type in the title'
    elif name in gui_list:
        return False, 'Title already exist'
    elif len(message_table_list) == 0:
        return False, 'None of the signals are activated'
    else:
        return True, ''

def AddMessageTableList(content):
    message_table_list.append(content)

def AddGuiName(name):
    gui_list.append(name)

def EditSignalValue(message, row, val):
    if data_dic[message][3][row] is None or data_dic[message][4][row] is None:
        pass
    elif val < int(data_dic[message][3][row]):
        val = int(data_dic[message][3][row])
    elif val > int(data_dic[message][4][row]):
        val = int(data_dic[message][4][row])

    data_dic[message][0][row] = val

    return val

def DataCalculate(message):
    total_sum = sum(int(data_dic[message][0][i]) << data_dic[message][2][i]
                    for i in range(len(data_dic[message][0])))
    little_hex = str(BigEndianToLittleEndian((str(hex(total_sum)[2:])).zfill(data_dic[message][8] * 2)))
    data_dic[message][9] = [int(little_hex[i:i + 2], 16) for i in range(0, len(little_hex), 2)]

    if data_dic[message][7] != 'Cyclic':        # 주기적이지 않은 단발성 메시지 송신
        if data_dic[message][11] == 'c':
            # 코드 수정 필요
            VIEW.bus1.send(can.message(arbitration_id= message.message_dic[message.self.cur_cell.text()][5],
                                  data=message.self.message_dic[message.self.cur_cell.text()][9],
                                  extended_id=False))
        elif data_dic[message][11] == 'm':
            VIEW.bus2.send(can.message(arbitration_id=message.message_dic[message.cur_cell.text()][5], data=message.message_dic[message.cur_cell.text()][9], extended_id=False))

def BigEndianToLittleEndian(val):
    if len(val) % 2 == 1:
        val = '0' + val
    else:
        pass
    little_hex = bytearray.fromhex(val)
    little_hex.reverse()
    str_little = ''.join(format(x, '02x') for x in little_hex)
    return str_little

def UpdateState(message, state):
    data_dic[message][1] = state

def DeleteMessageData(content):
    data_dic[content][0] = [0 for _ in data_dic[content][0]]
    data_dic[content][9] = [0 for _ in data_dic[content][9]]
    data_dic[content][1] = 'OFF'
    message_table_list.remove(content)

def DeleteGuiData(name):
    del save_dic[name]
    gui_list.remove(name)

# Delete 버튼을 눌렀을 때, 해당 행만 삭제하기 위함.
def DeleteGuiID(name):
    # del save_dic[name]
    gui_list.remove(name)

# ALL DELETE
def DeleteAllGuiID():
    # save_dic.clear()
    gui_list.clear()

def getSelectedGUIDic(SelKey):
    if SelKey not in save_dic:
        return None
    else:
        return save_dic[SelKey]

InitSetting()
