/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad.ejneodatiscuentas;

import menu.Menu;
import utilidades.Log;

/**
 *
 * @author a20armandocb
 */
public class App {

    
    /**
     * @param args the command line arguments
     */
    static private Log log = Log.getInstance();

    public static void main(String[] args) {
        boolean continuar = true;
        Menu menu = construirMenuPrincipal();
        
        do {
            try {
                continuar = menuAcciones(menu);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (continuar);
        System.exit(0);
    }

    private static Menu construirMenuPrincipal() {
        Menu menu = new Menu();
        AccionesApp app = new AccionesApp();


        
        menu.setTituloMenu("Menu Neodatis Librería");
        menu.setTextoSalir("Salir");
        log.addToLog("Iniciado el programa");

        menu.addLabel("Servidor");
        menu.addOpcion("Iniciar/Parar Sevidor", () -> {
            app.runStopServer();
        });
        menu.addLabel("Altas");
        menu.addOpcion("Cuenta Corriente", () -> {
            app.altaCuentaCorriente();
        });
        menu.addOpcion("Cuenta a Plazo", () -> {
            app.altaCuentaPlazo();
        });
        menu.addOpcion("Movimiento", () -> {
            app.altaMovimiento();
        });
                
        menu.addLabel("Modificaciones");
        menu.addOpcion("Interes Cuenta Plazo", () -> {
            app.modInteresCuentaPlazo();
        });
        
        menu.addLabel("Borrar");
        menu.addOpcion("Borrar Cuenta Plazo", () -> {
            app.delCuentaPlazo();
        });
        
        menu.addLabel("Consultas");
        menu.addOpcion("Listado Clientes 'C*'", () -> {
            app.listarClientesC();
        });
        menu.addOpcion("Listado Clientes saldo > 200k", () -> {
            app.listarClientesSaldoMayor();
        });        
        menu.addOpcion("Cantidad clientes numeros rojos", () -> {
            app.contarClientesNumerosRojos();
        });       
        menu.addOpcion("Saldo medio cuentas Plazo", () -> {
            app.verAVGSaldoCuentPlazo();
        });        
        
        menu.addOpcion("Listado movimientros entre fechas", () -> {
            app.listarMovimientosEntreFechas();
        });        
        
        
        /* Log de libreriaAr 1.4 */
        menu.addLabel("LOG");
        menu.addOpcion("Ver Log", () -> {
            peticiones.SalidasGui.bloqueTexto("Log", utilidades.Log.getInstance().getLog());
        });
        menu.addOpcion("Borrar Log", () -> {
            utilidades.Log.getInstance().borrarLog();
        });
        

        return menu;
    }

    private static boolean menuAcciones(Menu menu) throws Exception {
        boolean continuar = true;
        menu.mostrarGUI();
        //menu.mostrar();
        switch (menu.getSeleccion()) {
            case 0:
                //salir
                continuar = false;
                log.addToLog("finalizado el programa");
                System.out.println("Bye Bye!");
                break;

        }
        return continuar;
    }

}
