package it.servlets.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/forward", "/redirect"})
public class ForwardAndRedirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getRequestURI();

        // Usiamo il forward per efficienza, poiche avviene tutto internamente al server, non c'è comunicazione col client nel forward, 		oppure quando siamo circa nello stesso contesto dell'app.
        if (url.equals(request.getContextPath() + "/forward")) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/destinazione.jsp");
        	dispatcher.forward(request, response);
        	return;
        } 
        // Usiamo il redirect quando vogliamo far cambiare l'URL, oppure quando cambia il contesto nell'app quindi ci troviamo in una sezione 		completamente differente rispetto a quella precedente, ma il redirect ha come conseguenza che avviene un altra richiesta http, quindi 		il browser è a conoscenza di cio che sta accadendo.
        else if (url.equals(request.getContextPath() + "/redirect")) {
            response.sendRedirect(request.getContextPath() + "/destinazione.jsp");
            return;
        }
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
