package com.crm.action.patient;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ManageDoctorVO;
import com.crm.model.PatientListDAO;

public class GetDoctorListByDateAction implements Action {

    @Override
    public String execute(HttpServletRequest req) throws IOException {
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        PatientListDAO dao = new PatientListDAO();
        List<ManageDoctorVO> result = dao.getDoctorName(startDate, endDate);

        req.setAttribute("result", result);

        return "/WEB-INF/json/getDoctorListByDate.jsp";

    }
}