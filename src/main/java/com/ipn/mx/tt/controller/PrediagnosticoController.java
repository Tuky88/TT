/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.Cuestionario;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PrediagnosticoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    String resultados;
    @FXML
    private JFXButton btnPrecomendaciones;

    @FXML
    private Label ihsdq;

    @FXML
    private Label rchsdq;

    @FXML
    private Label pihsdq;

    @FXML
    private Label ahsdq;

    @FXML
    private Label hhsdq;

    @FXML
    private Label nhsdq;

    @FXML
    private Label ohsdq;

    @FXML
    private Label is50;

    @FXML
    private Label rcs50;

    @FXML
    private Label pis50;

    @FXML
    private Label as50;

    @FXML
    private Label hs50;

    @FXML
    private Label ns50;

    @FXML
    private Label os50;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //c.toString();
//        is50.setText(String.valueOf(c.getTrastorno(1, 1)));
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }
    public void cargarResultados()
    {
        is50.setText(resultados);
    }

}
