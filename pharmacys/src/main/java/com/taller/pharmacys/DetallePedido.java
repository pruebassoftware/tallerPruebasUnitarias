/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taller.pharmacys;


/**
 *
 * @author Stephany
 */
public class DetallePedido {
   private Producto producto;
   private int cantidad;
   private double subtotal;

    public DetallePedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal=0;
    }
    //Funcion que retorna el tipo de dato producto
    public Producto getProducto() {
        return producto;
    }
    //Funcion que retorna la cantidad que solicito de un producto.
    public int getCantidad() {
        return cantidad;
    }
    
    //Funcion que retorna el subtotal de un producto.
    public double subtotalDeProducto(){
        this.subtotal=(this.producto.getPrecio())*(this.getCantidad());
            return this.subtotal;
    }
   
    //Funcion que retorna el detalle del pedido: producto, cantidad que pidi� y el subtotal.
    @Override
    public String toString() {
        return "DetallePedido{" + "p=" + this.getProducto() + ", cantidad=" + this.getCantidad() +", subtotal= "+ this.subtotalDeProducto() + "}";
    }
    
    
      
}
