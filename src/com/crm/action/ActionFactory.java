package com.crm.action;

import com.crm.action.patient.GetDoctorListByDateAction;
import com.crm.action.patient.GetPatientListAction;
import com.crm.action.patient.PatientUIAction;

public class ActionFactory {
	private ActionFactory() {
	}// 외부에서 접근 금지 위해 생성자 메서드 private

	public static Action getAction(String cmd) {
		Action a = null;
		// 구현부
		switch (cmd) {
		case "getDoctorListByDateAction":
		    a = new GetDoctorListByDateAction();
		    break;
		case "getPatientListAction":
			a = new GetPatientListAction();
			break;
		case "patientListUI":
			a = new PatientUIAction();
			break;
		case "reserveListUI":
			a = new ReserveListUIAction();
			break;
//		case "logoutAction":
//			a = new LogoutAction();
//			break;
//		case "loginAction":
//			a = new LoginAction();// 3
//			break;
		case "loginUI":
		case "mainUI":
			a = new LoginUIAction();
			break;
		default:
			a = new LoginUIAction();
		}
		return a;// 4
	}

}
