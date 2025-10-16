package com.crm.action.reserveList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;

public class ReserveListUIAction implements Action {

	@Override
	public String execute(HttpServletRequest req) throws ServletException, IOException {
		return "reserveList.html";
	}

}
