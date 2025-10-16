package com.crm.action.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;

public class DoctorMainUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		return "doctorReserveList.html";
	}

}
