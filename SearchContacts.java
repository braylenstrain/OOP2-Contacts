
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SearchContacts extends ScrollPane{
	TextField tfSearchBar = new TextField();
	GridPane gridPane = new GridPane();
	Button btExit = new Button("Return to Homepage");
	Button btSearch = new Button("Search");
	Text[] textArray = {
			new Text("First Name"),
			new Text("Last Name"),
			new Text("Personal Phone Number"),
			new Text("Work Phone Number"),
			new Text("Personal Email Address"),
			new Text("Work Email Address")
			};
	int listLength = 0;
	
	public SearchContacts() {
		//Set tfSearchBar, btSearch, and btExit into gridPane. Set gridPane into SearchContacts.
		gridPane.setHgap(20);
		//tfSearchBar.setPrefColumnCount(50);
		gridPane.add(tfSearchBar, 0, 0);
		gridPane.add(btSearch, 1, 0);
		gridPane.add(btExit, 2, 0);
		Font font = Font.font("Times New Roman", FontWeight.BOLD, 15);
		for (int i = 0; i < textArray.length; i++) {
			textArray[i].setFont(font);
			gridPane.add(textArray[i], i, 1);
		}
		setContent(gridPane);
		
		//Searches for information match when btSearch is clicked
		btSearch.setOnAction(e -> search());
		
		//Searches for information match when enter key is pressed
		setOnKeyPressed(e -> {
			
			if (e.getCode() == KeyCode.ENTER) {
				search();
			}
		});
	}
	
	//Takes String from tfSearchBar and puts all matching Contacts into ArrayList, then implements DisplayContacts.display to add to gridPane.
	public void search() {
		//Clear gridPane starting at beginning of Contact info, if needed
		for (int i = 0; i < listLength; i++) {
			gridPane.getChildren().remove(9);
		}
		
		//Reset listLength to 0
		listLength = 0;
		
		//Create temp ArrayList and add any contact that has matching info to the String typed in tfSearchBar
		ArrayList<Contact> temp = new ArrayList<>();
		String searchInfo = tfSearchBar.getText();
		for (Contact i: ContactsOOP2.contacts) {
			if (i.getFirstName().toLowerCase().contains(searchInfo.toLowerCase())
				|| i.getLastName().toLowerCase().contains(searchInfo.toLowerCase())
				|| i.getPersonalPhoneNumber().toLowerCase().contains(searchInfo.toLowerCase())
				|| i.getWorkPhoneNumber().toLowerCase().contains(searchInfo.toLowerCase())
				|| i.getPersonalEmailAddress().toLowerCase().contains(searchInfo.toLowerCase())
				|| i.getWorkEmailAddress().toLowerCase().contains(searchInfo.toLowerCase())) {
				
				temp.add(i);
				
				//Add 6 to listLength to signal how many nodes need to be removed on a new search
				listLength += 6;
			}	
		}
		
		//Display all matching contacts from temp ArrayList
		DisplayContacts.display(temp, gridPane);
	}
	
}
