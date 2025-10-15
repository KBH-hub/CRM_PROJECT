<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="com.google.gson.Gson" %>
<%
  Object result = request.getAttribute("result");
  if (result == null) result = new java.util.HashMap<>();
  String json = new Gson().toJson(result);
  out.print(json);
%>