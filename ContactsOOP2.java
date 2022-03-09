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
		Scene displayScene = new Scene(displayContacts, 900, 600);
		
		AddContacts addContacts = new AddContacts();
		Scene addScene = new Scene(addContacts, 350, 350);
		
		SearchContacts searchContacts = new SearchContacts();
		Scene searchScene = new Scene(searchContacts, 900, 300);
		
		//Set the scene to homepage when program starts
		primaryStage.setTitle("Homepage");
		primaryStage.setScene(homepageScene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		//Go to DisplayContacts scene when btDisplay is clicked
		homepage.btDisplay.setOnAction(e -> {
			primaryStage.setTitle("Display Contacts");
			primaryStage.setScene(displayScene);
			
			//Display all contacts from ArrayList contacts and exit Button
			DisplayContacts.display(contacts, displayContacts.gridPane);
			
			displayContacts.btExit.setOnAction(f -> {
				primaryStage.setTitle("Homepage");
				primaryStage.setScene(homepageScene);
				
				//Clear displayContact.gridPane of all Contacts info on exit
				for (int i = 0; i < contacts.size() * 6; i++) {
					displayContacts.gridPane.getChildren().remove(7);
				}
			});
		});
		
		//Go to AddContacts scene when btAdd is clicked
		homepage.btAdd.setOnAction(e -> {
			primaryStage.setTitle("Add Contacts");
			primaryStage.setScene(addScene);
			
			
			
			//Clear counter and sort contacts on exit, then return to homepage
			addContacts.btExit.setOnAction(f -> {
				addContacts.counter = 0;
				addContacts.setTop(new Text(""));
				sortContacts();
				primaryStage.setTitle("Homepage");
				primaryStage.setScene(homepageScene);
			});
		});
		
		//Go to SearchContacts scene when btSearch is clicked
		homepage.btSearch.setOnAction(e -> {
			primaryStage.setTitle("Search Contacts");
			primaryStage.setScene(searchScene);
			
			searchContacts.btExit.setOnAction(f -> {
				primaryStage.setTitle("Homepage");
				primaryStage.setScene(homepageScene);
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
			}
		}
	}

}
