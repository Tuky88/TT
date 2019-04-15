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
public class Instrumento {
    
    private Trastorno[] trastornos;
    
    public Instrumento()
    {
        trastornos=new Trastorno[10];
        for (int i = 0; i < 8; i++) {
            trastornos[i]=new Trastorno();
        }
    }
   public void sumarPuntaje(int trastorno,int puntaje)
   {
       trastornos[trastorno].sumar(puntaje);
   }
   public int getTrastorno(int trastorno)
   {
       return trastornos[trastorno].getPuntaje();
   }

    void restarPuntaje(int trastorno, int puntaje) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        trastornos[trastorno].restar(puntaje);
    }
    
}
