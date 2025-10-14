<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String list = (String) request.getAttribute("list");
  if (list == null) list = "[]";
  out.print(list);
%>