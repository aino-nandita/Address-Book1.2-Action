package action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import backend.Backend;
import backendmanager.AddBackendMenuAction;
import backendmanager.ExitAction;
import backendmanager.ListBackendMenuAction;
import backendmanager.SwitchBackendMenuAction;
import funtional.Menu;
import helper.BackendHelper;

public class BackendManagerMenuAction implements Action {
	
	public ArrayList<Backend> list ;
	Backend currentbackend;
	BackendHelper backendhelper;
    Menu menu1;
	Menu addBM;
	Menu listBM;
	Menu selectBM;
	Menu exit;
	
	public BackendManagerMenuAction(Menu menu){
		list=new ArrayList<Backend>();
		
	    addBM=new Menu(1, " Add Backend Menu");
		addBM.setAction(new AddBackendMenuAction(addBM, this));
		
		listBM=new Menu(2, " List of Backend Menu");
		listBM.setAction(new ListBackendMenuAction(listBM, this));
		
		selectBM=new Menu(3, " Switch Backend Menu");
		selectBM.setAction(new SwitchBackendMenuAction(selectBM,this));
		
		exit=new Menu(4," Exit");
		exit.setAction( new ExitAction(exit));
		
		menu.addMenuItem(addBM);
		menu.addMenuItem(listBM);
		menu.addMenuItem(selectBM);
		menu.addMenuItem(exit);
		load();
	}

	
	public ArrayList<Backend> getList() {
		return list;
	}

	public void setList(ArrayList<Backend> list) {
		this.list = list;
	}

	public Backend getCurrentbackend() {
		return currentbackend;
	}

	public void setCurrentbackend(Backend currentbackend) {
		this.currentbackend = currentbackend;
	}

	public BackendHelper getBackendhelper() {
		return backendhelper;
	}

	public void setBackendhelper(BackendHelper backendhelper) {
		this.backendhelper = backendhelper;
	}

	public void addBackendDetails(Backend backend) {
		list.add(backend);
		save();
	}
	
	public void display() {
		for(Backend b : list) {
			System.out.println(b);
		}
	}
	
	public void performAction() {
		//menu1.performAction();
	}
	
	public void save() { 
		try {
			FileOutputStream fos=new FileOutputStream("/home/intern2/Desktop/PathFile/Nandita1.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(list);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try {
			FileInputStream fin=new FileInputStream("/home/intern2/Desktop/PathFile/Nandita1.ser");
			ObjectInputStream ois=new ObjectInputStream(fin);
			
			list=(ArrayList<Backend>) ois.readObject();
			
			System.out.println("list has been deserialized! ");
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught");
		}
	}
}
