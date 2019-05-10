/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PrediagnosticosController implements Initializable {

    private cargadorVista cv;
    @FXML
    private Pane panelLeft;

    @FXML
    private JFXButton btnPhistorial;

    @FXML
    private JFXButton btnPvalidar;

    @FXML
    private BorderPane panelRight;

    @FXML
    void abrirHistorial(ActionEvent event) {
        HistorialController hc = (HistorialController) cv.cambiarVista("/Center/Historial.fxml", panelRight);
        btnPhistorial.setDisable(true);
        btnPvalidar.setDisable(false);
    }

    @FXML
    void abrirValidar(ActionEvent event) {
        ValidarController vc = (ValidarController) cv.cambiarVista("/Center/Validar.fxml", panelRight);
        btnPhistorial.setDisable(false);
        btnPvalidar.setDisable(true);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cv = new cargadorVista();
    }
}
