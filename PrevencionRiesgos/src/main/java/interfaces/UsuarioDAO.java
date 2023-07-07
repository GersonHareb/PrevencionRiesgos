package interfaces;

import java.util.List;

import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;


public interface UsuarioDAO {
	public void guardarCliente(Cliente cliente);
	public void actualizarCliente(Cliente cliente);
	public void guardarAdministrativo(Administrativo administrativo);
	public void guardarProfesional(Profesional profesional);
	List<Cliente> listarClientes();
	List<Administrativo> listarAdmins();
	List<Profesional> listarPros();
}
