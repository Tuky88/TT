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
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestPacientePreguntasController implements Initializable {

    menuController mc;

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

   
    
      @FXML
    private JFXRadioButton rbtnTPoca;

    @FXML
    private ToggleGroup grupoPregunta;

    @FXML
    private JFXRadioButton rbtnTPsiempre;

    @FXML
    private JFXRadioButton rbtnTPnunca;

    @FXML
    private JFXRadioButton rbtnTPavc;

    @FXML
    private JFXRadioButton rbtnTPcs;

    @FXML
    private JFXTextArea txtpregunta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cargarPregunta(Pregunta p)
    {
        txtpregunta.setText(p.getId()+".-"+p.getTexto());
    }
    void iniciarTest() {
        PreguntaDAO pd=new PreguntaDAO();
        pd.cjm.conectar();
        cargarPregunta(pd.getPregunta(1));
    }

    
}
