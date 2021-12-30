/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author mrnov
 */
public class PruebaSingleton {
    public static void main(String[] args) {
        RootUserSingleton tmp = RootUserSingleton.getInstance();
        tmp.dimeAlgo();
    }
    
}
