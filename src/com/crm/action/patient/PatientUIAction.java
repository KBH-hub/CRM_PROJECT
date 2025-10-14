package com.crm.action.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;

public class PatientUIAction implements Action {

	@Override	//6
	public String execute(HttpServletRequest req) throws ServletException, IOException {
		return "patientList.html";
	}

}
