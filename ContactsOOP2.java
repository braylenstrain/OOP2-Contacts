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
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

public class ContactsOOP2 extends Application{
	
	static ArrayList<Contact> contacts = new ArrayList<>();

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
			
			//When btAdd is clicked, take text from all text fields and add a Contact to contacts
			addContacts.btAdd.setOnAction(f -> addContacts.addContact());
			
			//When the enter key is pressed, Take text from all text fields and add a Contact to contacts
			addContacts.setOnKeyPressed(f -> {
				if (f.getCode() == KeyCode.ENTER)
						addContacts.addContact();
			});
			
			addContacts.btExit.setOnAction(f -> {
				sortContacts();
				primaryStage.setTitle("Contacts: Homepage");
				primaryStage.setScene(scene);
			});
		});
	}
	
	//Sort the contacts ArrayList by Contact first name
	public static void sortContacts() {
		for (int i = 0; i < contacts.size() - 1; i++) {
			Contact temp = contacts.get(i);
			int tempIndex = i;
			for (int j = i + 1; j < contacts.size(); j++) {
				if (temp.compareTo(contacts.get(j)) == -1) {
					temp = contacts.get(j);
					tempIndex = j;
				}
			}
			if (!temp.equals(contacts.get(i))) {
				contacts.set(tempIndex, contacts.get(i));
				contacts.set(i, temp);
				System.out.println(contacts);
			}
		}
	}

}
