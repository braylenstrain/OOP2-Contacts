
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;

public class AddContacts extends BorderPane {
	
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
	HBox buttons = new HBox(80);
	Button btExit = new Button("Return to Homepage");
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
		
		//When btAdd is clicked, take text from all text fields and add a Contact to contacts
		btAdd.setOnAction(e -> addContact());
		
		//When the enter key is pressed, Take text from all text fields and add a Contact to contacts
		setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
					addContact();
		});
	}
	
	//
	public void addSuccessful() {
		counter++;
		Text contactsAdded = new Text(counter + " Contact(s) Added");
		setTop(contactsAdded);
		setAlignment(contactsAdded, Pos.TOP_RIGHT);
	}
	
	public void addContact() {
		Contact contact = new Contact();
		contact.setFirstName(tfFirstName.getText().trim());
		contact.setLastName(tfLastName.getText().trim());
		contact.setPersonalPhoneNumber(tfPersonalPhone.getText().trim());
		contact.setWorkPhoneNumber(tfWorkPhone.getText().trim());
		contact.setPersonalEmailAddress(tfPersonalEmail.getText().trim());
		contact.setWorkEmailAddress(tfWorkEmail.getText().trim());
		ContactsOOP2.contacts.add(contact);
		
		//Display how many contacts have been added at the top of the scene
		addSuccessful();
		
		//Clear the text fields
		tfFirstName.clear();
		tfLastName.clear();
		tfPersonalPhone.clear();
		tfWorkPhone.clear();
		tfPersonalEmail.clear();
		tfWorkEmail.clear();
	}
}
