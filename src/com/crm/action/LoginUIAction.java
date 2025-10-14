package com.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class LoginUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		return "login.html";
	}

}
