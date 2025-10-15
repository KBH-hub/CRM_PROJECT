package com.crm.action.patient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.PatientListDAO;

public class AddPatientAction implements Action {

	@Override
	public String execute(HttpServletRequest req) throws ServletException, IOException {
		String patientName = req.getParameter("patientName");
		String phone = req.getParameter("phone");
		
		PatientListDAO dao = new PatientListDAO();
        int patientNo = dao.addPatient(patientName, phone);

        Map<String, Object> map = new HashMap<>();
        if (patientNo > 0) {
            map.put("result", "success");
            map.put("patientNo", patientNo);
        } else {
            map.put("result", "fail");
        }
        
        req.setAttribute("result", map);
		return "/WEB-INF/json/result.jsp";
	}

}
