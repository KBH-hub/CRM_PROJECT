<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%
  String json = (String) request.getAttribute("json");
  if (json == null) json = "[]";
  out.print(json);
%>