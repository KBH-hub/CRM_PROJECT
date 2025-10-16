package com.crm.action.doctorReserveList;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class CountMyReserveMonthAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String employeeId = (String) session.getAttribute("employeeId");
        String monthParam = request.getParameter("month");
        
        if (employeeId != null) {
        	List<ReserveVO> dailyCounts = new ReserveListDAO().countMyReserveMonth(employeeId,monthParam);
        	request.setAttribute("result", dailyCounts);
        	
        }
		return "/WEB-INF/json/result.jsp";
	}

}
