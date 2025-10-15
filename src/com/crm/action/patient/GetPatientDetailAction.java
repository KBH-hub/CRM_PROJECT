package com.crm.action.patient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.model.MedicalRecordVO;
import com.crm.model.PatientListDAO;
import com.crm.model.PatientVO;
import com.google.gson.Gson;

public class GetPatientDetailAction implements Action {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {

        String param = req.getParameter("patientNo");

        int patientNo = Integer.parseInt(param);

        PatientListDAO dao = new PatientListDAO();
        PatientVO vo = dao.getPatientDetail(patientNo);
        List<MedicalRecordVO> records = dao.getMedicalRecord(patientNo);

        Map<String, Object> result = new HashMap<>();
        result.put("patient", vo);
        result.put("records", records);

        req.setAttribute("result", result);
        return "/WEB-INF/json/getPatientDetail.jsp";
    }
}
