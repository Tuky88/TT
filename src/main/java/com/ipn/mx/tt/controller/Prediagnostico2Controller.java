/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.InfoCuestionario;
import com.ipn.mx.tt.modelo.Pregunta;
import com.ipn.mx.tt.modelo.PreguntaTabla;
import com.ipn.mx.tt.modelo.Respuesta;
import com.ipn.mx.tt.modelo.SintomaTrastornoTabla;
import com.ipn.mx.tt.modelo.Test;
import com.ipn.mx.tt.modelo.TrastornoTabla;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Temp
 */
public class Prediagnostico2Controller implements Initializable {

    private menuController mc;
    private cargadorVista cv;
    private Test test;
    private InfoCuestionario ic;
    private ObservableList<PreguntaTabla> ptol;
    private ObservableList<SintomaTrastornoTabla> sttol;
    private ObservableList<TrastornoTabla> ttol;
    @FXML
    private AnchorPane panelP;
    @FXML
    private TableColumn<PreguntaTabla, String> columnaPregunta;

    @FXML
    private TableColumn<PreguntaTabla, String> columnaRespuesta;

    @FXML
    private TableColumn<SintomaTrastornoTabla, String> columnaSintoma;

    @FXML
    private TableColumn<SintomaTrastornoTabla, String> columnaTrastorno;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaTrastornoR;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaHSDQ;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaHM;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaS50;

    @FXML
    private TableColumn<TrastornoTabla, String> columnaS50M;
    @FXML
    private TableView<PreguntaTabla> tbthabitos;

    @FXML
    private TableView<SintomaTrastornoTabla> tblsintomas;

    @FXML
    private TableView<TrastornoTabla> tbltrastornos;

    @FXML
    private JFXTextArea txtcomentarios;

    @FXML
    private JFXButton btnrecomendaciones;

    @FXML
    private JFXButton btnregresar;

    @FXML
    private void regresarDiagnostico(ActionEvent event) {
        PrediagnosticoController pc
                = (PrediagnosticoController) cv.cambiarVista("/Center/Prediagnostico.fxml", mc.getPanelPrin());
        pc.setTest(test);
        pc.setMc(mc);
        pc.cargarResultados();
        pc.startgrafica();
        pc.setIc(ic);

    }

    @FXML
    private void irRecomendaciones(ActionEvent event) {
        RecomendacionesController rc
                = (RecomendacionesController) cv.cambiarVista("/Center/Recomendaciones.fxml", mc.getPanelPrin());
        rc.setMc(mc);
        rc.setTest(test);
        
    }

    public InfoCuestionario getIc() {
        return ic;
    }

    public void setIc(InfoCuestionario ic) {
        this.ic = ic;
    }

    
    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

    public Test getTest() {
        return test;
        // TODO
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cv = new cargadorVista();

        ptol = FXCollections.observableArrayList();
        sttol = FXCollections.observableArrayList();
        ttol = FXCollections.observableArrayList();

        columnaPregunta.setCellValueFactory(cellData -> cellData.getValue().getPregunta());
        columnaRespuesta.setCellValueFactory(cellData -> cellData.getValue().getRespuesta());

        columnaTrastorno.setCellValueFactory(cellData -> cellData.getValue().getTrastorno());
        columnaSintoma.setCellValueFactory(cellData -> cellData.getValue().getSintoma());

        columnaTrastornoR.setCellValueFactory(cellData -> cellData.getValue().getTrastorno());
        columnaHSDQ.setCellValueFactory(cellData -> cellData.getValue().getHsdq());
        columnaHM.setCellValueFactory(cellData -> cellData.getValue().getHsdqM());
        columnaS50.setCellValueFactory(cellData -> cellData.getValue().getS50());
        columnaS50M.setCellValueFactory(cellData -> cellData.getValue().getS50M());

        ptol.add(new PreguntaTabla("Muestra", "5"));
        sttol.add(new SintomaTrastornoTabla("prueba", "prueba"));
        ttol.add(new TrastornoTabla("Prueba", "1", "2.5", "3", "2.5"));

        tbthabitos.setItems(ptol);
        tbltrastornos.setItems(ttol);
        tblsintomas.setItems(sttol);
    }
    public void ponerPreguntasHabitos()
    {
        for (int i = 62; i < 70; i++) {
            Respuesta r=test.obtenerRespuesta(new Double(i));
            Pregunta p=test.getPregunta(i);
            PreguntaTabla pt=new PreguntaTabla(r);
            pt.setPregunta(new SimpleStringProperty(p.getTexto()));
            
            ptol.add(pt);
        }
    }

}
