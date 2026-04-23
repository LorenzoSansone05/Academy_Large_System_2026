package it.jee.scope;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ContatorePaginaServlet
 */

public class ContatorePaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContatorePaginaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        Integer contatore = (Integer) servletContext.getAttribute("contatore"); // casting da object a Integer

        if (contatore == null) {
            contatore = 0;
        }

        contatore++;

        servletContext.setAttribute("contatore", contatore);

        PrintWriter printWriter = response.getWriter();
        printWriter.println("Numero visite in totale: " + contatore);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
