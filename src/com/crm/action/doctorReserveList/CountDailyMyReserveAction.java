package com.crm.action.doctorReserveList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class CountDailyMyReserveAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String employeeId = (String) session.getAttribute("employeeId");
		
		ReserveListDAO dao = new ReserveListDAO();
		List<ReserveVO> myReserve = dao.countDailyMyReserve(employeeId);

		request.setAttribute("result", myReserve);
		return "/WEB-INF/json/result.jsp";
	}

}
