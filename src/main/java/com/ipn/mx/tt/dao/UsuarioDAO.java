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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        return new BasicDBObject("_id", u.getId()).append("contraseña", u.getContraseña());

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
        if(cursor.length()>0)
        {
            DBObject jo = cursor.one();
            user=new Usuario(jo);
        }
        else
        {
            user=new Usuario();
        }
        cjm.cerrarConexion();
        return user;
    }
}
