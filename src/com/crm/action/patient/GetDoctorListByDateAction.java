package com.crm.action.patient;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.model.ManageDoctorVO;
import com.crm.model.PatientListDAO;
import com.google.gson.Gson;

public class GetDoctorListByDateAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        PatientListDAO dao = new PatientListDAO();
        List<ManageDoctorVO> result = dao.getDoctorName(startDate, endDate);

        request.setAttribute("result", result);

        return "getMedicalRecord.jsp";
    }
}