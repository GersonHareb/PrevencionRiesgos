package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", true);
        sesion.setAttribute("username", userId);
        sesion.setAttribute("password", password);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
			  System.out.println(cookie.getName() + " : " + cookie.getValue());
		  }
        Cookie cUsername = new Cookie("username", userId);
        cUsername.setPath(request.getContextPath()); // Establece la ruta de la cookie
        Cookie cPassword = new Cookie("password", password);
        cPassword.setPath(request.getContextPath()); // Establece la ruta de la cookie
        
        response.addCookie(cUsername);
        response.addCookie(cPassword);

        if (userId.equals("admin") && password.equals("1234")) {
        	request.setAttribute("username", userId);
        	request.getRequestDispatcher("/inicio").forward(request, response);
        	System.out.println("Valor de la cookie username: " + cUsername.getValue());//Para revisar si la cookie esta pasando bien el nombre

        } else {
            request.setAttribute("errorMessage", "Los datos ingresados son incorrectos.");
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }


}

