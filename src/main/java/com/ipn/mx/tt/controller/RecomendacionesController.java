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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class RecomendacionesController implements Initializable {

    @FXML
    private TableView<?> tblRtrastornos;

    @FXML
    private Button btnRenviarcorreo;

    @FXML
    private TableView<?> tblPtrastornos1;

    @FXML
    private TableColumn<?, ?> tblRrecomendaciones;

    @FXML
    private Button btnRimprimir;

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
