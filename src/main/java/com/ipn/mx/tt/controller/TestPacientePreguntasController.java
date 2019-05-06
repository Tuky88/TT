/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.InfoCuestionario;
import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.modelo.Pregunta;
import com.ipn.mx.tt.modelo.SintomaPregunta;
import com.ipn.mx.tt.modelo.Test;
import com.ipn.mx.tt.modelo.TrastornoSintoma;
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
public class TestPacientePreguntasController implements Initializable {

    private InfoCuestionario ic;
    private cargadorVista cv;
    private int tipoCuestionario;
    private int instrumento, pregunta, puntaje;
    private LinkedList sintoma, trastorno, preguntas;
    private menuController mc;
    private Test test;
    private int contadorPregunta;
    private Paciente paciente;

    @FXML
    private BorderPane panelRight;

//    @FXML
//    private ProgressBar pbTPprogeso;
    @FXML
    private JFXRadioButton rbtnTPnunca;

    @FXML
    private ToggleGroup grupoPregunta;

    @FXML
    private JFXRadioButton rbtnTPoca;

    @FXML
    private JFXRadioButton rbtnTPavc;

    @FXML
    private JFXRadioButton rbtnTPcs;

    @FXML
    private JFXRadioButton rbtnTPsiempre;

    @FXML
    private JFXTextArea txtpregunta;

    @FXML
    private ImageView imgRegresar;

    @FXML
    private JFXButton regresar;

    @FXML
    private Label lblProgress;
    @FXML
    private Label lblPaciente;

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
        contadorPregunta = 1;

    }

    public InfoCuestionario getIc() {
        return ic;
    }

    public void setIc(InfoCuestionario ic) {
        this.ic = ic;
    }

    public void cargarPregunta(Pregunta p) {

        if (p.getId() > 0 && p.getId() != 99) {
            txtpregunta.setText("(" + p.getId() + ")" + contadorPregunta + ".-" + p.getTexto());
            pregunta = p.getId();
            instrumento = test.getTipoCuestionario(pregunta);
            // int tipo=id.tipoCuestionario(pregunta);
            if (instrumento == 1) {
                rbtnTPavc.setVisible(true);
            } else {

                rbtnTPavc.setVisible(false);
            }
            contadorPregunta++;
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
        //pbTPprogeso.setProgress(0.001);
    }

    public void limpiarVista() {
        rbtnTPavc.setSelected(false);
        rbtnTPnunca.setSelected(false);
        rbtnTPcs.setSelected(false);
        rbtnTPoca.setSelected(false);
        rbtnTPsiempre.setSelected(false);
    }

    void contestarPregunta(int valor) {

        if (!test.cuestionarioCompletado()) {
            ThreadPregunta tp = new ThreadPregunta(3, rbtnTPcs, rbtnTPavc, rbtnTPnunca, rbtnTPoca, rbtnTPsiempre, regresar);
            //tp.runClock();
            //AGREGAR A LA VISTA
            getRespuesta(valor);
            limpiarVista();
            //SUMAR AL CUESTIONARIO 
            sumarATrastorno();
            //TRAER NUEVA PREGUNTA

            cargarPregunta(test.getPregunta(test.getSigPregunta()));
        }
        if (test.cuestionarioCompletado()) {
            test.getFinCuestionario();
            test.getDuracion();
            cv = new cargadorVista();
            TestEspecialistaFinalizadoController telp
                    = (TestEspecialistaFinalizadoController) cv.cambiarVista("/Center/TestEspecialistaFinalizado.fxml", mc.getPanelPrin());
            telp.setMc(mc);
            telp.setIc(ic);
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

    public void sumarAPregunta(int preguntaContestada, Double valor) {
        sintoma = test.getSintoma(preguntaContestada);
        sintoma.forEach((sintomaLoop) -> {
            SintomaPregunta sp = (SintomaPregunta) sintomaLoop;
            int numeroSintoma = sp.getSintoma();
            trastorno = test.getTrastorno(numeroSintoma);
            trastorno.forEach((trastornoLoop) -> {
                TrastornoSintoma ts = (TrastornoSintoma) trastornoLoop;

                if (test.banderaLevantada(ts.getTrastorno())) {
                    //System.out.println("YA SUMADO:" + preguntaC);
                } else {
                    if ((!test.respuestaContestada(preguntaContestada))
                            || ((test.respuestaContestada(preguntaContestada)) && (preguntaContestada == 16 || preguntaContestada == 17))) {
                        test.levantarBandera(ts.getTrastorno());
                        System.out.println("/Instrumento:/" + instrumento + "/Sintoma/" + numeroSintoma + "/Trastorno/" + ts.getTrastorno()
                                + "/Pregunta:/" + preguntaContestada + "/Valor:/" + valor);
                        test.calificarPregunta(instrumento, ts.getTrastorno(), valor);
                        test.agregarRespuesta(preguntaContestada, valor.intValue());
                        //aumentarProgreso();
                    }
                }
            });
        });
        test.reiniciarBanderas();
    }

    private void sumarATrastorno() {

        sumarAPregunta(pregunta, new Double(puntaje));
        preguntas = test.obtenerEquivalente(pregunta);
        if (preguntas.size() > 0) {
            System.out.println("EQUIVALENCIA ENCONTRADA: " + preguntas.size());
        }
        preguntas.forEach((preguntaLoop) -> {
            int preguntaC = (int) preguntaLoop;

            sumarAPregunta(preguntaC, test.puntajeEquivalente( test.getTipoCuestionario(pregunta),
                    test.getTipoCuestionario(preguntaC), new Double(puntaje)));
        });
        test.sumarContadorPregunta();
        //System.out.println(preguntas.size());

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

//    private void aumentarProgreso() {
//        DecimalFormat df2 = new DecimalFormat("#.##");
//        Double avance = test.getContadorPreguntas() * 0.01449;
//        pbTPprogeso.setProgress(avance);
//        Double porcentaje = avance * 100;
//        lblProgress.setText(df2.format(porcentaje) + "%");
//    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    void ponerPaciente() {
        this.lblPaciente.setText(this.lblPaciente.getText() + " " + paciente.getNombre());
    }
}
