from PyQt5.QtCore import Qt, QEvent, QRect
from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5 import uic, QtGui
from PIL import ImageGrab
import sys
import os

Basic_UI = uic.loadUiType("Basic_UI.ui")[0]

class Set_UI(QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)

        self.central_widget = Central_Widget()
        self.setCentralWidget(self.central_widget)
        self.menubar_setting()
        self.show()

    def menubar_setting(self):
        new_action = QAction('&New', self)
        new_action.setShortcut('Ctrl+N')
        new_action.triggered.connect(self.central_widget.NewFile)
        open_action = QAction('&Open', self)
        open_action.setShortcut('Ctrl+O')
        open_action.triggered.connect(self.central_widget.OpenFile)
        save_action = QAction('&Save', self)
        save_action.setShortcut('Ctrl+s')
        save_action.triggered.connect(self.central_widget.SaveFile)
        save_as_action = QAction('&Save as', self)
        save_as_action.setShortcut('Ctrl+Shift+s')
        save_as_action.triggered.connect(self.central_widget.SaveAsFile)
        exitAct = QAction('&Exit', self)
        exitAct.setShortcut('Ctrl+Q')
        exitAct.triggered.connect(qApp.quit)

        menuBar = self.menuBar()
        file_menu = QMenu('&File', self)
        file_menu.addAction(new_action)
        file_menu.addAction(open_action)
        file_menu.addAction(save_action)
        file_menu.addAction(save_as_action)
        file_menu.addAction(exitAct)
        menuBar.addMenu(file_menu)

class MySwitch(QPushButton):    # 신호 On/Off 를 위한 스위치
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setCheckable(True)
        self.setMinimumWidth(66)
        self.setMinimumHeight(22)

    def paintEvent(self, event):
        label = "ON" if self.isChecked() else "OFF"
        bg_color = Qt.green if self.isChecked() else Qt.red

        radius = 10
        width = 32
        center = self.rect().center()

        painter = QtGui.QPainter(self)
        painter.setRenderHint(QtGui.QPainter.Antialiasing)
        painter.translate(center)
        painter.setBrush(QtGui.QColor(0, 0, 0))

        pen = QtGui.QPen(Qt.black)
        pen.setWidth(2)
        painter.setPen(pen)

        painter.drawRoundedRect(QRect(-width, -radius, 2 * width, 2 * radius), radius, radius)
        painter.setBrush(QtGui.QBrush(bg_color))
        sw_rect = QRect(-radius, -radius, width + radius, 2 * radius)
        if not self.isChecked():
            sw_rect.moveLeft(-width)
        painter.drawRoundedRect(sw_rect, radius, radius)
        painter.drawText(sw_rect, Qt.AlignCenter, label)

class Central_Widget(QWidget, Basic_UI):
    def __init__(self):
        super().__init__()

        self.initUI()
        self.EventFunction()

        self.click_message = ''
        self.gui_name = ''
        self.file_address = ''
        self.file_open_status = False

    def initUI(self):
        self.setupUi(self)

        main_layout = QHBoxLayout()

        ###############################outer_vbox1###############################
        outer_vbox1 = QVBoxLayout()
        inner_vbox1 = QVBoxLayout()

        inner_vbox1.addWidget(self.search_box)
        inner_vbox1.addWidget(self.search_table)
        inner_vbox1.addWidget(self.clear_btn)
        outer_vbox1.addLayout(inner_vbox1)

        main_layout.addLayout(outer_vbox1)

        self.search_box.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.search_box.setFixedWidth(170)
        self.search_table.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Expanding)
        self.search_table.setFixedWidth(170)
        self.search_table.setDragDropOverwriteMode(False)
        self.search_table.installEventFilter(self)
        self.clear_btn.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.clear_btn.setFixedWidth(170)

        ###############################outer_vbox2###############################
        outer_vbox2 = QVBoxLayout()
        inner_hbox2 = QHBoxLayout()

        inner_hbox2.addWidget(self.c_can_load_btn)
        inner_hbox2.addWidget(self.m_can_load_btn)
        outer_vbox2.addLayout(inner_hbox2)
        outer_vbox2.addWidget(self.message_table)

        main_layout.addLayout(outer_vbox2)

        self.message_table.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Expanding)
        self.message_table.setFixedWidth(245)
        self.message_table.setColumnWidth(0, 155)
        self.message_table.setColumnWidth(1, 70)
        self.message_table.setDragDropMode(QAbstractItemView.NoDragDrop)
        self.message_table.setDragDropOverwriteMode(False)
        self.message_table.installEventFilter(self)

        ###############################outer_vbox3###############################
        outer_vbox3 = QVBoxLayout()
        inner_hbox3 = QHBoxLayout()

        inner_hbox3.addWidget(self.gui_name_box)
        inner_hbox3.addWidget(self.gui_save_btn)
        outer_vbox3.addWidget(self.signal_table)
        outer_vbox3.addLayout(inner_hbox3)

        main_layout.addLayout(outer_vbox3)

        self.signal_table.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Expanding)
        self.signal_table.setFixedWidth(250)
        self.signal_table.setHorizontalHeaderLabels(['Signal', 'Dec', 'Hex'])
        self.signal_table.setColumnWidth(0, 163)
        self.signal_table.setColumnWidth(1, 20)
        self.signal_table.setColumnWidth(2, 20)
        self.gui_name_box.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.gui_name_box.setPlaceholderText('Please Input Name')
        self.gui_save_btn.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.gui_save_btn.setEnabled(True)

        ###############################outer_vbox4###############################
        outer_vbox4 = QVBoxLayout()

        outer_vbox4.addWidget(self.gui_table)

        main_layout.addLayout(outer_vbox4)

        self.current_file_label_2.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.gui_table.setHorizontalHeaderLabels(['GUI ID'])
        self.gui_table.setColumnWidth(0, 260)
        self.gui_table.installEventFilter(self)

        ###############################outer_hbox5###############################
        outer_vbox5 = QVBoxLayout()
        inner_hbox5 = QHBoxLayout()
        inner_hbox5_ = QHBoxLayout()

        inner_hbox5.addWidget(self.current_file_label)
        inner_hbox5.addWidget(self.current_file_label_2)
        inner_hbox5_.addWidget(self.image_load_btn)
        inner_hbox5_.addWidget(self.image_remove_btn)
        outer_vbox5.addLayout(inner_hbox5)
        outer_vbox5.addWidget(self.image_label)
        outer_vbox5.addLayout(inner_hbox5_)

        main_layout.addLayout(outer_vbox5)

        self.current_file_label.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.current_file_label.setFixedWidth(71)
        self.current_file_label_2.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.current_file_label_2.setFixedWidth(310)
        self.image_label.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Expanding)
        self.image_label.setFixedWidth(381)
        self.image_label.installEventFilter(self)
        self.image_load_btn.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.image_load_btn.setFixedWidth(171)##171
        self.image_load_btn.setEnabled(True)
        self.image_remove_btn.setSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        self.image_remove_btn.setFixedWidth(171)
        self.image_remove_btn.setEnabled(True)

        ###############################ain_Layout###############################

        self.setLayout(main_layout)

        main_layout.addStretch()

        ########################################################################

    def EventFunction(self):
        self.c_can_load_btn.clicked.connect(lambda: self.LoadDbcData('c'))
        self.m_can_load_btn.clicked.connect(lambda: self.LoadDbcData('m'))
        self.search_box.textChanged.connect(lambda: self.SearchName())
        self.clear_btn.clicked.connect(lambda: self.ResetAll())
        self.search_table.cellDoubleClicked.connect(lambda: self.AddMessage())
        self.message_table.itemSelectionChanged.connect(lambda: self.SelectMessage())
        self.signal_table.cellChanged.connect(lambda: self.EditSignalValue())
        self.gui_save_btn.clicked.connect(lambda: self.SaveGui())
        self.gui_table.clicked.connect(lambda: self.LoadGui())
        self.image_load_btn.clicked.connect(lambda: self.LoadImage(self.OpenFileAddress('jpg')))
        self.image_remove_btn.clicked.connect(lambda: self.LoadImage(None))

    def LoadDbcData(self, can_type):
        file_address = self.OpenFileAddress('dbc')
        if file_address == '':
            return
        CONTROLLER.LoadDBCData(file_address, can_type)
        message_list = CONTROLLER.GetMessageList()
        self.search_table.setRowCount(len(message_list))
        for row, message in enumerate(message_list):
            item = QTableWidgetItem(message)
            tooltip_message = '\n'.join(CONTROLLER.GetSignalList(message))
            item.setToolTip(tooltip_message)
            self.search_table.setItem(row, 0, item)

    def SearchName(self):
        name = self.search_box.text()
        CONTROLLER.CheckSearchMessageList(name)
        search_message_list = CONTROLLER.GetSearchMessageList()
        self.search_table.setRowCount(len(search_message_list))
        for row, message in enumerate(search_message_list):
            item = QTableWidgetItem(message)
            tooltip_message = '\n'.join(CONTROLLER.GetSignalList(message))
            item.setToolTip(tooltip_message)
            self.search_table.setItem(row, 0, item)

    def AddMessage(self):
        message = self.search_table.currentItem().text()
        if CONTROLLER.CheckMessageTableList(message) is True:
            CONTROLLER.UpdateState(message, 'ON')
            message_table_list = CONTROLLER.GetMessageTableList()
            row = len(message_table_list) - 1
            self.message_table.insertRow(row)
            self.message_table.setItem(row, 0, QTableWidgetItem(message))

            state_btn = MySwitch()
            state_btn.setChecked(True)
            self.message_table.setCellWidget(row, 1, state_btn)
            state_btn.pressed.connect(lambda: self.ToggleSwitch(message))

    def DelMessage(self):
        message = self.message_table.currentItem().text()
        self.message_table.removeRow(self.message_table.currentRow())
        if self.message_table.rowCount() == 0:
            self.signal_table.setRowCount(0)
        CONTROLLER.DeleteMessageData(message)

    def LoadGui(self):
        name = self.gui_table.currentItem().text()
        CONTROLLER.LoadGui(name)
        message_table_list = CONTROLLER.GetMessageTableList()
        self.message_table.setRowCount(len(message_table_list))
        for row, message in enumerate(message_table_list):
            item = QTableWidgetItem(message)
            self.message_table.setItem(row, 0, item)

            state_btn = MySwitch()  # 신호 On/Off 용 토글 스위치 추가
            state = CONTROLLER.GetSignalState(message)
            state_btn.setChecked(True if state == 'ON' else False)
            self.message_table.setCellWidget(row, 1, state_btn)
            state_btn.pressed.connect(lambda: self.ToggleSwitch(message))
        self.LoadImage(CONTROLLER.GetImageAddress())

    def ToggleSwitch(self, message):  # Switch 의 state 가 변경 됐을 때
        state = "OFF" if self.message_table.cellWidget(self.message_table.currentRow(),1).isChecked() else "ON"
        CONTROLLER.UpdateState(message, state)

    def SelectMessage(self):
        try:
            self.click_message = self.message_table.item(self.message_table.currentRow(), 0).text()
            signal_list = CONTROLLER.GetSignalList(self.click_message)
            signal_value_list = CONTROLLER.GetSignalValueList(self.click_message)
            self.signal_table.setRowCount(len(signal_list))
            self.signal_table.blockSignals(True)
            for row, signal in enumerate(signal_list):
                item = QTableWidgetItem(signal)
                item.setFlags(Qt.ItemIsEditable)
                self.signal_table.setItem(row, 0, item)

                item_dec = QTableWidgetItem(str(int(str(signal_value_list[row]), 16)))
                item_dec.setTextAlignment(Qt.AlignCenter)
                self.signal_table.setItem(row, 1, item_dec)

                item_hex = QTableWidgetItem(str(signal_value_list[row]).upper())
                item_hex.setTextAlignment(Qt.AlignCenter)
                self.signal_table.setItem(row, 2, item_hex)
            self.signal_table.blockSignals(False)
        except AttributeError:
            pass

    def SaveGui(self):
        self.gui_name = self.gui_name_box.text()
        flag = CONTROLLER.CheckGuiName(self.gui_name)[0]
        if flag is True:
            CONTROLLER.AddGuiName(self.gui_name)
            gui_list = CONTROLLER.GetGuiList()
            self.gui_table.setRowCount(len(gui_list))
            for row, message in enumerate(gui_list):
                item = QTableWidgetItem(message)
                self.gui_table.setItem(row, 0, item)
        elif flag is False:
            text = CONTROLLER.CheckGuiName(self.gui_name)[1]
            QMessageBox.warning(self, "Warning", text,
                                QMessageBox.Ok, QMessageBox.Ok)

        CONTROLLER.SaveGui(self.gui_name)

    def EditSignalValue(self):
        self.signal_table.blockSignals(True)

        row = self.signal_table.currentRow()
        column = self.signal_table.currentColumn()
        init_val = self.signal_table.item(row, column).text()

        try:
            if column == 1:
                init_val = int(str(int(float(init_val))), 10)
            elif column == 2:
                init_val = int(init_val, 16)
        except Exception as e:
            print(e)
            init_val = 0

        val = CONTROLLER.EditSignalValue(self.click_message, row, init_val)

        item_dec = QTableWidgetItem(str(val))
        item_dec.setTextAlignment(Qt.AlignCenter)
        self.signal_table.setItem(row, 1, item_dec)

        item_hex = QTableWidgetItem(str(hex(val))[2:].upper())
        item_hex.setTextAlignment(Qt.AlignCenter)
        self.signal_table.setItem(row, 2, item_hex)

        self.signal_table.blockSignals(False)

        CONTROLLER.DataCalculate(self.click_message)

    def LoadImage(self, image_address):
        CONTROLLER.SaveImageAddress(image_address)
        pixmap = QPixmap(image_address)
        self.image_label.setPixmap(pixmap.scaledToWidth(381))

    def eventFilter(self, table_name, event):
        if table_name is self.search_table:  # TableWidget_1
            if event.type() == QEvent.KeyPress:  # 키보드 이벤트
                if event.key() == Qt.Key_Enter or event.key() == 16777220:  # Enter 입력 시 선택 항목 오른쪽으로 추가
                    self.AddMessage()

                elif event.key() == Qt.Key_Escape:  # ESC 입력 시 선택 초기화
                    self.search_table.clearSelection()

        elif table_name is self.message_table:  # TableWidget_2
            if event.type() == QEvent.KeyPress:  # 키보드 이벤트
                if event.key() == Qt.Key_Delete:  # Delete 시 선택 항목 제거
                    try:
                        self.DelMessage()
                    except Exception as e:
                        print(e)
                        pass

                elif event.key() == Qt.Key_Escape:  # ESC 입력 시 선택 초기화
                    self.message_table.clearSelection()

        elif table_name is self.gui_table:  # CSV table
            if event.type() == QEvent.KeyPress: # 키보드 이벤트
                if event.key() == Qt.Key_Enter or event.key() == 16777220:  # Enter 입력 시
                    self.LoadGui()

                elif event.key() == Qt.Key_Delete:
                    try:
                        self.gui_table.removeRow(self.gui_table.currentRow())
                        CONTROLLER.DeleteGuiData(self.gui_table.currentItem().text())
                    except Exception as e:
                        print(e)
                        pass
        elif table_name is self.image_label:
            if event.type() == QEvent.KeyPress: # 키보드 이벤트
                if (event.key() == Qt.Key_V) and (event.modifiers() & Qt.ControlModifier):
                    im = ImageGrab.grabclipboard()
                    image_address = ''.join(im)
                    if image_address is not None:
                        self.LoadImage(image_address)
                        CONTROLLER.SaveImageAddress(image_address)
        return False

    def ResetAll(self):
        CONTROLLER.InitSetting()
        self.search_table.setRowCount(0)
        self.message_table.setRowCount(0)
        self.signal_table.setRowCount(0)
        self.gui_table.setRowCount(0)
        self.LoadImage(None)

    # noinspection PyMethodMayBeStatic
    def OpenFileAddress(self, file_type):
        file_address = (QFileDialog.getOpenFileName(caption="Open",
                                                    filter="{0} File(*.{0})".format(file_type),
                                                    options=QFileDialog.ShowDirsOnly))[0]
        return file_address

    # noinspection PyMethodMayBeStatic
    def SaveFileAddress(self, file_type):
        file_address = (QFileDialog.getSaveFileName(caption="Save",
                                                    filter="{0} File(*.{0})".format(file_type)))[0]
        return file_address

    def NewFile(self):
        self.file_address = self.SaveFileAddress('csv')
        if self.file_address != '':
            self.current_file_label_2.setText(os.path.basename(self.file_address))
            csv_file = open(self.file_address, 'w')
            csv_file.close()

            self.file_open_status = True
            #self.gui_save_btn.setEnabled(True)

    def OpenFile(self):
        self.file_address = self.OpenFileAddress('csv')
        if self.file_address != '':
            self.ResetAll()

            self.current_file_label_2.setText(os.path.basename(self.file_address))
            CONTROLLER.LoadCSVData(self.file_address)

            gui_list = CONTROLLER.GetGuiList()
            self.gui_table.setRowCount(len(gui_list))
            for row, message in enumerate(gui_list):
                item = QTableWidgetItem(message)
                self.gui_table.setItem(row, 0, item)

    def SaveFile(self):
        if self.file_open_status is True:
            CONTROLLER.SaveCSV(self.file_address)
        else:
            self.SaveAsFile()

    def SaveAsFile(self):
        self.NewFile()
        self.SaveFile()

if __name__ == '__main__':
    import CONTROLLER

    app = QApplication(sys.argv)
    ex = Set_UI()
    sys.exit(app.exec_())