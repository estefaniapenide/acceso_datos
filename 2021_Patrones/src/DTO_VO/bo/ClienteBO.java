package DTO_VO.BO;
 
import java.util.ArrayList;
import java.util.List;
 
import DTO_VO.VO.ClienteVO;
 
public class ClienteBO {
	
	//lista de tipo cliente
	List<ClienteVO> clientes;
	
	
	//constructor, se guarda en la lista 2 clientes
	public ClienteBO() {
            clientes = new ArrayList<>();
            ClienteVO cliente1= new ClienteVO(0,"María","Rodríguez");
            ClienteVO cliente2= new ClienteVO(1,"Pepe","Perez");
            clientes.add(cliente1);
            clientes.add(cliente2);
	}
	
	//elimina el cliente que se le pasa como paraámetro
	public void eliminarCliente(ClienteVO cliente) {
            clientes.remove(cliente.getId());
            System.out.println("Cliente "+cliente.getId()+" eliminado satisfactoriamente");
	}
	
	//obtiene toda la lista de clientes
	public List<ClienteVO> obtenerClientes(){
            return clientes;
	}
	
	//obtiene un cliente de acuerdo al id pasado como parámetro
	public ClienteVO obtenerCliente(int id) {
            return clientes.get(id);
	}
	
	// actualiza el cliente que se le pasa como parámetro
	public void actualizarCliente(ClienteVO cliente) {
            clientes.get(cliente.getId()).setNombre(cliente.getNombre());
            clientes.get(cliente.getId()).setApellido(cliente.getApellido());
            System.out.println("Cliente id: "+ cliente.getId()+" actualizado satisfactoriamente");		
	}
}