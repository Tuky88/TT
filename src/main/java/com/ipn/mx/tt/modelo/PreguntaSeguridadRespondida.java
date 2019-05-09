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
public class PreguntaSeguridadRespondida {

    private String user;
    private String pregunta;
    private String respuesta;

    public PreguntaSeguridadRespondida(String user, String pregunta, String respuesta) {
        this.user = user;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public PreguntaSeguridadRespondida(DBObject dbo) {
        user = (String) dbo.get("User");
        pregunta = (String) dbo.get("Pregunta");
        respuesta = (String) dbo.get("Respuesta");
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
