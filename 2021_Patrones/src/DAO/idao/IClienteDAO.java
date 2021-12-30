package DAO.idao;
 
import java.util.List;
 
import DAO.model.Cliente;
 
public interface IClienteDAO {
	//declaración de métodos para acceder a la base de datos
	public List<Cliente> obtenerClientes();
	public Cliente obtenerCliente(int id);
	public void actualizarCliente(Cliente cliente);
	public void eliminarCliente(Cliente cliente);
}