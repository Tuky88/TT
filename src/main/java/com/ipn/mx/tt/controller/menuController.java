/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.Usuario;
import com.ipn.mx.tt.util.movEscena;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


/**
 * FXML Controller class
 *
 * @author User
 */
public class menuController implements Initializable {

    movEscena mov;
    Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String val;
    @FXML
    private Tab TabInicio;

    @FXML
    private JFXButton btnCerrarSesion;
    @FXML
    private BorderPane PanelPrin;
    @FXML
    private Label lblHora;

    @FXML
    private Label lblFecha;

    @FXML
    private Tab TabConfig;

    @FXML
    private Tab TabTest;

    @FXML
    private Tab TabPrediagnostico;

    @FXML
    private Tab TabReporte;

    @FXML
    private Tab TabAyuda;

    @FXML
    private Tab TabAcerca;

    @FXML
    void cerrarSesion(Event event) {
        int resp =1; //alertMessage.confirm(0, "¿Cerrar Sesión?", "Desea cerrar sesión");
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

//        alertMessage = new AlertMessage();
        runClock();
        cambiarMenu("/Center/Inicio.fxml", 2);

        TabInicio.setOnSelectionChanged((Event event) -> {
            cambiarMenu("/Center/Inicio.fxml", 2);
        });
        TabConfig.setOnSelectionChanged((Event event) -> {
            ConfiguracionesController cc=(ConfiguracionesController)
                    cambiarMenu("/Center/Configuraciones.fxml", 0);
            cc.setUsuario(usuario);
            System.out.println(usuario.toString());
            
        });
        TabTest.setOnSelectionChanged((Event event) -> {
            cambiarMenu("/Center/Test.fxml", 0);
        });
        TabReporte.setOnSelectionChanged((Event event) -> {
            cambiarMenu("/Center/Reportes.fxml", 0);
        });
        TabPrediagnostico.setOnSelectionChanged((Event event) -> {
            cambiarMenu("/Center/Prediagnosticos.fxml", 0);
        });
        TabAcerca.setOnSelectionChanged((Event event) -> {
            cambiarMenu("/Center/Prediagnosticos.fxml", 99);
        });
        TabAyuda.setOnSelectionChanged((Event event) -> {
            cambiarMenu("/Center/Prediagnosticos.fxml", 99);
        });
        
    }

    public void imprimir() {
        System.out.println("oifodsjflksjdl");
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

    public Object cambiarMenu(String menu, int tipo) {
        Object o = null;
        if (tipo == 99) {
            PanelPrin.setLeft(null);
        } else {
            Parent root = null;
            FXMLLoader fx=new FXMLLoader(getClass().getResource(menu));
            try {
                
                root = fx.load();
                o=fx.getController();
            } catch (IOException ex) {
                Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tipo == 1) {
                PanelPrin.setCenter(root);
            }
            if (tipo == 2) {
                PanelPrin.setCenter(root);
                PanelPrin.setLeft(null);
            } else {
                PanelPrin.setLeft(root);
            }

        }
        return o;
    }

    public void abrirMenu(String menu) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(menu));
            PanelPrin.setCenter(root);

        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cambiarTexto() {
        btnCerrarSesion.setText("TE VEO PRRO");
    }
}
