/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.dao;

import com.ipn.mx.tt.modelo.InfoCuestionario;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.List;

/**
 *
 * @author Axel Reyes
 */
public class CuestionarioAplicadoDAO extends DocumentoDAO {

    public CuestionarioAplicadoDAO(String base, String coleccion) {
        super(base, coleccion);
    }

    public CuestionarioAplicadoDAO() {
        super("TT", "CuestionarioAplicado");
    }

    public List traerInformacion() {
        return traerTodo();
    }

    public void insertarInfoCuestionario(InfoCuestionario info) {
        cjm.getMongoCollection().insert(convertirInfoCuestionario(info));

    }

    public DBObject convertirInfoCuestionario(InfoCuestionario info) {
        return new BasicDBObject("_idCuestionario", info.getIdCuestionario())
                .append("status", info.getStatus())
                .append("Paciente", info.getPaciente())
                .append("Especialista", info.getEspecialista());
    }

    public Double buscarSiguiente() {
        DBObject dbo = new BasicDBObject("_idCuestionario", -1);
        DBCursor cursor = cjm.getMongoCollection().find().sort(dbo).limit(1);
        if (cursor.hasNext()) {
            return (Double) cursor.one().get("_idCuestionario");
        } else {
            return 0.0;
        }

    }

    public Double status(Double cuestionario) {
        DBObject dbo = new BasicDBObject("_idCuestionario", cuestionario);
        DBCursor cursor = cjm.getMongoCollection().find(dbo);
        if (cursor.hasNext()) {
            return (Double) cursor.one().get("status");
        } else {
            return 0.0;
        }

    }

}
