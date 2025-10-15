package com.crm.action.patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.PatientListDAO;

public class DeletePatientAction implements Action {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String patientNoList = req.getParameter("patientNoList");
        if (patientNoList == null || patientNoList.trim().isEmpty()) {
            req.setAttribute("result", "fail");
            return "/WEB-INF/json/deletePatient.jsp";
        }
        String[] arr = patientNoList.split(",");

        int result = 0;
        PatientListDAO dao = new PatientListDAO();
        for (String no : arr) {
            int patientNo = Integer.parseInt(no.trim());
        	result += dao.deletePatient(patientNo);
        }

        req.setAttribute("result", result == arr.length ? "success" : "fail");
        return "/WEB-INF/json/deletePatient.jsp";
    }
}
