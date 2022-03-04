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
		Scene scene = new Scene(new Homepage(), 600, 350);
		primaryStage.setTitle("Contacts: Homepage");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

}
