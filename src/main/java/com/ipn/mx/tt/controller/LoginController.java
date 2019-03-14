package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.UsuarioDAO;
import com.ipn.mx.tt.modelo.Usuario;
import com.ipn.mx.tt.util.AlertMessage;
import com.ipn.mx.tt.util.movEscena;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LoginController implements Initializable {

    movEscena mov;
    AlertMessage alertMessage;

    
    @FXML
    private Button btnAcceder;

    @FXML
    private TextField txtUser;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtPass;

    @FXML
    private Button btnEjemplo;

    @FXML
    void btnActionPrueba(ActionEvent event) {
//        UsuarioDAO udao = new UsuarioDAO();
//        udao.insertarUsuario(new Usuario(txtUser.getText(), txtPass.getText()));
        lblStatus.setVisible(true);
        lblStatus.setText("----");
        txtPass.setText("");
        txtUser.setText("");
    }

    public void iniciarSesion(Event e) {
        UsuarioDAO udao = new UsuarioDAO();
        Usuario user;
        if (txtPass.getText().length() > 0 && txtUser.getText().length() > 0) {

            user = udao.buscarUsuario(txtUser.getText());
            if (user.getContraseña().equals(txtPass.getText())) {
                lblStatus.setText("BIENVENIDO");
                mov.cambiarEscena(e, "Menu.fxml");

                alertMessage.alert(0, "BIENVENIDO AL SISTEMA", "BIENVENIDO: " + user.getId());
            } else {
                lblStatus.setText("inBIENVENIDO");

            }
        } else {
            alertMessage.alert(0, "ERROR", "LOS CAMPOS NO PUEDEN ESTAR VACIOS");
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        iniciarSesion(event);
    }

    @FXML
    private void handleButtonActionSound(ActionEvent event) {
        Media song = new Media(getClass().getResource("/sonidos/feel.mp3").toString());
        MediaPlayer media = new MediaPlayer(song);
        media.play();
    }

    @FXML
    private void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            iniciarSesion(event);
        } else {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // lblStatus.setVisible(false);
        mov = new movEscena();
        alertMessage = new AlertMessage();
        txtPass.getStyleClass().setAll("btn", "btn-primary");
    }

    @FXML
    void irMenuRecuperarContra(MouseEvent event) {
        mov.cambiarEscena(event,"Recuperarcontra.fxml");
    }

}
