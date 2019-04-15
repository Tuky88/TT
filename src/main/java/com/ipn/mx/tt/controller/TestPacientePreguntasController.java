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
import com.ipn.mx.tt.modelo.Pregunta;
import com.ipn.mx.tt.util.ThreadPregunta;
import com.ipn.mx.tt.util.cargadorVista;
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

    Cuestionario cuestionario;
    cargadorVista cv;
    int instrumento, pregunta, trastorno, sintoma, puntaje;
    int tipoCuestionario;
    PreguntaDAO pd;
    CuestionarioPreguntaDAO cd;
    SintomaPreguntaDAO spd;
    TrastornoSintomaDAO tsd;
    menuController mc;
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
        instrumento = cd.buscarCuestionario(pregunta);
        // int tipo=id.tipoCuestionario(pregunta);
        if (instrumento == 1) {
            rbtnTPavc.setVisible(true);
        } else {

            rbtnTPavc.setVisible(false);
        }
    }

    void iniciarTest() {
        pd = new PreguntaDAO();
        cd = new CuestionarioPreguntaDAO();
        spd = new SintomaPreguntaDAO();
        tsd = new TrastornoSintomaDAO();
        cd.conectar();
        pd.conectar();
        spd.conectar();
        tsd.conectar();
        cargarPregunta(pd.getPregunta(contadorPreguntas,getTipoCuestionario()));
    }

    void contestarPregunta(int valor) {

        if (contadorPreguntas < 61) {
            ThreadPregunta tp = new ThreadPregunta(5, rbtnTPavc, rbtnTPcs, rbtnTPnunca, rbtnTPoca, rbtnTPsiempre);
            tp.runClock();
            //AGREGAR A LA VISTA
            limpiarVista();
            //SUMAR AL CUESTIONARIO 
            getRespuesta(valor);
            contadorPreguntas++;
            sumarATrastorno();
            //TRAER NUEVA PREGUNTA
            cargarPregunta(pd.getPregunta(contadorPreguntas,getTipoCuestionario()));
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
                puntaje = 4;
                break;
            case 5:
                resp = rbtnTPsiempre.getText();
                puntaje = 5;
                break;

            default:
                resp = "";

        }
        return resp;
    }

    public void limpiarVista() {
        rbtnTPavc.setSelected(false);
        rbtnTPnunca.setSelected(false);
        rbtnTPcs.setSelected(false);
        rbtnTPoca.setSelected(false);
        rbtnTPsiempre.setSelected(false);
    }

    private void sumarATrastorno() {
        sintoma = spd.buscarSintoma(pregunta);
        trastorno = tsd.buscarTrastorno(sintoma);
        System.out.println("/Instrumento:/" + instrumento + "/Sintoma/" + sintoma + "/Trastorno/" + trastorno
                + "/Pregunta:/" + pregunta + "/Valor:/" + puntaje);
        cuestionario.calificarPregunta(instrumento, trastorno, puntaje);
        cuestionario.agregarRespuesta(pregunta, puntaje);

    }
}
