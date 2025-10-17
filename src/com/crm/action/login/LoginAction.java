package com.crm.action.login;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crm.action.Action;
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
			HttpSession session = request.getSession();
			session.setAttribute("employeeId", employeeId);
			if ("관리자".equals(authority)) {
                request.setAttribute("redirectUrl", "reserveList.html");
            } else {
                request.setAttribute("redirectUrl", "doctorReserveList.html");
            }

            url = "/WEB-INF/json/redirect.jsp";
        }
		return url;
	}

}
