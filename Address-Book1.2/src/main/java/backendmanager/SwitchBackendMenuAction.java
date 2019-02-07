package backendmanager;

import action.Action;
import action.BackendManagerMenuAction;
import backend.AddDatabaseBackendAction;
import backend.AddFileBackendAction;
import backend.SwitchToDatabaseBackendAction;
import backend.SwitchToFileBackendAction;
import funtional.Menu;
import funtional.MenuItem;

public class SwitchBackendMenuAction implements Action {
	Menu database;
	Menu file;
	Menu back;
	Menu exit;
	
	public SwitchBackendMenuAction(Menu menu, BackendManagerMenuAction bmanager) {
		
		database=new Menu(1, " Database Backend");
		database.setAction(new SwitchToDatabaseBackendAction(database, bmanager));
		
		file=new Menu(2, " File System Backend");
		file.setAction(new SwitchToFileBackendAction(file, bmanager));
		
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
		
	}
}
