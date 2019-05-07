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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    @FXML
    private JFXButton btnPsiguientes;

    @FXML
    private BarChart<?, ?> ginsomnioh;

    @FXML
    private BarChart<?, ?> gritmoh;

    @FXML
    private BarChart<?, ?> gpiernash;

    @FXML
    private BarChart<?, ?> gapneah;

    @FXML
    private BarChart<?, ?> ghiper;

    @FXML
    private BarChart<?, ?> gnarcolepsia;

    @FXML
    private BarChart<?, ?> gimpacto;

    @FXML
    private BarChart<?, ?> ginsomnios;

    @FXML
    private BarChart<?, ?> gritmos;

    @FXML
    private BarChart<?, ?> gapneas;

    @FXML
    private BarChart<?, ?> gpiernass;
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

    public void startgrafica() {
        
        CategoryAxis xAxisrih = new CategoryAxis();
        NumberAxis yAxisrih = new NumberAxis();
        xAxisrih.setLabel("Preguntas");       
        yAxisrih.setLabel("Valor");
 
        XYChart.Series seriesih = new XYChart.Series();
        double ih=Double.parseDouble(ihsdq.getText());
        seriesih.getData().add(new XYChart.Data("Obtenido",ih));
        XYChart.Series seriesihm = new XYChart.Series();
        double ihm=29.44;
        seriesihm.getData().add(new XYChart.Data("Minimo",ihm));
        ginsomnioh.getData().addAll(seriesih,seriesihm);
        
        CategoryAxis xAxisis = new CategoryAxis();
        NumberAxis yAxisis = new NumberAxis();
        xAxisis.setLabel("Preguntas");       
        yAxisis.setLabel("Valor");
 
        XYChart.Series seriesis = new XYChart.Series();
        double is=Double.parseDouble(is50.getText());
        seriesis.getData().add(new XYChart.Data("Obtenido",is));
        XYChart.Series seriesism = new XYChart.Series();
        double ism=19;
        seriesism.getData().add(new XYChart.Data("Minimo",ism));
        ginsomnios.getData().addAll(seriesis,seriesism);
        
        
        
        CategoryAxis xAxisrh = new CategoryAxis();
        NumberAxis yAxisrh = new NumberAxis();
        xAxisrh.setLabel("Preguntas");       
        yAxisrh.setLabel("Valor");
 
        XYChart.Series seriesrh = new XYChart.Series();
        double rh=Double.parseDouble(rchsdq.getText());
        seriesrh.getData().add(new XYChart.Data("Obtenido",rh));
        XYChart.Series seriesrhm = new XYChart.Series();
        double rhm=20.46;
        seriesrhm.getData().add(new XYChart.Data("Minimo",rhm));
        gritmoh.getData().addAll(seriesrh,seriesrhm);
        
        CategoryAxis xAxisrs = new CategoryAxis();
        NumberAxis yAxisrs = new NumberAxis();
        xAxisrs.setLabel("Preguntas");       
        yAxisrs.setLabel("Valor");
 
        XYChart.Series seriesrs = new XYChart.Series();
        double rs=Double.parseDouble(rcs50.getText());
        seriesrs.getData().add(new XYChart.Data("Obtenido",rs));
        XYChart.Series seriesrsm = new XYChart.Series();
        double rsm=8;
        seriesrsm.getData().add(new XYChart.Data("Minimo",rsm));
        gritmos.getData().addAll(seriesrs,seriesrsm);
        
        CategoryAxis xAxipih = new CategoryAxis();
        NumberAxis yAxipih = new NumberAxis();
        xAxipih.setLabel("Preguntas");       
        yAxipih.setLabel("Valor");
 
        XYChart.Series seriespih = new XYChart.Series();
        double pih=Double.parseDouble(pihsdq.getText());
        seriespih.getData().add(new XYChart.Data("Obtenido",pih));
        XYChart.Series seriesphm = new XYChart.Series();
        double pihm=13.5;
        seriesphm.getData().add(new XYChart.Data("Minimo",pihm));
        gpiernash.getData().addAll(seriespih,seriesphm);
        
        CategoryAxis xAxipis = new CategoryAxis();
        NumberAxis yAxipis = new NumberAxis();
        xAxipis.setLabel("Preguntas");       
        yAxipis.setLabel("Valor");
 
        XYChart.Series seriespis = new XYChart.Series();
        double pis=Double.parseDouble(pis50.getText());
        seriespis.getData().add(new XYChart.Data("Obtenido",pis));
        XYChart.Series seriespsm = new XYChart.Series();
        double pism=7;
        seriespsm.getData().add(new XYChart.Data("Minimo",pism));
        gpiernass.getData().addAll(seriespis,seriespsm);
        
        CategoryAxis xAxiaih = new CategoryAxis();
        NumberAxis yAxiaih = new NumberAxis();
        xAxiaih.setLabel("Preguntas");       
        yAxiaih.setLabel("Valor");
 
        XYChart.Series seriesah = new XYChart.Series();
        double ah=Double.parseDouble(ahsdq.getText());
        seriesah.getData().add(new XYChart.Data("Obtenido",ah));
        XYChart.Series seriesahm = new XYChart.Series();
        double ahm=11.48;
        seriesahm.getData().add(new XYChart.Data("Minimo",ahm));
        gapneah.getData().addAll(seriesah,seriesahm);
        
        CategoryAxis xAxiais = new CategoryAxis();
        NumberAxis yAxiais = new NumberAxis();
        xAxiais.setLabel("Preguntas");       
        yAxiais.setLabel("Valor");
 
        XYChart.Series seriesas = new XYChart.Series();
        double as=Double.parseDouble(as50.getText());
        seriesas.getData().add(new XYChart.Data("Obtenido",as));
        XYChart.Series seriesasm = new XYChart.Series();
        double asm=15;
        seriesasm.getData().add(new XYChart.Data("Minimo",asm));
        gapneas.getData().addAll(seriesas,seriesasm);
        
        CategoryAxis xAxihi = new CategoryAxis();
        NumberAxis yAxihi = new NumberAxis();
        xAxihi.setLabel("Preguntas");       
        yAxihi.setLabel("Valor");
 
        XYChart.Series serieshh = new XYChart.Series();
        double hh=Double.parseDouble(hhsdq.getText());
        serieshh.getData().add(new XYChart.Data("Obtenido",hh));
        XYChart.Series serieshm = new XYChart.Series();
        double hm=14.5;
        serieshm.getData().add(new XYChart.Data("Minimo",hm));
        ghiper.getData().addAll(serieshh,serieshm);
        
        CategoryAxis xAxini = new CategoryAxis();
        NumberAxis yAxini = new NumberAxis();
        xAxini.setLabel("Preguntas");       
        yAxini.setLabel("Valor");
 

        XYChart.Series seriesns = new XYChart.Series();
        double ns=Double.parseDouble(ns50.getText());
        seriesns.getData().add(new XYChart.Data("Obtenido",ns));
         XYChart.Series seriesnsm = new XYChart.Series();
        double nsm=7;
        seriesnsm.getData().add(new XYChart.Data("Minimo",nsm));
        gnarcolepsia.getData().addAll(seriesns,seriesnsm);
        
        CategoryAxis xAxioi = new CategoryAxis();
        NumberAxis yAxioi = new NumberAxis();
        xAxioi.setLabel("Preguntas");       
        yAxioi.setLabel("Valor");
 

        XYChart.Series seriesos = new XYChart.Series();
        double os=Double.parseDouble(os50.getText());
        seriesos.getData().add(new XYChart.Data("Obtenido",os));
         XYChart.Series seriesosm = new XYChart.Series();
        double osm=15;
        seriesosm.getData().add(new XYChart.Data("Minimo",osm));
        gimpacto.getData().addAll(seriesos,seriesosm);
       
       
        

    }
}
