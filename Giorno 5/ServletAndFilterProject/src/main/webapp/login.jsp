<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Login</h2>

<%
    String parametro = request.getParameter("errore");

    if ("1".equals(parametro)) { //Faccio l'equal a partire dalla stringa per evitare errori nel caso parametro fosse null
%>
        <p style="color:red;">
            Credenziali non valide. Riprova.
        </p>
<%
    }
%>

<form action="login" method="post">
    
    <label>Username:</label><br>
    <input type="text" name="username"><br><br>

    <label>Password:</label><br>
    <input type="password" name="password"><br><br>

    <button type="submit">Accedi</button>

</form>

</body>
</html>