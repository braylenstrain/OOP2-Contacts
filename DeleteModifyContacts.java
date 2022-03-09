
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;

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
	
	public DeleteModifyContacts() {
		//Create informative text and add to gridPane
		Font font = Font.font("Times New Roman", FontWeight.BOLD, 15);
		Text text = new Text("Use the buttons to the right of the contact to modify or delete it.");
		text.setFont(font);
		setTop(text);
		setAlignment(text, Pos.CENTER);
		
		//Set Hgap and add btExit to gridPane
		gridPane.setHgap(20);
		gridPane.add(btExit, 0, 100);
		
		//Put gridPane in scrollPane and center of DeleteModifyContacts
		scrollPane.setContent(gridPane);
		setCenter(scrollPane);
	}
}
