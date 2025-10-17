package com.crm.action.doctorReserveList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class GetMyReserveListAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		HttpSession session = request.getSession();
        String employeeId = (String) session.getAttribute("employeeId");
        String targetDate = request.getParameter("targetDate");
        		
        if (targetDate == null || targetDate.isEmpty()) {
            System.err.println("ERROR: ");
            request.setAttribute("result", new ArrayList<ReserveVO>());
            return "/WEB-INF/json/result.jsp";
        }
		
		ReserveListDAO dao = new ReserveListDAO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
		List<ReserveVO> weeklyReservationCounts = dao.getMyReserveListDay(employeeId, targetDate);
		request.setAttribute("result", weeklyReservationCounts);
		System.out.println(weeklyReservationCounts);
        
    
		return "/WEB-INF/json/result.jsp";
	}

}