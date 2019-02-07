package backendmanager;

import action.Action;
import action.BackendManagerMenuAction;
import backend.AddDatabaseBackendAction;
import backend.AddFileBackendAction;
import funtional.Menu;

public class AddBackendMenuAction implements Action {
	BackendManagerMenuAction menu;
	Menu database;
	Menu file;
	Menu back;
	Menu exit;
	public AddBackendMenuAction(Menu menu, BackendManagerMenuAction bmanager) {
		this.menu=bmanager;
		
		database=new Menu(1, " Add Database Backend");
		database.setAction(new AddDatabaseBackendAction(database, bmanager));
	
		file=new Menu(2, " Add File Backend");
		file.setAction(new AddFileBackendAction(file, bmanager));
		
		back=new Menu(3, " Go Back");
		back.setAction(new GoBackAction(back, bmanager));
	
		exit=new Menu(4," Exit");
		exit.setAction(new ExitAction(exit));
		
		menu.addMenuItem(database);
		menu.addMenuItem(file);
		menu.addMenuItem(back);
		menu.addMenuItem(exit);
	}

	public void performAction() {
		//menu.performAction();
	}
}
