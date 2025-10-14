package com.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUIAction implements Action {

	@Override	//6
	public String execute(HttpServletRequest req) throws ServletException, IOException {
		return "login.html";
	}

}
