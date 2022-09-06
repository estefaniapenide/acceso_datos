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

/**
 *
 * @author a20estefaniapc
 */
public class Listados {
    
    public static void listado(Scanner input, SessionFactory sessionFactory){
        
        byte op=0;
        do{
            Cadenas.menuListados();
            op=ControlData.leerByte(input);
            switch(op){
                case 1:
                    ciclosTaller(input,sessionFactory);
                    break;
                case 2:
                    institutoCiclos(input,sessionFactory);
                    break;
                case 3:
                    cicloInstitutos(input,sessionFactory);
                    break;
                case 0:
                    Cadenas.vueltaMenu();
                    break;
                default:
                    Cadenas.defaultMensajeMenu();
                    break;
            
            }
        
        }while(op!=0);
    
    }
    
    public static void ciclosTaller(Scanner input, SessionFactory sessionFactory){
    }
    
     public static void institutoCiclos(Scanner input, SessionFactory sessionFactory){
    }
    
    public static void cicloInstitutos(Scanner input, SessionFactory sessionFactory){
    }
    
   
    
}
