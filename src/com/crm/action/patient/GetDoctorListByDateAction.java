package com.crm.action.patient;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.model.ManageDoctorVO;
import com.crm.model.PatientListDAO;

public class GetDoctorListByDateAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        PatientListDAO dao = new PatientListDAO();
        List<ManageDoctorVO> list = dao.getDoctorName(startDate, endDate);

        // JSON 직접 생성
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            ManageDoctorVO vo = list.get(i);
            json.append("{")
                .append("\"doctorCode\":\"").append(vo.getDoctorCode()).append("\",")
                .append("\"employeeName\":\"").append(vo.getEmployeeName()).append("\",")
                .append("\"department\":\"").append(vo.getDepartment()).append("\"")
                .append("}");
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");

        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(json.toString());
		return null;
    }
}