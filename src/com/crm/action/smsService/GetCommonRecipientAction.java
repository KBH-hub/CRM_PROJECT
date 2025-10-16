package com.crm.action.smsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.CommonSmsVO;
import com.crm.model.SmsDAO;

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
		SmsDAO dao = new SmsDAO();
		List<CommonSmsVO> list = dao.getCommonRecipient(patientNo);
		request.setAttribute("result", list);
		return "result.jsp";
	}

}
