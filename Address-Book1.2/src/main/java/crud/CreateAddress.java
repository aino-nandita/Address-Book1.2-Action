package crud;

import action.Action;
import action.BackendManagerMenuAction;
import funtional.Menu;
import funtional.MenuItem;

public class CreateAddress implements Action {
	
	BackendManagerMenuAction bmm;
	
	public CreateAddress(MenuItem menuitem, BackendManagerMenuAction bmanager) {
		this.bmm=bmanager;
	}

	public void performAction() {
		bmm.getBackendhelper().createAddressbook();
	}

}
