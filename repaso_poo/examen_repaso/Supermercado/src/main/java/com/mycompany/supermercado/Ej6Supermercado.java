/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.supermercado;

import java.io.File;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author a20estefaniapc
 */
public class Ej6Supermercado extends javax.swing.JFrame{
    
    private DefaultTableModel modeloTabla;
    private File fichero;
    
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonCerrar;
    private javax.swing.JButton buttonLeer;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JCheckBox checkDisponible;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelMensajes;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelMensaje;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textNombre;
    
    public Ej6Supermercado(){
        initComponents();
        fichero = new File("productos.txt");
        textCodigo.setEnabled(false);
        textNombre.setEnabled(false);
        
        
    }
    
    private void initComponents(){
    
    }
      
}
