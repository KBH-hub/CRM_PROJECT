package com.crm.action.patient;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.crm.action.Action;
import com.crm.model.*;
import com.google.gson.Gson;

public class GetPatientListAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // ✅ 파라미터 수집 및 페이징 계산
        int page = parseInt(req.getParameter("page"), 1);
        int pageSize = parseInt(req.getParameter("pageSize"), 10);
        int startRow = (page - 1) * pageSize + 1;
        int endRow = page * pageSize;

        Map<String, Object> map = new HashMap<>();
        map.put("startDate", req.getParameter("startDate"));
        map.put("endDate", req.getParameter("endDate"));
        map.put("doctorCode", req.getParameter("doctorCode"));
        map.put("patientName", req.getParameter("patientName"));
        map.put("birth", req.getParameter("birth"));
        map.put("startRow", startRow);
        map.put("endRow", endRow);

        // ✅ DAO 호출
        PatientListDAO dao = new PatientListDAO();
        List<PatientVO> list = dao.getPatientList(map);
        int totalCount = dao.getTotalCount();

        // ✅ JSON 응답용 결과 Map
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("totalCount", totalCount);

        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().print(new Gson().toJson(result));
        return null;
    }

    // ✅ 안전한 int 파싱 유틸
    private int parseInt(String val, int def) {
        try { return (val == null || val.isEmpty()) ? def : Integer.parseInt(val); }
        catch (Exception e) { return def; }
    }
}
