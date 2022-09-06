/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CrearBDInfoPredeterminada;

import POO.Autor;
import POO.Libro;
import java.sql.Date;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author Estefania
 */
public class CrearBDInfoPredeterminada {
    
//No es necesario.
//El servidor ya crea una base de datos si esta no está creada, pero puede servir para hacer pruebas.
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Autor autor1 = new Autor("53191630J","AUTOR1","CALLE SINNOMBRE Nº1",32,"ESPAÑOLA");
        Libro libro1 = new Libro(1,"SIN TÍTULO 1","AVENTURAS",21.99f,new Date(2020-1900, 12-1, 13));
        Libro libro3 = new Libro(3,"SIN TÍTULO 3","AVENTURAS",21.99f,new Date(2022-1900, 1-1, 24));
        autor1.getLibros().add(libro1);
        autor1.getLibros().add(libro3);
        
        Autor autor2 = new Autor("98691168P","AUTOR2","CALLE SINNOMBRE Nº2",23,"ITALIANA");
        Libro libro2 = new Libro(2,"SIN TÍTULO 2","AVENTURAS",21.99f,new Date(2010-1900, 5-1, 23));
        autor2.getLibros().add(libro2);
        
        Autor autor3 = new Autor("24060524V","AUTOR3","CALLE SINNOMBRE Nº3",45,"ITALIANA");
        Libro libro4 = new Libro(4,"SIN TÍTULO 4","AVENTURAS",21.99f,new Date(2005-1900, 7-1, 8));
        autor3.getLibros().add(libro4);
        
        Autor autor4 = new Autor("37870278L","AUTOR4","CALLE SINNOMBRE Nº4",58,"ESPAÑOLA");
        Libro libro5 = new Libro(5,"SIN TÍTULO 5","AVENTURAS",21.99f,new Date(2020-1900, 12-1, 13));
        Libro libro6 = new Libro(6,"SIN TÍTULO 6","AVENTURAS",21.99f,new Date(2020-1900, 12-1, 22));
        autor4.getLibros().add(libro5);
        autor4.getLibros().add(libro6);
        
        Autor autor5 = new Autor("34665845S","AUTOR5","CALLE SINNOMBRE Nº5",67,"ESPAÑOLA");
        
        Autor autor6 = new Autor("25540439C","AUTOR6","CALLE SINNOMBRE Nº6",45,"PORTUGUESA");
        
        
        ODB odb = ODBFactory.open("libreria.test");
        odb.store(autor1);
        odb.store(autor2);
        odb.store(autor3);
        odb.store(autor4);
        odb.store(autor5);
        odb.store(autor6);
        odb.commit();
        odb.close();
    }
    
}
