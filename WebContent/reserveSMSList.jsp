<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="com.google.gson.Gson"%>
<%@page import="com.crm.model.ReserveSmsVO"%>
<%@page import="java.util.List"%>
<%
 List<ReserveSmsVO> list = (List<ReserveSmsVO>) request.getAttribute("list");
 if (list == null) list = java.util.Collections.emptyList();

 String json = new Gson().toJson(list);

 out.print(json);
%>