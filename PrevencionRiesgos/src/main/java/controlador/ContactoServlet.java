package controlador;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class ContactoServlet
 */
@WebServlet("/contactos")
public class ContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("usuario") != null) {
		request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/login").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String comentarios = request.getParameter("comentarios");
        
        System.out.println("Paso por Servlet Contactos:");
        System.out.println("Nombre: " + username);
        System.out.println("Correo Electrónico: " + email);
        System.out.println("Dirección: " + direccion);
        System.out.println("Comentarios: " + comentarios);
        
        response.sendRedirect(request.getContextPath() + "/inicio");
	}

}