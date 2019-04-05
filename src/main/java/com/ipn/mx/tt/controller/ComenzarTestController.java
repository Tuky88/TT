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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class ComenzarTestController implements Initializable {

    menuController c;

    public menuController getC() {
        return c;
    }

    public void setC(menuController c) {
        this.c = c;
    }

    @FXML
    private BorderPane panelRight;

    @FXML
    private JFXButton btnTespecialista;

    @FXML
    private JFXButton btnTpaciente;

    @FXML
    private JFXButton btnTacompañante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cargarMenu(String menu) {
        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource(menu));
            AnchorPane bp = fx.load();
            c.getPanelPrin().setCenter(bp);
        } catch (IOException ex) {
            Logger.getLogger(ComenzarTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void abirAcompañante(ActionEvent event) {
        cargarMenu("/Center/TestPaciente.fxml");
    }

    @FXML
    void abrirEspecialista(ActionEvent event) {
        cargarMenu("/Center/TestEspecialista.fxml");
    }

    @FXML
    void abrirPaciente(ActionEvent event) {
        cargarMenu("/Center/TestPaciente.fxml");
    }

}
