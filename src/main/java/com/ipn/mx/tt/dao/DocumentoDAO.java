/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.dao;

import com.ipn.mx.tt.util.ConexionJavaMongo;

/**
 *
 * @author Axel Reyes
 */
public class DocumentoDAO {

    ConexionJavaMongo cjm;
    String base, coleccion;
    public DocumentoDAO(String base, String coleccion) {
        this.base = base;
        this.coleccion = coleccion;
        cjm = new ConexionJavaMongo(base, coleccion);
    }
    public void conectar()
    {
        cjm.conectar();
    }
    
}
