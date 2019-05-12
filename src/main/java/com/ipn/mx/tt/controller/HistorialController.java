/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class HistorialController implements Initializable{

    private cargadorVista cv;
    private menuController mc;
    @FXML
    private AnchorPane btnPver;

    @FXML
    private JFXTextField txtPnombre;

    @FXML
    private TableView<?> tblPpre;

    @FXML
    private JFXButton btnPver1;

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        cv=new cargadorVista();
    } 

    
        @FXML
    private void verPrediagnostico(ActionEvent event) {
        HistorialvistaController hc=(HistorialvistaController)
                cv.cambiarVista("/Center/Historialvista.fxml",mc.getPanelPrin());
        hc.setMc(mc);
        
    }
}

