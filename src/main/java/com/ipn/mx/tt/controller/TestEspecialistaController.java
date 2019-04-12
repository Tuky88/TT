/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.PreguntaDAO;
import com.ipn.mx.tt.modelo.Pregunta;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class TestEspecialistaController implements Initializable {

    PreguntaDAO pd;
    menuController mc;
  
    @FXML
    private GridPane  gridPane;
    @FXML
    private ScrollBar sbTEpreguntas;

    @FXML
    private BorderPane panelRight;

    @FXML
    private JFXTextArea txtpregunta;

    @FXML
    private ProgressBar pbTEprogeso;

    @FXML
    private JFXButton btnTEsiguiente;

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
        contadorPreguntas=1;
        
    }

    public void cargarPregunta(Pregunta p) {
        txtpregunta.setText(p.getId() + ".-" + p.getTexto());
    }

    void setMc(menuController c) {
        mc = c;
    }

    void iniciarTest() {
        pd = new PreguntaDAO();
        pd.cjm.conectar();
        cargarPregunta(pd.getPregunta(contadorPreguntas));
    }

    public void registroPregunta(String t, String r) {
        GridPane p = new GridPane();
        TextArea pregunta = new TextArea(t);
        Label respuesta = new Label(r);
        pregunta.setWrapText(true);
        p.addRow(0, pregunta);
        p.addRow(1, respuesta);
       int posicion=gridPane.impl_getRowCount();
        gridPane.addRow(posicion, p);
        scrollE.setContent(gridPane);
        scrollE.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollE.setPannable(true);

    }

    void contestarPregunta(int valor) {

        //AGREGAR A LA VISTA
        registroPregunta(txtpregunta.getText(),getRespuesta(valor));
        //SUMAR AL CUESTIONARIO 
        contadorPreguntas++;
        //TRAER NUEVA PREGUNTA
        cargarPregunta(pd.getPregunta(contadorPreguntas));
    }
    
    String getRespuesta(int valor)
    {
                String resp;
        switch (valor) {
            case 1:
                resp = rbtnTEnunca.getText();
                break;
            case 2:
                resp = rbtnTEoca.getText();
                break;
            case 3:
                resp = rbtnTEavc.getText();
                break;
            case 4:
                resp = rbtnTEcs.getText();
                break;
            case 5:
                resp = rbtnTEsiempre.getText();
                break;

            default:
                resp = "";

        }
        return resp;
    }
}
