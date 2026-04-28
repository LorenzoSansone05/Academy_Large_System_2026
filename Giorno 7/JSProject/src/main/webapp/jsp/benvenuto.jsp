<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<%-- Pagina jsp che mostra la data e l'ora attuale --%>
<%= "Ora attuale :  " + java.time.LocalDateTime.now() %> <br>
<%= "Data di oggi :  " + new Date() %>
</body>
</html>