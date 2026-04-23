package it.firstwebapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BenvenutoServlet
 */
public class BenvenutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int contatore = 0;
	
	
    public BenvenutoServlet() {
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printwriter = response.getWriter();
		contatore++;
		printwriter.print("<h1> Numero di chiamate alla servlet: " + contatore + "</h1>");
		String nome = request.getParameter("nome"); // recupera il valore della chiave nome;
		
		if (nome == null) {
		    printwriter.print("<h2>Benvenuto ospite!</h2>");
		} else {
		    printwriter.print("<h2>Benvenuto " + nome + "</h2>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
	    System.out.println("Metodo init");
	}

	@Override
	public void destroy() {
	    System.out.println("Metodo destroy");
	}
	
}
