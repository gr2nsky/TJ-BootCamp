<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

	request.setCharacterEncoding("utf-8");

	String conditionType = request.getParameter("conditionType");
	String conditionInput = request.getParameter("conditionInput");
	
	session.setAttribute("TYPE", conditionType);
	session.setAttribute("INPUT", conditionInput);

	response.sendRedirect("purchaserSelect01.jsp");
%>