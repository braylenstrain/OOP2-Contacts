package application;
/*
 * Author: Braylen Strain
 * Date: 03/03/2022
 * 
 * This program allows you to store the contact information of any number of people.
 */

import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class ContactsOOP2 extends Application{
	
	ArrayList<Contact> contacts = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Load all the different pages
		Homepage homepage = new Homepage();
		DisplayContacts displayContacts = new DisplayContacts();
		AddContacts addContacts = new AddContacts();
		
		//Set the scene to homepage when program starts
		Scene scene = new Scene(homepage, 600, 350);
		primaryStage.setTitle("Contacts: Homepage");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		//Go to DisplayContacts scene when btDisplay is clicked
		homepage.btDisplay.setOnAction(e -> {
			Scene scene2 = new Scene(displayContacts, 850, 600);
			primaryStage.setTitle("Contacts: Display Contacts");
			primaryStage.setScene(scene2);
			
			//Display all contacts from ArrayList contacts when DisplayContacts is loaded
			for (int i = 0, j = 1; i < contacts.size(); i++, j += 2) {
				displayContacts.gridPane.add(new Text(contacts.get(i).getFirstName()), 0, j);
				displayContacts.gridPane.add(new Text(contacts.get(i).getLastName()), 1, j);
				displayContacts.gridPane.add(new Text(contacts.get(i).getPersonalPhoneNumber()), 2, j);
				displayContacts.gridPane.add(new Text(contacts.get(i).getWorkPhoneNumber()), 3, j);
				displayContacts.gridPane.add(new Text(contacts.get(i).getPersonalEmailAddress()), 4, j);
				displayContacts.gridPane.add(new Text(contacts.get(i).getWorkEmailAddress()), 5, j);
			}
		});
		
		//Go to AddContacts scene when btAddContacts is clicked
		homepage.btAdd.setOnAction(e -> {
			Scene scene3 = new Scene(addContacts, 350, 350);
			primaryStage.setTitle("Contacts: Add Contacts");
			primaryStage.setScene(scene3);
			
			//Take text from all text fields and add a Contact to contacts when btAdd is clicked
			addContacts.btAdd.setOnAction(f -> {
				Contact contact = new Contact();
				contact.setFirstName(addContacts.tfFirstName.getText().trim());
				contact.setLastName(addContacts.tfLastName.getText().trim());
				contact.setPersonalPhoneNumber(addContacts.tfPersonalPhone.getText().trim());
				contact.setWorkPhoneNumber(addContacts.tfWorkPhone.getText().trim());
				contact.setPersonalEmailAddress(addContacts.tfPersonalEmail.getText().trim());
				contact.setWorkEmailAddress(addContacts.tfWorkEmail.getText().trim());
				contacts.add(contact);
				
				//Display how many contacts have been added at the top of the scene
				addContacts.addSuccessful();
				System.out.println(contacts.get(contacts.size() - 1));
				
				//Clear the text fields
				addContacts.tfFirstName.clear();
				addContacts.tfLastName.clear();
				addContacts.tfPersonalPhone.clear();
				addContacts.tfWorkPhone.clear();
				addContacts.tfPersonalEmail.clear();
				addContacts.tfWorkEmail.clear();
			});
		});
	}

}
