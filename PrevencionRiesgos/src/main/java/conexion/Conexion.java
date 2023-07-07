package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	//Declarar conexion
	private static Connection cn = null;
	
	//Constructor privado de la clase
	private Conexion() {
		try {
			//Cargar el driverino
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Se crea la conexion
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prevencion_riesgos", "adminbd", "1234");
			
			//Verificamos si esta funcionando
			if(cn != null) {
				System.out.println("Desde clase conexion: Conexion a BD establecida");
			} else {
				System.out.println("Desde clase conexion: Fallo la conexion a BD");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	//Metodo que crea la conexion
	public static Connection getConnected() {
		if(cn == null) {
			new Conexion();
		}
		return cn;
	}
	
    // Método para cerrar la conexión
  /*  public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Desde clase conexion: Conexion a BD cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }*/
	
	

}
