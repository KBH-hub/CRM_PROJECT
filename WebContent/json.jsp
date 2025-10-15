<%@ page contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String list = (String)request.getAttribute("list");

	if (list == null){
		list = "[]"; // 빈 문자열을 보내면 팡싱에러 
	}
	out.print(list); // 클라이언트 전송
%>