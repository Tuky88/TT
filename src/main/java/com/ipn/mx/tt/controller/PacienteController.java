/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.util.cargadorVista;
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
public class PacienteController implements Initializable {
 menuController  c;
 cargadorVista cv;

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
        PacienteNuevoController pnc= (PacienteNuevoController) 
                cv.cambiarVista("/Center/PacienteNuevo.fxml",panelRight);
        pnc.setC(c);
        pnc.configurarObjetos();
        btnTpacientenuevo.setDisable(true);
        btnTpacienteregistrado.setDisable(false);  
        System.out.println(c.getUsuario().toString());
    }
    
    @FXML
    void abrirPacienteR(ActionEvent event) {

        cv.cambiarVista("/Center/PacienteConRegistro.fxml",panelRight);
                btnTpacientenuevo.setDisable(false);
        btnTpacienteregistrado.setDisable(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cv=new cargadorVista();
    }
public void clickMenu()
    {
        btnTpacientenuevo.fire();
    }
}
