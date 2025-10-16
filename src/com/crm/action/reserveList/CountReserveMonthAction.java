package com.crm.action.reserveList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;
import com.google.gson.Gson;

public class CountReserveMonthAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String monthParam = request.getParameter("month");
		
		ReserveListDAO dao = new ReserveListDAO();
		List<ReserveVO> dailyCounts = dao.countReserveMonth(monthParam);
	
		

		request.setAttribute("result", dailyCounts); 
		
		return "/WEB-INF/json/result.jsp";
	}

	

}
