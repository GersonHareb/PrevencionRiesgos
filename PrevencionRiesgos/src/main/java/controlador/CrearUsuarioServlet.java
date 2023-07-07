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
import java.time.LocalDate;

import implementacion.UsuarioDAOImp;


/**
 * Servlet implementation class CrearUsuarioServlet
 */
@WebServlet("/crearusuario")
public class CrearUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioServlet() {
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
        request.getRequestDispatcher("/views/crearusuario.jsp").forward(request, response);
    } else {
    	request.getRequestDispatcher("/login").forward(request, response);
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombre = request.getParameter("nombre");
	    String tipoUsuario = request.getParameter("tipo");
	    LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
	    String rut = request.getParameter("rut");

	    UsuarioDAOImp usuarioDAO = new UsuarioDAOImp();

	    if (tipoUsuario.equals("Cliente")) {
	        int telefono = Integer.parseInt(request.getParameter("telefono"));
	        String afp = request.getParameter("afp");
	        String sistemaSalud = request.getParameter("sistemaSalud");
	        String direccion = request.getParameter("direccion");
	        String comuna = request.getParameter("comuna");
	        int edad = Integer.parseInt(request.getParameter("edad"));

	        Cliente cliente = new Cliente(0, nombre, tipoUsuario, fechaNacimiento, rut, telefono, afp, sistemaSalud, direccion, comuna, edad);
	        usuarioDAO.guardarCliente(cliente);
	    } else if (tipoUsuario.equals("Administrativo")) {
	        String area = request.getParameter("area");
	        String experienciaPrevia = request.getParameter("experienciaPrevia");

	        Administrativo administrativo = new Administrativo(0, nombre, tipoUsuario, fechaNacimiento, rut, area, experienciaPrevia);
	        usuarioDAO.guardarAdministrativo(administrativo);
	    } else if (tipoUsuario.equals("Profesional")) {
	        String titulo = request.getParameter("titulo");
	        LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"));
	        Profesional profesional = new Profesional(0, nombre, tipoUsuario, fechaNacimiento, rut, titulo, fechaIngreso);
	        usuarioDAO.guardarProfesional(profesional);
	    } 

	    response.sendRedirect(request.getContextPath() + "/listarusuario"); // Redirecciona a otra página después de procesar los datos
	}



	

}
