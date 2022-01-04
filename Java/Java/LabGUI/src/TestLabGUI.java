import com.sun.glass.ui.Window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestLabGUI extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		MenuBar mb = new MenuBar();
		mb.setPadding(new Insets(15, 15, 15, 15));

		// Definition of menus that you can see right away.
		Menu m1 = new Menu("Controls");
		Menu m2 = new Menu("Layouts");
		Menu m3 = new Menu("Shapes");
		Menu m4 = new Menu("Applications");
		Menu m5 = new Menu("Exit");

		// Define the details of the Controls menu defined above.
		MenuItem m11 = new MenuItem("Text");
		MenuItem m12 = new MenuItem("Button");
		MenuItem m13 = new MenuItem("Label");
		MenuItem m14 = new MenuItem("ImageView");
		MenuItem m15 = new MenuItem("TreeView");
		MenuItem m16 = new MenuItem("TableView");
		MenuItem m17 = new MenuItem("TreeTableView");
		MenuItem m18 = new MenuItem("DataPicker");

		// Define the details of the Layout menu defined above.
		MenuItem m21 = new MenuItem("HBox");
		MenuItem m22 = new MenuItem("VBox");
		MenuItem m23 = new MenuItem("Pane");
		MenuItem m24 = new MenuItem("FlowPane");
		MenuItem m25 = new MenuItem("GridPane");
		MenuItem m26 = new MenuItem("TabPane");
		MenuItem m27 = new MenuItem("StackPane");

		// Define the details of the Shapes menu defined above.
		MenuItem m31 = new MenuItem("2D Shpaes");
		MenuItem m32 = new MenuItem("3D Shpaes");

		// Define the details of the Applications menu defined above.
		MenuItem m41 = new MenuItem("Counter");
		MenuItem m42 = new MenuItem("Calculator");
		MenuItem m43 = new MenuItem("Task-2");
		MenuItem m44 = new MenuItem("TicTacToe");

		// Add m11~m17 to the menu m1.
		m1.getItems().addAll(m11, m12, m13, m14, m15, m16, m17, m18); // controls
		m2.getItems().addAll(m21, m22, m23, m24, m25, m26, m27); // layouts
		m3.getItems().addAll(m31, m32); // Shapes
		m4.getItems().addAll(m41, m42, m43, m44); // Applications

		// Add m1~m5 to the menu bar.
		mb.getMenus().addAll(m1, m2, m3, m4, m5);

		TextArea ta = new TextArea();
		ta.setMinSize(800, 100); // 가로, 세로
		ta.setPadding(new Insets(15, 15, 15, 15));
		ta.prefWidthProperty().bind(mb.prefWidthProperty());

		VBox midBox = new VBox();

		midBox.prefWidthProperty().bind(mb.prefWidthProperty());

		ControlExamples.setVBproperties(midBox);
//		midBox.setMinSize(500, 300);
//		midBox.setPadding(new Insets(15, 15, 15, 15));
//		midBox.setSpacing(10); // Gap between nodes
//		midBox.setStyle("-fx-border-color: Blue;");

		VBox mainBox = new VBox(mb, midBox, ta);
		mainBox.setSpacing(10); // make a 10 size space on top.
//		mainBox.setAlignment(Pos.BASELINE_CENTER);		// To the middle.
		mainBox.setPadding(new Insets(15, 15, 15, 15));

		// ControlExamples
		m11.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, ControlExamples.getTextBox());
		});

		// When you press the button,
		m12.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, ControlExamples.getButtonBox());
		});

		// When you press the Label,
		m13.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, ControlExamples.getLabelBox());
		});

		// When you press the ImageView
		m14.setOnAction((e) -> {
			try {
				ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
				mainBox.getChildren().set(1, ControlExamples.getImageViewBox());
			} catch (Exception ec) {
				ta.appendText(ec.getMessage());
			}
		});

		// When you press the TreeView
		m15.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, ControlExamples.getTreeViewBox());
		});

		// When you press the TableView
		m16.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, ControlExamples.getTableViewBox());
		});

		// When you press the DatePicker
		m18.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, ControlExamples.getDatePickerBox());
		});

		// LayoutsExamples
		m21.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, LayoutExamples.getHBoxBox());
		});

		m22.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, LayoutExamples.getVBoxBox());
		});

		m23.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, LayoutExamples.getPaneBox());
		});

		m24.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, LayoutExamples.getFlowPaneBox());
		});

		m25.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, LayoutExamples.getGridPaneBox());
		});

		m26.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, LayoutExamples.getTabPaneBox());
		});

		m27.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, LayoutExamples.getStackPaneBox());
		});

		// ShapeExamples
		m31.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			mainBox.getChildren().set(1, ShapeExamples.get2DShapesBox());
		});

		m32.setOnAction((e) -> {
			try {
				ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
				mainBox.getChildren().set(1, ShapeExamples.get3DShapesBox());
			} catch (Exception ec) {
				ta.appendText(ec.getMessage());
			}
		});

		// Applications
		m41.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			Counter cn = new Counter();
			cn.runCounter();
		});

		m42.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			Calculator cn = new Calculator();
			cn.runCalculator();
		});

		// Database
		m43.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			DBGUI db = new DBGUI();
			db.displayDBGUI();
		});

		// When you press the TicTacToe
		m44.setOnAction((e) -> {
			ta.appendText(((MenuItem) e.getSource()).getText().toString() + " is selected from the Menu. " + "\n");
			TicTacToe ttt = new TicTacToe();
			ttt.runTicTacToe();

		});

		Scene scn = new Scene(mainBox, 1000, 700);
		stage.setScene(scn);
		stage.setTitle("Lab07");
		stage.show(); // Screen execution.

	}

}

/*
 * VBox root = new VBox(); root.setPadding(new Insets(25,25,25,25)); // 실행 창 크기
 * 설정 root.setSpacing(30);
 * 
 * Button btn1 = new Button("Btn-1"); btn1.setMinSize(100, 20); // 버튼 크기
 * 
 * Button btn2 = new Button("Btn-2"); btn2.setMinSize(100, 20);
 * 
 * Button btn3 = new Button("Btn-3"); btn3.setMinSize(100, 20);
 * 
 * Button btn4 = new Button("Btn-4"); btn4.setMinSize(100, 20);
 * 
 * root.getChildren().addAll(btn1,btn2,btn3,btn4); Scene scn = new Scene(root,
 * 500, 300); stage.setScene(scn); stage.setTitle("Lab GUI"); // 실행 창의 제목
 * 
 * stage.show(); // 화면 실행
 */