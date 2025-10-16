package com.crm.action.smsService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveSmsVO;
import com.crm.model.SmsDAO;

public class GetTemplateAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<ReserveSmsVO> list = new SmsDAO().getTemplate(request.getParameter("templateName"));
		request.setAttribute("result", list);
		
		return "/WEB-INF/json/result.jsp";
	}
		
//		// ✅ 수동으로 JSON 문자열 생성
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//
//        for (int i = 0; i < list.size(); i++) {
//            ReserveSmsVO vo = list.get(i);
//
//            // 따옴표나 줄바꿈 같은 특수문자 처리 (JSON 깨짐 방지)
//            String name = escape(vo.getTemplateName());
//            String content = escape(vo.getTemplateContent());
//
//            if (i > 0) sb.append(",");
//            sb.append("{")
//              .append("\"templateName\":\"").append(name).append("\",")
//              .append("\"templateContent\":\"").append(content).append("\"")
//              .append("}");
//        }
//
//        sb.append("]");
//        
//        request.setAttribute("list", sb.toString());
//		return "getTemplate.jsp";
//	}
//	
//	 // ⚙️ 문자열 이스케이프 처리 (큰따옴표, 줄바꿈 등)
//    private String escape(String s) {
//        if (s == null) return "";
//        return s
//                .replace("\\", "\\\\")
//                .replace("\"", "\\\"")
//                .replace("\r", "")
//                .replace("\n", "\\n");
//    }


}
