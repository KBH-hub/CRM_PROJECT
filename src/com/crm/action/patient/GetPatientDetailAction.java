package com.crm.action.patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.model.PatientListDAO;
import com.crm.model.PatientVO;
import com.google.gson.Gson;

public class GetPatientDetailAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1. 요청 파라미터 받기
        String noParam = req.getParameter("patientNo");
        if (noParam == null || noParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "patientNo is missing");
            return null;
        }

        int patientNo = Integer.parseInt(noParam);

        // 2. DAO 호출
        PatientListDAO dao = new PatientListDAO();
        PatientVO vo = dao.getPatientDetail(patientNo);

        // 3. JSON으로 응답
        resp.setContentType("application/json; charset=UTF-8");
        Gson gson = new Gson();
        String json = gson.toJson(vo);
        resp.getWriter().write(json);

        return null; // JSP 이동 없음 (AJAX 응답)
    }
}
