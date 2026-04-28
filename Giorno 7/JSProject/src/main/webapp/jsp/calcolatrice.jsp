<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Pagina jsp che va ad estrapolare due parametri dall'url, verifica se ci sono parametri effettivamente nell'URL,
 se ci sono va a fare la conversione da stringa ad intero, cosiu da avere i numeri per fare la somma,
 altrimenti mostra l'utente un messaggio in cui viene richiesto di inserire i parametri nell'URL --%>
 
<% 
   String num1 = request.getParameter("num1");
   String num2 = request.getParameter("num2");
   int numero1 = 0;
   int numero2 = 0;
   if(num1 != null && num2!= null) {
   	  numero1 = Integer.parseInt(num1);
  	  numero2 = Integer.parseInt(num2);
   }
%>
   
<%= num1 != null && num2 != null ? "Il risultato della somma è " + (numero1 + numero2) : 
	"Per favore inserisci due numeri nei parametri dell'URL" %> <br><br>
<%@ include file="./footer.jsp" %>
</body>
</html>