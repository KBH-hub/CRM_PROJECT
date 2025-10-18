package com.crm.action.reserveList;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AddReserveAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> resultMap = new HashMap<>();

        try {
            
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String jsonString = sb.toString();

      
            Gson gson = new Gson();
            Map<String, Object> requestData = gson.fromJson(jsonString, new TypeToken<Map<String, Object>>(){}.getType());

            
            Object patientNoObj = requestData.get("patientNo");
            if (patientNoObj == null) {
                 throw new Exception("환자 번호(patientNo)가 전달되지 않았습니다.");
            }
           
            int patientNo = Integer.parseInt(String.valueOf(patientNoObj)); 

            String reserveDay = (String) requestData.get("reserveDay");
            String reserveTime = (String) requestData.get("reserveTime");
            String doctorScheduleNoStr = String.valueOf(requestData.get("doctorScheduleNo"));
            int doctorScheduleNo = Integer.parseInt(doctorScheduleNoStr);
            String reason = (String) requestData.get("reason");

         

            ReserveVO vo = new ReserveVO();
            vo.setPatientNo(patientNo); 
            vo.setReserveDay(reserveDay);
            vo.setReserveTime(reserveTime);
            vo.setDoctorScheduleNo(doctorScheduleNo);
            vo.setReason(reason);

           
            ReserveListDAO reserveDAO = new ReserveListDAO();
            int insertedRows = reserveDAO.addReserve(vo);

        
            if (insertedRows > 0) {
                resultMap.put("success", true);
                resultMap.put("message", "예약이 성공적으로 등록되었습니다.");
            } else {
                resultMap.put("success", false);
                resultMap.put("message", "이미 예약된 시간이거나 등록에 실패했습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("success", false);
            resultMap.put("message", "서버 처리 중 오류가 발생했습니다: " + e.getMessage());
        }

      
        request.setAttribute("result", resultMap);

        return "/WEB-INF/json/result.jsp";
    }
}