/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.util.Validador;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteConRegistroController implements Initializable {

    Validador v;
    @FXML
    private JFXButton btnPriniciar;

    @FXML
    private JFXTextField txtPrnombre;

    @FXML
    private JFXTreeTableView<?> tabla;

    @FXML
    void buscarPaciente(KeyEvent event) {
        String busqueda=v.validarTF(txtPrnombre);
        if(busqueda.length()>3)
        {
            System.out.println(busqueda);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    

}
