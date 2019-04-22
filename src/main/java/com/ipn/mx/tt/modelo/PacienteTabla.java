/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Axel Reyes
 */
public class PacienteTabla {

    private StringProperty nombre;
    private StringProperty edad;
    private StringProperty CURP;

    public PacienteTabla(String CURP, String nombre, String edad) {
        this.CURP = new SimpleStringProperty(CURP);
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleStringProperty(edad);
    }

    public PacienteTabla(Paciente paciente) {
                this.CURP = new SimpleStringProperty(paciente.getCURP());
        this.nombre = new SimpleStringProperty(paciente.getNombre());
        this.edad = new SimpleStringProperty("19");
    }

    public StringProperty getNombre() {
        return nombre;
    }

    public void setNombre(StringProperty nombre) {
        this.nombre = nombre;
    }

    public StringProperty getEdad() {
        return edad;
    }

    public void setEdad(StringProperty edad) {
        this.edad = edad;
    }

    public StringProperty getCURP() {
        return CURP;
    }

    public void setCURP(StringProperty CURP) {
        this.CURP = CURP;
    }

    
    


}
