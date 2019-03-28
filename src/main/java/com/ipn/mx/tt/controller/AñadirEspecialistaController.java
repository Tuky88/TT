/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    
}
