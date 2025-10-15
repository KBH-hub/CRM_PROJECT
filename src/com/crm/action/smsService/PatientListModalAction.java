package com.crm.action.smsService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.PatientListDAO;
import com.crm.model.PatientVO;

public class PatientListModalAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		int page = parseInt(request.getParameter("page"), 1);
        int pageSize = parseInt(request.getParameter("pageSize"), 10);
        int startRow = (page - 1) * pageSize + 1;
        int endRow = page * pageSize;

        Map<String, Object> map = new HashMap<>();
        map.put("startDate", request.getParameter("startDate"));
        map.put("endDate", request.getParameter("endDate"));
        map.put("doctorCode", request.getParameter("doctorCode"));
        map.put("patientName", request.getParameter("patientName"));
        map.put("birth", request.getParameter("birth"));
        map.put("startRow", startRow);
        map.put("endRow", endRow);
        
        String searchType = request.getParameter("searchType");
        String keyword = request.getParameter("keyword");

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
        
        request.setAttribute("result", result);

        return "/WEB-INF/json/result.jsp";
    }

    private int parseInt(String val, int def) {
        try { return (val == null || val.isEmpty()) ? def : Integer.parseInt(val); }
        catch (Exception e) { return def; }
    }
}
