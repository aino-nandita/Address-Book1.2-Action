package backend;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.BackendManagerMenuAction;
import backendmanager.ExitAction;
import backendmanager.GoBackAction;
import backendpojo.FileBackend;
import crud.CreateAddress;
import crud.DeleteAddress;
import crud.ReadAddress;
import crud.UpdateAddress;
import funtional.Menu;
import funtional.MenuItem;
import helper.FileAddressBookHelper;

public class SwitchToFileBackendAction implements Action {

	BackendManagerMenuAction bmm;
	MenuItem create;
	MenuItem read;
	MenuItem update;
	MenuItem delete;
	MenuItem back;
	MenuItem exit;
	private Scanner scanner;
	ArrayList<Backend> list;
	
	public SwitchToFileBackendAction(Menu menu, BackendManagerMenuAction bmanager) {
		this.bmm=bmanager;
		
		System.out.println();
		
		create=new MenuItem(1, "Create Address");
		create.setAction(new CreateAddress(create, bmanager));
		
		read=new MenuItem(2, "Read Address");
		read.setAction(new ReadAddress(read, bmanager));
		
		update=new MenuItem(3, "Update Address");
		update.setAction(new UpdateAddress(update, bmanager));
		
		delete=new MenuItem(4, "Delete Address");
		delete.setAction(new DeleteAddress(delete, bmanager));
		
		back=new MenuItem(3, "Go Back");
		back.setAction(new GoBackAction(back, bmanager));
		
		exit=new MenuItem(4,"Exit");
		exit.setAction(new ExitAction(exit));
		
		menu.addMenuItem(create);
		menu.addMenuItem(read);
		menu.addMenuItem(update);
		menu.addMenuItem(delete);
		menu.addMenuItem(back);
		menu.addMenuItem(exit);
	}

	public void performAction() {
		checkInstance();
		setCurrentBackend();
		bmm.setBackendhelper(new FileAddressBookHelper(bmm)); 
		System.out.println("Backend Helper: " + bmm.getBackendhelper()+ "\n");
	}
	
	public void checkInstance() {
		for(Backend b : bmm.list) {
			if(b instanceof FileBackend) {
				System.out.println("\nFileBackend "+ bmm.list.indexOf(b) + ". "+ b);
			} 
		}
	}
	
	public void setCurrentBackend() {
		System.out.println("\nChoose your file number: \n");
		scanner = new Scanner(System.in);
		int choice=scanner.nextInt();
		
		for(Backend currentbackend : bmm.list) {
			if(choice==bmm.list.indexOf(currentbackend)) {
				bmm.setCurrentbackend(currentbackend);
				break;
			}
		}
		System.out.println("\nCurrentbackend is :  "+ bmm.list.indexOf(bmm.getCurrentbackend())+ ". "+ bmm.getCurrentbackend() +"\n");
	}
}
