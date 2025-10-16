package com.crm.action.SMSService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.CommonSMSVO;
import com.crm.model.SMSDAO;

public class GetCommonRecipientAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String[] patientNoParm = request.getParameterValues("patientNo");
		List<Integer> patientNo = new ArrayList<>();
		if (patientNoParm != null) {
			for (String no : patientNoParm) {
				patientNo.add(Integer.parseInt(no));
			}
		}
		SMSDAO dao = new SMSDAO();
		List<CommonSMSVO> list = dao.getCommonRecipient(patientNo);
		request.setAttribute("result", list);
		return "/WEB-INF/json/result.jsp";
	}

}
