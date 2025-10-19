package com.crm.action.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.action.Action;
import com.crm.model.LoginDAO;
import com.google.gson.Gson;

public class SidebarAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
        
		HttpSession session = request.getSession();
        String employeeId = (String) session.getAttribute("employeeId");

        if (employeeId != null) {
            Map<String, Object> sidebarInfo = new LoginDAO().getEmployeeInfo(employeeId);
            
            request.setAttribute("result", sidebarInfo);
        }
        
        return "/WEB-INF/json/result.jsp";
        
    }
}
