/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutociclos_estefaniapenide;

import cadenas.Cadenas;
import controldata.ControlData;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author a20estefaniapc
 */
public class InstitutoCiclos_EstefaniaPenide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        
        byte op=0;
        do{
            Cadenas.menuPrincipal();
            op=ControlData.leerByte(input);
            
            switch(op){
                case 1:
                    Altas.alta(input, sessionFactory);
                    break;
                case 2:
                    Bajas.ciclo(input, sessionFactory);
                    break;
                case 3:
                    Modificaciones.telefonoInstituto(input, sessionFactory);
                    break;
                case 4:
                    Listados.listado(input, sessionFactory);
                    break;
                case 5:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.defaultMensajeMenu();
                    break;                           
            }
        
        }while(op!=5);
    }
    
}
