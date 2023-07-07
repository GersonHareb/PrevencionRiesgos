package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;


import java.io.IOException;
import java.util.List;

import implementacion.UsuarioDAOImp;

/**
 * Servlet implementation class ListarUsuarioServlet
 */
@WebServlet("/listarusuario")
public class ListarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuarioServlet() {
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
	        UsuarioDAOImp clienteDAO = new UsuarioDAOImp();
	        UsuarioDAOImp AdminDAO = new UsuarioDAOImp();
	        UsuarioDAOImp ProDAO = new UsuarioDAOImp();
	        List<Cliente> clientes = clienteDAO.listarClientes();
	        request.setAttribute("clientes", clientes);
	        
	        List<Administrativo> admins = AdminDAO.listarAdmins();
	        request.setAttribute("admins", admins);
	        
	        List<Profesional> pros = ProDAO.listarPros();
	        request.setAttribute("pros", pros);
	        
			
			request.getRequestDispatcher("/views/listarusuario.jsp").forward(request, response);
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
