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
public class SintomaPreguntaDAO {
    
    ConexionJavaMongo cjm;
    String base, coleccion;

    public SintomaPreguntaDAO(String base, String coleccion) {
        this.base = base;
        this.coleccion = coleccion;
        cjm = new ConexionJavaMongo(base, coleccion);
    }

    public SintomaPreguntaDAO() {
        this.base = "TT";
        this.coleccion = "SintomaXPregunta";
        cjm = new ConexionJavaMongo(base, coleccion);

    }

    public void conectar() {
        this.cjm.conectar();
    }

    public int buscarSintoma(int id) {

        double resp = 0;
        DBObject query = new BasicDBObject("_idPregunta", Double.valueOf(id));
        DBCursor cursor = cjm.getMongoCollection().find(query);
        
        System.out.println("SINTOMAS ENCONTRADOS:" +cursor.size());
        if (cursor.hasNext()) {
            DBObject jo = cursor.one();
            if (jo != null) {
                resp = (Double) jo.get("_idSintoma");
            }

        }
        else
        {
            System.out.println("NO SE ENCONTRÓ EL SINTOMA");
        }
        return (int) resp;
    }
}
