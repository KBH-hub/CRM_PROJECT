package com.crm.action.doctorSchedule;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.crm.action.Action;
import com.crm.model.ManageDoctorDAO;
import com.crm.model.ManageDoctorVO;

public class GetDoctorNameAction implements Action {
    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        ManageDoctorDAO dao = new ManageDoctorDAO();
        List<ManageDoctorVO> list = dao.getDoctorName(startDate, endDate);

        req.setAttribute("result", list);
        return "/WEB-INF/json/result.jsp";
    }
}
