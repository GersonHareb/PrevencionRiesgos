package controlador;

import conexion.Conexion;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;



/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("usuario") != null) {
			String username = (String) session.getAttribute("username");
			try {
				Connection cn = Conexion.getConnected();
				if(cn.isValid(1)) {
					System.out.println("Desde Servlet inicio: Conexion a BD validada");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			if (cookies != null) {
			  for (Cookie cookie : cookies) {
			    if (cookie.getName().equals("username")) {
			      username = cookie.getValue();
			      break;
			    }
			  }
			}

			
			request.setAttribute("username", username);

			request.getRequestDispatcher("/views/inicio.jsp").forward(request, response);
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