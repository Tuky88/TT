/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.InfoCuestionario;
import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestPacienteController implements Initializable {

    int tipoCuestionario;

    boolean datosPaciente;
    Paciente paciente;
    cargadorVista cv;
    menuController mc;
    private InfoCuestionario ic;

    @FXML
    private Label lblPaciente;
    @FXML
    private JFXButton btnTPComenzar;

    @FXML
    private JFXTextField txtTPnumero;
    @FXML
    private AnchorPane panelT;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getTipoCuestionario() {
        return tipoCuestionario;
    }

    public void setTipoCuestionario(int tipoCuestionario) {
        this.tipoCuestionario = tipoCuestionario;
    }

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

    public boolean isDatosPaciente() {
        return datosPaciente;
    }

    public void setDatosPaciente(boolean datosPaciente) {
        this.datosPaciente = datosPaciente;
    }

    public void ponerPaciente() {
        lblPaciente.setText(lblPaciente.getText() + " " + paciente.getNombre());
    }

    public InfoCuestionario getIc() {
        return ic;
    }

    public void setIc(InfoCuestionario ic) {
        this.ic = ic;
    }
    
    public void clickComenzar()
    {
        btnTPComenzar.fire();
    }

    @FXML
    void iniciarTest(ActionEvent event) {
        TestPacientePreguntasController tppc = (TestPacientePreguntasController) cv.cambiarVista("/Center/TestPacientePreguntas.fxml", mc.getPanelPrin());
        tppc.setMc(mc);
        tppc.setTipoCuestionario(tipoCuestionario);
        tppc.iniciarTest();
        tppc.setPaciente(paciente);
        if(datosPaciente)
        {
            tppc.setIc(ic);
            tppc.ponerPaciente();  
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cv = new cargadorVista();
        // TODO
    }

}
