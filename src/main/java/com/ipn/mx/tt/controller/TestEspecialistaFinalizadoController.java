/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.PreguntaContestadaDAO;
import com.ipn.mx.tt.modelo.Cuestionario;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import com.ipn.mx.tt.modelo.InfoCuestionario;
import com.ipn.mx.tt.modelo.Test;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaFinalizadoController implements Initializable {


    private menuController mc;
    private cargadorVista cv;
    private Test test;
    private PreguntaContestadaDAO pcd;
    
    private InfoCuestionario ic;

    public InfoCuestionario getIc() {
        return ic;
    }

    public void setIc(InfoCuestionario ic) {
        this.ic = ic;
    }

    
    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
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
        cv=new cargadorVista();
        pcd=new PreguntaContestadaDAO();
        pcd.conectar();
    }

    @FXML
    private void mostrarPrediagnostico(ActionEvent ae) {
        
        pcd.guardarPreguntasContestadas(1.0,test.obtenerPreguntasContestadas());
        PrediagnosticoController p= new PrediagnosticoController();
        PrediagnosticoController pc = (PrediagnosticoController) cv.cambiarVista("/Center/Prediagnostico.fxml", mc.getPanelPrin());
        pc.setCuestionario(test.getCuestionario());
        pc.cargarResultados();
        pc.startgrafica();
        
        if(ic!=null)
        System.out.println(ic.getIdCuestionario());
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    
}
