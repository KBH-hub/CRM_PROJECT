package com.crm.action.smsService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;

public class PatientListModalAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String patientNo = request.getParameter("patientNo");
		String patientName = request.getParameter("patientName");
		String phone = request.getParameter("phone");
		
		
		return null;
	}

}
