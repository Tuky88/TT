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
public class TrastornoTabla {
    private StringProperty Trastorno;
    private StringProperty Hsdq;
    private StringProperty HsdqM;
    private StringProperty s50;
    private StringProperty s50M;

    public String getTrastorno() {
        return Trastorno.getValue();
    }

    public void setTrastorno(String Trastorno) {
        this.Trastorno = new SimpleStringProperty(Trastorno);
    }

    public String getHsdq() {
        return Hsdq.getValue();
    }

    public void setHsdq(String Hsdq) {
        this.Hsdq = new SimpleStringProperty(Hsdq);
    }

    public String getHsdqM() {
        return HsdqM.getValue();
    }

    public void setHsdqM(String HsdqM) {
        this.HsdqM = new SimpleStringProperty(HsdqM);
    }

    public String getS50() {
        return s50.getValue();
    }

    public void setS50(String s50) {
        this.s50 = new SimpleStringProperty(s50);
    }

    public String getS50M() {
        return s50M.getValue();
    }

    public void setS50M(String s50M) {
        this.s50M = new SimpleStringProperty(s50M);
    }
    
}
