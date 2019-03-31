/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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
    private JFXButton btnTPsiguiente;

    @FXML
    private JFXRadioButton rbtnTPoca;

    @FXML
    private JFXRadioButton rbtnTPsiempre;

    @FXML
    private JFXRadioButton rbtnTPnunca;

    @FXML
    private JFXRadioButton rbtnTPavc;

    @FXML
    private JFXRadioButton rbtnTPcs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
