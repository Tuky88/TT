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
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestController implements Initializable {
 menuController  c;

    public menuController getC() {
        return c;
    }

    public void setC(menuController c) {
        this.c = c;
    }
 
    @FXML
    private JFXButton btnTpacientenuevo;

    @FXML
    private JFXButton btnTpacienteregistrado;

    @FXML
    private BorderPane panelRight;

    @FXML
    void abrirPacienteN(ActionEvent event) {
        PacienteNuevoController pnc= (PacienteNuevoController) abrirMenu("/Center/PacienteNuevo.fxml");
        pnc.setC(c);
        
    }

    public void clickMenu()
    {
        btnTpacientenuevo.fire();
    }
    @FXML
    void abrirPacienteR(ActionEvent event) {
        abrirMenu("/Center/PacienteConRegistro.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }

    public Object abrirMenu(String menu) {
        Object o = null;
        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource(menu));
            Parent root = fx.load();
            panelRight.setCenter(root);
            o = fx.getController();
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
}
