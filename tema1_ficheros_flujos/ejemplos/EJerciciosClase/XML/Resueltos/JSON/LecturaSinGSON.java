/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import com.sun.istack.logging.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger.Level;

/**
 *
 * @author mrnov
 */
public class LecturaSinGSON {
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

        System.out.println(json);
    }
}
