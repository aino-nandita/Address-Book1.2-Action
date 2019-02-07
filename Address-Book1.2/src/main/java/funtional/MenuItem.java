package funtional;

import action.Action;
import action.BackendManagerMenuAction;

public class MenuItem implements Action {
	int id;
	String name;
	Action action;
	//BackendManagerMenuAction bmm;
	
	public MenuItem(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public MenuItem(Action action) {
		this.action = action;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return + id+". "+ name+ " : " + action;
	}

	public void performAction() {
		action.performAction();
	}
}
