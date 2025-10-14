package com.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ManagerMainUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		return "reserveList.html";
	}

}
