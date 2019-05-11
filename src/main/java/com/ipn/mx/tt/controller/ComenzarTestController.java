/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.CuestionarioAplicadoDAO;
import com.ipn.mx.tt.modelo.InfoCuestionario;
import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class ComenzarTestController implements Initializable {

    private boolean datosPaciente;
    private menuController c;
    private cargadorVista cv;
    private Paciente paciente;
    private InfoCuestionario ic;
    private CuestionarioAplicadoDAO cad;

    public boolean isDatosPaciente() {
        return datosPaciente;
    }

    public void setDatosPaciente(boolean datosPaciente) {
        this.datosPaciente = datosPaciente;
    }

    public InfoCuestionario getIc() {
        return ic;
    }

    public void setIc(InfoCuestionario ic) {
        this.ic = ic;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void ocultarEspecialista() {
        this.btnTespecialista.setVisible(false);
        this.imgEspecialista.setVisible(false);
    }

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
    @FXML
    private ImageView imgEspecialista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cv = new cargadorVista();
        cad = new CuestionarioAplicadoDAO();
        cad.conectar();
    }

    public void abrirPaciente(int i) {
        TestPacienteController tpc
                = (TestPacienteController) cv.cambiarVista("/Center/TestPaciente.fxml", c.getPanelPrin());
        tpc.setMc(c);
        tpc.setTipoCuestionario(i);
        tpc.setPaciente(paciente);

        tpc.setDatosPaciente(datosPaciente);
        if (datosPaciente) {
            tpc.setIc(ic);
            tpc.ponerPaciente();
            tpc.clickComenzar();
        }
        //1 .- Paciente
        //2 .- Acompañante
    }

    @FXML
    void abirAcompañante(ActionEvent event) {
        abrirPaciente(2);
    }

    @FXML
    void abrirEspecialista(ActionEvent event) {

        CustomMessage cm = new CustomMessage("¿?", "¿Asignar el cuestionario a un paciente?", 3);
        if (cm.getMessage().getButtonData().equals(ButtonType.OK.getButtonData())) {
            // ABRIR PANEL BUSCAR/AGREGAR PACIENTE
            System.out.println("TONTO");
        } else {
            System.out.println("Paciente generico...");
            InfoCuestionario icg = new InfoCuestionario(cad.buscarSiguiente() + 1, c.getUsuario().getId());
            ic = icg;
            cad.insertarInfoCuestionario(icg);
        }
        TestEspecialistaController tec
                = (TestEspecialistaController) cv.cambiarVista("/Center/TestEspecialista.fxml", c.getPanelPrin());
        tec.setMc(c);
        tec.setTipoCuestionario(1);
        tec.iniciarTest();
        if (ic != null) {
            tec.setIc(ic);
        }
    }

    @FXML
    void abrirPaciente(ActionEvent event) {
        abrirPaciente(1);

    }

    void setCuestionario(Double idCuestionario) {

    }

}
