import cantools
import csv
import VIEW

data_dic = {}

def LoadDBC(file_address, can_type):
    if file_address != '':
        dbc_file = cantools.database.load_file(file_address)

        for message in dbc_file.messages:
            if message.senders[0] == 'CLU_MM' or message.senders[0] == 'CLU':
                continue
            data_dic[message.name] = [[0 for _ in range(len(message.signals))],     # index : 0
                                      'OFF',                                        # index : 1
                                      [j.start for j in message.signals],           # index : 2
                                      [j.minimum for j in message.signals],         # index : 3
                                      [j.maximum for j in message.signals],         # index : 4
                                      message.frame_id,                             # index : 5
                                      message.cycle_time,                           # index : 6
                                      message.send_type,                            # index : 7
                                      message.length,                               # index : 8
                                      [0] * message.length,                         # index : 9
                                      message.signal_tree,                          # index : 10
                                      can_type,                                     # index : 11
                                      # {},                                            # index : 12 (message.crckey)
                                      0,
                                      0,                                            # index : 13 (message.alvcnt)
                                      '']                                           # index : 14
        return data_dic

def SaveCSV(file_address, save_dic):
    with open(file_address, 'w', newline='', encoding='UTF8') as csv_file:
        csv_writer = csv.writer(csv_file, delimiter=',', quotechar='"')
        for key in save_dic.keys():
            for message in save_dic[key]:
                csv_writer.writerow([key] + [message] + save_dic[key][message])
            csv_writer.writerow([''])

def LoadCSV(file_address):      # {gui_name : [{message_name_1 : [data_1]}]}
    with open(file_address, newline='', encoding='UTF8') as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',', quotechar='"')
        save_dic = {}
        temp = ''
        for row in csv_reader:
            if len(row) != 0 and not (row == ['']):
                if row[0] == '':
                    pass
                else:
                    if temp != row[0]:
                        save_dic[row[0]] = {row[1]: [CSVFormatChange(row[i]) for i in range(2, 15)]}
                        temp = row[0]
                    elif temp == row[0]:
                        save_dic[row[0]][row[1]] = [CSVFormatChange(row[i]) for i in range(2, 15)]
    return save_dic

def CSVFormatChange(content):
    if content.startswith('[') is True and content.endswith(']') is True:
        if '\'' in content:
            temp_list = str(content)[2:len(content) - 2].split('\', \'')
        else:
            temp = str(content)[1:len(content) - 1].split(', ')
            if 'None' not in content:
                temp_list = list(map(float, temp))
                temp_list = list(map(int, temp_list))
            else:
                temp_list = []
                for i in range(len(temp)):
                    if temp[i] != 'None':
                        temp_list.append(int(temp[i]))
                    else:
                        temp_list.append(None)
    elif content.isdigit() is True:
        temp_list = int(content)
    else:
        temp_list = content

    return temp_list