/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipofutbol_mongo;

import POJO.Futbolista;
import POJO.FutbolistaNew;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estefania
 */
public class ListasFutbolistas {
    
    public static ArrayList<Futbolista> futbolistas = new ArrayList<Futbolista>();
    
    public static List<FutbolistaNew> futbolistasNew = new ArrayList<FutbolistaNew>();
    
    public static void addFutbolistas(){

        ArrayList<String> d1 = new ArrayList<String>();
        d1.add("portero");
        ArrayList<String> d2 = new ArrayList<String>();
        d2.add("delantero");
        ArrayList<String> d3 = new ArrayList<String>();
        d3.add("centro");
        d3.add("delantero");

        Futbolista f1 = new Futbolista("Juan", "López Pérez", 22, d1, false);
        Futbolista f2 = new Futbolista("Pablo", "Fernández García", 27, d2, true);
        Futbolista f3 = new Futbolista("Pedro", "González García", 28, d3, false);

        futbolistas.add(f1);
        futbolistas.add(f2);
        futbolistas.add(f3);
        
    }
    
       public static void addFutbolistasNew(){

        ArrayList<String> d1 = new ArrayList<String>();
        d1.add("portero");
        ArrayList<String> d2 = new ArrayList<String>();
        d2.add("delantero");
        ArrayList<String> d3 = new ArrayList<String>();
        d3.add("centro");
        d3.add("delantero");

        FutbolistaNew f1 = new FutbolistaNew("Juan", "López Pérez", 22, d1, false,1);
        FutbolistaNew f2 = new FutbolistaNew("Pablo", "Fernández García", 27, d2, true,2);
        FutbolistaNew f3 = new FutbolistaNew("Pedro", "González García", 28, d3, false,3);

        futbolistasNew.add(f1);
        futbolistasNew.add(f2);
        futbolistasNew.add(f3);
        
    }
    
}
