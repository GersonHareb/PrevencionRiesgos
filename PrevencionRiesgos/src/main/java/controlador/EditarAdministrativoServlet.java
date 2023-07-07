package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Administrativo;

import java.io.IOException;
import java.time.LocalDate;

import implementacion.UsuarioDAOImp;

/**
 * Servlet implementation class EditarAdministrativoServlet
 */
@WebServlet("/editarAdmin")
public class EditarAdministrativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOImp usuarioDAO;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAdministrativoServlet() {
        super();
        usuarioDAO = new UsuarioDAOImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adminId = Integer.parseInt(request.getParameter("id"));
		Administrativo admin = usuarioDAO.obtenerAdminPorId(adminId);
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("/views/editarAdministrativos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adminId = Integer.parseInt(request.getParameter("adminId"));
	    String nombre = request.getParameter("nombre");
	    String tipoUsuario = request.getParameter("tipo");
	    LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
	    String rut = request.getParameter("rut");
	    String area = request.getParameter("area");
	    String experienciaPrevia = request.getParameter("experienciaPrevia");
	    Administrativo adminActualizado = new Administrativo(adminId, nombre, tipoUsuario, fechaNacimiento, rut, area, experienciaPrevia);
	    usuarioDAO.actualizarAdmin(adminActualizado);
	    
	    response.sendRedirect(request.getContextPath() + "/listarusuario");
	}

}
