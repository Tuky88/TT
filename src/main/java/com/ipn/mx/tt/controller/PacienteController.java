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

        btnTpacientenuevo.setDisable(true);
        btnTpacienteregistrado.setDisable(false);
        
       
    }

    public void clickMenu()
    {
        btnTpacientenuevo.fire();
    }
    @FXML
    void abrirPacienteR(ActionEvent event) {

        PacienteConRegistroController pcr=(PacienteConRegistroController)cv.cambiarVista("/Center/PacienteConRegistro.fxml",panelRight);
        pcr.setC(c);
                btnTpacientenuevo.setDisable(false);
        btnTpacienteregistrado.setDisable(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cv=new cargadorVista();
        // TODO
    }

}
