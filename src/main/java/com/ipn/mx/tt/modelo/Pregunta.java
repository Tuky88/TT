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
    String Id;
    String Texto;

    public Pregunta(String Id, String Texto) {
        this.Id = Id;
        this.Texto = Texto;
    }

    public Pregunta() {
    Texto="";
    Id="";
    }
    
    public Pregunta(DBObject dbo)
    {
        Id=(String)dbo.get("_idPregunta");
        Texto=(String)dbo.get("texto");
    }
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }
}
