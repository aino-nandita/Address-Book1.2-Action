package crud;

import java.util.Scanner;

import action.Action;
import action.BackendManagerMenuAction;
import funtional.MenuItem;

public class ReadAddress implements Action {
	BackendManagerMenuAction bmm;
	Scanner scanner;
	
	public ReadAddress(MenuItem menuitem, BackendManagerMenuAction bmanager) {
		scanner=new Scanner(System.in);
		this.bmm=bmanager;
	}

	public void performAction() {
		System.out.println("Enter the name to display the Address: ");
		String name=scanner.next();
		bmm.getBackendhelper().readAddressbook(name);
	}

}
