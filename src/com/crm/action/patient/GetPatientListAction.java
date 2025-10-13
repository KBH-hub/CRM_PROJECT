package com.crm.action.patient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crm.action.Action;
import com.crm.model.PatientListDAO;
import com.crm.model.PatientVO;
import com.google.gson.Gson;

public class GetPatientListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String startDate   = request.getParameter("startDate");
	    String endDate     = request.getParameter("endDate");
	    String doctorCode  = request.getParameter("doctorCode");
	    String patientName = request.getParameter("patientName");
	    String birth       = request.getParameter("birth");

	    // ✅ 페이지 번호와 크기 수집
	    int page = 1;
	    int pageSize = 10;
	    String p1 = request.getParameter("page");
	    String p2 = request.getParameter("pageSize");
	    if (p1 != null && !p1.isEmpty()) page = Integer.parseInt(p1);
	    if (p2 != null && !p2.isEmpty()) pageSize = Integer.parseInt(p2);

	    int startRow = (page - 1) * pageSize + 1;
	    int endRow = page * pageSize;

	    PatientListDAO dao = new PatientListDAO();

	    // ✅ 검색용 + 페이징 포함 map
	    Map<String, Object> map = new HashMap<>();
	    map.put("startDate", startDate);
	    map.put("endDate", endDate);
	    map.put("doctorCode", doctorCode);
	    map.put("patientName", patientName);
	    map.put("birth", birth);
	    map.put("startRow", startRow);
	    map.put("endRow", endRow);

	    List<PatientVO> list = dao.getPatientList(map);
	    int totalCount = dao.getTotalCount(); // mapper.xml에 COUNT(*) 쿼리 필요

	    Map<String, Object> result = new HashMap<>();
	    result.put("list", list);
	    result.put("totalCount", totalCount);

	    response.setContentType("application/json; charset=UTF-8");
	    response.getWriter().print(new Gson().toJson(result));

	    return null;
	}

}
