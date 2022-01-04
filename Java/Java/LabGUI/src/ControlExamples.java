import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ControlExamples {

	// text
	public static VBox getTextBox() {

		// create text
		Text text1 = new Text("This is a JavaFX text 1.");
		Text text2 = new Text("This is a JavaFX text 2.");
		Text text3 = new Text("This is a JavaFX text 3.");
		Text text4 = new Text("This is a JavaFX text 4.");

		// Write down the texts 1 to 4 generated in the VBox above.
		VBox vb = new VBox(text1, text2, text3, text4);
		setVBproperties(vb);
		return vb;

	}

	// Button
	public static VBox getButtonBox() {
		// create text
		Text text = new Text("button not selected");

		// create a button
		Button b = new Button("button");

		// action event
//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
//            public void handle(ActionEvent e) 
//            { 
//                text.setText("button selected    "); 
//            } 
//        }; 
//  
		// when button is pressed
//        b.setOnAction(event); 

		b.setOnAction(e -> {
			text.setText("button selected    ");
		});

		VBox vb = new VBox(b, text);
		setVBproperties(vb);
		return vb;

	}

	// Label
	public static VBox getLabelBox() {
		// create text
		Text text = new Text("button not selected");
		text.setFont(Font.font("Arial", FontWeight.BOLD, 36));
		text.setFill(Color.BLUE);

		// create a button
		Button b = new Button("button");

		// create a label
		Label label = new Label("This is a label");
		label.setFont(new Font("Arial", 24));

		// action event
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				text.setText("button selected    ");
				label.setText("button selected    ");
			}
		};

		// when button is pressed
		b.setOnAction(event);

		VBox vb = new VBox(b, text, label);
		setVBproperties(vb);
		return vb;

	}

	// ImageView
	public static VBox getImageViewBox() throws Exception {
		// create text
		Text text = new Text("button not selected");
		text.setFont(Font.font("Arial", FontWeight.BOLD, 36)); // 글자모양
		text.setFill(Color.BLUE); // 글자 색

		// create a button
		Button b = new Button("button");

		// create a label
		Label label = new Label("This is a label");
		label.setFont(new Font("Arial", 24));

		// Put the picture in.
		FileInputStream input = new FileInputStream("ijava.png");
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);

		// action event
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				text.setText("button selected    ");
				label.setText("button selected    ");
			}
		};

		// when button is pressed
		b.setOnAction(event);

		VBox vb = new VBox(imageView);
		setVBproperties(vb);
		return vb;

	}

	// TreeView
	public static VBox getTreeViewBox() {

		// create Root
		TreeItem<String> rootItem = new TreeItem<String>("Tutorials");

		// create Web Tutorials tree
		TreeItem<String> webItem = new TreeItem<String>("Web Tutorials");
		// create children in Web Tutorials tree
		webItem.getChildren().add(new TreeItem<String>("HTML  Tutorial"));
		webItem.getChildren().add(new TreeItem<String>("HTML5 Tutorial"));
		webItem.getChildren().add(new TreeItem<String>("CSS Tutorial"));
		webItem.getChildren().add(new TreeItem<String>("SVG Tutorial"));
		rootItem.getChildren().add(webItem);

		// create Java Tutorials tree
		TreeItem<String> javaItem = new TreeItem<String>("Java Tutorials");
		// create children in Java Tutorials tree
		javaItem.getChildren().add(new TreeItem<String>("Java Language"));
		javaItem.getChildren().add(new TreeItem<String>("Java Collections"));
		javaItem.getChildren().add(new TreeItem<String>("Java Concurrency"));
		rootItem.getChildren().add(javaItem);

		TreeView<String> treeView = new TreeView<String>();
		treeView.setRoot(rootItem);

		treeView.setShowRoot(true);

		// create text
		Text text = new Text("button not selected");

		// action event
		treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (oldValue != newValue) {
				String str = treeView.getSelectionModel().selectedItemProperty().getValue().toString();
				text.setText("You have selected " + str + "\n");
			}
		});

		VBox vb = new VBox(treeView, text);
		setVBproperties(vb);
		return vb;

	}

	// pick date you want
	public static VBox getDatePickerBox() {

		// first
		Text text = new Text("This is a JavaFX text.");
		DatePicker datePicker = new DatePicker();

		// add button named "Read Date"
		Button button = new Button("Read Date");

		// When you click the button, the data is output.
		button.setOnAction(action -> {
			LocalDate value = datePicker.getValue();
			text.setText(value.toString());
		});

		VBox vb = new VBox(button, datePicker, text);
		setVBproperties(vb);
		return vb;

	}

	// TableView
	public static VBox getTableViewBox() {
		// create TableView named Person
		TableView<Person> tableView = new TableView<Person>();

		// Person array
		Person[] persons = { new Person("Jacob", "Smith", "jacob.smith@example.com"),
				new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
				new Person("Ethan", "Williams", "ethan.williams@example.com"),
				new Person("Emma", "Jones", "emma.jones@example.com"),
				new Person("Michael", "Brown", "michael.brown@example.com") };

		ObservableList<Person> data = FXCollections.observableArrayList(persons);

		Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		// modify
		tableView.setEditable(false);

		// create Column named "First Name"
		TableColumn firstNameCol = new TableColumn("First Name");
		// width = 100
		firstNameCol.setMinWidth(100);
		// Write down the names defined above according to the First Name column in the
		// table
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

		// create Column named "Last Name"
		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(100);
		// Write down the names defined above according to the lastt Name column in the
		// table
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

		// create Column named "Email"
		TableColumn emailCol = new TableColumn("Email");
		emailCol.setMinWidth(200);
		// Write down the emails defined above according to the email column in the
		// table
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

		tableView.setItems(data);
		tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

		VBox vb = new VBox(tableView);
		setVBproperties(vb);
		return vb;

	}

	public static void setVBproperties(VBox vb) {

		vb.setMinSize(600, 400);
		vb.setPadding(new Insets(15, 15, 15, 15));
		vb.setSpacing(10); // Gap between nodes
		vb.setStyle("-fx-border-color: Blue;");
	}

}
