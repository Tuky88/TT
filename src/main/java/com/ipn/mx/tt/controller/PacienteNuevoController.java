/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteNuevoController implements Initializable {

    menuController c;
    

    public menuController getC() {
        return c;
    }

    public void setC(menuController c) {
        this.c = c;
    }
    @FXML
    private JFXButton btnPnregistrar;

    @FXML
    private JFXTextField txtPnnombre;

    @FXML
    private AnchorPane panelP;
    @FXML
    private JFXTextField txtPnapellido;

    @FXML
    private JFXTextField txtPncorreo;

    @FXML
    private JFXTextField txtPndireccion;

    @FXML
    private JFXTextField txtPntelefono;

    @FXML
    private JFXRadioButton rbPfemenino;

    @FXML
    private JFXRadioButton rbPmasculino;

    @FXML
    private JFXDatePicker datePn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    void registrarPaciente(ActionEvent event) {
        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource("/Center/ComenzarTest.fxml"));
            
            AnchorPane ap = fx.load();
            c.getPanelPrin().setCenter(ap);
            c.getPanelPrin().setLeft(null);
            ComenzarTestController ctc=(ComenzarTestController) fx.getController();
            ctc.setC(c);
        } catch (IOException ex) {
            Logger.getLogger(PacienteNuevoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
