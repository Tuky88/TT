/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Axel Reyes
 */
public class PrediagnosticoTabla {

    private StringProperty Nombre;
    private StringProperty Edad;
    private StringProperty Fecha;
    private StringProperty NumeroCuestionario;

    public PrediagnosticoTabla(String Nombre, String Edad, String Fecha, String NumeroCuestionario) {
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Edad = new SimpleStringProperty(Edad);
        this.Fecha = new SimpleStringProperty(Fecha);
        this.NumeroCuestionario = new SimpleStringProperty(NumeroCuestionario);
    }

    public StringProperty getNombre() {
        return Nombre;
    }

    public void setNombre(StringProperty Nombre) {
        this.Nombre = Nombre;
    }

    public StringProperty getEdad() {
        return Edad;
    }

    public void setEdad(StringProperty Edad) {
        this.Edad = Edad;
    }

    public StringProperty getFecha() {
        return Fecha;
    }

    public void setFecha(StringProperty Fecha) {
        this.Fecha = Fecha;
    }

    public StringProperty getNumeroCuestionario() {
        return NumeroCuestionario;
    }

    public void setNumeroCuestionario(StringProperty NumeroCuestionario) {
        this.NumeroCuestionario = NumeroCuestionario;
    }

}
