package it.firstwebapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter printwriter = response.getWriter();

        printwriter.println("<html>");
        printwriter.println("<body>");

        printwriter.println("<h3>Metodo: " + request.getMethod() + "</h3>");

        printwriter.println("<h3>URL: " + request.getRequestURL().toString() + "</h3>");

        String nome = request.getParameter("nome");
        String eta = request.getParameter("eta");

        printwriter.println("<h3>Nome: " + nome + "</h3>");
        printwriter.println("<h3>Età: " + eta + "</h3>");

        printwriter.println("</body>");
        printwriter.println("</html>");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
