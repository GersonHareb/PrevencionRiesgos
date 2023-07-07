package controlador;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Capacitacion;

import java.io.IOException;
import java.util.List;

import implementacion.CapacitacionDAOImpl;

/**
 * Servlet implementation class ListarCapacitacionServlet
 */
@WebServlet("/listarCapacitacion")
public class ListarCapacitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapacitacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("usuario") != null) {
	        CapacitacionDAOImpl capacitacionDAO = new CapacitacionDAOImpl();
	        List<Capacitacion> capacitaciones = capacitacionDAO.listarCapacitaciones();
	        request.setAttribute("capacitaciones", capacitaciones);
	        request.getRequestDispatcher("/views/listarcapacitacion.jsp").forward(request, response);
    } else {
    	request.getRequestDispatcher("/login").forward(request, response);
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
