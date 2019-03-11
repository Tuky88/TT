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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestPacientePreguntasController implements Initializable {
 @FXML
    private Label lblTPpregunta;

    @FXML
    private RadioButton rbtnTPopcion3;

    @FXML
    private Button btnTPsiguiente;

    @FXML
    private RadioButton rbtnTPopcion2;

    @FXML
    private RadioButton rbtnTPopcion1;

    @FXML
    private Pane panelLeft1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
