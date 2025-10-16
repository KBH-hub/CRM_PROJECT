package com.crm.action.doctorSchedule;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;
import com.crm.model.ManageDoctorDAO;
import com.crm.model.ManageDoctorVO;

public class GetDoctorListAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		List<ManageDoctorVO> list = new ManageDoctorDAO().getDoctorList();
		request.setAttribute("result", list);
		
		return "/WEB-INF/json/result.jsp";
	}

}
