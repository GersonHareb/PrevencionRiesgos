package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;

import java.io.IOException;
import java.time.LocalDate;

import implementacion.UsuarioDAOImp;

/**
 * Servlet implementation class EditarClienteServlet
 */
@WebServlet("/editarClientes")
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOImp usuarioDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarClienteServlet() {
        super();
        usuarioDAO = new UsuarioDAOImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int clienteId = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = usuarioDAO.obtenerClientePorId(clienteId);
		request.setAttribute("cliente", cliente);
		request.getRequestDispatcher("/views/editarClientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    int clienteId = Integer.parseInt(request.getParameter("clienteId"));
	    String nombre = request.getParameter("nombre");
	    String tipoUsuario = request.getParameter("tipo");
	    LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
	    String rut = request.getParameter("rut");
	    int telefono = Integer.parseInt(request.getParameter("telefono"));
	    String afp = request.getParameter("afp");
	    String sistemaSalud = request.getParameter("sistemaSalud");
	    String direccion = request.getParameter("direccion");
	    String comuna = request.getParameter("comuna");
	    int edad = Integer.parseInt(request.getParameter("edad"));
	    Cliente clienteActualizado = new Cliente(clienteId, nombre, tipoUsuario, fechaNacimiento, rut, telefono, afp, sistemaSalud, direccion, comuna, edad);
	    usuarioDAO.actualizarCliente(clienteActualizado);
	    
	    String[] camposCliente = {
	    	    "ID: " + clienteActualizado.getId(),
	    	    "Nombre: " + clienteActualizado.getNombre(),
	    	    "Fecha de Nacimiento: " + clienteActualizado.getFechaNacimiento(),
	    	    "RUT: " + clienteActualizado.getRut(),
	    	    "Teléfono: " + clienteActualizado.getTelefono(),
	    	    "AFP: " + clienteActualizado.getAfp(),
	    	    "Sistema de Salud: " + clienteActualizado.getSistemaSalud(),
	    	    "Dirección: " + clienteActualizado.getDireccion(),
	    	    "Comuna: " + clienteActualizado.getComuna(),
	    	    "Edad: " + clienteActualizado.getEdad()
	    	};
	    for (String cliente : camposCliente) {
	        System.out.println(cliente);
	    }
	    
	    response.sendRedirect(request.getContextPath() + "/listarusuario");
	}

}
