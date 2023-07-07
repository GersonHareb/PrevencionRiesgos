package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Profesional;

import java.io.IOException;
import java.time.LocalDate;

import implementacion.UsuarioDAOImp;

/**
 * Servlet implementation class EditarProfesionalServlet
 */
@WebServlet("/editarProfesional")
public class EditarProfesionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOImp usuarioDAO; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProfesionalServlet() {
        super();
        usuarioDAO = new UsuarioDAOImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int proId = Integer.parseInt(request.getParameter("id"));
		Profesional profesional = usuarioDAO.obtenerProPorId(proId);
		request.setAttribute("profesional", profesional);
		request.getRequestDispatcher("/views/editarProfesionales.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int proId = Integer.parseInt(request.getParameter("proId"));
	    String nombre = request.getParameter("nombre");
	    String tipoUsuario = request.getParameter("tipo");
	    LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
	    String rut = request.getParameter("rut");
	    String titulo = request.getParameter("titulo");
	    LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"));
	    Profesional proActualizado = new Profesional(proId, nombre, tipoUsuario, fechaNacimiento, rut, titulo, fechaIngreso);
	    usuarioDAO.actualizarPro(proActualizado);
	    
	    response.sendRedirect(request.getContextPath() + "/listarusuario");
	}

}
