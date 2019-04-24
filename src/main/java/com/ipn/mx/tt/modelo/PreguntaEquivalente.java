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
public class PreguntaEquivalente {
    int idPregunta,idPreguntaEquivalente;

    public PreguntaEquivalente(int idPregunta, int idPreguntaEquivalente) {
        this.idPregunta = idPregunta;
        this.idPreguntaEquivalente = idPreguntaEquivalente;
    }
    public PreguntaEquivalente(DBObject dbo) {
        this.idPregunta = (int) dbo.get("_idPregunta");
        this.idPreguntaEquivalente = (int) dbo.get("_idEquivalente");
    }
    
    
    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdPreguntaEquivalente() {
        return idPreguntaEquivalente;
    }

    public void setIdPreguntaEquivalente(int idPreguntaEquivalente) {
        this.idPreguntaEquivalente = idPreguntaEquivalente;
    }
    
}
