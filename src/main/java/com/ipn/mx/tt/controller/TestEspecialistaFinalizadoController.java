/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.Cuestionario;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import com.ipn.mx.tt.controller.PrediagnosticoController;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaFinalizadoController implements Initializable {

    Cuestionario cuestionario;
    menuController mc;
    cargadorVista cv;

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

    
    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    @FXML
    private JFXButton btnTEprediagnostico;

    @FXML
    private ProgressBar pbTEterminado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void mostrarPrediagnostico(ActionEvent ae) {
        cv=new cargadorVista(); 
        PrediagnosticoController p= new PrediagnosticoController();
        PrediagnosticoController pc = (PrediagnosticoController) cv.cambiarVista("/Center/Prediagnostico.fxml", mc.getPanelPrin());
        pc.setCuestionario(cuestionario);
        pc.cargarResultados();
        pc.startgrafica();
        
    }
}
