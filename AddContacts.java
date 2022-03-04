package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;

public class AddContacts extends BorderPane{
	TextField tfFirstName = new TextField();
	TextField tfLastName = new TextField();
	TextField tfPersonalPhone = new TextField();
	TextField tfWorkPhone = new TextField();
	TextField tfPersonalEmail = new TextField();
	TextField tfWorkEmail = new TextField();
	Label[] labelArray = {
		new Label("First name: ", tfFirstName),
		new Label("Last Name: ", tfLastName),
		new Label("Personal Phone Number: ", tfPersonalPhone),
		new Label("Work Phone Number: ", tfWorkPhone),
		new Label("Personal Email Address: ", tfPersonalEmail),
		new Label("Work Email Address: ", tfWorkEmail)
	};
	VBox textFields = new VBox(20);
	HBox buttons = new HBox(110);
	Button btExit = new Button("Back to Homepage");
	Button btAdd = new Button("Add Contact");
	int counter;
	
	public AddContacts() {
		//Create layout for textFields
		for (Label i: labelArray)
			i.setContentDisplay(ContentDisplay.RIGHT);
		textFields.getChildren().addAll(labelArray);
		textFields.setAlignment(Pos.CENTER_RIGHT);
		//Create layout for buttons
		buttons.getChildren().addAll(btExit, btAdd);
		buttons.setAlignment(Pos.TOP_RIGHT);
		
		//Create layout for AddContacts
		setCenter(textFields);
		setBottom(buttons);
		setPadding(new Insets(20));
	}
	
	public void addSuccessful() {
		counter++;
		Text contactsAdded = new Text(counter + " Contact(s) Added");
		setTop(contactsAdded);
		setAlignment(contactsAdded, Pos.CENTER_RIGHT);
	}
	
	
}
