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
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.ThreadPregunta;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaController implements Initializable {

    Cuestionario cuestionario;
    cargadorVista cv;
    int instrumento, pregunta, puntaje;
    LinkedList sintoma, trastorno;
    PreguntaDAO pd;
    CuestionarioPreguntaDAO cd;
    SintomaPreguntaDAO spd;
    TrastornoSintomaDAO tsd;
    menuController mc;
    private int contadorPreguntas;

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
        sintoma = new LinkedList();
        trastorno = new LinkedList();
        cargarPregunta(pd.getPregunta(contadorPreguntas, 1));
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

        if (contadorPreguntas < 61) {
            ThreadPregunta tp = new ThreadPregunta(3, rbtnTEcs, rbtnTEavc, rbtnTEnunca, rbtnTEoca, rbtnTEsiempre, regresar);
            //tp.runClock();
            //AGREGAR A LA VISTA

            registroPregunta(txtpregunta.getText(), getRespuesta(valor));
            limpiarVista();
            //SUMAR AL CUESTIONARIO 
            contadorPreguntas++;
            sumarATrastorno();
            //TRAER NUEVA PREGUNTA
            cargarPregunta(pd.getPregunta(contadorPreguntas, 1));
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
        sintoma = spd.buscarSintoma(pregunta);

        int numeroSintoma = (int) sintoma.get(0);
        trastorno = tsd.buscarTrastorno(numeroSintoma);
        for (int j = 0; j < trastorno.size(); j++) {
            int numeroTrastorno = (int) trastorno.get(j);
            System.out.println("/Instrumento:/" + instrumento + "/Sintoma/" + numeroSintoma + "/Trastorno/" + numeroTrastorno
                    + "/Pregunta:/" + pregunta + "/Valor:/" + puntaje);
            cuestionario.calificarPregunta(instrumento, (int) numeroTrastorno, puntaje);
            cuestionario.agregarRespuesta(pregunta, puntaje);

        }

    }

    @FXML
    private void regresarPregunta(ActionEvent ae) {

        if (contadorPreguntas > 1) {

            cargarPregunta(pd.getPregunta(contadorPreguntas - 1, 1));
            restarATrastorno();
        } else {
            CustomMessage cm = new CustomMessage("ERROR", "No hay pregunta Anterior...", 2);

        }
    }

    public void restarATrastorno() {
        sintoma = spd.buscarSintoma(pregunta);
        //      trastorno = tsd.buscarTrastorno(sintoma);
//        cuestionario.quitarPregunta(instrumento, trastorno, puntaje);
        contadorPreguntas--;
    }

    @FXML
    void regresarImg(MouseEvent event) {

        if (contadorPreguntas > 1) {

            cargarPregunta(pd.getPregunta(contadorPreguntas - 1, 1));
            restarATrastorno();
        } else {
            CustomMessage cm = new CustomMessage("ERROR", "No hay pregunta Anterior...", 2);

        }
    }
}
