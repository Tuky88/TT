/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

import com.mongodb.DBObject;

/**
 *
 * @author User
 */
public class Usuario {

    String Id;
    String Contraseña;
    String Nombre;
    String Apellido;
    String Correo;

    public Usuario(String Id, String Contraseña, String Nombre, String Apellido, String Correo) {
        this.Id = Id;
        this.Contraseña = Contraseña;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Usuario(String Id, String Contraseña) {
        this.Id = Id;
        this.Contraseña = Contraseña;
        this.Apellido="";
        this.Correo="";
        this.Nombre="";
    }

    public Usuario(String Id, String Nombre, String Apellido, String Correo) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
    }
    

    public Usuario() {
        Contraseña = "";
        Id = "";
    }

    public Usuario(DBObject dbo) {
        Id = (String) dbo.get("_id");
        Contraseña = (String) dbo.get("contraseña");
        Apellido= (String )dbo.get("Apellido");
        Nombre=(String) dbo.get("Nombre");
        Correo=(String) dbo.get("Correo");
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

    @Override
    public String toString() {
        return "Usuario{" + "Id=" + Id + ", Contrase\u00f1a=" + Contraseña + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Correo=" + Correo + '}';
    }

}
