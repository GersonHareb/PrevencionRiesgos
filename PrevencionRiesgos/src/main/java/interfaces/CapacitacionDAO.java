package interfaces;

import java.util.List;

import modelo.Capacitacion;

public interface CapacitacionDAO {
	
	public void guardarCapacitacion(Capacitacion capacitacion);
	List<Capacitacion> listarCapacitaciones();

}
