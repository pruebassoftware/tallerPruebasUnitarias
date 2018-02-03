/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taller.pharmacys;

/**
 *
 * @author kattya
 */
public class TarjetaCredito {
       
    private static String REGEX_DINERS = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$";  //30569309025904
    private static String REGEX_MASTERCARD = "5[1-5][0-9]{14}$";  //5105105105105100
    //Fuente regex http://w3.unpocodetodo.info/utiles/regex-ejemplos.php?type=cc
    
    private int tipo; //1 diners 2 mastercard 
    private String numero;
    private String cvv;
    
    public TarjetaCredito(){}
    
    public TarjetaCredito(int tipo, String numero, String cvv) {
        this.tipo = tipo;
        this.numero = numero;
        this.cvv = cvv;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    
    public int validarTarjeta(){
        
        switch (tipo) {
             case 1:
                if (this.numero.matches(REGEX_DINERS)){
                    return 1;
                }
             case 2:
                 if (this.numero.matches(REGEX_MASTERCARD)){
                    return 1;
                }
             default:
                 break;
         }
        
        return 0;
    }
}
