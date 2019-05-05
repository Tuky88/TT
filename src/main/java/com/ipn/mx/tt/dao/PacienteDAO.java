/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.dao;

import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.util.ConexionJavaMongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.List;

/**
 *
 * @author Axel Reyes
 */
public class PacienteDAO {

    ConexionJavaMongo cjm;
    String base, coleccion;

    public PacienteDAO(String base, String coleccion) {
        this.base = base;
        this.coleccion = coleccion;
        cjm = new ConexionJavaMongo(base, coleccion);

    }

    public PacienteDAO() {
        this.base = "TT";
        this.coleccion = "Paciente";
        cjm = new ConexionJavaMongo(base, coleccion);

    }

    public DBObject convertirPaciente(Paciente p) {

        return new BasicDBObject("Direccion", p.getDireccion())
                .append("Fecha", p.getFecha())
                .append("Nombre", p.getNombre())
                .append("Apellido", p.getApellido())
                .append("Correo", p.getCorreo())
                .append("Sexo", p.getSexo())
                .append("Telefono", p.getTelefono())
                .append("_CURP", p.getCURP());
    }

    public void insertarPaciente(Paciente p) {

        cjm.conectar();
        cjm.getMongoCollection().insert(convertirPaciente(p));
        System.out.println("Registro Agregado con éxito");
        
    }

    public Paciente buscarPaciente(String id) {
        cjm.conectar();
        //db.users.find({name: /a/})
        DBObject query = new BasicDBObject("CURP", id);
        DBCursor cursor = cjm.getMongoCollection().find(query);
        Paciente paciente;
        if (cursor.hasNext()) {
            DBObject jo = cursor.one();
            paciente = new Paciente(jo);
        } else {
            paciente = new Paciente();
        }
        cjm.cerrarConexion();
        return paciente;
    }

    public List buscarSimilar() {
        cjm.conectar();
        DBCursor cursor = cjm.getMongoCollection().find();

        return cursor.toArray();
    }
}
