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

public class EditReserveAction implements Action {

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
            ReserveVO vo = gson.fromJson(jsonString, ReserveVO.class);

            ReserveListDAO dao = new ReserveListDAO();
            int updatedRows = dao.editReserve(vo);

            if (updatedRows > 0) {
                resultMap.put("success", true);
                resultMap.put("message", "예약이 성공적으로 수정되었습니다.");
            } else {
                resultMap.put("success", false);
                resultMap.put("message", "해당 시간은 이미 예약되어 있거나, 수정에 실패했습니다.");
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
