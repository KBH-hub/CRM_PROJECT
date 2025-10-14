<%@ page language="java" contentType="application/json; charset=UTF-8" 
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="com.google.gson.Gson, java.util.HashMap, java.util.Map" %>
<%
    Object result = request.getAttribute("result");
    if (result == null) result = "fail";

    Map<String, Object> responseMap = new HashMap<>();
    responseMap.put("success", "success".equals(result));

    String json = new Gson().toJson(responseMap);
    out.print(json);
%>
