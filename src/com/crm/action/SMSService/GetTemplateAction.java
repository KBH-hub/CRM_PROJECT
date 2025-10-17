package com.crm.action.SMSService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveSMSVO;
import com.crm.model.SMSDAO;

public class GetTemplateAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<ReserveSMSVO> list = new SMSDAO().getTemplate(request.getParameter("templateName"));
		request.setAttribute("result", list);
		
		return "/WEB-INF/json/result.jsp";
	}
		
//		// ?? ?????��? JSON 문�???? ????
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//
//        for (int i = 0; i < list.size(); i++) {
//            ReserveSMSVO vo = list.get(i);
//
//            // ?��?��???? �?�?�? �??? ?��??문�?? �?�? (JSON 깨�? 방�?)
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
//	 // ??�? 문�???? ?��?��??��?? �?�? (?��?��?��??, �?�?�? ??)
//    private String escape(String s) {
//        if (s == null) return "";
//        return s
//                .replace("\\", "\\\\")
//                .replace("\"", "\\\"")
//                .replace("\r", "")
//                .replace("\n", "\\n");
//    }


}
