/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.Cuestionario;
import com.ipn.mx.tt.modelo.Pregunta;
import com.ipn.mx.tt.modelo.SintomaPregunta;
import com.ipn.mx.tt.modelo.Test;
import com.ipn.mx.tt.modelo.TrastornoSintoma;
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.ThreadPregunta;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaController implements Initializable {
    
    private Cuestionario cuestionario;
    private cargadorVista cv;
    private int tipoCuestionario;
    private int instrumento, pregunta, puntaje;
    private LinkedList sintoma, trastorno;
    private menuController mc;
    private Test test;
    private int contadorPregunta;
    
    @FXML
    private TreeTableView<String> tablaRespuesta;
    
    @FXML
    private TreeTableColumn<String, String> columnaRespuesta;
    
    @FXML
    private BorderPane panelRight;
    
    @FXML
    private ProgressBar pbTEprogeso;
    
    @FXML
    private JFXRadioButton rbtnTEnunca;
    
    @FXML
    private ToggleGroup grupoPregunta;
    
    @FXML
    private JFXRadioButton rbtnTEoca;
    
    @FXML
    private JFXRadioButton rbtnTEavc;
    
    @FXML
    private JFXRadioButton rbtnTEcs;
    
    @FXML
    private JFXRadioButton rbtnTEsiempre;
    
    @FXML
    private JFXTextArea txtpregunta;
    
    @FXML
    private ImageView imgRegresar;
    
    @FXML
    private JFXButton regresar;
    
    @FXML
    private Label lblProgress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        rbtnTEnunca.setOnAction((event) -> {
            contestarPregunta(1);
        });
        rbtnTEoca.setOnAction((event) -> {
            contestarPregunta(2);
        });
        rbtnTEavc.setOnAction((event) -> {
            contestarPregunta(3);
        });
        rbtnTEcs.setOnAction((event) -> {
            contestarPregunta(4);
        });
        rbtnTEsiempre.setOnAction((event) -> {
            contestarPregunta(5);
        });
        cuestionario = new Cuestionario();
        TreeItem<String> itemRaiz = new TreeItem<>("RESPUESTAS");
        itemRaiz.setExpanded(true);
        tablaRespuesta.setRoot(itemRaiz);
        
        columnaRespuesta.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> param) -> {
            return new SimpleStringProperty(param.getValue().getValue());
        });
        
    }
    
    public void cargarPregunta(Pregunta p) {
        txtpregunta.setText(p.getId() + ".-" + p.getTexto());
        pregunta = p.getId();
        instrumento = test.getTipoCuestionario(pregunta);
        // int tipo=id.tipoCuestionario(pregunta);
        if (instrumento == 1) {
            rbtnTEavc.setVisible(true);
        } else {
            
            rbtnTEavc.setVisible(false);
        }
    }
    
    public int getTipoCuestionario() {
        return tipoCuestionario;
    }
    
    public void setTipoCuestionario(int tipoCuestionario) {
        this.tipoCuestionario = tipoCuestionario;
    }
    
    void setMc(menuController c) {
        mc = c;
    }
    
    void iniciarTest() {
        sintoma = new LinkedList();
        trastorno = new LinkedList();
        test = new Test(tipoCuestionario);
        cargarPregunta(test.getPregunta(test.getSigPregunta()));
        pbTEprogeso.setProgress(0.001);
    }
    
    public void registroPregunta(String t, String r) {
        
        TreeItem<String> itemPregunta = new TreeItem<>(t);
        TreeItem<String> itemRespuesta = new TreeItem<>(r);
        itemPregunta.getChildren().addAll(itemRespuesta);
        itemPregunta.setExpanded(true);
        tablaRespuesta.getRoot().getChildren().addAll(itemPregunta);
        
    }
    
    public void limpiarVista() {
        rbtnTEavc.setSelected(false);
        rbtnTEnunca.setSelected(false);
        rbtnTEcs.setSelected(false);
        rbtnTEoca.setSelected(false);
        rbtnTEsiempre.setSelected(false);
    }
    
    void contestarPregunta(int valor) {
        
        if (!test.cuestionarioCompletado()) {
            ThreadPregunta tp = new ThreadPregunta(3, rbtnTEcs, rbtnTEavc, rbtnTEnunca, rbtnTEoca, rbtnTEsiempre, regresar);
            tp.runClock();
            //AGREGAR A LA VISTA
            registroPregunta(txtpregunta.getText(), getRespuesta(valor));
            aumentarProgreso();
            limpiarVista();
            //SUMAR AL CUESTIONARIO 
            test.sumarContadorPregunta();
            sumarATrastorno();
            //TRAER NUEVA PREGUNTA

            cargarPregunta(test.getPregunta(test.getSigPregunta()));
        } else {
            cuestionario.getFinCuestionario();
            cuestionario.getDuracion();
            cv = new cargadorVista();
            TestEspecialistaFinalizadoController telp = (TestEspecialistaFinalizadoController) cv.cambiarVista("/Center/TestEspecialistaFinalizado.fxml", mc.getPanelPrin());
            telp.setCuestionario(cuestionario);
            telp.setMc(mc);
        }
    }
    
    String getRespuesta(int valor) {
        String resp;
        switch (valor) {
            case 1:
                resp = rbtnTEnunca.getText();
                puntaje = 1;
                break;
            case 2:
                resp = rbtnTEoca.getText();
                puntaje = 2;
                break;
            case 3:
                resp = rbtnTEavc.getText();
                puntaje = 3;
                break;
            case 4:
                resp = rbtnTEcs.getText();
                if (instrumento == 1) {
                    puntaje = 4;
                } else {
                    puntaje = 3;
                }
                break;
            case 5:
                resp = rbtnTEsiempre.getText();
                if (instrumento == 1) {
                    puntaje = 5;
                } else {
                    puntaje = 4;
                }
                break;
            
            default:
                resp = "";
            
        }
        return resp;
    }
    
    private void sumarATrastorno() {
        sintoma = test.getSintoma(pregunta);
        
        sintoma.forEach((sintomaLoop) -> {
            SintomaPregunta sp = (SintomaPregunta) sintomaLoop;
            int numeroSintoma = sp.getSintoma();
            trastorno = test.getTrastorno(numeroSintoma);
            trastorno.forEach((trastornoLoop) -> {
                TrastornoSintoma ts = (TrastornoSintoma) trastornoLoop;
                
                if (test.banderaLevantada(ts.getTrastorno())) {
                    System.out.println("YA SUMADO");
                } else {
                    test.levantarBandera(ts.getTrastorno());
                    System.out.println("/Instrumento:/" + instrumento + "/Sintoma/" + numeroSintoma + "/Trastorno/" + ts.getTrastorno()
                            + "/Pregunta:/" + pregunta + "/Valor:/" + puntaje);
                    cuestionario.calificarPregunta(instrumento, ts.getTrastorno(), puntaje);
                    cuestionario.agregarRespuesta(pregunta, puntaje);
                }
            });
        });
        test.reiniciarBanderas();
    }
    
    @FXML
    private void regresarPregunta(ActionEvent ae) {

//        if (contadorPreguntas > 1) {
//
//            cargarPregunta(test.getPregunta(contadorPreguntas - 1));
//            restarATrastorno();
//        } else {
//            CustomMessage cm = new CustomMessage("ERROR", "No hay pregunta Anterior...", 2);
//
//        }
    }
    
    public void restarATrastorno() {
//        sintoma = spd.buscarSintoma(pregunta);
        //      trastorno = tsd.buscarTrastorno(sintoma);
//        cuestionario.quitarPregunta(instrumento, trastorno, puntaje);
        //      contadorPreguntas--;
    }
    
    @FXML
    void regresarImg(MouseEvent event) {
//
//        if (contadorPreguntas > 1) {
//
//            cargarPregunta(test.getPregunta(contadorPreguntas - 1));
//            restarATrastorno();
//        } else {
//            CustomMessage cm = new CustomMessage("ERROR", "No hay pregunta Anterior...", 2);
//
//        }
    }
    
    private void aumentarProgreso() {
        DecimalFormat df2 = new DecimalFormat("#.##");
        System.out.println(test.getContadorPreguntas() + "//" + (test.getContadorPreguntas() * 100 / 6100));
        Double avance = test.getContadorPreguntas() * 0.0164;
        pbTEprogeso.setProgress(avance);
        Double porcentaje = avance * 100;
        lblProgress.setText(df2.format(porcentaje) + "%");
    }
}
