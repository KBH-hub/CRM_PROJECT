package com.crm.action.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;

public class PatientUIAction implements Action {

	@Override	//6
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//혹시 처리가 있다면 구현 코드 삽입(현재는 단순 UI연결) - DAO //7
		return "patientList.html";
	}

}
