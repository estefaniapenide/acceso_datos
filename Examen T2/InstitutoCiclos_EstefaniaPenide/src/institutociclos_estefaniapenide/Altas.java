/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutociclos_estefaniapenide;

import cadenas.Cadenas;
import org.hibernate.SessionFactory;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Altas {

    public static void alta(Scanner input, SessionFactory sessionFactory) {
        byte op = 0;
        do {
            Cadenas.menuAltas();
            switch(op){
                case 1:
                    instituto(input,sessionFactory);
                    break;
                case 2:
                    ciclo(input,sessionFactory);
                    break;
                case 3:
                    taller(input,sessionFactory);
                    break;
                case 4:
                    relacionarObjeto(input,sessionFactory);
                    break;
                case 5:
                    uso(input,sessionFactory);
                    break;
                case 0:
                    Cadenas.vueltaMenu();
                    break;
                default:
                    Cadenas.defaultMensajeMenu();
                    break;
            }
        } while (op != 0);

    }
    
    public static void instituto(Scanner input, SessionFactory sessionFactory){
        

    
    }
    
    public static void ciclo(Scanner input, SessionFactory sessionFactory){
    
    }
    
    public static void taller(Scanner input, SessionFactory sessionFactory){
    
    }
    
    public static void relacionarObjeto(Scanner input, SessionFactory sessionFactory){
    
    }
    
    public static void uso(Scanner input, SessionFactory sessionFactory){
    
    }

}
