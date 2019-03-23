/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class ConfiguracionesController implements Initializable {

    @FXML
    private Pane panelLeft;

    @FXML
    private Button btnCcuenta;

    @FXML
    private Button btnCaespecialista;
    @FXML
    private BorderPane panelRight;

    @FXML
    void abrirCuenta(ActionEvent event) {
        abrirMenu("/Center/CuentaEspecialista.fxml");
    }
        @FXML
    void abrirEspecialista(ActionEvent event) {
        abrirMenu("/Center/AñadirEspecialista.fxml");
    }

    public void abrirMenu(String menu) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(menu));
            panelRight.setCenter(root);

        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
