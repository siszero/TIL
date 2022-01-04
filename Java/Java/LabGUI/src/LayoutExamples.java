import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LayoutExamples {
	// The layout that goes vertically.
	public static VBox getVBoxBox() {
		// create text
		Text text = new Text("This is a JavaFX text for VBox.");
		// create five button
		Button button1 = new Button("Button Number 1");
		Button button2 = new Button("Button Number 2");
		Button button3 = new Button("Button Number 3");
		Button button4 = new Button("Button Number 4");
		Button button5 = new Button("Button Number 5");

		VBox vbox = new VBox(20, text, button1, button2, button3, button4, button5);
		vbox.setAlignment(Pos.BASELINE_RIGHT);
		vbox.setSpacing(20);	// Designating an empty space.
		// Designating the style it.
		vbox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

		VBox vb = new VBox(vbox);
		setVBproperties(vb);
		return vb;

	}

	// Layout that goes horizontally.
	public static VBox getHBoxBox() {

		// create text
		Text text = new Text("This is a JavaFX text for HBox.");
		// create five button
		Button button1 = new Button("Button Number 1");
		Button button2 = new Button("Button Number 2");
		Button button3 = new Button("Button Number 3");
		Button button4 = new Button("Button Number 4");
		Button button5 = new Button("Button Number 5");

		HBox hbox = new HBox(20, text, button1, button2, button3, button4, button5);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		hbox.setSpacing(50);	// Designating an empty space.
		// Designating the style it.
		hbox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		VBox vb = new VBox(hbox);
		setVBproperties(vb);
		return vb;

	}
	
	// Pane is a layout.
	public static VBox getPaneBox() {

		Button button1 = new Button("Button Number 1");
		Button button2 = new Button("Button Number 2");
		Button button3 = new Button("Button Number 3");
		Button button4 = new Button("Button Number 4");
		Button button5 = new Button("Button Number 5");

		// X,Y Position
		button1.setLayoutX(10);
		button1.setLayoutY(30);
		button2.setLayoutX(10);
		button2.setLayoutY(60);
		button3.setLayoutX(10);
		button3.setLayoutY(90);
		button4.setLayoutX(10);
		button4.setLayoutY(120);
		button5.setLayoutX(10);
		button5.setLayoutY(150);

		// add button
		Pane pane = new Pane(button1, button2, button3, button4, button5);

		VBox vb = new VBox(pane);
		setVBproperties(vb);
		return vb;

	}

	// FlowPane is a container that places controls
	// in a row and places controls in a new row if space is insufficient.
	public static VBox getFlowPaneBox() {
		// create five button
		Button button1 = new Button("Button Number 1");
		Button button2 = new Button("Button Number 2");
		Button button3 = new Button("Button Number 3");
		Button button4 = new Button("Button Number 4");
		Button button5 = new Button("Button Number 5");
		FlowPane flowpane = new FlowPane(button1, button2, button3, button4, button5);
		// set style
		flowpane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		VBox vb = new VBox(flowpane);
		setVBproperties(vb);
		return vb;
	}

	// GridPane is a layout in which desired components, 
	// such as text, text lines, and images, are listed at regular intervals and criteria.
	public static VBox getGridPaneBox() {
		// create button
		Button button1 = new Button("Button Number 1");
		Button button2 = new Button("Button Number 2");
		Button button3 = new Button("Button Number 3");
		Button button4 = new Button("Button Number 4");
		Button button5 = new Button("Button Number 5");
		Button button6 = new Button("Button Number 6");

		GridPane gridPane = new GridPane();

		// position
		gridPane.add(button1, 0, 0, 1, 1);
		gridPane.add(button2, 1, 0, 1, 1);
		gridPane.add(button3, 2, 0, 1, 1);
		gridPane.add(button4, 0, 1, 1, 1);
		gridPane.add(button5, 1, 1, 1, 1);
		gridPane.add(button6, 2, 1, 1, 1);

		gridPane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		VBox vb = new VBox(gridPane);
		setVBproperties(vb);
		return vb;
	}

	// TabPane is a container control which can contain multiple tabs (sections) internally.
	public static VBox getTabPaneBox() {

		TabPane tabPane = new TabPane();
		// create three tab
		Tab tab1 = new Tab("Planes", new Label("Show all planes available"));
		Tab tab2 = new Tab("Cars", new Label("Show all cars available"));
		Tab tab3 = new Tab("Boats", new Label("Show all boats available"));

		tabPane.getTabs().add(tab1);
		tabPane.getTabs().add(tab2);
		tabPane.getTabs().add(tab3);

		// set style
		tabPane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		VBox vb = new VBox(tabPane);
		setVBproperties(vb);
		return vb;
	}

	// Layouts of layers that come into one position 
	// as if stacking something up in the layout of layers that come in the order of entry.
	public static VBox getStackPaneBox() {

		// Drawing a Circle
		Circle circle = new Circle(300, 135, 100);
		circle.setFill(Color.DARKSLATEBLUE);
		circle.setStroke(Color.BLACK);

		// Drawing Sphere
		Sphere sphere = new Sphere(50);

		// Creating a text
		Text text = new Text("Hello how are you");

		// Setting the font of the text
		text.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		text.setFill(Color.CRIMSON);

		// setting the position of the text
		text.setX(20);
		text.setY(50);

		// Creating a Stackpane
		StackPane stackPane = new StackPane();

		// Setting the margin for the circle
		stackPane.setMargin(circle, new Insets(50, 50, 50, 50));

		// Retrieving the observable list of the Stack Pane
		ObservableList list = stackPane.getChildren();

		// Adding all the nodes to the pane
		list.addAll(circle, sphere, text);

		VBox vb = new VBox();
		vb.getChildren().add(stackPane);
		setVBproperties(vb);
		return vb;
	}

	public static void setVBproperties(VBox vb) {

		vb.setMinSize(800, 500);
		vb.setPadding(new Insets(15, 15, 15, 15));
		vb.setSpacing(10); // Gap between nodes
		vb.setStyle("-fx-border-color: Blue;");
	}

}
