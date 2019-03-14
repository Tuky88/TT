/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

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
    private TextField txtCnombre;

    @FXML
    private TextField txtCapellido;

    @FXML
    private TextField txtCcorreo;

    @FXML
    private TextField txtCusuario;

    @FXML
    private Button btnCambiarcontra;

    @FXML
    private Button btnCguardar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
