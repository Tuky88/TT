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
public class Cutoff {

    private Double idCuestionario;
    private Double idTrastorno;
    private Double suma;
    private Double preguntas;
    private Double promedio;
    
    private Cutoff(DBObject dbo)
    {
        this.idCuestionario = (Double) dbo.get("_idCuestionario");
        this.idTrastorno = (Double) dbo.get("_idCuestionario");
        this.suma = (Double) dbo.get("_idCuestionario");
        this.preguntas = (Double) dbo.get("_idCuestionario");
        this.promedio = (Double) dbo.get("_idCuestionario");
    }

    public Double getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Double idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Double getIdTrastorno() {
        return idTrastorno;
    }

    public void setIdTrastorno(Double idTrastorno) {
        this.idTrastorno = idTrastorno;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    public Double getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Double preguntas) {
        this.preguntas = preguntas;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
    
}
