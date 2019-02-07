package backend;

import java.util.Scanner;

import action.Action;
import action.BackendManagerMenuAction;
import backendpojo.DatabaseBackend;
import funtional.Menu;

public class AddDatabaseBackendAction implements Action{
	
	BackendManagerMenuAction bmm;
	private Scanner scanner;
	public AddDatabaseBackendAction(Menu menu, BackendManagerMenuAction bmanager) {
		this.bmm=bmanager;
	}

	public void performAction() {
		create();
		bmm.save();
		bmm.display();
	}
	
	public void create() {
		DatabaseBackend databasebackend=new DatabaseBackend();
		System.out.println("Enter Url: ");
		scanner = new Scanner(System.in);
		databasebackend.setUrl(scanner.next());
		
		System.out.println("Enter User name: ");
		scanner = new Scanner(System.in);
		databasebackend.setUsername(scanner.next());
		
		System.out.println("Enter Password: ");
		scanner = new Scanner(System.in);
		databasebackend.setPassword(scanner.next());
		
		bmm.addBackendDetails(databasebackend);
	}
}
