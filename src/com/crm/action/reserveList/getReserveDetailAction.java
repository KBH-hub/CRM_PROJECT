package com.crm.action.reserveList;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class getReserveDetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String reserveNoStr = request.getParameter("reserveNo");
		int reserveNo = 0;
		
		if(reserveNoStr != null && !reserveNoStr.isEmpty()){
			reserveNo = Integer.parseInt(reserveNoStr);
		}else {
			System.out.println("예약 찾지 못함");
			return "/WEB-INF/json/result.jsp";
		}
		
		
		ReserveListDAO dao = new ReserveListDAO();
		
		ReserveVO reserveDetail = dao.getReserveDetail(reserveNo);
		
		request.setAttribute("result", reserveDetail);
		return "/WEB-INF/json/result.jsp";
	}

}
