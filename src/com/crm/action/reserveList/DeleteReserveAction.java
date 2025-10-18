package com.crm.action.reserveList;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveListDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DeleteReserveAction implements Action {

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

            Object reserveNoObj = requestData.get("reserveNo");
            if (reserveNoObj == null) {
                 throw new Exception("삭제할 예약 번호(reserveNo)가 전달되지 않았습니다.");
            }
            
           
            String reserveNoStr = String.valueOf(reserveNoObj); 
            
            int reserveNo = Integer.parseInt(reserveNoStr);
            
            List<Integer> reserveNoList = new ArrayList<>();
            reserveNoList.add(reserveNo);

            ReserveListDAO dao = new ReserveListDAO();
           
            int deletedRows = dao.deleteReserve(reserveNoList);

      
            if (deletedRows > 0) {
                resultMap.put("success", true);
                resultMap.put("message", "예약이 성공적으로 삭제되었습니다.");
            } else {
            
                resultMap.put("success", false);
                resultMap.put("message", "예약 삭제에 실패했습니다. (대상이 없거나 오류 발생)");
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