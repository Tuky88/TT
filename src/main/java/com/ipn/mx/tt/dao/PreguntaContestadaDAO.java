/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.dao;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Axel Reyes
 */
public class PreguntaContestadaDAO extends DocumentoDAO {
    
    public PreguntaContestadaDAO(String base, String coleccion) {
        super(base, coleccion);
    }
    public PreguntaContestadaDAO()
    {
        super("TT","PreguntaContestada");
    }
    public void guardarPreguntasContestadas(List l)
    {
        List ln=new LinkedList();
        l.forEach((objectLista) ->{
            
        });
    }
    
}
