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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class CuentaEspecialistaController implements Initializable {

    @FXML
    private JFXButton btnCguardar;
    @FXML
    private AnchorPane panelP;

    @FXML
    private JFXButton btnCambiarcontra;

    @FXML
    private JFXTextField txtCnombre;

    @FXML
    private JFXTextField txtCcorreo;

    @FXML
    private JFXTextField txtCusuario;
    @FXML
    private Pane panel;
    @FXML
    private JFXTextField txtCapellido;
       @FXML
    private JFXTextField txtCnoempleado;
    Usuario u;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    void cambiarContraseña(ActionEvent event) {

        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource("/Center/Cambiarcontra.fxml"));
            AnchorPane ap = fx.load();
            CambiarcontraController cc = (CambiarcontraController) fx.getController();
            cc.setUsuario(u);
            panelP.getChildren().setAll(ap);
        } catch (IOException ex) {
            Logger.getLogger(CuentaEspecialistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void guardarDatos(ActionEvent event) {

        UsuarioDAO ud = new UsuarioDAO();
        Usuario u = new Usuario(txtCusuario.getText(), txtCnombre.getText(),
                txtCapellido.getText(), txtCcorreo.getText());
        if (ud.actualizarDatos(u)) {
            Alert a = new Alert(Alert.AlertType.NONE, "Se realizaron los cambios con exito", ButtonType.OK);
            a.show();
        } else {
            Alert a = new Alert(Alert.AlertType.NONE, "No pudimos actualizar los datos", ButtonType.OK);
            a.show();

        }
    }

    public void colocarDatos(Usuario u) {
        System.out.println(u.toString());
        this.txtCapellido.setText(u.getApellido());
        this.txtCcorreo.setText(u.getCorreo());
        this.txtCnombre.setText(u.getNombre());
        this.txtCusuario.setText(u.getId());
        this.u = u;
    }

}
