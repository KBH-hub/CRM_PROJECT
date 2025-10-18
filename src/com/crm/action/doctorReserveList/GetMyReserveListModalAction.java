package com.crm.action.doctorReserveList;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class GetMyReserveListModalAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		Object employeeId =  request.getSession(false).getAttribute("employeeId");
		String month = request.getParameter("month");
		String weekStart = request.getParameter("weekStart");
		String weekEnd = request.getParameter("weekEnd");
		String day = request.getParameter("day");
		String hour = request.getParameter("hour");
		
		List<ReserveVO> myReserveList = new ReserveListDAO().getMyReserveList((String) employeeId, month, weekStart, weekEnd, day, hour);
		request.setAttribute("result", myReserveList);
				
		return "/WEB-INF/json/result.jsp";
	}

}
