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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaController implements Initializable {
@FXML
    private Label lblTEpregunta;

    @FXML
    private RadioButton rbtnTEopcion3;

    @FXML
    private Button btnTEsiguiente;

    @FXML
    private RadioButton rbtnTEopcion2;

    @FXML
    private RadioButton rbtnTEopcion1;

    @FXML
    private ProgressBar pbTprogeso;

    @FXML
    private Pane panelLeft1;

     @FXML
    private TableView<?> listTEpreguntas;

    @FXML
    private ScrollBar sbTEpreguntas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
