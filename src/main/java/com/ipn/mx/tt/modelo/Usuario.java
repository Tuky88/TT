/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

/**
 *
 * @author User
 */
public class Usuario {
    String Id;
    String Contraseña;

    public Usuario(String Id, String Contraseña) {
        this.Id = Id;
        this.Contraseña = Contraseña;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
}
