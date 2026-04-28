<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Pagina jsp che attraverso un ciclo for 
popola una lista non ordinata e all'interno di ogni elemento della lista va ad inserire il valore della variabile numero --%>
<%@ include file="./header.jsp" %>
<ul>
<% for(int numero = 0; numero < 10; numero++) { %> 		
		<li><%=numero+1 %></li>
<%
	}
%>
</ul>
</body>
</html>