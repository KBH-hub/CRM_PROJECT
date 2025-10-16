package com.crm.action.SMSService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveSMSVO;
import com.crm.model.SMSDAO;

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
		SMSDAO dao = new SMSDAO();
		List<ReserveSMSVO> list = dao.getReserveRecipient(reserveNo);
		request.setAttribute("result", list);
		return "/WEB-INF/json/result.jsp";
	}

}
