/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.Cuestionario;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
    Cuestionario cuestionario;
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
    @FXML
    private Label lblTermino;

    @FXML
    private Label lblInicio;

    @FXML
    private Label lblDuracion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //c.toString();
//        is50.setText(String.valueOf(c.getTrastorno(1, 1)));
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public void cargarResultados() {
        ihsdq.setText("" + cuestionario.getTrastorno(1, 1));
        is50.setText("" + cuestionario.getTrastorno(2, 1));
        rchsdq.setText("" + cuestionario.getTrastorno(1, 2));
        rcs50.setText("" + cuestionario.getTrastorno(2, 2));
        pihsdq.setText("" + cuestionario.getTrastorno(1, 3));
        pis50.setText("" + cuestionario.getTrastorno(2, 3));
        ahsdq.setText("" + cuestionario.getTrastorno(1, 4));
        as50.setText("" + cuestionario.getTrastorno(2, 4));
        hhsdq.setText("" + cuestionario.getTrastorno(1, 5));
        hs50.setText("" + cuestionario.getTrastorno(2, 5));
        nhsdq.setText("" + cuestionario.getTrastorno(1, 6));
        ns50.setText("" + cuestionario.getTrastorno(2, 6));
        ohsdq.setText("" + cuestionario.getTrastorno(1, 7));
        os50.setText("" + cuestionario.getTrastorno(2, 7));
        
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss"); 
        SimpleDateFormat dt1 = new SimpleDateFormat("mm:ss"); 
        lblDuracion.setText(dt1.format(cuestionario.getDuracion()) + "minutos");
        lblInicio.setText(dt.format(cuestionario.getInicioCuestionario()));
        lblTermino.setText(dt.format(cuestionario.getFinCuestionario()));
    }

}
