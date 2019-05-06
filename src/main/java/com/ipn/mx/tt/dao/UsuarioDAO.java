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
 * @author User
 */
public class UsuarioDAO {

    ConexionJavaMongo cjm;
    String base, coleccion;

    public UsuarioDAO(String base, String coleccion) {
        this.base = base;
        this.coleccion = coleccion;
        cjm = new ConexionJavaMongo(base, coleccion);

    }

    public UsuarioDAO() {
        this.base = "TT";
        this.coleccion = "User";
        cjm = new ConexionJavaMongo(base, coleccion);

    }

    public DBObject convertirUser(Usuario u) {

        return new BasicDBObject("_id", u.getId()).append("contraseña", u.getContraseña())
                .append("Nombre", u.getNombre()).append("Apellido", u.getApellido())
                .append("Correo", u.getCorreo())
                .append("numEmpleado", u.getNumEmpleado());

    }

    public void insertarUsuario(Usuario u) {

        cjm.conectar();
        cjm.getMongoCollection().insert(convertirUser(u));
        System.out.println("Registro Agregado con éxito");
        cjm.cerrarConexion();
    }

    public Usuario buscarUsuario(String id) {
        cjm.conectar();
        DBObject query = new BasicDBObject("_id", id);
        DBCursor cursor = cjm.getMongoCollection().find(query);
        Usuario user;
        if (cursor.hasNext()) {
            DBObject jo = cursor.one();
            user = new Usuario(jo);
        } else {
            user = new Usuario();
        }
        cjm.cerrarConexion();
        return user;
    }

    public boolean usuarioExiste(String usuario) {
        DBObject query = new BasicDBObject("_id", usuario);
        DBCursor cursor = cjm.getMongoCollection().find(query);
        return cursor.hasNext();
    }

    public boolean actualizarDatos(Usuario text) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cjm.conectar();
        if (usuarioExiste(text.getId())) {
            DBObject query = new BasicDBObject("_id", text.getId());
            cjm.getMongoCollection().update(query, new BasicDBObject("$"
                    + "set",
                    new BasicDBObject("Nombre", text.getNombre())
                            .append("Apellido", text.getApellido())
                            .append("Correo", text.getCorreo())
            ));
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarContraseña(Usuario text) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cjm.conectar();
        if (usuarioExiste(text.getId())) {
            DBObject query = new BasicDBObject("_id", text.getId());
            cjm.getMongoCollection().update(query, new BasicDBObject("$set",
                    new BasicDBObject("contraseña", text.getContraseña())
            ));
            return true;
        } else {
            return false;
        }
    }
}
