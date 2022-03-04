package application;
/*
 * Author: Braylen Strain
 * Date: 03/03/2022
 * 
 * This program allows you to store the contact information of any number of people.
 */

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class ContactsOOP2 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Load all the different pages
		Homepage homepage = new Homepage();
		DisplayContacts displayContacts = new DisplayContacts();
		
		//Set the scene to homepage when program starts
		Scene scene = new Scene(homepage, 600, 350);
		primaryStage.setTitle("Contacts: Homepage");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		//Set actions for homepage
		homepage.btDisplay.setOnAction(e -> {
			Scene scene2 = new Scene(displayContacts, 800, 550);
			primaryStage.setTitle("Contacts: Display Contacts");
			primaryStage.setScene(scene2);
			primaryStage.show();
		});
	}

}
