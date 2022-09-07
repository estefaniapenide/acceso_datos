package controlador;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.neodatis.odb.ODB;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.CuentaCorriente;
import modelo.CuentaPlazo;
import modelo.Movimiento;

public class CrearBase {

	public static void crear(ODB odb) {
		
		CuentaCorriente c1=new CuentaCorriente(1,"Vigo",1000,null,null);
		CuentaCorriente c2=new CuentaCorriente(2,"Santiago",10000,null,null);
		CuentaPlazo c3=new CuentaPlazo(3,"Lugo",3000,null,3,"2023-04-04",2000);
		CuentaPlazo c4=new CuentaPlazo(4,"Ourense",5000,null,3,"2024-04-04",3000);
		
		CuentaCorriente c5=new CuentaCorriente(5,"Vigo",200000000,null,null);
		CuentaCorriente c6=new CuentaCorriente(6,"Santiago",-10000,null,null);
		
		
		
		Cliente cl1=new Cliente("11111111A","Cliente1",null);
		Set<Cuenta> cuentasCl1=new HashSet<>();
		cuentasCl1.add(c1);
		cuentasCl1.add(c2);
		cl1.setCuentas(cuentasCl1);
		
		Cliente cl2=new Cliente("22222222B","Cliente2",null);
		Set<Cuenta> cuentasCl2=new HashSet<>();
		cuentasCl1.add(c2);
		cuentasCl1.add(c3);
		cl2.setCuentas(cuentasCl2);
		
		Cliente cl3=new Cliente("33333333C","Cliente3",null);
		Set<Cuenta> cuentasCl3=new HashSet<>();
		cuentasCl3.add(c3);
		cuentasCl3.add(c4);
		cl3.setCuentas(cuentasCl3);
		
		Cliente cl5=new Cliente("55555555P","Cliente5",null);
		Set<Cuenta> cuentasCl5=new HashSet<>();
		cuentasCl5.add(c5);
		cl5.setCuentas(cuentasCl5);
		
		Cliente cl6=new Cliente("66666666P","Cliente6",null);
		Set<Cuenta> cuentasCl6=new HashSet<>();
		cuentasCl6.add(c6);
		cl6.setCuentas(cuentasCl6);
		
				
		
		
		
		Timestamp t1=new Timestamp(1999,11,11,11,11,11,11);
		Timestamp t2=new Timestamp(1500,1,1,1,1,1,1);
		
		
		Movimiento m1=new Movimiento(t1, c1, 'a', 50, 1050);
		Movimiento m2=new Movimiento(t2, c1, 'b', 100, 1100);

		
		Set<Cliente> clientesC1=new HashSet<>();
		clientesC1.add(cl1);
		c1.setClientes(clientesC1);
		
		Set<Cliente> clientesC2=new HashSet<>();
		clientesC2.add(cl1);
		clientesC2.add(cl2);
		c2.setClientes(clientesC2);
		
		Set<Cliente> clientesC3=new HashSet<>();
		clientesC3.add(cl2);
		clientesC3.add(cl3);
		c3.setClientes(clientesC3);
		
		Set<Cliente> clientesC4=new HashSet<>();
		clientesC4.add(cl3);
		c4.setClientes(clientesC4);
		
		Set<Cliente> clientesC5=new HashSet<>();
		clientesC5.add(cl5);
		c5.setClientes(clientesC5);
		
		Set<Cliente> clientesC6=new HashSet<>();
		clientesC6.add(cl6);
		c6.setClientes(clientesC6);
		
		
		
		ArrayList<Movimiento>movimientosC1=new ArrayList<>();
		movimientosC1.add(m1);
		movimientosC1.add(m2);		
		c1.setMovimientos(movimientosC1);
				
		odb.store(c1);
		odb.store(c2);
		odb.store(c3);
		odb.store(c4);
		odb.store(c5);
		odb.store(c6);
			
		odb.commit();
	
		
	}
}
