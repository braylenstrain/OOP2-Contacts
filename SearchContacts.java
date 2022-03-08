
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class SearchContacts extends ScrollPane{
	TextField tfSearchBar = new TextField();
	GridPane gridPane = new GridPane();
	Label searchBarLabel = new Label("Search: ", tfSearchBar);
	
	public SearchContacts() {
		tfSearchBar.setPrefColumnCount(50);
		searchBarLabel.setContentDisplay(ContentDisplay.RIGHT);
		gridPane.add(new Text("                               "), 0, 0);
		gridPane.add(searchBarLabel, 1, 0);
		setContent(gridPane);
	}
}
