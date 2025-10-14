package com.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.model.LoginDAO;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "login.html";
		
		String employeeId = request.getParameter("employeeId");
		String pw = request.getParameter("pw");
		String loginIp = request.getRemoteAddr();
		String authority = new LoginDAO().login(employeeId, pw, loginIp);
		
		if(authority != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("employeeId", employeeId);
			if("관리자".equals(authority)){
				url = "reserveList.html";
			}
			else url = "doctorReserveList.html";
		}
		return url;
	}

}
