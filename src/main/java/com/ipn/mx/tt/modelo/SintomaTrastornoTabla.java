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
public class SintomaTrastornoTabla {

    private StringProperty Trastorno;
    private StringProperty Sintoma;

    public SintomaTrastornoTabla(String Trastorno, String Sintoma) {
        this.Trastorno =new  SimpleStringProperty(Trastorno);
        this.Sintoma = new SimpleStringProperty(Sintoma);
    }

    public String getTrastorno() {
        return Trastorno.getValue();
    }

    public void setTrastorno(String Trastorno) {
        this.Trastorno = new  SimpleStringProperty(Trastorno);
    }

    public String getSintoma() {
        return Sintoma.getValue();
    }

    public void setSintoma(String Sintoma) {
        this.Sintoma = new SimpleStringProperty(Sintoma);
    }
    
    

}
