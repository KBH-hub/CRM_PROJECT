package com.crm.action;

public class ActionFactory {
	private ActionFactory() {
	}

	public static Action getAction(String cmd) {
		Action a = null;
		
		switch (cmd) {
		case "managerMainUIAction":
			a = new ManagerMainUIAction();
			break;
		case "doctorMainUIAction":
			a = new DoctorMainUIAction();
			break;
		case "loginAction":
			a = new LoginAction();
			break;
		case "logoutAction":
			a = new LogoutAction();
			break;
		case "sidebarAction":
	        a = new SidebarAction();
	        break;
		case "loginUI":
		case "mainUI":
	    	a = new LoginUIAction();
	    	break;
	    default :
	    	a = new LoginUIAction();
		}
		return a;
	}

}
