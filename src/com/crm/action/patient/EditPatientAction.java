package com.crm.action.patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.PatientListDAO;

public class EditPatientAction implements Action {
    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String patientName = req.getParameter("patientName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String birth = req.getParameter("birth");
        String gender = req.getParameter("gender");
        String path = req.getParameter("path");
        int patientNo = Integer.parseInt(req.getParameter("patientNo"));

        PatientListDAO dao = new PatientListDAO();
        int result = dao.editPatient(patientName, phone, address, birth, gender, path, patientNo);

        req.setAttribute("result", result > 0 ? "success" : "fail");
        return "/WEB-INF/json/editPatient.jsp";
    }
}
