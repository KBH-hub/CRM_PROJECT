package com.crm.action.doctorSchedule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.crm.action.Action;
import com.crm.model.ManageDoctorDAO;

public class AddDoctorScheduleAction implements Action {
    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        String doctorCode = req.getParameter("doctorCode");
        String workDate = req.getParameter("workDate");

        ManageDoctorDAO dao = new ManageDoctorDAO();
        int result = dao.addDoctorSchedule(doctorCode, workDate);

        req.setAttribute("result", result > 0 ? "success" : "fail");
        return "/WEB-INF/json/result.jsp";
    }
}
