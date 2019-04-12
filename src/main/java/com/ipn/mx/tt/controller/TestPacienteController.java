/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestPacienteController implements Initializable {

    cargadorVista cv;
    menuController mc;

    @FXML
    private JFXButton btnTPComenzar;

    @FXML
    private JFXTextField txtTPnumero;
    @FXML
    private AnchorPane panelT;

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    void iniciarTest(ActionEvent event) {
        TestPacientePreguntasController tppc = (TestPacientePreguntasController) cv.cambiarVista("/Center/TestPacientePreguntas.fxml", mc.getPanelPrin());
       tppc.setMc(mc);
        tppc.iniciarTest();
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cv = new cargadorVista();
        // TODO
    }

}
