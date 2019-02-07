package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Scanner;

import action.BackendManagerMenuAction;

public class DatabaseAddressBookHelper implements BackendHelper {
	BackendManagerMenuAction backendManagerMenu;
	
	Connection connection=null;
	Statement statement;
	ResultSet result;
	
	public DatabaseAddressBookHelper(BackendManagerMenuAction backendManagerMenu) {
		this.backendManagerMenu=backendManagerMenu;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // To load the mySQL driver
			
			System.out.println("Trying to connect to database....");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book","root","root");     
			System.out.println("Connection established successfully!!!!");
		}
		catch(Exception e) {
			 System.out.println("Unable to connect to mySQL database!");
			 System.out.println(e.getMessage());
		} 
	}

	public void createAddressbook() {
		Address address=new Address();
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String name=scanner.next();
		System.out.println("Enter Email: ");
		String email=scanner.next();
		System.out.println("Enter Phone Number: ");
		String phoneNumber=scanner.next();
		
		address.setName(name);
		address.setEmail(email);
		address.setPhoneNumber(phoneNumber);
		
		try {
			statement=connection.createStatement();
			statement.executeUpdate("Insert into Address2 values('"+address.getName() + "','" +address.getEmail()+ "','"+ address.getPhoneNumber() +"')");	
			System.out.println("Data inserted!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readAddressbook(String name) {
		Address address=new Address();
		try {
			statement=connection.createStatement();
			result=statement.executeQuery("SELECT * from Address2 where name='"+ name+"'");
			address.name=name;
			
			if(result.next()) {
				String email=result.getString("email");
				String phoneNumber=result.getString("phonenumber");
				
				System.out.println("Name: "+ name);
				System.out.println("Email: "+ email);
				System.out.println("Phone Number: "+ phoneNumber);
			}
			
			System.out.println("\nReading Data!\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAddressbook(String name) {
		Address address=new Address();
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Email: ");
		String email=scanner.next();
		System.out.println("Enter Phone Number: ");
		String phoneNumber=scanner.next();
		
		address.setEmail(email);
		address.setPhoneNumber(phoneNumber);
		
		try {
			statement=connection.createStatement();
			statement.executeUpdate("Update Address2 set email='"+ address.email +"', phonenumber='"+ address.phoneNumber +"' where name= '" + name + "' ");	
			
			System.out.println("Name: "+ name);
			System.out.println("Email: "+ email);
			System.out.println("Phone Number: "+ phoneNumber);
			
			System.out.println("\nData Updated!\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAddressbook(String name) {
		try {
			statement=connection.createStatement();
			statement.executeUpdate("delete from Address2 where name='"+ name +"' ");	
			System.out.println("Data Deleted!");	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
