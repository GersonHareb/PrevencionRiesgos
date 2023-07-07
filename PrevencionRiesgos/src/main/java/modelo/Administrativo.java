package modelo;

import java.time.LocalDate;

public class Administrativo extends Usuario{
    private String area;
    private String experienciaPrevia;

    public Administrativo() {
    }
    
    public Administrativo(int id, String nombre, String tipo, LocalDate fechaNacimiento, String rut, String area,
			String experienciaPrevia) {
		super(id, nombre, tipo, fechaNacimiento, rut);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

}

