package com.ipn.mx.tt.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ipn.mx.tt.dao.PacienteDAO;
import com.ipn.mx.tt.modelo.Paciente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteNuevo2Controller implements Initializable {

     @FXML
    private AnchorPane panelP;

    @FXML
    private JFXButton btnPnComenzar;

    @FXML
    private Label lblhorario;

    @FXML
    private JFXRadioButton rbPhorariof;

    @FXML
    private ToggleGroup grupoPregunta;

    @FXML
    private JFXRadioButton rbPhorarioturnos;

    @FXML
    private JFXRadioButton rbPhorarionof;

    @FXML
    private JFXRadioButton rbPlv;

    @FXML
    private ToggleGroup grupoPregunta1;

    @FXML
    private JFXRadioButton rbPls;

    @FXML
    private Label lbldias;

    @FXML
    private Label lblhoras;

    @FXML
    private Label lblphorass;

    @FXML
    private JFXTextField txtPhorasl;

    @FXML
    private Label lblphorasdd;

    @FXML
    private JFXTextField txtPhorasd;

    @FXML
    private JFXButton btnPnguardar;

    @FXML
    private Label lbltrabaja;

    @FXML
    private Label lblphoras;

    @FXML
    private Spinner<?> spnhoras;

    @FXML
    private JFXRadioButton rbPtrabajas;

    @FXML
    private ToggleGroup grupoPregunta11;

    @FXML
    private JFXRadioButton rbPtrabajan;


    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    @FXML
    public void comenzarCuestionario(ActionEvent event) {
        
    }
    
}
