package com.crm.action.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;

public class AddPatientUIAction implements Action {

	@Override
	public String execute(HttpServletRequest req){
		return "addPatient.html";
	}

}
