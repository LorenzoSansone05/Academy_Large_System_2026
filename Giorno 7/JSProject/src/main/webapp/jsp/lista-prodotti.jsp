<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Pagina jsp nella quale vado a ricevere i prodotti da ProdottiServlet e qui li vado a posizionare visivamente in una tabella,
prima vado a dare un nome alle varie sezioni per far comprendere meglio all'utente la tabella,
poi per ogni prodotto nel body della tabella viene creata una riga nella quale inseriamo le informazioni formattate in maniera custom tramite gli if statement
e alla fine della tabella si mostra il numero totale di prodotti e il prezzo medio per far avere al cliente un resoconto finale --%>
	 <c:set var="sommaPrezzi" value="0" />
    <c:set var="conteggio" value="0" />

    <table border="1">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Fascia</th>
                <th>Prezzo</th>
                <th>Stato</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${prodotti}" var="p">
                <c:set var="sommaPrezzi" value="${sommaPrezzi + p.prezzo}" />
                <c:set var="conteggio" value="${conteggio + 1}" />

                <tr>
                    <td>${p.nome}</td>
                    <td>
                        <c:if test="${p.prezzo < 20}">Economico</c:if>
                        <c:if test="${p.prezzo >= 20 && p.prezzo <= 100}">Medio</c:if>
                        <c:if test="${p.prezzo > 100}">Costoso</c:if>
                    </td>
                    <td>${p.prezzo} &euro;</td>
                    <td>
                        <c:if test="${p.disponibile}">
                            <font color="green">Disponibile</font>
                        </c:if>
                        <c:if test="${!p.disponibile}">
                            <font color="red">Non disponibile</font>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4">Prodotti totali: ${conteggio}</td>
        </tr>
        <tr>
            <td colspan="4">Prezzo medio: ${sommaPrezzi / conteggio} &euro;</td>
        </tr>
        </tfoot>
    </table>


</body>
</html>