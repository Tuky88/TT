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
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaController implements Initializable {

    Cuestionario cuestionario;
    cargadorVista cv;
    int instrumento, pregunta, trastorno, sintoma, puntaje;
    PreguntaDAO pd;
    CuestionarioPreguntaDAO cd;
    SintomaPreguntaDAO spd;
    TrastornoSintomaDAO tsd;
    menuController mc;
  
    @FXML
    private GridPane gridPane;
    @FXML
    private ScrollBar sbTEpreguntas;

    @FXML
    private BorderPane panelRight;

    @FXML
    private JFXTextArea txtpregunta;

    @FXML
    private ProgressBar pbTEprogeso;

    @FXML
    private JFXRadioButton rbtnTEoca;

    @FXML
    private JFXRadioButton rbtnTEsiempre;

    @FXML
    private JFXRadioButton rbtnTEnunca;

    @FXML
    private JFXRadioButton rbtnTEavc;

    @FXML
    private JFXRadioButton rbtnTEcs;
    
    @FXML
    private ScrollPane scrollE;
    
 

    private int contadorPreguntas;

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
        contadorPreguntas = 1;
        cuestionario = new Cuestionario();

    }

    public void cargarPregunta(Pregunta p) {
        txtpregunta.setText(p.getId() + ".-" + p.getTexto());
        pregunta = p.getId();
        instrumento = cd.buscarCuestionario(pregunta);
        // int tipo=id.tipoCuestionario(pregunta);
        if (instrumento == 1) {
            rbtnTEavc.setVisible(true);
        } else {

            rbtnTEavc.setVisible(false);
        }
    }

    void setMc(menuController c) {
        mc = c;
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
        System.out.println("BANDERA");
        cargarPregunta(pd.getPregunta(contadorPreguntas));
    }

    public void registroPregunta(String t, String r) {
        GridPane p = new GridPane();
        Label preguntaL = new Label(t);
        Label respuesta = new Label(r);
        p.addRow(0, preguntaL);
        p.addRow(1, respuesta);
        int posicion = gridPane.impl_getRowCount();
        gridPane.addRow(posicion, p);
        scrollE.setContent(gridPane);
        scrollE.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollE.setPannable(true);

    }

    public void limpiarVista() {
        rbtnTEavc.setSelected(false);
        rbtnTEnunca.setSelected(false);
        rbtnTEcs.setSelected(false);
        rbtnTEoca.setSelected(false);
        rbtnTEsiempre.setSelected(false);
    }

    void contestarPregunta(int valor) {

        if (contadorPreguntas < 62) {
            //AGREGAR A LA VISTA
            registroPregunta(txtpregunta.getText(), getRespuesta(valor));
            limpiarVista();
            //SUMAR AL CUESTIONARIO 
            contadorPreguntas++;
            sumarATrastorno();
            //TRAER NUEVA PREGUNTA
            cargarPregunta(pd.getPregunta(contadorPreguntas));
        } else {
            cv = new cargadorVista();
            PrediagnosticoController pc = (PrediagnosticoController) cv.cambiarVista("/Center/Prediagnostico.fxml", mc.getPanelPrin());
            pc.setCuestionario(cuestionario);
            pc.cargarResultados();
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
                puntaje = 4;
                break;
            case 5:
                resp = rbtnTEsiempre.getText();
                puntaje = 5;
                break;

            default:
                resp = "";

        }
        return resp;
    }

    private void sumarATrastorno() {
        sintoma = spd.buscarSintoma(pregunta);
        trastorno = tsd.buscarTrastorno(sintoma);
        System.out.println("/Instrumento:/" + instrumento + "/Sintoma/" + sintoma + "/Trastorno/" + trastorno
                + "/Pregunta:/" + pregunta + "/Valor:/" + puntaje);
        cuestionario.calificarPregunta(instrumento, trastorno, puntaje);

    }
}
