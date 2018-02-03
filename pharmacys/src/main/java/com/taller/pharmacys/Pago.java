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
public class Pago {
    

    Boolean tipo ; // tipo = True(efectivo) tipo=false(tarjeta de credito)
    TarjetaCredito tarjeta;
    
    public Pago(){}
    
    public void crearPago(Boolean tipo){
        this.tipo = tipo;
    }
    
    public void asociarTarjeta(TarjetaCredito tarjeta){
        this.tarjeta=tarjeta;
    }

//Funcion que ingresa un tipo de dato Pago y retorna un String que indica el tipo de pago del cliente.
    public String validarPago(){
        if (this.getTipo().equals(true)){
            return "Pago en efectivo";
        }
        else if (this.getTipo().equals(false)) {
               TarjetaCredito t = this.tarjeta;
               if (t.validarTarjeta()!=1){
                   return "Tarjeta invalida"; 
                }
               else{
                   return "Tarjeta valida"; 
               }
               
        }
        
        return "Tipo de pago incorrecto"; 
    }

    //Funcion que retorna el si el pago fue en efectivo(true) o tarjeta(false).
    public Boolean getTipo() {
        return tipo;
    }

    
    
}
