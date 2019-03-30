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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteNuevoController implements Initializable {

    @FXML
    private JFXButton btnPnregistrar;

    @FXML
    private JFXTextField txtPnnombre;

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
        Alert a = new Alert(Alert.AlertType.NONE, datePn.getValue().toString(), ButtonType.OK);
        a.show();
    }
}
