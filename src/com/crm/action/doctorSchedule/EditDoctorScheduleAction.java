package com.crm.action.doctorSchedule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.crm.action.Action;
import com.crm.model.ManageDoctorDAO;

public class EditDoctorScheduleAction implements Action {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        String noParam = req.getParameter("doctorScheduleNo");
        String amParam = req.getParameter("am");
        String pmParam = req.getParameter("pm");

        int result = 0;
        try {
            if (noParam != null && amParam != null && pmParam != null) {
                int doctorScheduleNo = Integer.parseInt(noParam);
                char am = amParam.charAt(0);
                char pm = pmParam.charAt(0);

                ManageDoctorDAO dao = new ManageDoctorDAO();
                result = dao.editDoctorSchedule(doctorScheduleNo, am, pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("result", result > 0 ? "success" : "fail");
        return "/WEB-INF/json/result.jsp";
    }
}
