package helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import action.BackendManagerMenuAction;
import backend.Backend;

public class FileAddressBookHelper implements BackendHelper {
	
	ArrayList<Address> addresslist;
	private Scanner scanner;
	BackendManagerMenuAction bmm;
	Backend currentbackend;
	
	public FileAddressBookHelper(BackendManagerMenuAction  backendManagerMenu) {
		this.bmm=backendManagerMenu;
		currentbackend=backendManagerMenu.getCurrentbackend();
		addresslist=new ArrayList<Address>();
		scanner=new Scanner(System.in);
		load();
	}

	public void createAddressbook() {
		Address address=new Address();
		
		System.out.println("Enter Name: ");
		String name=scanner.next();
		System.out.println("Enter Email: ");
		String email=scanner.next();
		System.out.println("Enter Phone Number: ");
		String phoneNumber=scanner.next();
		
		address.setName(name);
		address.setEmail(email);
		address.setPhoneNumber(phoneNumber);
		
		addresslist.add(address);
		save();
		display();
		System.out.println("\nAddress Created!!!!!!!!\n ");
	}
	
	public void display() {
		System.out.println("\nList of Addresses : ");
		for(Address address: addresslist) {
			System.out.println(address.getName());
			System.out.println(address.getEmail());
			System.out.println(address.getPhoneNumber());
			System.out.println();
		}
	}
	
	
	public void readAddressbook(String name) {
		System.out.println("\n ***** Displaying Address ******\n");
		
		for(Address address : addresslist) {
			System.out.println("Name: "+ name);
			System.out.println("Email: "+ address.getEmail());
			System.out.println("Phone Number: "+ address.getPhoneNumber());
			System.out.println();
		}
	}

	public void updateAddressbook(String name) {
		System.out.println("****** Enter your details to update Address *******");
		Address addresstemp=null;
		
		for(Address add : addresslist) {
			if(name.equals(add.getName())) {
				addresstemp=add;
			}
		}
		
		System.out.println("Enter Email: ");
		String email=scanner.next();
		System.out.println("Enter Phone Number: ");
		String phoneNumber=scanner.next();
		
		addresstemp.setEmail(email);
		addresstemp.setPhoneNumber(phoneNumber);
		
		//addresslist.add(addresstemp);
		save();
		display();
		System.out.println("Address Updated!!! \n");
	}

	public void deleteAddressbook(String name) {
		System.out.println("***** Delete the details ******");
		//Address address=new Address();
		Address addtemp=null;
		for(Address add : addresslist) {
			if(name.equals(add.getName())) {
				addtemp=add;
				break;
			}
		}
		addresslist.remove(addtemp);
		save();
		display();
		System.out.println("\nAddress Deleted!!!!!!!!\n");
	}
	
	public void save() { 
		try {
			FileOutputStream fos=new FileOutputStream(currentbackend.toString());
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(addresslist);
			oos.close();
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() { //deserialize
		try {
			FileInputStream fin=new FileInputStream(currentbackend.toString());
			ObjectInputStream ois=new ObjectInputStream(fin);
			
			addresslist=(ArrayList<Address>) ois.readObject();
			System.out.println("addresslist has been deserialized! ");
			
		} catch(IOException e) {
			e.printStackTrace();
			//System.out.println("IOException is caught");
		} catch(ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught");
		}
	}
}

//if(isValidEmail()) {	
//	}
//	if(isValidPhoneNumber()) {	
	//}

/*public boolean isValidEmail() {
String email="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
Pattern pattern=Pattern.compile(email);

if(email==null)
	return false;

return pattern.matcher(email).matches();
}

public boolean isValidPhoneNumber() {
String phoneNumber="(0/91)?[7-9][0-9]{9}";
Pattern pattern=Pattern.compile(phoneNumber);
if(phoneNumber==null)
	return false;

Matcher matcher=pattern.matcher(phoneNumber);
if(matcher.matches()) {
	System.out.println( phoneNumber + "is a Valid PhoneNumber!!!\n");
}
return false;
}*/

