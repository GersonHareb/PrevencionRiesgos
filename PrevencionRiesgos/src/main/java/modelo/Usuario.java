package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Usuario {
	private int id;
    private String nombre;
    private String tipo;
    private LocalDate fechaNacimiento;
    private String rut;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String tipo, LocalDate fechaNacimiento, String rut) {
    	this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
    }

    public String mostrarEdad() {
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
        return "El usuario tiene " + edad + " años";
    }

    public String analizarUsuario() {
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", RUN: " + rut;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "\nNombre: " + nombre  +
                "\nEdad: " + mostrarEdad() +
                "\nRut: " + rut +
                "\n ";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && nombre.length() >= 10 && nombre.length() <= 50) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre debe tener entre 10 y 50 caracteres.");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRut() {
        return rut;
    }
    
    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRut(String rut) {
        int runNumerico = Integer.parseInt(rut.replaceAll("[^0-9]", ""));
        if (runNumerico > 0 && runNumerico < 99999999) {
            this.rut = rut;
        } else {
            throw new IllegalArgumentException("El RUN debe ser un número menor a 99.999.999.");
        }
    }
}

