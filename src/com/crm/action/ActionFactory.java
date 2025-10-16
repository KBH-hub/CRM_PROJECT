package com.crm.action;

import com.crm.action.patient.GetDoctorListByDateAction;
import com.crm.action.SMSService.GetCommonRecipientAction;
import com.crm.action.SMSService.GetCommonSMSAction;
import com.crm.action.SMSService.GetReserveRecipientAction;
import com.crm.action.doctorSchedule.DoctorScheduleUIAction;
import com.crm.action.SMSService.GetReseveSMSAction;
import com.crm.action.patient.AddPatientAction;
import com.crm.action.patient.AddPatientUIAction;
import com.crm.action.patient.DeletePatientAction;
import com.crm.action.patient.EditPatientAction;
import com.crm.action.patient.GetPatientDetailAction;
import com.crm.action.patient.GetPatientListAction;
import com.crm.action.patient.PatientInfoUIAction;
import com.crm.action.patient.PatientUIAction;
import com.crm.action.reserveList.CountReserveMonthAction;
import com.crm.action.reserveList.CountReserveWeekByTimeAction;
import com.crm.action.reserveList.ReserveCalUIAction;
import com.crm.action.reserveList.ReserveListUIAction;
import com.crm.action.reserveList.getReserveDayAction;
import com.crm.action.SMSService.GetTemplateAction;
import com.crm.action.SMSService.PatientListModalAction;
import com.crm.action.SMSService.ReserveListModalAction;
import com.crm.action.SMSService.SMSRecordUIAction;
import com.crm.action.SMSService.SMSUIAction;
import com.crm.action.login.DoctorMainUIAction;
import com.crm.action.login.LoginAction;
import com.crm.action.login.LoginUIAction;
import com.crm.action.login.LogoutAction;
import com.crm.action.login.ManagerMainUIAction;
import com.crm.action.login.SidebarAction;

public class ActionFactory {
	private ActionFactory() {
	}

	public static Action getAction(String cmd) {
		Action a = null;

		switch (cmd) {
		case "doctorScheduleUI":
			a = new DoctorScheduleUIAction();
			break;
			
		case "deletePatientAction":
			a = new DeletePatientAction();
			break;
		case "editPatientAction":
			a = new EditPatientAction();
			break;
		case "addPatientAction":
			a = new AddPatientAction();
			break;
		case "addPatientUI":
			a = new AddPatientUIAction();
			break;
		case "getPatientDetailAction":
			a = new GetPatientDetailAction();
			break;
		case "patientInfoUI":
			a = new PatientInfoUIAction();
			break;
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

		case "SMSUI":
			a = new SMSUIAction();
			break;
		case "SMSRecordUI":
			a = new SMSRecordUIAction();
			break;
		case "getTemplate":
			a = new GetTemplateAction();
			break;
		case "reserveListModal":
			a = new ReserveListModalAction();
			break;
		case "patientListModal":
			a = new PatientListModalAction();
			break;
		case "getReserveSMS":
			a = new GetReseveSMSAction();
			break;
		case "getReserveRecipient":
			a = new GetReserveRecipientAction();
			break;
		case "getCommonSMS":
			a = new GetCommonSMSAction();
			break;
		case "getCommonRecipient":
			a = new GetCommonRecipientAction();
			break;
		case "reserveCalUI": 
			a = new ReserveCalUIAction();
			break;
		case "countReserveMonth":
			a = new CountReserveMonthAction();
			break;
		case "countReserveWeekByTime":
			a = new CountReserveWeekByTimeAction();
			break;
			
		case "getReserveDay":
			a = new getReserveDayAction();
			break;
			
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
		default:
			a = new LoginUIAction();
			break;
		}
		return a;
	}
}
