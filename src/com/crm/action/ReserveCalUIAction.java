package com.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReserveCalUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "reserveList.html";
	}


}
