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
            // DAO로 DB에서 정보를 가져옵니다.
            Map<String, Object> sidebarInfo = new LoginDAO().getEmployeeInfo(employeeId);
            
            // 가져온 데이터를 "sidebarData"라는 이름으로 request에 담습니다.
            request.setAttribute("result", sidebarInfo);
        }
        
        // FrontController에게 이 데이터를 "sidebar-data.jsp"로 넘겨달라고 요청합니다.
        return "/WEB-INF/json/result.jsp"; //
        
    }
}
