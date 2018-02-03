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
public class Cliente {
    private String nombres;
    private int sector;

    public Cliente(String Nombres, int sector) {
        this.nombres = Nombres;
        this.sector = sector;
    }

    public int getSector() {
        return sector;
    }
    
    //Funcion que retorna el nombre del cliente.
    public String getNombres() {
        return nombres;
    }
    //Funcion que retorna el sector donde vive el cliente.
    public String getNombreSector(){
         switch (this.sector) {
             case 1:
                 return "Norte";
             case 2:
                 return "Centro";
             case 3:
                 return "Sur";
             default:
                 break;
         }
         return null;
    }
    //Funcion que retorna la informacion del cliente.
    public String getInformacionCliente(){
        return "Usted ingreso la siguiente informacion" + "\nNombre:" + nombres + "\nSector=" + sector;
    }
    
    
//    //Funcion que retorna que la informacion ingresada fue incorrecta.
//    @Override
//    public String toString() {
//        return "Informacion correcta";
//    }
    
}
