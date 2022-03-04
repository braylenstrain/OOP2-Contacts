package application;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DisplayContacts extends ScrollPane {
	GridPane pane = new GridPane();
	Text firstName = new Text("First Name");
	Text lastName = new Text("Last Name");
	Text personalPhone = new Text("Personal Phone Number");
	Text workPhone = new Text("Work Phone Number");
	Text personalEmail= new Text("Personal Email Address");
	Text workEmail = new Text("Work Email Address");
	
	public DisplayContacts() {
		pane.addRow(0, firstName, lastName, personalPhone, workPhone, personalEmail, workEmail);
		setContent(pane);
	}
}
