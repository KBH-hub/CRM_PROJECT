<%@page import="com.crm.model.ReserveVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="com.google.gson.Gson"%>
<%
	List<ReserveVO> reserveList = (List<ReserveVO>) request.getAttribute("reserveList");
	if (reserveList == null) reserveList = java.util.Collections.emptyList();
	
	String json = new Gson().toJson(reserveList);
	
	out.print(json);
%>