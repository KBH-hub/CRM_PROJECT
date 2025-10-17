package com.crm.action.SMSService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crm.action.Action;
import com.crm.model.SMSDAO;

public class SendCommonSMSAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {

        String result = "not_login";

        Object employeeId =  request.getSession(false).getAttribute("employeeId");
        System.out.println((String) employeeId);
        String[] patientNos = request.getParameterValues("patientNo");
        String content = request.getParameter("content");

        if (patientNos == null || patientNos.length == 0 || content == null) {
            request.setAttribute("result", "invalid_param");
            return "/WEB-INF/json/result.jsp";
        }

        SMSDAO dao = new SMSDAO();
        int resultCount = 0;
        
        for (String s : patientNos) {
            int patientNo = Integer.parseInt(s);
            int r = dao.addCommonSMS(patientNo, (String) employeeId, content);
            resultCount += r;
        }

        result = (resultCount > 0) ? "success" : "fail";

        request.setAttribute("result", result);
        return "/WEB-INF/json/result.jsp";
    }
}
