/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class CuentaEspecialistaController implements Initializable {

       @FXML
    private Pane panelPrin;

@FXML
    private JFXButton btnCguardar;

    @FXML
    private JFXButton btnCambiarcontra;

    @FXML
    private JFXTextField txtCnombre;

    @FXML
    private JFXTextField txtCcorreo;

    @FXML
    private JFXTextField txtCusuario;

    @FXML
    private JFXTextField txtCapellido;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
