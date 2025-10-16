package com.crm.action.smsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveSmsVO;
import com.crm.model.SmsDAO;

public class GetReserveRecipientAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String[] reserveNoParm = request.getParameterValues("reserveNo");
		List<Integer> reserveNo = new ArrayList<>();
		if (reserveNoParm != null) {
			for (String no : reserveNoParm) {
				reserveNo.add(Integer.parseInt(no));
			}
		}
		SmsDAO dao = new SmsDAO();
		List<ReserveSmsVO> list = dao.getReserveRecipient(reserveNo);
		request.setAttribute("result", list);
		return "/WEB-INF/json/result.jsp";
	}

}
