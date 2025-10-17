package com.crm.action.reserveList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class getReserveDayAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String targetDate = request.getParameter("targetDate");
		
		if(targetDate == null || targetDate.isEmpty()){
			
			 System.err.println("ERROR:targetDate 파라미터가 누락되었거나 비어있습니다.");
	            request.setAttribute("result", new ArrayList<ReserveVO>()); // 빈 JSON 배열 반환
	            return "/WEB-INF/json/result.jsp";
		}
		
		ReserveListDAO dao = new ReserveListDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<ReserveVO> getReserveDay = dao.getReserveDay(targetDate);
		request.setAttribute("result", getReserveDay);
        
		return "/WEB-INF/json/result.jsp";
	}

}
