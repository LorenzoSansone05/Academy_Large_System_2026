<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="primoProdotto" class="javaBeans.Prodotto" scope="page" />

<jsp:setProperty name="primoProdotto" property="nome" value="laptop" />
<jsp:setProperty name="primoProdotto" property="prezzo" value="999.99" />
    
    <p>
        Nome : <jsp:getProperty name="primoProdotto" property="nome" />
    </p>
    
    <p>
        Prezzo : <jsp:getProperty name="primoProdotto" property="prezzo" />
    </p>
</body>
</html>