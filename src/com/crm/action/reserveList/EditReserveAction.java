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
		
		// 3. 최종 처리 결과를 담을 Map 객체 생성
        Map<String, Object> resultMap = new HashMap<>();

        try {
            // 1. 브라우저가 보낸 JSON 데이터 읽기
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String jsonString = sb.toString();

            // Gson을 사용하여 JSON 문자열을 ReserveVO 객체로 변환
            Gson gson = new Gson();
            ReserveVO vo = gson.fromJson(jsonString, ReserveVO.class);

            // 2. DAO를 통해 DB 작업 수행
            ReserveListDAO dao = new ReserveListDAO();
            int updatedRows = dao.editReserve(vo);

            // 처리 결과에 따라 resultMap에 데이터 저장
            if (updatedRows > 0) {
                resultMap.put("success", true);
                resultMap.put("message", "예약이 성공적으로 수정되었습니다.");
            } else {
                resultMap.put("success", false);
                // DAO의 reserveCheck 로직에 의해 0이 반환될 수 있습니다.
                resultMap.put("message", "해당 시간은 이미 예약되어 있거나, 수정에 실패했습니다.");
            }

        } catch (Exception e) {
            // JSON 파싱 오류나 DB 오류 등 모든 예외를 처리합니다.
            e.printStackTrace(); // 서버 콘솔에 에러 로그 출력
            resultMap.put("success", false);
            resultMap.put("message", "서버 처리 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        // 4. ★가장 중요★ 처리 결과 Map을 "result"라는 이름으로 request에 저장
        request.setAttribute("result", resultMap);
        
        // 5. 결과를 JSON으로 변환해 줄 JSP 경로를 반환
        return "/WEB-INF/json/result.jsp";
    }
}
