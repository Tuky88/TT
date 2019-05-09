package com.ipn.mx.tt.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ipn.mx.tt.dao.PreguntaSeguridadDAO;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class RecuperarcontraController implements Initializable {

    private PreguntaSeguridadDAO psd;
    private cargadorVista cv;
        @FXML
    private AnchorPane panelPrincipal;
    @FXML
    private Label lblStatus1;

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXTextField txtCorreo;

    @FXML
    private JFXTextField txtResseguridad;

    @FXML
    private JFXComboBox<?> cmbpreguntaseguridad;
    

    @FXML
    void cambiarContra(ActionEvent event) {

    }

    @FXML
    void cancelarCambio(ActionEvent event) {
        LoginController lc=(LoginController) cv.cambiarVista("/Center/Login.fxml", panelPrincipal);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       psd=new PreguntaSeguridadDAO();
       psd.conectar();
       cv=new cargadorVista();
    }

}
