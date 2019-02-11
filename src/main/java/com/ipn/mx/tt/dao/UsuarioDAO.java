/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.dao;

import com.ipn.mx.tt.modelo.Usuario;
import com.ipn.mx.tt.util.ConexionJavaMongo;
import com.mongodb.BasicDBObject;
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
    String base,coleccion;
    public UsuarioDAO(String base,String coleccion) {
        this.base=base;
        this.coleccion=coleccion;
        cjm = new ConexionJavaMongo(base,coleccion);
        
    }
    public UsuarioDAO() {
        this.base="TT";
        this.coleccion="User";
        cjm = new ConexionJavaMongo(base,coleccion);
        
    }
    public void insertarUsuario(Usuario u) {
        try {
            cjm.conectarDB();
            cjm.obtenerBase(base);
            cjm.obtenerColeccion(coleccion);
            DBObject usuario = new BasicDBObject("_id", u.getId())
                    .append(("contraseña"), u.getContraseña())
                    .append("edad",25);
            cjm.getMongoCollection().insert(usuario);
            System.out.println("Registro Agregado con éxito");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
