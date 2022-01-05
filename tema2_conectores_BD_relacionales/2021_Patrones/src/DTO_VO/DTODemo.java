package DTO_VO;
 
import DTO_VO.BO.ClienteBO;
import DTO_VO.VO.ClienteVO;
 
public class DTODemo {
    public static void main(String[] args) {
        //objeto business object
        ClienteBO clienteBusinessObject = new ClienteBO();

        //obtiene todos los clientes
        System.out.println("**Datos del Listado**");
        clienteBusinessObject.obtenerClientes().forEach(System.out::println);

        // actualiza un cliente
        System.out.println("**Actualización Cliente**");
        ClienteVO cliente = clienteBusinessObject.obtenerCliente(0);
        cliente.setNombre("Marisol");
        clienteBusinessObject.actualizarCliente(cliente);

        // obtiene un cliente
        System.out.println("**Recupera Cliente**");
        cliente=clienteBusinessObject.obtenerCliente(0);
        System.out.println(cliente);

        //elimina un cliente
        System.out.println("**Elimina Cliente**");
        cliente=clienteBusinessObject.obtenerCliente(0);
        clienteBusinessObject.eliminarCliente(cliente);	
        
         //obtiene todos los clientes
        System.out.println("**Datos del Listado**");
        clienteBusinessObject.obtenerClientes().forEach(System.out::println);
    }
}