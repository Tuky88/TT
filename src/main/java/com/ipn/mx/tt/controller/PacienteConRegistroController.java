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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteConRegistroController implements Initializable {
@FXML
    private Button btnTcguardar;

    @FXML
    private PasswordField txtTrnombre;

    @FXML
    private TableView<?> tblTpacientes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
