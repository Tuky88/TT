/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.dao;

import com.ipn.mx.tt.util.ConexionJavaMongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 *
 * @author Axel Reyes
 */
public class TrastornoSintomaDAO {

    ConexionJavaMongo cjm;
    String base, coleccion;

    public TrastornoSintomaDAO(String base, String coleccion) {
        this.base = base;
        this.coleccion = coleccion;
        cjm = new ConexionJavaMongo(base, coleccion);
    }

    public TrastornoSintomaDAO() {
        this.base = "TT";
        this.coleccion = "TrastornoXSintoma";
        cjm = new ConexionJavaMongo(base, coleccion);

    }

    public void conectar() {
        this.cjm.conectar();
    }

    public int buscarTrastorno(int id) {

        double resp = 0;
        DBObject query = new BasicDBObject("_idSintoma", Double.valueOf(id));
        DBCursor cursor = cjm.getMongoCollection().find(query);
        System.out.println("TRASTORNOS ENCONTRADOS:" +cursor.size());
        if (cursor.hasNext()) {
            
            DBObject jo = cursor.one();
            if (jo != null) {
                resp = (Double) jo.get("_idTrastorno");
            } else {
                System.out.println("NO SE ENCONTRÓ EL TRASTORNO");
            }

        }
        return (int) resp;
    }
}
