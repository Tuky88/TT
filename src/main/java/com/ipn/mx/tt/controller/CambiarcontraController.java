/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.UsuarioDAO;
import com.ipn.mx.tt.modelo.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class CambiarcontraController implements Initializable {

    Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @FXML
    private AnchorPane panelP;

    @FXML
    private Pane panel;

    @FXML
    private Button btnCcguardar;

    @FXML
    private PasswordField txtCpass;

    @FXML
    private PasswordField txtCnpass;

    @FXML
    private PasswordField txtCrnpass;


    @FXML
    private void CambiarContraseña(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cambiarContraseña();
        } else { 
        }
    }

    @FXML
    void cambiarContraseña(ActionEvent event) {
        cambiarContraseña();
    }

    public void cambiarContraseña() {
        if (txtCnpass.getText().length() > 0 && txtCpass.getText().length() > 0 && txtCrnpass.getText().length() > 0) {
            if (txtCpass.getText().equals(usuario.getContraseña())) {
                UsuarioDAO ud = new UsuarioDAO();
                if (txtCnpass.getText().equals(txtCrnpass.getText())) {
                    if (ud.actualizarContraseña(usuario)) {

                        Alert a = new Alert(Alert.AlertType.NONE, "Se actualizó la contraseña.", ButtonType.OK);
                        a.show();
                    } else {

                        Alert a = new Alert(Alert.AlertType.NONE, "No se pudo actualizar la contraseña..", ButtonType.OK);
                        a.show();
                    }
                } else {

                    Alert a = new Alert(Alert.AlertType.NONE, "Las contraseña no coinciden.", ButtonType.OK);
                    a.show();
                }
            } else {

                Alert a = new Alert(Alert.AlertType.NONE, "Hay un error en tu contraseña.", ButtonType.OK);
                a.show();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.NONE, "Los campos no pueden estar vacíos.", ButtonType.OK);
            a.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
