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
public class Pregunta {

    int Id;
    String Texto;

    public Pregunta(int Id, String Texto) {
        this.Id = Id;
        this.Texto = Texto;
    }
        public Pregunta(Double Id, String Texto) {
        this.Id = Id.intValue();
        this.Texto = Texto;
    }

    public Pregunta() {
        Texto = "";
        Id = 0;
    }

    public Pregunta(DBObject dbo, int tipo) {
        Double x= (Double) dbo.get("_idPregunta");
        Id = x.intValue();
        if (tipo == 1) {
            Texto = (String) dbo.get("texto");
        } else {

            Texto = (String) dbo.get("texto_2");
        }
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }
}
