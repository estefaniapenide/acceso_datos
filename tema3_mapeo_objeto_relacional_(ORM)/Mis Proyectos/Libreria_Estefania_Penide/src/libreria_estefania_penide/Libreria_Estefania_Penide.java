/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria_estefania_penide;

import POO.Autor;
import POO.Libro;
import POO.Telefono;
import cadenas.Cadenas;
import controldata.ControlData;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author a20estefaniapc
 */
public class Libreria_Estefania_Penide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();

        byte op = 0;
        do {
            Cadenas.menuPrincipal();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    Insercion.inserciones(input, sessionFactory);
                    break;
                case 2:
                    Borrado.borrados(input, sessionFactory);
                    break;
                case 3:
                    Consultas.datos(input, sessionFactory);
                    break;
                case 0:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.defaultMensajeMenu();
                    break;
            }
        } while (op != 0);

        sessionFactory.close();
        input.close();

    }

}
