package app;

import action.BackendManagerMenuAction;
import funtional.Menu;

public class App {

	public static void main(String args[]) {
		System.out.println("Welcome to Address Book\n");
		
		Menu menu=new Menu(1, "Backend Manager Menu");
		menu.setAction(new BackendManagerMenuAction(menu));
		menu.performAction();
	}	
}
