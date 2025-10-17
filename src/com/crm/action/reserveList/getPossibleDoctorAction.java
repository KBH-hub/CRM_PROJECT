package com.crm.action.reserveList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class getPossibleDoctorAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reserveDateStr = request.getParameter("reserveDate");
		String reserveHourStr = request.getParameter("reserveHour");
		String reserveMinuteStr =  request.getParameter("reserveMinute");

		
		String fullReserveDateTime = String.format("%s %s:%s", reserveDateStr, reserveHourStr, reserveMinuteStr);
		
		
	
		ReserveListDAO dao = new ReserveListDAO();
		List<ReserveVO> possibleDoctor = dao.getPossibleDoctor(reserveDateStr, fullReserveDateTime);
		request.setAttribute("result", possibleDoctor);

		return "/WEB-INF/json/result.jsp";
	}

}
