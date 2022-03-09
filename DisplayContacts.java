
import java.util.ArrayList;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class DisplayContacts extends ScrollPane {
	
	Button btExit = new Button("Return to Homepage");
	GridPane gridPane = new GridPane();
	Text[] textArray = {
		new Text("First Name"),
		new Text("Last Name"),
		new Text("Personal Phone Number"),
		new Text("Work Phone Number"),
		new Text("Personal Email Address"),
		new Text("Work Email Address")
		};
	
	
	public DisplayContacts() {
		gridPane.setHgap(20);
		Font font = Font.font("Times New Roman", FontWeight.BOLD, 15);
		for (int i = 0; i < textArray.length; i++) {
			textArray[i].setFont(font);
			gridPane.add(textArray[i], i, 0);
		}
		gridPane.add(btExit, 0, 100);
		setContent(gridPane);
	}
	
	//Display all contacts from ArrayList contacts
	public static void display(ArrayList<Contact> contacts, GridPane gridPane) {
		for (int i = 0, j = 2; i < contacts.size(); i++, j += 2) {
			gridPane.add(new Text(contacts.get(i).getFirstName()), 0, j);
			gridPane.add(new Text(contacts.get(i).getLastName()), 1, j);
			gridPane.add(new Text(contacts.get(i).getPersonalPhoneNumber()), 2, j);
			gridPane.add(new Text(contacts.get(i).getWorkPhoneNumber()), 3, j);
			gridPane.add(new Text(contacts.get(i).getPersonalEmailAddress()), 4, j);
			gridPane.add(new Text(contacts.get(i).getWorkEmailAddress()), 5, j);
		}
	}
}
