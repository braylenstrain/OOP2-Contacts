
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class Homepage extends BorderPane {
	
	VBox options = new VBox(20);
	VBox fileOrExit = new VBox(50);
	Button btDisplay = new Button("Display Contacts");
	Button btAdd = new Button("Add Contacts");
	Button btDeleteModify = new Button("Delete/Modify Contacts");
	Button btSearch = new Button("Search Contacts");
	Button btExit = new Button("Exit Program");
	Button btFile = new Button("Load Contacts");
	
	public Homepage() {
		//Create Layout for VBox options
		btDisplay.setPrefSize(300, 65);
		btAdd.setPrefSize(300, 65);
		btDeleteModify.setPrefSize(300, 65);
		btSearch.setPrefSize(300, 65);
		options.getChildren().addAll(btDisplay, btAdd, btDeleteModify, btSearch, btExit, btFile);
		
		//Create layout for VBox fileOrExit
		btExit.setPrefSize(200, 130);
		btFile.setPrefSize(200, 130);
		fileOrExit.getChildren().addAll(btFile, btExit);
		
		//Create layout for Homepage
		setPadding(new Insets(20));
		setCenter(options);
		setRight(fileOrExit);
	}
	
}
