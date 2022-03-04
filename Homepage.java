import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class Homepage extends BorderPane {
	
	VBox options = new VBox(20);
	VBox fileOrExit = new VBox(100);
	Button btDisplay = new Button("Display Contacts");
	Button btAdd = new Button("Add Contacts");
	Button btDelete = new Button("Delete Contacts");
	Button btModify = new Button("Modify Contacts");
	Button btSearch = new Button("Search Contacts");
	Button btExit = new Button("Exit Program");
	Button btFile = new Button("Change Source File");
	
	public Homepage() {
		options.getChildren().addAll(btDisplay, btAdd, btDelete, btModify, btSearch, btExit, btFile);
		setCenter(options);
		fileOrExit.getChildren().addAll(btExit, btFile);
		setRight(fileOrExit);
	}
	
}
