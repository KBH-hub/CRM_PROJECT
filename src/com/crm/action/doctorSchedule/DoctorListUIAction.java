package com.crm.action.doctorSchedule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;

public class DoctorListUIAction implements Action {

	@Override	//6
	public String execute(HttpServletRequest req) throws ServletException, IOException {
		return "manageDoctorList.html";
	}

}
