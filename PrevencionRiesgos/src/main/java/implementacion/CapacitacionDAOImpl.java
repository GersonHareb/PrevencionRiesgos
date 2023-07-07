package implementacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.CapacitacionDAO;
import modelo.Capacitacion;

public class CapacitacionDAOImpl implements CapacitacionDAO{
    private Connection cn = null;
    
    


    public CapacitacionDAOImpl() {
	}




	public void guardarCapacitacion(Capacitacion capacitacion) {
        String sql = "INSERT INTO Capacitaciones (nombre, detalle, dia, hora, lugar, duracion, cantidad_asistentes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
        	this.cn = Conexion.getConnected();
        	PreparedStatement stm = this.cn.prepareStatement(sql);
        	
        	
        	stm.setString(1, capacitacion.getNombre());
        	stm.setString(2, capacitacion.getDetalle());
        	stm.setDate(3, java.sql.Date.valueOf(capacitacion.getDia()));
        	stm.setTime(4, java.sql.Time.valueOf(capacitacion.getHora()));
        	stm.setString(5, capacitacion.getLugar());
        	stm.setTime(6, java.sql.Time.valueOf(capacitacion.getDuracion()));
        	stm.setInt(7, capacitacion.getCantidadAsistentes());
        	
        	if(!stm.execute()) {
        		System.out.println("Capacitacion registrada");
        	} else {
        		System.out.println("Registo de capacitacion fallido.");
        	}
        	stm.close();

        } catch(SQLException e) {
        	e.printStackTrace();
        	System.out.println(e.getMessage());
        }
    }
	
	public List<Capacitacion> listarCapacitaciones() {
	    List<Capacitacion> capacitaciones = new ArrayList<>();
	    String sql = "SELECT * FROM Capacitaciones";

	    try {
	    	
	    	
	    	 this.cn = Conexion.getConnected();
	         PreparedStatement stm = this.cn.prepareStatement(sql);
	         ResultSet rs = stm.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String detalle = rs.getString("detalle");
	            LocalDate dia = rs.getDate("dia").toLocalDate();
	            LocalTime hora = rs.getTime("hora").toLocalTime();
	            String lugar = rs.getString("lugar");
	            LocalTime duracion = rs.getTime("duracion").toLocalTime();
	            int cantidadAsistentes = rs.getInt("cantidad_asistentes");

	            Capacitacion capacitacion = new Capacitacion(id, nombre, detalle, dia, hora, lugar, duracion, cantidadAsistentes);
	            capacitaciones.add(capacitacion);
	        }
	        
            rs.close();
            stm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return capacitaciones;
	}

}
