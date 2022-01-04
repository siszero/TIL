
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DBGUI {
	// data members

	private TableView table;
	private TreeView<String> tree;
	private Button[] buttons;
	private Label[] labels;
	private TextField[] txt;
	private TextArea txtArea;
	private final String[] btntext = { "clear", "save", "update", "delete", "print", "search" };

	// write table contents
	private final ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("Jacob", "Smith", "jacob.smith@example.com"),
			new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
			new Person("Ethan", "Williams", "ethan.williams@example.com"),
			new Person("Emma", "Jones", "emma.jones@example.com"),
			new Person("Michael", "Brown", "michael.brown@example.com"),
			new Person("Jacob", "Smith", "jacob.smith@example.com"),
			new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
			new Person("Ethan", "Williams", "ethan.williams@example.com"),
			new Person("Emma", "Jones", "emma.jones@example.com"),
			new Person("Michael", "Brown", "michael.brown@example.com"));

	public void displayDBGUI() {
		Stage stage = new Stage();

		// root node

		VBox vbox = new VBox();
		vbox.setMinSize(900, 500); // set minsize
		vbox.setMaxSize(1000, 700); // set maxsize
		vbox.setPadding(new Insets(15, 15, 15, 15));
		vbox.setSpacing(10); // Gap between nodes
		vbox.setStyle("-fx-border-color: Black;");

		// Top Box
		HBox tbox = getTopPane();
		tbox.prefHeightProperty().bind(vbox.prefWidthProperty());
		vbox.getChildren().add(tbox);

		// Center box
		HBox cbox = getCenterPane();
		cbox.prefHeightProperty().bind(vbox.prefWidthProperty());
		vbox.getChildren().add(cbox);

		// Bottom pane
		StackPane bbox = getBottomPane();
		bbox.prefHeightProperty().bind(vbox.prefWidthProperty());
		vbox.getChildren().add(bbox);

		// create and show stage

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.setTitle("Dream Home");
		stage.show();

	}

	private HBox getTopPane() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setSpacing(10); // Gap between nodes
		hbox.setStyle("-fx-border-color: Blue;"); // set blue button
		buttons = new Button[6]; // Set the number of buttons to 6

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(btntext[i]);
			buttons[i].setPrefSize(80, 20);
			buttons[i].prefHeightProperty().bind(hbox.prefWidthProperty());
		}

		for (int i = 0; i < buttons.length; i++) {
			final int j = i;
			buttons[j].setOnAction((event) -> {
				String str = buttons[j].getText();
				txtArea.appendText("You have clicked + " + str + "\n");
			});
		}
		hbox.getChildren().addAll(buttons);

		return hbox;

	}

	private StackPane getBottomPane() {
		StackPane stack = new StackPane();
		stack.setMaxHeight(150);
		stack.setMinHeight(150);
		stack.setPrefHeight(150);
		stack.setStyle("-fx-border-color: blue");// set color

		txtArea = new TextArea();
		txtArea.appendText("");
		txtArea.prefHeightProperty().bind(stack.prefHeightProperty());
		stack.getChildren().add(txtArea);

		return stack;
	}

	private HBox getCenterPane() {
		HBox hb1 = new HBox();
		// Add TableView
		VBox vb = new VBox();
		table = new TableView<Person>();
		table.setMinSize(600, 150);
		table.setMaxSize(600, 150);
		table.setStyle("-fx-border-color: Black;");
		table.prefWidthProperty().bind(vb.prefWidthProperty());
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		table.getSelectionModel().setCellSelectionEnabled(false);

		// Data Table
		// put First Name in first column
		TableColumn firstNameCol = new TableColumn("First Name");
		firstNameCol.setMinWidth(200);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

		// put Last Name in second column
		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(200);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

		// put Email in third column
		TableColumn emailCol = new TableColumn("Email");
		emailCol.setMinWidth(300);
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

		table.setItems(data);
		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol); // add

		table.getSelectionModel().selectedItemProperty().addListener((v, oldV, newV) -> {
			showFields();
		});

		// Add Labels and TextFields
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(15, 15, 15, 125));
		gp.setHgap(5);
		gp.setVgap(5);
		gp.setStyle("-fx-border-color: Green;");
		gp.prefHeightProperty().bind(table.prefWidthProperty());
		txt = new TextField[10];
		labels = new Label[10];

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label("Label..");
			labels[i].setMinSize(150, 20);
			txt[i] = new TextField(" Text.. ");
			txt[i].setMinSize(300, 20);
			gp.addRow(i, labels[i], txt[i]);
			labels[i].prefHeightProperty().bind(gp.widthProperty());
			txt[i].prefHeightProperty().bind(gp.widthProperty());
		}

		vb.getChildren().addAll(table, gp);

		// Add TreeView
		StackPane stack = new StackPane();

		// Create the tree

		tree = new TreeView<String>();
		TreeItem<String> root, Tables, Reports, Exit, About;

		// root
		root = new TreeItem<String>("DreamHome");
		// The child of DreamHome
		Tables = new TreeItem<String>("Tables");
		// Details of the Tables. = // The child of Tables
		TreeItem<String> lab0101, lab0102, lab0103, lab0104, lab0105, lab0106, lab0107;
		lab0101 = new TreeItem<String>("Branch");
		lab0102 = new TreeItem<String>("Client");
		lab0103 = new TreeItem<String>("PrivateOwner");
		lab0104 = new TreeItem<String>("Staff");
		lab0105 = new TreeItem<String>("PropertyForRent");
		lab0106 = new TreeItem<String>("Registration");
		lab0107 = new TreeItem<String>("Viewing");
		Tables.getChildren().addAll(lab0101, lab0102, lab0103, lab0104, lab0105, lab0106, lab0107);
		// The child of DreamHome
		Reports = new TreeItem<String>("Reports");
		// Details of the Reports. = // The child of Reports
		TreeItem<String> Report01, Report02, Report03;
		Report01 = new TreeItem<String>("Report01");
		Report02 = new TreeItem<String>("Report02");
		Report03 = new TreeItem<String>("Report03");
		Reports.getChildren().addAll(Report01, Report02, Report03);

		// The child of DreamHome
		Exit = new TreeItem<String>("Exit");
		// The child of DreamHome
		About = new TreeItem<String>("About");

		// add
		root.getChildren().addAll(Tables, Reports, Exit, About);
		tree.setRoot(root);
		tree.setMaxWidth(250);
		tree.prefWidthProperty().bind(stack.prefWidthProperty());

		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (oldValue != newValue) {
				String str = tree.getSelectionModel().selectedItemProperty().getValue().getValue().toString();
				txtArea.appendText("You have selected " + str + "\n");
			}
		});

		stack.getChildren().add(tree);

		hb1.prefHeightProperty().bind(vb.prefHeightProperty());
		hb1.getChildren().addAll(stack, vb);

		return hb1;

	}

	private void clearFields() {
		for (int i = 0; i < txt.length; i++) {
			txt[i].setText("");
			txt[i].setVisible(false);
			labels[i].setText("");
			labels[i].setVisible(false);
		}

	}

	// It allows you to see it visually.
	private void showFields() {
		clearFields();
		TablePosition pos = (TablePosition) table.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		int cols = table.getColumns().size();

		for (int j = 0; j < cols; j++) {
			Object ch = ((TableColumnBase) table.getColumns().get(j)).getText();
			Object cell = ((TableColumnBase) table.getColumns().get(j)).getCellData(row).toString();

			txt[j].setText(cell.toString());
			txt[j].setVisible(true);

			labels[j].setText(ch.toString());
			labels[j].setVisible(true);
		}

	}

}
