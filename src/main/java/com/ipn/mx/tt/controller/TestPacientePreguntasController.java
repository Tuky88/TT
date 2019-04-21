/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.CuestionarioPreguntaDAO;
import com.ipn.mx.tt.dao.PreguntaDAO;
import com.ipn.mx.tt.dao.SintomaPreguntaDAO;
import com.ipn.mx.tt.dao.TrastornoSintomaDAO;
import com.ipn.mx.tt.modelo.Cuestionario;
import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.modelo.Pregunta;
import com.ipn.mx.tt.modelo.SintomaPregunta;
import com.ipn.mx.tt.modelo.Test;
import com.ipn.mx.tt.modelo.TrastornoSintoma;
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.ThreadPregunta;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestPacientePreguntasController implements Initializable {

    private Paciente paciente;
    private Cuestionario cuestionario;
    private cargadorVista cv;
    private int tipoCuestionario;
    private int instrumento, pregunta, puntaje;
    private LinkedList sintoma, trastorno;
    private menuController mc;
    private Test test;
    private int contadorPreguntas;

    public menuController getMc() {
        return mc;
    }

    public void setMc(menuController mc) {
        this.mc = mc;
    }

    public int getTipoCuestionario() {
        return tipoCuestionario;
    }

    public void setTipoCuestionario(int tipoCuestionario) {
        this.tipoCuestionario = tipoCuestionario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @FXML
    private Label lblPaciente;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        rbtnTPnunca.setOnAction((event) -> {
            contestarPregunta(1);
        });
        rbtnTPoca.setOnAction((event) -> {
            contestarPregunta(2);
        });
        rbtnTPavc.setOnAction((event) -> {
            contestarPregunta(3);
        });
        rbtnTPcs.setOnAction((event) -> {
            contestarPregunta(4);
        });
        rbtnTPsiempre.setOnAction((event) -> {
            contestarPregunta(5);
        });
        contadorPreguntas = 1;
        cuestionario = new Cuestionario();
        
    }

    public void cargarPregunta(Pregunta p) {
        txtpregunta.setText(p.getId() + ".-" + p.getTexto());
        pregunta = p.getId();
        instrumento = test.getTipoCuestionario(pregunta);
        // int tipo=id.tipoCuestionario(pregunta);
        if (instrumento == 1) {
            rbtnTPavc.setVisible(true);
        } else {

            rbtnTPavc.setVisible(false);
        }
    }

    void iniciarTest() {
        sintoma = new LinkedList();
        trastorno = new LinkedList();
        test = new Test(tipoCuestionario);
        cargarPregunta(test.getPregunta(contadorPreguntas));
    }

    public void limpiarVista() {
        rbtnTPavc.setSelected(false);
        rbtnTPnunca.setSelected(false);
        rbtnTPcs.setSelected(false);
        rbtnTPoca.setSelected(false);
        rbtnTPsiempre.setSelected(false);
    }

    void contestarPregunta(int valor) {

        if (contadorPreguntas < 61) {
            ThreadPregunta tp = new ThreadPregunta(3, rbtnTPcs, rbtnTPavc, rbtnTPnunca, rbtnTPoca, rbtnTPsiempre);
            tp.runClock();
            //AGREGAR A LA VISTA
            getRespuesta(valor);
            limpiarVista();
            //SUMAR AL CUESTIONARIO 
            contadorPreguntas++;
            sumarATrastorno();
            //TRAER NUEVA PREGUNTA
            cargarPregunta(test.getPregunta(contadorPreguntas));
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
                resp = rbtnTPnunca.getText();
                puntaje = 1;
                break;
            case 2:
                resp = rbtnTPoca.getText();
                puntaje = 2;
                break;
            case 3:
                resp = rbtnTPavc.getText();
                puntaje = 3;
                break;
            case 4:
                resp = rbtnTPcs.getText();
                if (instrumento == 1) {
                    puntaje = 4;
                } else {
                    puntaje = 3;
                }
                break;
            case 5:
                resp = rbtnTPsiempre.getText();
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
        //      System.out.println("Sintomas:" + sintoma.size());
        //System.out.println(sintoma.toString());
        sintoma.forEach((sintomaLoop) -> {
            SintomaPregunta sp = (SintomaPregunta) sintomaLoop;
//            System.out.println(sp.toString());
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

        if (contadorPreguntas > 1) {

            cargarPregunta(test.getPregunta(contadorPreguntas - 1));
            restarATrastorno();
        } else {
            CustomMessage cm = new CustomMessage("ERROR", "No hay pregunta Anterior...", 2);

        }
    }

    public void restarATrastorno() {
//        sintoma = spd.buscarSintoma(pregunta);
        //      trastorno = tsd.buscarTrastorno(sintoma);
//        cuestionario.quitarPregunta(instrumento, trastorno, puntaje);
        //      contadorPreguntas--;
    }

    @FXML
    void regresarImg(MouseEvent event) {

        if (contadorPreguntas > 1) {

            cargarPregunta(test.getPregunta(contadorPreguntas - 1));
            restarATrastorno();
        } else {
            CustomMessage cm = new CustomMessage("ERROR", "No hay pregunta Anterior...", 2);

        }
    }

    public void ponerPaciente() {
        this.lblPaciente.setText(this.lblPaciente.getText() + " " + paciente.getNombre());
    }
}
