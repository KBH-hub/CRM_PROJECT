package com.crm.action.reserveList;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.PatientListDAO;
import com.crm.model.PatientVO;

public class GetPatientNameAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> resultMap = new HashMap<>();

        try {
           
            String keyword = request.getParameter("keyword");

            List<PatientVO> patientList = null;

            if (keyword != null && !keyword.trim().isEmpty()) {
                PatientListDAO dao = new PatientListDAO();
               
                patientList = dao.searchPatientsByName(keyword.trim()); 
            }

            
            resultMap.put("success", true); 
            resultMap.put("data", patientList); 

        } catch (Exception e) {
            e.printStackTrace();

            
            resultMap.put("success", false);
            resultMap.put("message", "환자 검색 중 오류 발생: " + e.getMessage());
        
        }

        request.setAttribute("result", resultMap);

      
        return "/WEB-INF/json/result.jsp";
    }
}
