/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PrediagnosticosController implements Initializable {

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
        abrirMenu("/Center/Historial.fxml");
    }

    @FXML
    void abrirValidar(ActionEvent event) {
        abrirMenu("/Center/Validar.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void abrirMenu(String menu) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(menu));
            panelRight.setCenter(root);

        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
