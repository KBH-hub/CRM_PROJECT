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

public class CountDailyAllReserveAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		ReserveListDAO dao = new ReserveListDAO();
		List<ReserveVO> allReserve = dao.countDailyAllReserve();

		request.setAttribute("result", allReserve);
		return "/WEB-INF/json/result.jsp";
	}

}
