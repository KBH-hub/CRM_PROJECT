package com.crm.action;

import com.crm.action.patient.GetDoctorListByDateAction;
import com.crm.action.SMSService.GetCommonRecipientAction;
import com.crm.action.SMSService.GetCommonSMSAction;
import com.crm.action.SMSService.GetReserveRecipientAction;
import com.crm.action.doctorSchedule.DoctorScheduleUIAction;
import com.crm.action.doctorSchedule.EditDoctorScheduleAction;
import com.crm.action.SMSService.GetReseveSMSAction;
import com.crm.action.SMSService.GetTemplateAction;
import com.crm.action.SMSService.PatientListModalAction;
import com.crm.action.SMSService.ReserveListModalAction;
import com.crm.action.SMSService.SMSRecordUIAction;
import com.crm.action.SMSService.SMSUIAction;
import com.crm.action.doctorReserveList.CountMyReserveMonthAction;
import com.crm.action.doctorReserveList.CountMyReserveWeekAction;
import com.crm.action.doctorSchedule.DoctorListUIAction;
import com.crm.action.SMSService.SendCommonSMSAction;
import com.crm.action.SMSService.SendReserveSMSAction;
import com.crm.action.doctorReserveList.CountDailyAllReserveAction;
import com.crm.action.doctorReserveList.CountDailyMyReserveAction;
import com.crm.action.doctorReserveList.GetMyReserveListAction;
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
import com.crm.action.reserveList.getPossibleDoctorAction;
import com.crm.action.reserveList.getReserveDayAction;
import com.crm.action.reserveList.getReserveDetailAction;
import com.crm.action.doctorSchedule.AddDoctorScheduleAction;
import com.crm.action.doctorSchedule.DeleteDoctorScheduleAction;
import com.crm.action.doctorSchedule.GetDoctorListAction;
import com.crm.action.doctorSchedule.GetDoctorNameAction;
import com.crm.action.doctorSchedule.GetDoctorScheduleAction;
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
		case "deleteDoctorSchedule":
		    a = new DeleteDoctorScheduleAction();
		    break;
		case "editDoctorSchedule":
			a = new EditDoctorScheduleAction();
			break;
		case "addDoctorSchedule":
		    a = new AddDoctorScheduleAction();
		    break;
		case "getDoctorName":
			a = new GetDoctorNameAction();
			break;
		case "getDoctorSchedule":
		    a = new GetDoctorScheduleAction();
		    break;
		case "getDoctorListAction":
			a = new GetDoctorListAction();
			break; 
		case "doctorListUI":
			a = new DoctorListUIAction();
			break;
		case "countMyReserveMonth":
			a = new CountMyReserveMonthAction();
			break;
		case "countMyReserveWeek":
			a = new CountMyReserveWeekAction();
			break;
		case "getMyReserveList":
			a = new GetMyReserveListAction();
			break;
		case "countDailyAllReserve":
			a = new CountDailyAllReserveAction();
			break;
		case "countDailyMyReserve":
			a = new CountDailyMyReserveAction();
			break;
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
		case "sendReserveSMS":
			a = new SendReserveSMSAction();
			break;
		case "getCommonSMS":
			a = new GetCommonSMSAction();
			break;
		case "getCommonRecipient":
			a = new GetCommonRecipientAction();
			break;
		case "sendCommonSMS":	
			a = new SendCommonSMSAction();
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
		case "getReserveDetail":
			a = new getReserveDetailAction();
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
			
		case "getPossibleDoctor":
			a = new getPossibleDoctorAction();
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
