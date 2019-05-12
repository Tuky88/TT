/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.PreguntaTabla;
import com.ipn.mx.tt.modelo.TrastornoTabla;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Temp
 */
public class HistorialvistaController implements Initializable {

    private menuController mc;
    private cargadorVista cv;
    @FXML
    private JFXButton btnVolver;
    @FXML
    private TableView<TrastornoTabla> tbltrastornos;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaTrastorno;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaHsdq;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaHsdqM;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaS50;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaS50M;

    @FXML
    private TableView<PreguntaTabla> tbltest;

    @FXML
    private TableColumn<PreguntaTabla, String> columnaPregunta;

    @FXML
    private TableColumn<PreguntaTabla, String> columnaRespuesta;

    private ObservableList<PreguntaTabla> ptol;
    private ObservableList<TrastornoTabla> ttol;

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cv = new cargadorVista();
        ptol = FXCollections.observableArrayList();
        ttol = FXCollections.observableArrayList();

        columnaPregunta.setCellValueFactory(cellData -> cellData.getValue().getPregunta());
        columnaRespuesta.setCellValueFactory(cellData -> cellData.getValue().getRespuesta());

        columnaTrastorno.setCellValueFactory(cellData -> cellData.getValue().getTrastorno());
        columnaHsdq.setCellValueFactory(cellData -> cellData.getValue().getHsdq());
        columnaHsdqM.setCellValueFactory(cellData -> cellData.getValue().getHsdqM());
        columnaS50.setCellValueFactory(cellData -> cellData.getValue().getS50());
        columnaS50M.setCellValueFactory(cellData -> cellData.getValue().getS50M());

        tbltest.setItems(ptol);
        tbltrastornos.setItems(ttol);

    }

    @FXML
    private void volverAMenu(ActionEvent event) {
        PrediagnosticosController pc
                = (PrediagnosticosController) cv.cambiarVista("/Center/Prediagnosticos.fxml", mc.getPanelPrin());
        pc.setMc(mc);
        pc.abrirHistorial();
    }

}
