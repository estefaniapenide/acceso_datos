/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Estefania
 */
public class Producto {

    private String codigo;
    private int stockActualAlmacen;
    private final int STOCK_MINIMO = 30;
    private float precioUnitario;

    public Producto() {

    }

    public Producto(String codigo, int stockAlmacen, float precioUnitario) {
        this.codigo = codigo;
        this.stockActualAlmacen = stockAlmacen;
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the stockActualAlmacen
     */
    public int getStockActualAlmacen() {
        return stockActualAlmacen;
    }

    /**
     * @param stockActualAlmacen the stockActualAlmacen to set
     */
    public void setStockActualAlmacen(int stockActualAlmacen) {
        this.stockActualAlmacen = stockActualAlmacen;
    }

    /**
     * @return the STOCK_MINIMO
     */
    public int getSTOCK_MINIMO() {
        return STOCK_MINIMO;
    }

    /**
     * @return the precioUnitario
     */
    public float getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
