/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.util.AlertMessage;
import com.ipn.mx.tt.util.movEscena;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
                int i = 0;
                while (true) {
                    final int finalI = i;
                    Platform.runLater(() -> {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        String[] date = dtf.format(now).split("-");
                        lblHora.setText(date[1]);
                        lblFecha.setText(date[0]);
                    });
                    i++;
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

}
