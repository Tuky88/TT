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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    void cerrarSesion(ActionEvent event) {
        int resp = alertMessage.confirm(0, "¿Cerrar Sesión?", "Desea cerrar sesión");
        if (resp == 1) {
            mov.cambiarEscena(event, "Scene.fxml");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mov = new movEscena();
        alertMessage = new AlertMessage();
        runClock();
    }

    public void runClock() {

        boolean running = true;
        new Thread() {
            public void run() {
                long last = System.nanoTime();
                double delta = 0;
                double ns = 1000000000.0;
                while (running) {
                    long now = System.nanoTime();
                    delta += (now - last) / ns;
                    last = now;
                    while (delta >= 1) {

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy---HH:mm:ss");
                        LocalDateTime ahorita;
                        ahorita = LocalDateTime.now();
                        String fecha[] = dtf.format(ahorita).split("---");
                        lblFecha.setText(fecha[0]);
                        lblFecha.setText(fecha[1]);
                        delta--;
                    }
                }
            }
        }.start();

    }

}
