package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.UsuarioDAO;
import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;


public class UsuarioDAOImp implements UsuarioDAO {
	private Connection cn = null;

    
    @Override
    public void guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, tipo, fecha_nacimiento, rut, telefono, afp, sistema_salud, direccion, comuna, edad) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
        	this.cn = Conexion.getConnected();
        	PreparedStatement stm = this.cn.prepareStatement(sql);
        	stm.setString(1, cliente.getNombre());
        	stm.setString(2, cliente.getTipo());
        	stm.setDate(3, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
        	stm.setString(4, cliente.getRut());
        	stm.setInt(5, cliente.getTelefono());
        	stm.setString(6, cliente.getAfp());
        	stm.setString(7, cliente.getSistemaSalud());
        	stm.setString(8, cliente.getDireccion());
        	stm.setString(9, cliente.getComuna());
        	stm.setInt(10, cliente.getEdad());

            stm.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    
    
    public void guardarAdministrativo(Administrativo admin) {
        String sql = "INSERT INTO administrativos (nombre, tipo, fecha_nacimiento, rut, area, experiencia_previa) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            this.cn = Conexion.getConnected();
            PreparedStatement stm = this.cn.prepareStatement(sql);
            stm.setString(1, admin.getNombre());
            stm.setString(2, admin.getTipo());
            stm.setDate(3, java.sql.Date.valueOf(admin.getFechaNacimiento()));
            stm.setString(4, admin.getRut());
            stm.setString(5, admin.getArea());
            stm.setString(6, admin.getExperienciaPrevia());

            stm.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

    public void guardarProfesional(Profesional pro) {
        String sql = "INSERT INTO profesionales (nombre, tipo, fecha_nacimiento, rut, titulo, fecha_ingreso) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            this.cn = Conexion.getConnected();
            PreparedStatement stm = this.cn.prepareStatement(sql);
            stm.setString(1, pro.getNombre());
            stm.setString(2, pro.getTipo());
            stm.setDate(3, java.sql.Date.valueOf(pro.getFechaNacimiento()));
            stm.setString(4, pro.getRut());
            stm.setString(5, pro.getTitulo());
            stm.setDate(6, java.sql.Date.valueOf(pro.getFechaIngreso()));

            stm.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }


	@Override
	public List<Cliente> listarClientes() {
	    List<Cliente> clientes = new ArrayList<>();
	    String sql = "SELECT * FROM clientes";

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String tipo = rs.getString("tipo");
	            LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
	            String rut = rs.getString("rut");
	            int telefono = rs.getInt("telefono");
	            String afp = rs.getString("afp");
	            String sistemaSalud = rs.getString("sistema_salud");
	            String direccion = rs.getString("direccion");
	            String comuna = rs.getString("comuna");
	            int edad = rs.getInt("edad");

	            Cliente cliente = new Cliente(id, nombre, tipo, fechaNacimiento, rut, telefono, afp, sistemaSalud, direccion, comuna, edad);
	            clientes.add(cliente);
	        }

	        rs.close();
	        stm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return clientes;
	}

	
	@Override
	public List<Administrativo> listarAdmins() {
	    List<Administrativo> administrativos = new ArrayList<>();
	    String sql = "SELECT * FROM administrativos";

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String tipo = rs.getString("tipo");
	            LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
	            String rut = rs.getString("rut");
	            String area = rs.getString("area");
	            String experienciaPrevia = rs.getString("experiencia_previa");

	            Administrativo administrativo = new Administrativo(id, nombre, tipo, fechaNacimiento, rut, area, experienciaPrevia);
	            administrativos.add(administrativo);
	        }

	        rs.close();
	        stm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return administrativos;
	}

	
	public List<Profesional> listarPros() {
	    List<Profesional> profesionales = new ArrayList<>();
	    String sql = "SELECT * FROM profesionales";

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String tipo = rs.getString("tipo");
	            LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
	            String rut = rs.getString("rut");
	            String titulo = rs.getString("titulo");
	            LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();

	            Profesional profesional = new Profesional(id, nombre, tipo, fechaNacimiento, rut, titulo, fechaIngreso);
	            profesionales.add(profesional);
	        }

	        rs.close();
	        stm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return profesionales;
	}
	
	
	public Cliente obtenerClientePorId(int clienteId) {
	    String sql = "SELECT * FROM clientes WHERE id = ?";
	    Cliente cliente = null;

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        stm.setInt(1, clienteId);
	        ResultSet rs = stm.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String tipo = rs.getString("tipo");
	            LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
	            String rut = rs.getString("rut");
	            int telefono = rs.getInt("telefono");
	            String afp = rs.getString("afp");
	            String sistemaSalud = rs.getString("sistema_salud");
	            String direccion = rs.getString("direccion");
	            String comuna = rs.getString("comuna");
	            int edad = rs.getInt("edad");

	            cliente = new Cliente(clienteId, nombre, tipo, fechaNacimiento, rut, telefono, afp, sistemaSalud, direccion, comuna, edad);
	        }

	        rs.close();
	        stm.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }

	    return cliente;
	}
	
	public void actualizarCliente(Cliente cliente) {
	    String sql = "UPDATE clientes SET nombre = ?, fecha_nacimiento = ?, rut = ?, telefono = ?, afp = ?, sistema_salud = ?, direccion = ?, comuna = ?, edad = ? WHERE id = ?";

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        stm.setString(1, cliente.getNombre());
	        stm.setDate(2, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
	        stm.setString(3, cliente.getRut());
	        stm.setInt(4, cliente.getTelefono());
	        stm.setString(5, cliente.getAfp());
	        stm.setString(6, cliente.getSistemaSalud());
	        stm.setString(7, cliente.getDireccion());
	        stm.setString(8, cliente.getComuna());
	        stm.setInt(9, cliente.getEdad());
	        stm.setInt(10, cliente.getId());

	        stm.executeUpdate();
	        stm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public Administrativo obtenerAdminPorId(int adminId) {
	    String sql = "SELECT * FROM administrativos WHERE id = ?";
	    Administrativo admin = null;

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        stm.setInt(1, adminId);
	        ResultSet rs = stm.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String tipo = rs.getString("tipo");
	            LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
	            String rut = rs.getString("rut");
	            String area = rs.getString("area");
	            String experienciaPrevia = rs.getString("experiencia_previa");

	            admin = new Administrativo(adminId, nombre, tipo, fechaNacimiento, rut, area, experienciaPrevia );
	        }

	        rs.close();
	        stm.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }

	    return admin;
	}
	
	public void actualizarAdmin(Administrativo admin) {
	    String sql = "UPDATE administrativos SET nombre = ?, fecha_nacimiento = ?, rut = ?, area = ?, experiencia_previa = ? WHERE id = ?";

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        stm.setString(1, admin.getNombre());
	        stm.setDate(2, java.sql.Date.valueOf(admin.getFechaNacimiento()));
	        stm.setString(3, admin.getRut());
	        stm.setString(4, admin.getArea());
	        stm.setString(5, admin.getExperienciaPrevia());
	        stm.setInt(6, admin.getId());

	        stm.executeUpdate();
	        stm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public Profesional obtenerProPorId(int proId) {
	    String sql = "SELECT * FROM profesionales WHERE id = ?";
	    Profesional pro = null;

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        stm.setInt(1, proId);
	        ResultSet rs = stm.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String tipo = rs.getString("tipo");
	            LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
	            String rut = rs.getString("rut");
	            String titulo = rs.getString("titulo");
	            LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();

	            pro = new Profesional(proId, nombre, tipo, fechaNacimiento, rut, titulo, fechaIngreso );
	        }

	        rs.close();
	        stm.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }

	    return pro;
	}
	
	public void actualizarPro(Profesional pro) {
	    String sql = "UPDATE profesionales SET nombre = ?, fecha_nacimiento = ?, rut = ?, titulo = ?, fecha_ingreso = ? WHERE id = ?";

	    try {
	        this.cn = Conexion.getConnected();
	        PreparedStatement stm = this.cn.prepareStatement(sql);
	        stm.setString(1, pro.getNombre());
	        stm.setDate(2, java.sql.Date.valueOf(pro.getFechaNacimiento()));
	        stm.setString(3, pro.getRut());
	        stm.setString(4, pro.getTitulo());
	        stm.setDate(5, java.sql.Date.valueOf(pro.getFechaIngreso()));
	        stm.setInt(6, pro.getId());

	        stm.executeUpdate();
	        stm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



}
