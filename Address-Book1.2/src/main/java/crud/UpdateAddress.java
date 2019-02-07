package crud;

import java.util.Scanner;

import action.Action;
import action.BackendManagerMenuAction;
import funtional.MenuItem;

public class UpdateAddress implements Action {
	BackendManagerMenuAction bmm;
	private Scanner scanner;
	
	public UpdateAddress(MenuItem menuitem, BackendManagerMenuAction bmanager) {
		scanner=new Scanner(System.in);
		this.bmm=bmanager;
	}

	public void performAction() {
		System.out.println("Enter the name to update the Address: ");
		String name=scanner.next();
		bmm.getBackendhelper().updateAddressbook(name);
	}

}
