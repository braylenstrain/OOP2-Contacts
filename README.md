# Object Oriented Programming 2 Final Project *Contacts*

## Synopsis
This project simulates a Contacts App you would use on a computer.
The features of the program are:
1. Display all of your current contacts
2. Add new contacts
3. Delete aa contact or modify their info
5. Search for a contact's information based on their name, phone number, or email
6. Load a saved list of contacts from *contacts.dat* file
7. Exit the program and save the contacts *contacts.dat* file

## Motivation
This is a project to display my understanding of the topics that I have learned from this course.

## How to Run
The program is used through a GUI interface, with actions fired from buttons being clicked, or in some cases, the ENTER key being pressed.

## Code Example
This code snippet shows how the program is controlled. Each scene is loaded into this class. All maneuverability between scenes is handled here, along with saving, loading contacts to a file, and sorting the contacts ArrayList when needed.
```
public class ContactsOOP2 extends Application{
	
	public static ArrayList<Contact> contacts = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Load all the different pages
		Homepage homepage = new Homepage();
		Scene homepageScene = new Scene(homepage, 600, 350);
		
		DisplayContacts displayContacts = new DisplayContacts();
		Scene displayScene = new Scene(displayContacts, 950, 600);
		
		AddContacts addContacts = new AddContacts();
		Scene addScene = new Scene(addContacts, 350, 350);
		
		SearchContacts searchContacts = new SearchContacts();
		Scene searchScene = new Scene(searchContacts, 950, 300);
		
		DeleteModifyContacts deleteModifyContacts = new DeleteModifyContacts();
		Scene deleteModifyScene = new Scene(deleteModifyContacts, 950, 300);
		
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
			
			//Return to homepage when btExit is clicked
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
			
			//Return to homepage when btExit is clicked
			searchContacts.btExit.setOnAction(f -> {
				primaryStage.setTitle("Homepage");
				primaryStage.setScene(homepageScene);
			});
		});
		
		//Go to DeleteModifyContacts scene when btDeleteModify is clicked
		homepage.btDeleteModify.setOnAction(e -> {
			primaryStage.setTitle("Delete/Modify Contacts");
			primaryStage.setScene(deleteModifyScene);
			
			//Fill deleteModifyContacts.gridPane with contacts and delete, modify buttons
			deleteModifyContacts.printList();
		
			//Return to homepage when btExit is clicked
			deleteModifyContacts.btExit.setOnAction(f -> {
				primaryStage.setTitle("Homepage");
				primaryStage.setScene(homepageScene);
				
				//Clear deleteModifyContacts.gridPane of all Contacts info and Buttons on exit
				for (int i = 0; i < contacts.size() * 8; i++) {
					deleteModifyContacts.gridPane.getChildren().remove(1);
				}
			});
		});
		
		//Load contacts from contacts.dat file
		homepage.btFile.setOnAction(e -> loadContacts(homepage.btFile));
		
		//Exit the program when btExit is clicked
		homepage.btExit.setOnAction(e -> {
			saveContacts();
			System.exit(0);
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

	//Save Contacts to file using Binary I/O
	public static void saveContacts() {
		try (
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("contacts.dat"));
				) {
			output.writeObject(contacts);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//Load Contacts into contacts ArrayList
	@SuppressWarnings("unchecked")
	public static void loadContacts(Button btFile) {
		try (
				ObjectInputStream input = new ObjectInputStream(new FileInputStream("contacts.dat"))
				) {
			contacts = (ArrayList<Contact>)(input.readObject());
			btFile.setText("Load Successful!");
		} catch (FileNotFoundException ex) {
			btFile.setText("File Not Found");
		} catch (ClassNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

```
