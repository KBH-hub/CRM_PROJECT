package com.crm.action.reserveList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class CountReserveWeekByTimeAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
		
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            System.err.println("ERROR: startDate �삉�뒗 endDate �뙆�씪誘명꽣媛� �늻�씫�릺�뿀嫄곕굹 鍮꾩뼱�엳�뒿�땲�떎.");
            request.setAttribute("result", new ArrayList<ReserveVO>()); // 鍮� JSON 諛곗뿴 諛섑솚
            return "/WEB-INF/json/result.jsp";
        }
		

		ReserveListDAO dao = new ReserveListDAO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
		List<ReserveVO> weeklyReservationCounts = dao.countReserveWeekByTime(startDate, endDate);
		request.setAttribute("result", weeklyReservationCounts);
        
    
		return "/WEB-INF/json/result.jsp";
	}

}
