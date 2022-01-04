import javafx.scene.control.Label;

public class Cell {
	private String token = "";
	private Label label;
	
	public Cell() {
		this.label = new Label(" ");
		label.setPrefSize(100, 100);
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		label.setText(token);
	}
	public String getLabelText() {
		return label.getText();
	}


	
	
}
