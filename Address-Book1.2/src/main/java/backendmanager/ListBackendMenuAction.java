package backendmanager;

import action.Action;
import action.BackendManagerMenuAction;
import backend.AddDatabaseBackendAction;
import backend.AddFileBackendAction;
import funtional.Menu;


public class ListBackendMenuAction implements Action {
	Menu database;
	Menu file;
	Menu back;
	Menu exit;
	BackendManagerMenuAction bmm;
	
	public ListBackendMenuAction(Menu menu, BackendManagerMenuAction bmanager) {
		this.bmm=bmanager;
	
	}

	public void performAction() {
		bmm.display();
		System.out.println();
	}
}
