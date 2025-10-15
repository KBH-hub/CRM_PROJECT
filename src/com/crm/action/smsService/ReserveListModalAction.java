package com.crm.action.smsService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class ReserveListModalAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		String month = request.getParameter("month");
		String weekStart = request.getParameter("weekStart");
		String weekEnd = request.getParameter("weekEnd");
		String day = request.getParameter("day");
		String hour = request.getParameter("hour");
		
		List<ReserveVO> reserveList = new ReserveListDAO().getReserveList(month, weekStart, weekEnd, day, hour);
		request.setAttribute("reserveList", reserveList);
				
		return "/WEB-INF/json/getReserveList.jsp";
	}

}
