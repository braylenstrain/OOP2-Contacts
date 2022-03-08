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
		Scene homepageScene = new Scene(homepage, 600, 350);
		
		DisplayContacts displayContacts = new DisplayContacts();
		Scene displayScene = new Scene(displayContacts, 850, 600);
		
		AddContacts addContacts = new AddContacts();
		Scene addScene = new Scene(addContacts, 350, 350);
		
		SearchContacts searchContacts = new SearchContacts();
		Scene searchScene = new Scene(searchContacts, 850, 300);
		
		//Set the scene to homepage when program starts
		primaryStage.setTitle("Contacts: Homepage");
		primaryStage.setScene(homepageScene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		//Go to DisplayContacts scene when btDisplay is clicked
		homepage.btDisplay.setOnAction(e -> {
			primaryStage.setTitle("Contacts: Display Contacts");
			primaryStage.setScene(displayScene);
			
			//Display all contacts from ArrayList contacts and exit Button
			displayContacts.display(contacts, displayContacts.gridPane);
			
			displayContacts.btExit.setOnAction(f -> {
				primaryStage.setTitle("Contacts: Homepage");
				primaryStage.setScene(homepageScene);
			});
		});
		
		//Go to AddContacts scene when btAdd is clicked
		homepage.btAdd.setOnAction(e -> {
			primaryStage.setTitle("Contacts: Add Contacts");
			primaryStage.setScene(addScene);
			
			//When btAdd is clicked, take text from all text fields and add a Contact to contacts
			addContacts.btAdd.setOnAction(f -> addContacts.addContact());
			
			//When the enter key is pressed, Take text from all text fields and add a Contact to contacts
			addContacts.setOnKeyPressed(f -> {
				if (f.getCode() == KeyCode.ENTER)
						addContacts.addContact();
			});
			
			//Clear counter and sort contacts on exit, then return to homepage
			addContacts.btExit.setOnAction(f -> {
				addContacts.counter = 0;
				addContacts.setTop(new Text(""));
				sortContacts();
				primaryStage.setTitle("Contacts: Homepage");
				primaryStage.setScene(homepageScene);
			});
		});
		
		//Go to SearchContacts scene when btSearch is clicked
		homepage.btSearch.setOnAction(e -> {
			primaryStage.setTitle("Contacts: Search Contacts");
			primaryStage.setScene(searchScene);
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
			}
		}
	}

}
