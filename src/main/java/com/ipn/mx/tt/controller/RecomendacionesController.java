/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.Test;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class RecomendacionesController implements Initializable {

    private menuController mc;
    private cargadorVista cv;
    private Test test;

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @FXML
    private JFXButton btnVolver;

    @FXML
    private TableView<?> tblRtrastornos;

    @FXML
    private TableView<?> tblPtrastornos1;

    @FXML
    private TableColumn<?, ?> tblRrecomendaciones;

    @FXML
    private JFXButton btnRimprimir;

    @FXML
    private JFXButton btnRenviarcorreo;

    @FXML
    private JFXButton btnRcerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cv=new  cargadorVista();
    }

    @FXML
    void enviarEmailRecomendacion(ActionEvent event) {

    }

    @FXML
    void imprimirRecomendacion(ActionEvent event) {

    }

    @FXML
    void regresarPrediagnostico(ActionEvent event) {

    }

    @FXML
    void verRecomendacion(ActionEvent event) {

    }
}
