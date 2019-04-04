/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

import com.mongodb.DBObject;

/**
 *
 * @author Axel Reyes
 */
public class Paciente {

    String Nombre;
    String Apellido;
    String Sexo;
    String Correo;
    String Fecha;
    String Direccion;
    String Telefono;
    String CURP;

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public Paciente() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Paciente{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo + ", Correo=" + Correo + ", Fecha=" + Fecha + ", Direccion=" + Direccion + ", Telefono=" + Telefono + '}';
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

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Paciente(String Nombre, String Apellido, String Sexo, String Correo, String Fecha, String Direccion, String Telefono, String CURP) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Sexo = Sexo;
        this.Correo = Correo;
        this.Fecha = Fecha;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.CURP = CURP;
    }

    public Paciente(DBObject dbo) {
        this.Nombre = (String) dbo.get("Nombre");
        this.Apellido = (String) dbo.get("Apellido");
        this.Sexo = (String) dbo.get("Sexo");
        this.Correo = (String) dbo.get("Correo");
        this.Fecha = (String) dbo.get("Fecha");
        this.Direccion = (String) dbo.get("Direccion");
        this.Telefono = (String) dbo.get("Telefono");
        this.CURP = (String) dbo.get("CURP");
    }

}
