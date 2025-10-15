package com.crm.action;

public class ActionFactory {
	private ActionFactory() {
	}// 외부에서 접근 금지 위해 생성자 메서드 private

	public static Action getAction(String cmd) {
		Action a = null;
		// 구현부
		switch (cmd) {
//		case "logoutAction":
//			a = new LogoutAction();
//			break;
//		case "loginAction":
//			a = new LoginAction();// 3
//			break;
//		case "loginUI":
//		case "mainUI":
//			a = new LoginUIAction();
//			break;
//		default:
//			a = new LoginUIAction();
		
		case "reserveCalUI": // 예약관리를 눌렀을 때
			a = new ReserveCalUIAction();
			break;
		case "countReserveMonth":
			a = new CountReserveMonthAction();
			break;
		case "countReserveWeekByTime":
			a = new CountReserveWeekByTimeAction();
			break;
			
			
//		default:
//			a = new LoginUIAction();
		}
		return a;// 4
	}

}
