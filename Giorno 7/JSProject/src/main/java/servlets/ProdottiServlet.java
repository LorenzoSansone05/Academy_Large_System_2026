package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaBeans.Prodotto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ProdottiServlet
 */
@WebServlet("/ProdottiServlet")
public class ProdottiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Prodotto> listaProdotti = new ArrayList<>();
        
        listaProdotti.add(new Prodotto("Laptop Gaming", 1299.99, true));
        listaProdotti.add(new Prodotto("Mouse Wireless", 25.50, true));
        listaProdotti.add(new Prodotto("Monitor 4K", 350.00, false)); 
        listaProdotti.add(new Prodotto("Tastiera Meccanica", 89.90, true));
        listaProdotti.add(new Prodotto("Cuffie Noise Cancelling", 199.00, false)); 
        
        request.setAttribute("prodotti", listaProdotti);
        
        request.getRequestDispatcher("/jsp/lista-prodotti.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
