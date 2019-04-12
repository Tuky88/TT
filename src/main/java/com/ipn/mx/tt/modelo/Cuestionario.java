/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

/**
 *
 * @author Axel Reyes
 */
public class Cuestionario {
    private int numCuestionario=0;
    private Instrumento s50,hsdr;
    
    public Cuestionario()
    {
        s50=new Instrumento();
        hsdr=new Instrumento();
    }
    public void calificarPregunta(int instrumento,int trastorno,int puntaje)
    {
        if(instrumento==1)
        {
            s50.sumarPuntaje(trastorno, puntaje);
        }
        else
        {
            hsdr.sumarPuntaje(trastorno, puntaje);
        }
        
    }
    public int getTrastorno(int instrumento,int trastorno)
    {
        if(instrumento==1)
        {
            return s50.getTrastorno(trastorno);
        }
        else
            return hsdr.getTrastorno(trastorno);
    }

    @Override
    public String toString() {
        return "Cuestionario{" + "numCuestionario=" + numCuestionario + ", s50=" + s50 + ", hsdr=" + hsdr + '}';
    }
 
    
}
