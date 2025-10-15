package com.crm.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		 Gson gson = new Gson();
		 String jsonString = gson.toJson(dailyCounts); 

		request.setAttribute("list", jsonString); 
		
		return "json.jsp";
	}

	

}
