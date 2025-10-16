package com.crm.action.SMSService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crm.action.Action;

public class SMSRecordUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		return "SMSRecord.html";
	}

}
