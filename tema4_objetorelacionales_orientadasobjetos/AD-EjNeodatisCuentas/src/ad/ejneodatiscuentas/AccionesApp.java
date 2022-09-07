/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatiscuentas;

import ad.ejneodatiscuentas.pojos.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author a20armandocb
 */
class AccionesApp {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public AccionesApp() {
        runStopServer();
    }

    void runStopServer() {
        StringBuilder anuncio = new StringBuilder();
        if (OdbServer.isRun()) {
            anuncio.append("Apagando servidor...\n");
            if (OdbServer.stop()) {
                anuncio.append("--- Servidor apagado con éxito ---");
            } else {
                anuncio.append("--- Error al apagar el servidor ---");
            }
        } else {
            anuncio.append("Iniciando servidor...\n");
            if (OdbServer.run()) {
                anuncio.append("--- Servidor iniciado con éxito ---");
            } else {
                anuncio.append("--- Error al iniciar el servidor ---");
            }
        }
        peticiones.SalidasGui.mensaje(anuncio.toString());

    }

    void altaCuentaCorriente() {
        HashSet<Cliente> clientes = new HashSet<Cliente>();
        HashSet<Cliente> clientes2 = new HashSet<Cliente>();
        HashSet<Cliente> clientes3 = new HashSet<Cliente>();
        HashSet<Cliente> clientes4 = new HashSet<Cliente>();
        Cliente c1 = new Cliente("53170624Y", "Armando", "cualquier lugar 123");
        Cliente c2 = new Cliente("12345678Z", "Carlos", "ningún lugar 123");
        clientes.add(c1);
        clientes.add(c2);
        CuentaCorriente cc01 = new CuentaCorriente(10001, "florida", 300000, clientes);
        c1.addCuenta(cc01);
        c2.addCuenta(cc01);

        Cliente c3 = new Cliente("88888888P", "Ana", "el lugar 123");
        clientes2.add(c2);
        clientes2.add(c3);
        CuentaCorriente cc02 = new CuentaCorriente(10002, "salamanca", 350000, clientes2);

        clientes3.add(c1);
        CuentaCorriente cc03 = new CuentaCorriente(10003, "salamanca", -5000, clientes3);

        clientes4.add(c3);
        CuentaCorriente cc04 = new CuentaCorriente(10004, "bilbao", -30, clientes4);

        try {
            if (obtenerCuenta(cc01.getNumero()) == null) {
                OdbConnection.getOdb().store(cc01);
                peticiones.SalidasGui.mensaje("Guardada Cuenta: \n" + cc01.toString());
            } else {
                peticiones.SalidasGui.mensaje("No se puede crear la cuenta, el nº " + cc01.getNumero() + " ya existe.");
            }

            if (obtenerCuenta(cc02.getNumero()) == null) {
                OdbConnection.getOdb().store(cc02);
                peticiones.SalidasGui.mensaje("Guardada Cuenta: \n" + cc02.toString());
            } else {
                peticiones.SalidasGui.mensaje("No se puede crear la cuenta, el nº " + cc02.getNumero() + " ya existe.");
            }

            if (obtenerCuenta(cc03.getNumero()) == null) {
                OdbConnection.getOdb().store(cc03);
                peticiones.SalidasGui.mensaje("Guardada Cuenta: \n" + cc03.toString());
            } else {
                peticiones.SalidasGui.mensaje("No se puede crear la cuenta, el nº " + cc03.getNumero() + " ya existe.");
            }

            if (obtenerCuenta(cc04.getNumero()) == null) {
                OdbConnection.getOdb().store(cc04);
                peticiones.SalidasGui.mensaje("Guardada Cuenta: \n" + cc04.toString());
            } else {
                peticiones.SalidasGui.mensaje("No se puede crear la cuenta, el nº " + cc04.getNumero() + " ya existe.");
            }
            OdbConnection.getOdb().close();
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void altaCuentaPlazo() {
        HashSet<Cliente> clientes = new HashSet<Cliente>();
        Cliente c1 = new Cliente("36037769N", "Castro", "otro lugar distinto 123");
        clientes.add(c1);
        CuentaPlazo cp01 = new CuentaPlazo(4, "29/03/2023", 20000, 20001, "Sanjurjo Badía", 0, clientes);
        c1.addCuenta(cp01);

        if (obtenerCuenta(cp01.getNumero()) == null) {
            try {
                OdbConnection.getOdb().store(cp01);
                peticiones.SalidasGui.mensaje("Guardada Cuenta: \n" + cp01.toString());
                OdbConnection.getOdb().close();
            } catch (Exception ex) {
                peticiones.SalidasGui.mensaje(ex.toString());
            }
        } else {
            peticiones.SalidasGui.mensaje("No se puede crear la cuenta, el nº " + cp01.getNumero() + " ya existe.");
        }
    }

    void altaMovimiento() {
        try {
            CuentaCorriente cuentacorriente = obtenerCuentaCorriente(10001);
            Movimiento mov = null;
            Movimiento mov2 = null;
            Movimiento mov3 = null;
            if (cuentacorriente != null) {
                try {
                    mov = new Movimiento(dateFormat.parse("29/03/2021"), cuentacorriente, Movimiento.OP_INGRESO, 500);
                    mov2 = new Movimiento(dateFormat.parse("20/04/2021"), cuentacorriente, Movimiento.OP_RETIRADA, 100);
                    mov3 = new Movimiento(dateFormat.parse("29/01/2022"), cuentacorriente, Movimiento.OP_INGRESO, 10000);
                } catch (ParseException ex) {
                    peticiones.SalidasGui.mensaje(ex.toString());
                }
                cuentacorriente.addMovimientos(mov);
                cuentacorriente.addMovimientos(mov2);
                cuentacorriente.addMovimientos(mov3);

                OdbConnection.getOdb().store(cuentacorriente);
                peticiones.SalidasGui.mensaje("Guardada Cuenta: \n" + cuentacorriente.toString());
                OdbConnection.getOdb().close();
            } else {
                peticiones.SalidasGui.mensaje("La cuenta no existe.");
            }
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void modInteresCuentaPlazo() {
        try {
//            String dniCliente = "36037769N";
            int nCuentaPlazo = 20001;
            int nuevoInteres = (int) (Math.random() * 25);
            CuentaPlazo cuentaPlazo = obtenerCuentaPlazo(nCuentaPlazo);
            if (cuentaPlazo != null) {
                int antiguoInteres = cuentaPlazo.getIntereses();
                cuentaPlazo.setIntereses(nuevoInteres);
                OdbConnection.getOdb().store(cuentaPlazo);
                OdbConnection.getOdb().close();
                peticiones.SalidasGui.mensaje("Se ha cambiado el interes de la cuenta nº " + cuentaPlazo.getNumero()
                        + "\n Interes de " + antiguoInteres + " a  " + cuentaPlazo.getIntereses());
            } else {
                peticiones.SalidasGui.mensaje("La cuenta a plazo no existe.");
            }

        } catch (ODBRuntimeException ex) {
            //no hay resultados.        
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }

    }

    void delCuentaPlazo() {
        try {
            int nCuentaPlazo = 20001;
            CuentaPlazo cuentaPlazo = obtenerCuentaPlazo(nCuentaPlazo);
            if (cuentaPlazo != null) {
                OdbConnection.getOdb().delete(cuentaPlazo);
                OdbConnection.getOdb().close();
                peticiones.SalidasGui.mensaje("Se ha elimnado la cuenta nº " + cuentaPlazo.getNumero());
            } else {
                peticiones.SalidasGui.mensaje("La cuenta a plazo no existe.");
            }

        } catch (ODBRuntimeException ex) {
            //no hay resultados.        
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void listarClientesC() {
        try {
            ICriterion filtro = Where.like("nombre", "C%");
            IQuery query = new CriteriaQuery(Cliente.class, filtro);
            StringBuilder resultado = new StringBuilder();

            Object[] clientes = OdbConnection.getOdb().getObjects(query).toArray();
            OdbConnection.getOdb().close();
            resultado.append("Clientes C:  (" + clientes.length + "):\n");
            for (Object clienteObj : clientes) {
                resultado.append(" >> " + ((Cliente) clienteObj).toString() + "\n");
            }
            peticiones.SalidasGui.mensaje(resultado.toString());
        } catch (ODBRuntimeException ex) {
            //no hay resultados.        
            peticiones.SalidasGui.mensaje("No hay resultados");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void listarClientesSaldoMayor() {
        try {
            float saldo = 200000F;
            ICriterion filtro = Where.gt("saldoActual", saldo);
            IQuery query = new CriteriaQuery(CuentaCorriente.class, filtro);

            StringBuilder resultado = new StringBuilder();

            Object[] cuentasCorrientes = OdbConnection.getOdb().getObjects(query).toArray();
            resultado.append("Cuentas con saldo mayor que " + saldo + ":  (" + cuentasCorrientes.length + "):\n");
            for (Object cuentasCorrienteObj : cuentasCorrientes) {
                resultado.append(" >> " + ((CuentaCorriente) cuentasCorrienteObj).toString() + "\n");
            }
            peticiones.SalidasGui.mensaje(resultado.toString());
        } catch (ODBRuntimeException ex) {
            peticiones.SalidasGui.mensaje("No hay resultados");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void contarClientesNumerosRojos() {
        try {
            ICriterion filtro = Where.lt("saldoActual", 0);
            IQuery query = new CriteriaQuery(CuentaCorriente.class, filtro);
            StringBuilder resultado = new StringBuilder();
            Set<Cliente> listadoClientes = new HashSet<Cliente>();
            Object[] cuentasCorrientes = OdbConnection.getOdb().getObjects(query).toArray();
            OdbConnection.getOdb().close();

            for (Object cuentasCorrienteObj : cuentasCorrientes) {
                listadoClientes.addAll(((CuentaCorriente) cuentasCorrienteObj).getClientes());
            }

            resultado.append("Clientes en nº rojos:  (" + listadoClientes.size() + "):\n");
            for (Cliente cliente : listadoClientes) {
                resultado.append(">>> " + cliente.toString() + "):\n");

            }
            peticiones.SalidasGui.mensaje(resultado.toString());
        } catch (ODBRuntimeException ex) {
            peticiones.SalidasGui.mensaje("No hay resultados");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void verAVGSaldoCuentPlazo() {
        try {
            StringBuilder resultado = new StringBuilder();

            //uso mejor cuenta corriente que tiene mas variedad de saldos, cuenta a plazo tiene saldo 0 y depositos.
            Values valuesCuentas = OdbConnection.getOdb().getValues(new ValuesCriteriaQuery(CuentaCorriente.class).sum("saldoActual"));
            Values valuesClientes = OdbConnection.getOdb().getValues(new ValuesCriteriaQuery(Cliente.class).count("dni"));

            float saldoTotal = Float.parseFloat(valuesCuentas.getFirst().getByAlias("saldoActual").toString());
            int nClientes = Integer.parseInt(valuesClientes.getFirst().getByAlias("dni").toString());
            float media = saldoTotal / (float) nClientes;

            resultado.append("Saldos Totales: " + saldoTotal);
            resultado.append("\n Numero de clientes: " + nClientes);
            resultado.append("\n\n  -- Saldo Medio: " + media + " -- ");

            peticiones.SalidasGui.mensaje(resultado.toString());
            OdbConnection.getOdb().close();

        } catch (ODBRuntimeException ex) {
            peticiones.SalidasGui.mensaje("No hay resultados");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void listarMovimientosEntreFechas() {
        try {
            CuentaCorriente cuentacorriente = obtenerCuentaCorriente(10001);
            OdbConnection.getOdb().close();
            Date fechaInicio = dateFormat.parse("01/01/2021");
            Date fechaFin = dateFormat.parse("01/12/2021");
            Set<Movimiento> listaMovimientos = new HashSet<Movimiento>();
            StringBuilder resultado = new StringBuilder();
            Date f;
            resultado.append("Movimientos entre " + dateFormat.format(fechaInicio)+ " y " + dateFormat.format(fechaFin));
            if (cuentacorriente != null) {
                for (Movimiento movimiento : cuentacorriente.getMovimientos()) {
                    f = movimiento.getFecha();
                    if ((f.before(fechaFin) && f.after(fechaInicio)) || f.equals(fechaFin) || f.equals(fechaInicio)) {
//                        listaMovimientos.add(movimiento);
                        resultado.append("\n" + movimiento.toString());
                    }
                }

                peticiones.SalidasGui.mensaje(resultado.toString());
            } else {
                peticiones.SalidasGui.mensaje("La cuenta no existe.");
            }
        } catch (ParseException ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }

    }

    private Cuenta obtenerCuenta(int numero) {
        Cuenta cuentaBD = null;
        try {
            ICriterion filtro = Where.equal("numero", numero);
            IQuery query = new CriteriaQuery(Cuenta.class, filtro).setPolymorphic(true);
            cuentaBD = (Cuenta) OdbConnection.getOdb().getObjects(query).getFirst();
        } catch (ODBRuntimeException ex) {
            //no hay resultados.        
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        return cuentaBD;
    }

    private CuentaCorriente obtenerCuentaCorriente(int numero) {
        CuentaCorriente cuentaCorriente = null;
        Cuenta cuenta = obtenerCuenta(numero);
        if (cuenta != null && cuenta instanceof CuentaCorriente) {
            cuentaCorriente = (CuentaCorriente) cuenta;
        }
        return cuentaCorriente;
    }

    private CuentaPlazo obtenerCuentaPlazo(int numero) {
        CuentaPlazo cuentaPlazo = null;
        Cuenta cuenta = obtenerCuenta(numero);
        if (cuenta != null && cuenta instanceof CuentaPlazo) {
            cuentaPlazo = (CuentaPlazo) cuenta;
        }
        return cuentaPlazo;
    }

}
