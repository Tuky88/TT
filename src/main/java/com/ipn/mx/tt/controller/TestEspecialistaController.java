/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.PreguntaDAO;
import com.ipn.mx.tt.modelo.Pregunta;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaController implements Initializable {

    menuController mc;
    @FXML
    private TableView<?> listTEpreguntas;

    @FXML
    private ScrollBar sbTEpreguntas;

    @FXML
    private BorderPane panelRight;

    @FXML
    private Label lblTEpregunta;

    @FXML
    private ProgressBar pbTEprogeso;

    @FXML
    private JFXButton btnTEsiguiente;

    @FXML
    private JFXRadioButton rbtnTEoca;

    @FXML
    private JFXRadioButton rbtnTEsiempre;

    @FXML
    private JFXRadioButton rbtnTEnunca;

    @FXML
    private JFXRadioButton rbtnTEavc;

    @FXML
    private JFXRadioButton rbtnTEcs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cargarPregunta(Pregunta p) {
        lblTEpregunta.setText(p.getId() + ".-" + p.getTexto());
    }

    void setMc(menuController c) {
        mc=c;
    }

    void iniciarTest() {
        PreguntaDAO pd = new PreguntaDAO();
        pd.cjm.conectar();
        cargarPregunta(pd.getPregunta(1));
    }
}
