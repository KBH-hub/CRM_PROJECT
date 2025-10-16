package com.crm.action.SMSService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ReserveSMSVO;
import com.crm.model.SMSDAO;

public class GetReseveSMSAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
        int page = parseInt(request.getParameter("page"), 1);
        int pageSize = parseInt(request.getParameter("pageSize"), 10);
        int startRow = (page - 1) * pageSize + 1;
        int endRow = page * pageSize;
        
        Map<String, Object> map = new HashMap<>();
        map.put("startRow", startRow);
        map.put("endRow", endRow);
        
        SMSDAO dao = new SMSDAO();
        List<ReserveSMSVO> list = dao.getReserveSMS(map);
        int totalCount = dao.getReserveSMSCount();
        

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
