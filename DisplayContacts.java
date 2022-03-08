
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DisplayContacts extends ScrollPane {
	
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
		setContent(gridPane);
	}
	
}
