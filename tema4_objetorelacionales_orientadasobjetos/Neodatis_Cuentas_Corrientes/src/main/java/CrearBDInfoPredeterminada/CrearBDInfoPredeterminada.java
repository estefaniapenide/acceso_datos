/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrearBDInfoPredeterminada;

import POO.Modelo.C_Cliente;
import POO.Modelo.C_Cuenta;
import POO.Modelo.C_CuentaCorriente;
import POO.Modelo.C_CuentaPlazo;
import POO.Modelo.C_Movimiento;
import java.sql.Date;
import java.sql.Time;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author a20estefaniapc
 */
public class CrearBDInfoPredeterminada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        C_Cliente cliente1 = new C_Cliente("53191630J", "CLIENTE1", "calle1");
        C_Cliente cliente2 = new C_Cliente("33226624L", "CLIENTE2", "calle2");
        C_Cliente cliente3 = new C_Cliente("13509784K", "CLIENTE3", "calle3");
        C_Cliente cliente4 = new C_Cliente("38274210W", "OTROCLIENTE", "calle4");
        C_Cliente cliente5 = new C_Cliente("77950872P", "CLIENTE5", "calle5");

        C_Cuenta cuentaCC1 = new C_CuentaCorriente(1, "A", 200000.f);
        cuentaCC1.getClientes().add(cliente1);
        cuentaCC1.getClientes().add(cliente2);
        cuentaCC1.getClientes().add(cliente4);

        C_Cuenta cuentaCC2 = new C_CuentaCorriente(2, "B", -23.f);
        cuentaCC2.getClientes().add(cliente2);
        cuentaCC2.getClientes().add(cliente5);

        C_Cuenta cuentaCC3 = new C_CuentaCorriente(3, "C", 200001.f);
        cuentaCC3.getClientes().add(cliente2);
        cuentaCC3.getClientes().add(cliente3);

        C_Cuenta cuentaCC4 = new C_CuentaCorriente(4, "A", 200000.f);

        C_Movimiento movimiento1 = new C_Movimiento(new Date(2020 - 1900, 12 - 1, 1), cuentaCC1, 'I', 6.f);
        C_Movimiento movimiento2 = new C_Movimiento(new Date(2020 - 1900, 12 - 1, 2), cuentaCC1, 'R', 8.f);
        C_Movimiento movimiento3 = new C_Movimiento(new Date(2020 - 1900, 12 - 1, 3), cuentaCC1, 'I', 9.f);

        if (cuentaCC1 instanceof C_CuentaCorriente) {
            ((C_CuentaCorriente) cuentaCC1).getMovimientos().add(movimiento1);
            ((C_CuentaCorriente) cuentaCC1).getMovimientos().add(movimiento2);
            ((C_CuentaCorriente) cuentaCC1).getMovimientos().add(movimiento3);
        }


        C_Cuenta cuentaCP1 = new C_CuentaPlazo(5, "A", 200.f, 2, "fecha", 5.f);
        cuentaCP1.getClientes().add(cliente1);
        cuentaCP1.getClientes().add(cliente2);
        
        C_Cuenta cuentaCP2 = new C_CuentaPlazo(6, "B", 12.f, 2, "fecha", 5.f);
        cuentaCP2.getClientes().add(cliente2);
        
        C_Cuenta cuentaCP3 = new C_CuentaPlazo(7, "C", 23.f, 2, "fecha", 5.f);
        cuentaCP3.getClientes().add(cliente2);
        cuentaCP3.getClientes().add(cliente3);
        
        
        cliente1.getCuentas().add(cuentaCC1);
        cliente1.getCuentas().add(cuentaCC2);
        cliente1.getCuentas().add(cuentaCP1);
        cliente1.getCuentas().add(cuentaCP2);

        cliente2.getCuentas().add(cuentaCC2);
        cliente2.getCuentas().add(cuentaCP2);

        cliente3.getCuentas().add(cuentaCC2);
        cliente3.getCuentas().add(cuentaCC3);
        cliente3.getCuentas().add(cuentaCP2);
        cliente3.getCuentas().add(cuentaCP3);

        ODB odb = ODBFactory.open("BD_CUENTAS.test");
        odb.store(cuentaCC1);
        odb.store(cuentaCC2);
        odb.store(cuentaCC3);
        odb.store(cuentaCP1);
        odb.store(cuentaCP2);
        odb.store(cuentaCP3);
        odb.commit();
        odb.close();
    }

}
