/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.ArrayList;
// import java.util.*;

/**
 *
 * @author mrnovoa
 */
public class spa {
    private String CIF;
    private ArrayList<Socios> socios;
    private ArrayList<Actividades> actividades;

    
    public spa(String CIF) {
        this.CIF = CIF;
    }
   
    
    public spa(){
    
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }
    
    
    
    
}
