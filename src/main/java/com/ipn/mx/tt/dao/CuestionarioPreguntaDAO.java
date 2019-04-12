/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.dao;

import com.ipn.mx.tt.modelo.Usuario;
import com.ipn.mx.tt.util.ConexionJavaMongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 *
 * @author Axel Reyes
 */
public class CuestionarioPreguntaDAO {

    ConexionJavaMongo cjm;
    String base, coleccion;

    public CuestionarioPreguntaDAO(String base, String coleccion) {
        this.base = base;
        this.coleccion = coleccion;
        cjm = new ConexionJavaMongo(base, coleccion);
    }

    public CuestionarioPreguntaDAO() {
        this.base = "TT";
        this.coleccion = "CuestionarioXPregunta";
        cjm = new ConexionJavaMongo(base, coleccion);

    }

    public void conectar() {
        this.cjm.conectar();
    }

    public int buscarCuestionario(int id) {

        int resp = 0;
        DBObject query = new BasicDBObject("_idPregunta", String.valueOf(id));
        DBCursor cursor = cjm.getMongoCollection().find(query);

        if (cursor.hasNext()) {
            DBObject jo = cursor.one();
            if (jo != null) {
                resp =Integer.valueOf((String) jo.get("_idCuestionario"));
            }

        }
        return resp;
    }
}