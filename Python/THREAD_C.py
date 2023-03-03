from PyQt5 import QtCore
import can
import asyncio
import time

class Worker(QtCore.QThread, QtCore.QObject):  # Worker Thread
    def __init__(self, message_dic):
        super().__init__()
        self.message_dic = message_dic

    def run(self):
        asyncio.run(self.async_main())

    async def async_main(self):
        self.start = time.time()

        for i in [asyncio.create_task(self.signal_Can(key)) for key in self.message_dic.keys()
                  if(self.message_dic[key][11] == 'c' and self.message_dic[key][7] == 'Cyclic')]:
            await i

    async def signal_Can(self, key):
        while True:
            if self.message_dic[key][1] == 'ON':
                bus1.send(can.Message(arbitration_id=self.message_dic[key][5], data=self.message_dic[key][9], extended_id=False))
                print(time.time() - self.start, key, self.message_dic[key][6] / 1000, self.message_dic[key][9])
            else:
                pass
            await asyncio.sleep(self.message_dic[key][6] / 1000)

bus1 = can.interface.Bus(bustype='vector', app_name='CANalyzer', channel=0, bitrate=500000)  # C-can