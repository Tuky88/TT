/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Temp
 */
public class Prediagnostico2Controller implements Initializable {
        @FXML
    private TableView<?> tbthabitos;

    @FXML
    private TableView<?> tblsintomas;

    @FXML
    private TableView<?> tbltrastornos;

    @FXML
    private JFXTextArea txtcomentarios;

    @FXML
    private JFXButton btnrecomendaciones;

    @FXML
    private JFXButton btnregresar;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
