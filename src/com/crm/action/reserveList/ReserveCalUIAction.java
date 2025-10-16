package com.crm.action.reserveList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;

public class ReserveCalUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "reserveList.html";
	}


}
