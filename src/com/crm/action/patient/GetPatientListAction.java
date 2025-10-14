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
    public String execute(HttpServletRequest req) throws ServletException, IOException {

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
        
        String searchType = req.getParameter("searchType");
        String keyword = req.getParameter("keyword");

        if ("name".equals(searchType)) {
            map.put("patientName", keyword);
        } else if ("birth".equals(searchType)) {
            map.put("birth", keyword);
        }

        PatientListDAO dao = new PatientListDAO();
        List<PatientVO> list = dao.getPatientList(map);
        int totalCount = dao.getTotalCount(map);

        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("totalCount", totalCount);
        
        req.setAttribute("result", result);

        return "getPatientList.jsp";
    }

    private int parseInt(String val, int def) {
        try { return (val == null || val.isEmpty()) ? def : Integer.parseInt(val); }
        catch (Exception e) { return def; }
    }
}
