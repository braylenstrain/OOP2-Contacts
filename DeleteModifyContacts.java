package application;


import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class DeleteModifyContacts extends BorderPane {
	GridPane gridPane = new GridPane();
	Button btExit = new Button("Return to Homepage");
	ScrollPane scrollPane = new ScrollPane();
	Text[] textArray = {
			new Text("First Name"),
			new Text("Last Name"),
			new Text("Personal Phone Number"),
			new Text("Work Phone Number"),
			new Text("Personal Email Address"),
			new Text("Work Email Address")
			};
	Font font = Font.font("Times New Roman", FontWeight.BOLD, 15);
	Text header = new Text("Use the buttons to the right of the contact to modify or delete it.");
	
	public DeleteModifyContacts() {
		//Create informative text and add to gridPane
		header.setFont(font);
		setTop(header);
		setAlignment(header, Pos.CENTER);
		
		//Set Hgap and add btExit to gridPane
		gridPane.setHgap(20);
		gridPane.add(btExit, 0, 100);
		
		//Put gridPane in scrollPane and center of DeleteModifyContacts
		scrollPane.setContent(gridPane);
		setCenter(scrollPane);
		
	}
	
	//Delete Contact from contacts and redisplay list of contacts
	public void delete(int index) {
		
		//Clear current list off gridPane
		for (int i = 0; i < ContactsOOP2.contacts.size() * 8; i++) {
			gridPane.getChildren().remove(1);
		}
		
		//Remove Contact
		ContactsOOP2.contacts.remove(index);
		
		//Reprint list to gridPane
		printList();
		}
	
	//Fill deleteModifyContacts.gridPane with contacts and delete, modify buttons
	public void printList() {
		for (int i = 0; i < ContactsOOP2.contacts.size(); i++) {
			Button modify = new Button("Modify");
			Button delete = new Button("Delete");
			gridPane.add(new Text(ContactsOOP2.contacts.get(i).getFirstName()), 0, i);
			gridPane.add(new Text(ContactsOOP2.contacts.get(i).getLastName()), 1, i);
			gridPane.add(new Text(ContactsOOP2.contacts.get(i).getPersonalPhoneNumber()), 2, i);
			gridPane.add(new Text(ContactsOOP2.contacts.get(i).getWorkPhoneNumber()), 3, i);
			gridPane.add(new Text(ContactsOOP2.contacts.get(i).getPersonalEmailAddress()), 4, i);
			gridPane.add(new Text(ContactsOOP2.contacts.get(i).getWorkEmailAddress()), 5, i);
			gridPane.add(modify, 6, i);
			gridPane.add(delete, 7, i);
			int index = i;
			
			delete.setOnAction(f -> delete(index));
			
			modify.setOnAction(f -> modify(index));
		}
	}
	
	public void modify(int index) {
		
		//Create TextFields (prefilled with Contact info) and Labels
		TextField tfFirstName = new TextField();
		tfFirstName.setPromptText(ContactsOOP2.contacts.get(index).getFirstName());
		TextField tfLastName = new TextField();
		tfLastName.setPromptText(ContactsOOP2.contacts.get(index).getLastName());
		TextField tfPersonalPhone = new TextField();
		tfPersonalPhone.setPromptText(ContactsOOP2.contacts.get(index).getPersonalPhoneNumber());
		TextField tfWorkPhone = new TextField();
		tfWorkPhone.setPromptText(ContactsOOP2.contacts.get(index).getWorkPhoneNumber());
		TextField tfPersonalEmail = new TextField();
		tfPersonalEmail.setPromptText(ContactsOOP2.contacts.get(index).getPersonalEmailAddress());
		TextField tfWorkEmail = new TextField();
		tfWorkEmail.setPromptText(ContactsOOP2.contacts.get(index).getWorkEmailAddress());
		Label[] labelArray = {
			new Label("First name: ", tfFirstName),
			new Label("Last Name: ", tfLastName),
			new Label("Personal Phone Number: ", tfPersonalPhone),
			new Label("Work Phone Number: ", tfWorkPhone),
			new Label("Personal Email Address: ", tfPersonalEmail),
			new Label("Work Email Address: ", tfWorkEmail)
		};
		
		//Create Buttons, HBox, and Pane
		Button btCancel = new Button("Cancel");
		Button btModify = new Button("Save Changes");
		HBox buttons = new HBox(20);
		FlowPane pane = new FlowPane();
		
		//Create and modify VBoxs for Labels/TextFields
		VBox textFields1 = new VBox(20);
		textFields1.setPadding(new Insets(20));
		textFields1.setAlignment(Pos.CENTER_RIGHT);
		VBox textFields2 = new VBox(20);
		textFields2.setPadding(new Insets(20));
		textFields2.setAlignment(Pos.CENTER_RIGHT);
		VBox textFields3 = new VBox(20);
		textFields3.setPadding(new Insets(20));
		textFields3.setAlignment(Pos.CENTER_RIGHT);
		
		//Set Content Display of labelArray
		for (Label i: labelArray)
			i.setContentDisplay(ContentDisplay.RIGHT);
		
		//Put TextFields in VBoxs
		textFields1.getChildren().addAll(labelArray[0], labelArray[1]);
		textFields2.getChildren().addAll(labelArray[2], labelArray[3]);
		textFields3.getChildren().addAll(labelArray[4], labelArray[5]);
		
		//Put Buttons in Hbox
		buttons.getChildren().addAll(btCancel, btModify);
		
		//Add VBoxs to pane
		pane.getChildren().addAll(textFields1, textFields2, textFields3);
		
		//Position pane and buttons in BorderPane, hide header
		setTop(null);
		setCenter(pane);
		setBottom(buttons);
		setPadding(new Insets(20));
		
		//Return to previous pane when btCancel is clicked
		btCancel.setOnAction(e -> {
			setTop(header);
			setCenter(scrollPane);
			setBottom(null);
		});
		
		//Modify Contact info when btModify is clicked
		btModify.setOnAction(e -> {
			
			//Get Contact based on index. If TextField has text, change Contact info to that text
			Contact modContact = ContactsOOP2.contacts.get(index);
			if (tfFirstName.getText() != "")
				modContact.setFirstName(tfFirstName.getText());
			if (tfLastName.getText() != "")
				modContact.setLastName(tfLastName.getText());
			if (tfPersonalPhone.getText() != "")
				modContact.setPersonalPhoneNumber(tfPersonalPhone.getText());
			if (tfWorkPhone.getText() != "")
				modContact.setWorkPhoneNumber(tfWorkPhone.getText());
			if (tfPersonalEmail.getText() != "")
				modContact.setPersonalEmailAddress(tfPersonalEmail.getText());
			if (tfWorkEmail.getText() != "")
				modContact.setWorkEmailAddress(tfWorkEmail.getText());
			
			//Clear old gridPane
			for (int i = 0; i < ContactsOOP2.contacts.size() * 8; i++) {
				gridPane.getChildren().remove(1);
			}
			
			//Print new gridPane
			printList();
			
			//Return to scrollPane with header
			setTop(header);
			setCenter(scrollPane);
			setBottom(null);
		});
	}
}
