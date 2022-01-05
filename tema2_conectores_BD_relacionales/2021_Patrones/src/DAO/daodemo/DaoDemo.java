package DAO.daodemo;
 
import dao.ClienteDaoImpl;
import DAO.idao.IClienteDAO;
import DAO.model.Cliente;
 
public class DaoDemo {
 
	public static void main(String[] args) {
		// objeto para manipular el dao
		IClienteDAO clienteDao = new ClienteDaoImpl();
 
		// imprimir los clientes
		clienteDao.obtenerClientes().forEach(System.out::println);
 
		// obtner un cliente
		Cliente cliente = clienteDao.obtenerCliente(0);
		cliente.setApellido("Perez");
		//actualizar cliente
		clienteDao.actualizarCliente(cliente);
 
		// imprimir los clientes
		System.out.println("*****");
		clienteDao.obtenerClientes().forEach(System.out::println);
	}
}