package com.crm.action.SMSService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveSMSVO;
import com.crm.model.SMSDAO;

public class GetTemplateAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<ReserveSMSVO> list = new SMSDAO().getTemplate(request.getParameter("templateName"));
		request.setAttribute("result", list);
		
		return "/WEB-INF/json/result.jsp";
	}

}
