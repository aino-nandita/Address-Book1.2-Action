package crud;

import java.util.Scanner;

import action.Action;
import action.BackendManagerMenuAction;
import funtional.MenuItem;

public class DeleteAddress implements Action {
	BackendManagerMenuAction bm;
	Scanner scanner;
	public DeleteAddress(MenuItem menuitem, BackendManagerMenuAction bmanager) {
		scanner=new Scanner(System.in);
		this.bm=bmanager;
	}

	public void performAction() {
		System.out.println("Enter the name to delete the Address: ");
		String name=scanner.next();
		bm.getBackendhelper().deleteAddressbook(name);
	}

}
