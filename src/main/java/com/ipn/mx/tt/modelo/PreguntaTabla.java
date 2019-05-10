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
public class PreguntaTabla {

    private StringProperty pregunta;
    private StringProperty respuesta;

    public PreguntaTabla(String pregunta,String respuesta)
    {
        this.pregunta=new SimpleStringProperty(pregunta);
        this.respuesta=new SimpleStringProperty(respuesta);
    }

    public String getPregunta() {
        return pregunta.getValue();
    }

    public void setPregunta(String pregunta) {
        this.pregunta = new SimpleStringProperty(pregunta);
    }

    public String getRespuesta() {
        return respuesta.getValue();
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = new SimpleStringProperty(respuesta);
    }
    
}
