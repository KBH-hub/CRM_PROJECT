package com.crm.action;

import com.crm.action.patient.GetDoctorListByDateAction;
import com.crm.action.smsService.GetCommonRecipientAction;
import com.crm.action.patient.AddPatientAction;
import com.crm.action.patient.AddPatientUIAction;
import com.crm.action.patient.DeletePatientAction;
import com.crm.action.patient.EditPatientAction;
import com.crm.action.patient.GetPatientDetailAction;
import com.crm.action.patient.GetPatientListAction;
import com.crm.action.patient.PatientInfoUIAction;
import com.crm.action.patient.PatientUIAction;

import com.crm.action.smsService.GetTemplateAction;
import com.crm.action.smsService.PatientListModalAction;
import com.crm.action.smsService.ReserveListModalAction;
import com.crm.action.smsService.ReserveSmsUIAction;
import com.crm.action.smsService.SmsUIAction;
import com.crm.action.smsService.sendCommonSMSAction;

public class ActionFactory {
	private ActionFactory() {
	}

	public static Action getAction(String cmd) {
		Action a = null;

		switch (cmd) {
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

		case "smsUI":
			a = new SmsUIAction();
			break;
		case "reserveSmsUI":
			a = new ReserveSmsUIAction();
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
		case "getCommonRecipient":
			a = new GetCommonRecipientAction();
			break;
		case "sendCommonSMS":
			a = new sendCommonSMSAction();
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
