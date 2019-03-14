/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.util.AlertMessage;
import com.ipn.mx.tt.util.movEscena;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class menuController implements Initializable {

    movEscena mov;
    AlertMessage alertMessage;

    @FXML
    private TabPane tbdMenu;
    @FXML
    private Pane panelLeft;
    @FXML
    private Button btncuenta;
    @FXML
    private Button btnaespecialista;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private BorderPane PanelPrin;
    @FXML
    private Label lblHora;

    @FXML
    private Label lblFecha;

    @FXML
    private TextField txtCnombre;

    @FXML
    private TextField txtCapellido;

    @FXML
    private TextField txtCcorreo;

    @FXML
    private TextField txtCusuario;

    @FXML
    private Button btnCambiarcontra;

    @FXML
    private Button btnCguardar;
    @FXML
    private TextField txtTnombre;

    @FXML
    private TextField txtTapellido;

    @FXML
    private TextField txtTfecha;

    @FXML
    private TextField txtTtelefono;

    @FXML
    private RadioButton rbtnTMasculino;

    @FXML
    private RadioButton rbtnTFemenino;

    @FXML
    private Button btnTguardar;

    @FXML
    private TextField txtPnombre;

    @FXML
    private TableView<?> tblPpre;

    @FXML
    private Button btnPver;
    @FXML
    private Pane panelPrin;

    @FXML
    void cerrarSesion(Event event) {
        int resp = alertMessage.confirm(0, "¿Cerrar Sesión?", "Desea cerrar sesión");
        if (resp == 1) {
            mov.cambiarEscena(event, "Login.fxml");
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mov = new movEscena();
        alertMessage = new AlertMessage();
        tbdMenu.getSelectionModel().select(1);
        runClock();
    }

    public void runClock() {
        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                while (true) {

                    Platform.runLater(() -> {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        String[] date = dtf.format(now).split("-");
                        lblHora.setText(date[1]);
                        lblFecha.setText(date[0]);
                    });
                    Thread.sleep(1000);
                }
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    @FXML
    void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cerrarSesion(event);
        } else {
        }
    }

    @FXML
    void cambiarMenu(ActionEvent event) {
        cambiarMenu(event, "AñadirEspecialista.fxml");
    }

    public void cambiarMenu(Event e, String menu) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/" + menu));
        } catch (IOException ex) {
            Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PanelPrin.setCenter(root);
    }
}
