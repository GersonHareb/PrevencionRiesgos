package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Capacitacion;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import implementacion.CapacitacionDAOImpl;

@WebServlet("/crearCapacitacion")
public class CrearCapacitacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CrearCapacitacionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("usuario") != null) {
        request.getRequestDispatcher("/views/crearcapacitacion.jsp").forward(request, response);
    } else {
    	request.getRequestDispatcher("/login").forward(request, response);
    }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String detalle = request.getParameter("detalle");
        LocalDate dia = LocalDate.parse(request.getParameter("dia"));
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));
        String lugar = request.getParameter("lugar");
        LocalTime duracion = LocalTime.parse(request.getParameter("duracion"));
        int cantidadAsistentes = Integer.parseInt(request.getParameter("cantidadAsistentes"));

        // Crear un objeto Capacitacion
        Capacitacion capacitacion = new Capacitacion(0, nombre, detalle, dia, hora, lugar, duracion, cantidadAsistentes);

            CapacitacionDAOImpl capacitacionDAO = new CapacitacionDAOImpl();
            capacitacionDAO.guardarCapacitacion(capacitacion);

        response.sendRedirect(request.getContextPath() + "/listarCapacitacion");
    }
}

