<%@ page contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="com.crm.model.ReserveVO"%>
<%

	List<ReserveVO> list = (List<ReserveVO>)request.getAttribute("list");

	String jsonString;
	Gson gson = new Gson();

	if (list == null || list.isEmpty()){
		jsonString = "[]"; // 빈 문자열을 보내면 팡싱에러 
	}else{
		jsonString = gson.toJson(list);
	}
	out.print(jsonString); // 클라이언트 전송
%>