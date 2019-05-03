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
    private BarChart<?, ?> ginsomnio;
    
    @FXML
    private BarChart<?, ?> gritmo;

    @FXML
    private BarChart<?, ?> gpiernas;

    @FXML
    private BarChart<?, ?> gapnea;

    @FXML
    private BarChart<?, ?> ghiper;

    @FXML
    private BarChart<?, ?> gnarcolepsia;

    @FXML
    private BarChart<?, ?> gimpacto;
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
        
        CategoryAxis xAxisi = new CategoryAxis();
        NumberAxis yAxisi = new NumberAxis();
        xAxisi.setLabel("Preguntas");       
        yAxisi.setLabel("Valor");
 
        XYChart.Series seriesih = new XYChart.Series();     
        double ih=Double.parseDouble(ihsdq.getText());
        seriesih.getData().add(new XYChart.Data("HSDQ",ih));
        XYChart.Series seriesihm = new XYChart.Series();     
        double ihm=29.44;
        seriesih.getData().add(new XYChart.Data("Minimo",ihm));
        XYChart.Series seriesis = new XYChart.Series();
        double is=Double.parseDouble(is50.getText());
        seriesis.getData().add(new XYChart.Data("S50",is));
         XYChart.Series seriesism = new XYChart.Series();
        double ism=19;
        seriesis.getData().add(new XYChart.Data("Minimo",ism));
        ginsomnio.getData().addAll(seriesih,seriesihm,seriesis,seriesism);
         
        
        CategoryAxis xAxisr = new CategoryAxis();
        NumberAxis yAxisr = new NumberAxis();
        xAxisr.setLabel("Preguntas");       
        yAxisr.setLabel("Valor");
 
        XYChart.Series seriesrh = new XYChart.Series();
        double rh=Double.parseDouble(rchsdq.getText());
        seriesrh.getData().add(new XYChart.Data("HSDQ",rh));
        XYChart.Series seriesrs = new XYChart.Series();
        double rs=Double.parseDouble(rcs50.getText());
        seriesrs.getData().add(new XYChart.Data("S50",rs));
        gritmo.getData().addAll(seriesrh,seriesrs);
        
        CategoryAxis xAxipi = new CategoryAxis();
        NumberAxis yAxipi = new NumberAxis();
        xAxipi.setLabel("Preguntas");       
        yAxipi.setLabel("Valor");
 
        XYChart.Series seriespih = new XYChart.Series();
        double pih=Double.parseDouble(pihsdq.getText());
        seriespih.getData().add(new XYChart.Data("HSDQ",pih));
        XYChart.Series seriespis = new XYChart.Series();
        double pis=Double.parseDouble(pis50.getText());
        seriespis.getData().add(new XYChart.Data("S50",pis));
        gpiernas.getData().addAll(seriespih,seriespis);
        
        CategoryAxis xAxiai = new CategoryAxis();
        NumberAxis yAxiai = new NumberAxis();
        xAxiai.setLabel("Preguntas");       
        yAxiai.setLabel("Valor");
 
        XYChart.Series seriesah = new XYChart.Series();
        double ah=Double.parseDouble(ahsdq.getText());
        seriesah.getData().add(new XYChart.Data("HSDQ",ah));
        XYChart.Series seriesas = new XYChart.Series();
        double as=Double.parseDouble(as50.getText());
        seriesas.getData().add(new XYChart.Data("S50",as));
        gapnea.getData().addAll(seriesah,seriesas);
        
        CategoryAxis xAxihi = new CategoryAxis();
        NumberAxis yAxihi = new NumberAxis();
        xAxihi.setLabel("Preguntas");       
        yAxihi.setLabel("Valor");
 
        XYChart.Series serieshh = new XYChart.Series();
        double hh=Double.parseDouble(hhsdq.getText());
        serieshh.getData().add(new XYChart.Data("HSDQ",hh));
        ghiper.getData().addAll(serieshh);
        
        CategoryAxis xAxini = new CategoryAxis();
        NumberAxis yAxini = new NumberAxis();
        xAxini.setLabel("Preguntas");       
        yAxini.setLabel("Valor");
 

        XYChart.Series seriesns = new XYChart.Series();
        double ns=Double.parseDouble(ns50.getText());
        seriesns.getData().add(new XYChart.Data("S50",ns));
        gnarcolepsia.getData().addAll(seriesns);
        
        CategoryAxis xAxioi = new CategoryAxis();
        NumberAxis yAxioi = new NumberAxis();
        xAxioi.setLabel("Preguntas");       
        yAxioi.setLabel("Valor");
 

        XYChart.Series seriesos = new XYChart.Series();
        double os=Double.parseDouble(os50.getText());
        seriesos.getData().add(new XYChart.Data("S50",os));
        gimpacto.getData().addAll(seriesos);
       
       
        

    }
}
