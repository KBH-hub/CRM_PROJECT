package com.crm.action.SMSService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.SMSDAO;

public class SendReserveSMSAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
	       String result = "not_login";

	        Object employeeId =  request.getSession(false).getAttribute("employeeId");
	        String[] reserveNos = request.getParameterValues("reserveNo");
	        String templateName = request.getParameter("templateName");
	        
	        SMSDAO dao = new SMSDAO();
	        int resultCount = 0;
	        
	        for (String s : reserveNos) {
	            int reserveNo = Integer.parseInt(s);
	            int r = dao.addReserveSMS(reserveNo, (String) employeeId, templateName);
	            resultCount += r;
	        }

	        result = (resultCount > 0) ? "success" : "fail";

	        request.setAttribute("result", result);
	        return "/WEB-INF/json/result.jsp";
	}

}
