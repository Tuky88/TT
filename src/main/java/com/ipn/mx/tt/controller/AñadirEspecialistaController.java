/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.UsuarioDAO;
import com.ipn.mx.tt.modelo.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class AñadirEspecialistaController implements Initializable {

    @FXML
    private JFXButton btnCacguardar;

    @FXML
    private JFXTextField txtCanombre;

    @FXML
    private JFXTextField txtCaapellido;

    @FXML
    private JFXPasswordField txtCapass;

    @FXML
    private JFXPasswordField txtCarpass;

    @FXML
    private JFXTextField txtCausuario;

    @FXML
    private JFXTextField txtCacorreo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void cargarUsuario(ActionEvent event) {
        Usuario u;
        String c1 = txtCapass.getText(), cc = txtCarpass.getText();
        if (c1.equals(cc)) {
            String nombre = txtCanombre.getText();
            String apellido = txtCaapellido.getText();
            String usuario = txtCausuario.getText();
            String correo = txtCacorreo.getText();
            if (nombre.length() > 3 && apellido.length() > 3 && usuario.length() > 3 && correo.length() > 3) {
                u = new Usuario(usuario, cc, nombre, apellido, correo);
                UsuarioDAO ud = new UsuarioDAO();
                ud.insertarUsuario(u);
                Alert a = new Alert(Alert.AlertType.NONE, "CARGADO CON EXITO", ButtonType.OK);
                a.show();
            } else {
                Alert a = new Alert(Alert.AlertType.NONE, "LOS CAMPOS NO PUEDEN ESTAR VACÍOS", ButtonType.OK);
                a.show();

            }
        } else {
            Alert a = new Alert(Alert.AlertType.NONE, "LAS CONTRASEÑAS NO COINCIDEN", ButtonType.OK);
            a.show();
        }

    }
}
