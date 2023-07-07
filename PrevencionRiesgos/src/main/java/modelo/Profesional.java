package modelo;

import java.time.LocalDate;

public class Profesional extends Usuario {
    private String titulo;
    private LocalDate fechaIngreso;

    public Profesional() {
    }
    
    public Profesional(int id, String nombre, String tipo, LocalDate fechaNacimiento, String rut, String titulo,
    		LocalDate fechaIngreso) {
		super(id, nombre, tipo, fechaNacimiento, rut);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
    
    
}

