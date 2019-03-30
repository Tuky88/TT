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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class CuentaEspecialistaController implements Initializable {

    @FXML
    private JFXButton btnCacguardar;

    @FXML
    private JFXTextField txtCanombre;

    @FXML
    private JFXTextField txtCaapellido;

    @FXML
    private JFXTextField txtCausuario;

    @FXML
    private JFXTextField txtCacorreo;

    @FXML
    private JFXPasswordField txtCapass;

    @FXML
    private JFXPasswordField txtCarpass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    

}
