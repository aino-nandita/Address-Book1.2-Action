package funtional;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import backend.AddDatabaseBackendAction;
import backend.AddFileBackendAction;
import backend.SwitchToDatabaseBackendAction;
import backend.SwitchToFileBackendAction;
import backendmanager.ListBackendMenuAction;


public class Menu extends MenuItem implements Action {
	protected ArrayList<MenuItem> menulist=new ArrayList<MenuItem>();
	int ch=-1;

	Action action;
	private Scanner scanner;

	public Menu(int id, String name) {
		super(id, name);
	}

	public Menu(Action action) {
		super(action);
	}

	@Override
	public void performAction() {
		if(super.action instanceof AddDatabaseBackendAction || super.action instanceof AddFileBackendAction || super.action instanceof ListBackendMenuAction) {   
			super.action.performAction();
		}
		else if(super.action instanceof SwitchToFileBackendAction || super.action instanceof SwitchToDatabaseBackendAction) {
			super.action.performAction();
			
			while(true) {
				System.out.println(getName());
				displayMenuItems();
				System.out.println("Enter your choice: ");
				selectMenuItemChoice();
				
				boolean found=false;
				try {
					for(MenuItem m : menulist) {
						if(ch==m.getId()) {
							m.performAction();
							found=true;
							break;
						}
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				if(found==false) {
					System.out.println("Invalid choice! ");
				}
			}
		}
		else {
			while(true) {
				System.out.println(getName());
				displayMenuItems();
				System.out.println("Enter your choice: ");
				selectMenuItemChoice();
				validateChoice();
			}
		}	
	}

	public void displayMenuItems() {	
		for(MenuItem m : menulist) {
			System.out.println(m);
		}
	}

	public void selectMenuItemChoice() {
		scanner = new Scanner(System.in);
		ch=scanner.nextInt();
	}

	public void validateChoice() {
		boolean found=false;
		try {
			for(MenuItem m : menulist) {
				if(ch==m.getId()) {
					m.performAction();
					found=true;
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(found==false) {
			System.out.println("Invalid choice! ");
		}
	}


	public void addMenuItem(MenuItem m ) {
		menulist.add(m);
	}
}
