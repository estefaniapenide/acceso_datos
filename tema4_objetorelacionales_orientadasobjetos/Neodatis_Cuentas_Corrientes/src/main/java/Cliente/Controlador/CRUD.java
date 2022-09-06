/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Controlador;

import Cadenas.Cadenas;
import POO.Modelo.C_Cliente;
import POO.Modelo.C_Cuenta;
import POO.Modelo.C_CuentaCorriente;
import POO.Modelo.C_CuentaPlazo;
import POO.Modelo.C_Movimiento;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author a20estefaniapc
 */
public class CRUD {

//    public static void funcion(boolean metodo){
//        
//         boolean existe = false;
//        ODB odb = null;
//        try {
//            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
//            
//            metodo;
//            
//            } catch (org.neodatis.odb.ODBRuntimeException E) {
//            Cadenas.errorConexionServidor();
//            System.exit(0);
//        } finally {
//            if (odb != null) {
//                odb.close();
//            }
//        }
//    
//    }
    
    
    public static void guardarCuenta(C_Cuenta cuenta) {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            odb.store(cuenta);
            odb.commit();

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }
    
    public static void addClienteACuenta(C_Cliente cliente, C_Cuenta cuenta){
        
        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
            
            IQuery query = new CriteriaQuery((C_Cliente.class), Where.equal("dni", cliente.getDni()));
            Objects cli = odb.getObjects(query);
            C_Cliente cl = (C_Cliente) cli.getFirst();
            
            
            cl.getCuentas().add(cuenta);
            cuenta.getClientes().add(cl);
            
            odb.store(cuenta);
            odb.commit();

            
            } catch (org.neodatis.odb.ODBRuntimeException E) {
                E.printStackTrace();
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    
    }
    
//    public static void borrarCliente(C_Cliente cliente){
//    ODB odb = null;
//        try {
//            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
//            
//            IQuery query = new CriteriaQuery((C_Cliente.class), Where.equal("dni", cliente.getDni()));
//            Objects cli = odb.getObjects(query);
//            C_Cliente c = (C_Cliente) cli.getFirst();
//            
//            odb.delete(c.getCuentas());
//            odb.delete(c);
//            
//            
//            } catch (org.neodatis.odb.ODBRuntimeException E) {
//                E.printStackTrace();
//            Cadenas.errorConexionServidor();
//            System.exit(0);
//        } finally {
//            if (odb != null) {
//                odb.close();
//            }
//        }
//    
//    }

    public static boolean existeCuentaPorNumero(int numeroCuenta) {

        boolean existe = false;
        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            IQuery query = new CriteriaQuery((C_Cuenta.class), Where.equal("numero", numeroCuenta)).setPolymorphic(true);
            Objects cuenta = odb.getObjects(query);
            while (cuenta.hasNext()) {
                C_Cuenta a = (C_Cuenta) cuenta.next();
                existe = true;
            }
        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        return existe;

    }

    public static boolean existeClientePorDni(String dni) {

        boolean existe = false;
        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            IQuery query = new CriteriaQuery((C_Cliente.class), Where.equal("dni", dni));
            Objects cliente = odb.getObjects(query);
            while (cliente.hasNext()) {
                C_Cliente a = (C_Cliente) cliente.next();
                existe = true;
            }
        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        return existe;

    }

    public static C_Cuenta obtenerCuentaPorNumero(int numeroCuenta) {

        C_Cuenta c = null;

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            IQuery query = new CriteriaQuery((C_Cuenta.class), Where.equal("numero", numeroCuenta)).setPolymorphic(true);
            Objects cuenta = odb.getObjects(query);
            c = (C_Cuenta) cuenta.getFirst();

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            E.printStackTrace();
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        return c;

    }

    public static C_Cliente obtenerClientePorDni(String dni) {

        C_Cliente c = null;

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            IQuery query = new CriteriaQuery((C_Cliente.class), Where.equal("dni", dni));
            Objects cliente = odb.getObjects(query);
            c = (C_Cliente) cliente.getFirst();

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            E.printStackTrace();
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        return c;

    }

//    public static ArrayList<C_Movimiento> obtenerMovimientosPorCuenta(C_CuentaCorriente cuenta) {
//
//        ArrayList<C_Movimiento> movimientos = new ArrayList<C_Movimiento>();
//
//        ODB odb = null;
//        try {
//            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
//
//            for (Object mov : cuenta.getMovimientos()) {
//                IQuery query = new CriteriaQuery((C_Movimiento.class), Where.equal("dni", mov.));
//                Objects cliente = odb.getObjects(query);
//                c = (C_Cliente) cliente.getFirst();
//            }
//
//        } catch (org.neodatis.odb.ODBRuntimeException E) {
//            E.printStackTrace();
//            Cadenas.errorConexionServidor();
//            System.exit(0);
//        } finally {
//            if (odb != null) {
//                odb.close();
//            }
//        }
//        return movimientos;
//
//    }
    public static void imprimirCuentaPorNumero(int numeroCuenta) {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            IQuery query = new CriteriaQuery((C_Cuenta.class), Where.equal("numero", numeroCuenta)).setPolymorphic(true);
            Objects c = odb.getObjects(query);

            C_Cuenta cuenta = (C_Cuenta) c.getFirst();

            if (cuenta instanceof C_CuentaCorriente) {
                System.out.println(cuenta);
            } else if (cuenta instanceof C_CuentaPlazo) {
                System.out.println(cuenta);
            }

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }

    public static void imprimirClientePorDni(String dni) {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            IQuery query = new CriteriaQuery((C_Cliente.class), Where.equal("dni", dni));
            Objects c = odb.getObjects(query);

            C_Cliente cliente = (C_Cliente) c.getFirst();

            System.out.println(cliente);

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }

    
    public static void addMovimientoCuenta(C_Cuenta cuenta, C_Movimiento movimiento) {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
            

            IQuery query = new CriteriaQuery((C_Cuenta.class), Where.equal("numero", cuenta.getNumero())).setPolymorphic(true);
            Objects c = odb.getObjects(query);
            C_Cuenta cuentaCorriente = (C_Cuenta) c.getFirst();

            if (cuentaCorriente instanceof C_CuentaCorriente) {

                ((C_CuentaCorriente) cuentaCorriente).getMovimientos().add(movimiento);
                ((C_CuentaCorriente) cuentaCorriente).actualizarSaldo();
                movimiento.setCuenta(cuentaCorriente);

                odb.store(cuentaCorriente);
                odb.commit();

            }

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }

    public static void imprimirClientesEmpiezanPorLetra(String letra) {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            letra = letra.toUpperCase();

            ICriterion criterio = Where.like("nombre", letra + "%");
            IQuery query = new CriteriaQuery(C_Cliente.class, criterio);
            Objects client = odb.getObjects(query);
            while (client.hasNext()) {
                C_Cliente cliente = (C_Cliente) client.next();
                System.out.println(cliente);
            }

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }

//    public static void imprimirClientesSaldoSuperiorImporte(int saldo) {
//
//        ODB odb = null;
//        try {
//            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
//
//            ICriterion criterio = Where.gt("saldoActual", saldo);
//            IQuery query = new CriteriaQuery(C_CuentaCorriente.class, criterio);
//            Objects cuent = odb.getObjects(query);
//            while (cuent.hasNext()) {
//                C_CuentaCorriente cuenta = (C_CuentaCorriente) cuent.next();
//                System.out.println("NÚMERO DE CUENTA: " + cuenta.getNumero());
//                System.out.println("SALDO ACTUAL: " + cuenta.getSaldoActual());
//                for (C_Cliente cliente : cuenta.getClientes()) {
//                    System.out.println(cliente);
//                }
//            }
//
//        } catch (org.neodatis.odb.ODBRuntimeException E) {
//            Cadenas.errorConexionServidor();
//            System.exit(0);
//        } finally {
//            if (odb != null) {
//                odb.close();
//            }
//        }
//
//    }
    
    public static void imprimirClientesSaldoSuperiorImporte(int saldo) {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            HashSet<C_Cliente> clientes = new HashSet<C_Cliente>();

            ICriterion criterio = Where.gt("saldoActual", saldo);
            IQuery query = new CriteriaQuery(C_CuentaCorriente.class, criterio);
            Objects cuent = odb.getObjects(query);
            while (cuent.hasNext()) {
                C_CuentaCorriente cuenta = (C_CuentaCorriente) cuent.next();

                for (C_Cliente cliente : cuenta.getClientes()) {
                    clientes.add(cliente);
                }
            }

            for (C_Cliente cliente : clientes) {
                System.out.println(cliente);
            }

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }

    public static void imprimirNumeroClientesNumerosRojos() {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            HashSet<C_Cliente> clientes = new HashSet<C_Cliente>();

            ICriterion criterio = Where.lt("saldoActual", 0);
            IQuery query = new CriteriaQuery(C_CuentaCorriente.class, criterio);
            Objects cuent = odb.getObjects(query);
            while (cuent.hasNext()) {
                C_CuentaCorriente cuenta = (C_CuentaCorriente) cuent.next();

                for (C_Cliente cliente : cuenta.getClientes()) {
                    clientes.add(cliente);
                }
            }

            System.out.println(clientes.size());

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    public static void imprimirSaldoMedioCuentasPlazo() {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");

            Values valores = odb.getValues(new ValuesCriteriaQuery(C_CuentaPlazo.class).sum("saldoActual").count("numero"));
            while (valores.hasNext()) {
                ObjectValues objectValues = (ObjectValues) valores.nextValues();
                BigDecimal total = (BigDecimal) objectValues.getByIndex(0);
                BigInteger numero = (BigInteger) objectValues.getByIndex(1);

                float media = total.floatValue() / numero.intValue();
                System.out.println(media);
            }

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

//    public static ArrayList<C_Movimiento> obtenerMovimientosPorCuentaEntreDosFechas(C_CuentaCorriente cuenta, Date dateInicio, Date dateFin) {
//
//        ArrayList<C_Movimiento> movimientos = new ArrayList<C_Movimiento>();
//
//        ODB odb = null;
//        try {
//            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
//
//         
//                IQuery query = new CriteriaQuery((C_Movimiento.class), new And().add(Where.equal("cuenta.numero", cuenta.getNumero())).add(Where.ge("fecha", dateInicio)).add(Where.le("fecha", dateFin))).setPolymorphic(true);
//                Objects m = odb.getObjects(query);
//                while (m.hasNext()) {
//                    C_Movimiento movimiento = (C_Movimiento) m.next();
//                    movimientos.add(movimiento);
//                }
//            
//
//        } catch (org.neodatis.odb.ODBRuntimeException E) {
//            E.printStackTrace();
//            Cadenas.errorConexionServidor();
//            System.exit(0);
//        } finally {
//            if (odb != null) {
//                odb.close();
//            }
//        }
//        
//        return movimientos;
//    }
    
    
    public static void eliminarCuenta(C_Cuenta cuenta) {

        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
            
            IQuery query = new CriteriaQuery((C_Cuenta.class), Where.equal("numero", cuenta.getNumero())).setPolymorphic(true);
            Objects c = odb.getObjects(query);
            C_Cuenta cue = (C_Cuenta) c.getFirst();
            
            odb.delete(cue);

        } catch (org.neodatis.odb.ODBRuntimeException E) {
            E.printStackTrace();
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }
    
    public static void modificarIntereses(C_Cuenta cuenta, int intereses){
        
        ODB odb = null;
        try {
            odb = ODBFactory.openClient("localhost", 8000, "BD_CUENTAS");
            
            IQuery query = new CriteriaQuery((C_Cuenta.class), Where.equal("numero", cuenta.getNumero())).setPolymorphic(true);
            Objects c = odb.getObjects(query);
            C_CuentaPlazo cue = (C_CuentaPlazo) c.getFirst();
            
            cue.setIntereses(intereses);
            
            odb.store(cue);
            odb.commit();
        
        
         } catch (org.neodatis.odb.ODBRuntimeException E) {
            E.printStackTrace();
            Cadenas.errorConexionServidor();
            System.exit(0);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    
    }

}
