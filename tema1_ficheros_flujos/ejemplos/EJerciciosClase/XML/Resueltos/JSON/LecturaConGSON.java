/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mrnov
 */
public class LecturaConGSON {
     public static void main (String args []) throws IOException{
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("ejemplo.json"));

            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }

            br.close();

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(this.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(LecturaSinGSON.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        //Ahora vamos a usar GSON. Creamos un objeto GSON:
        Gson gson = new Gson();
        //Para parsear un objeto con GSON:

        Persona p = gson.fromJson(json, Persona.class);
        //Mostramos el objeto:

        System.out.println(p);
    }
}
