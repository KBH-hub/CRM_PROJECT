<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
    // Action이 request에 담아준 "sidebarData"를 꺼냅니다.
    Object result = request.getAttribute("result");
    // Gson을 사용해 Map을 JSON 문자열로 변환합니다.
    String json = new Gson().toJson(result);

    // 변환된 JSON 문자열을 화면(응답)에 출력합니다.
    out.print(json);
%>