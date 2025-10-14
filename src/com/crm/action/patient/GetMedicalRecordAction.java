package com.crm.action.patient;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.model.MedicalRecordVO;
import com.crm.model.PatientListDAO;
import com.crm.model.PatientVO;
import com.google.gson.Gson;

public class GetMedicalRecordAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String noParam = req.getParameter("patientNo");
        if (noParam == null || noParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "patientNo is missing");
            return null;
        }

        int patientNo = Integer.parseInt(noParam);

        PatientListDAO dao = new PatientListDAO();
        List<MedicalRecordVO> result = dao.getMedicalRecord(patientNo);

        req.setAttribute("result", result);
        return "getMedicalRecord.jsp";
	}

}
