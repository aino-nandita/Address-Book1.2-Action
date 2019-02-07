package backend;

import java.util.Scanner;

import action.Action;
import action.BackendManagerMenuAction;
import backendpojo.FileBackend;
import funtional.Menu;

public class AddFileBackendAction implements Action {
	BackendManagerMenuAction bmm;
	private Scanner scanner;
	
	public AddFileBackendAction(Menu menu, BackendManagerMenuAction bmenu) {
		this.bmm=bmenu;
	}

	public void performAction() {
		create();
		bmm.save();
		bmm.display();
		System.out.println();
	}

	public void create() {
		FileBackend filebackend=new FileBackend();
		System.out.println("Enter your path");
		scanner = new Scanner(System.in);
		filebackend.setPath(scanner.next());
		bmm.addBackendDetails(filebackend);
	}
}
