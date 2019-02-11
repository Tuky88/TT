package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.UsuarioDAO;
import com.ipn.mx.tt.modelo.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FXMLController implements Initializable {

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
        UsuarioDAO udao=new UsuarioDAO();
        udao.insertarUsuario(new Usuario(txtUser.getText(), txtPass.getText()));
        lblStatus.setVisible(true);
        lblStatus.setText("----");
                txtPass.setText("");
                txtUser.setText("");
         
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(txtPass.getText() + "//" + txtUser.getText());
        if (txtUser.getText().equals("Axel") && txtPass.getText().equals("1234")) {
            lblStatus.setText("BIENVENIDO CABALLERO");
        } else {
            lblStatus.setVisible(true);
            lblStatus.setText("ERROR");
        }
    }

    @FXML
    private void handleButtonActionSound(ActionEvent event) {
        Media song = new Media(getClass().getResource("/sonidos/feel.mp3").toString());
        MediaPlayer media = new MediaPlayer(song);
        media.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblStatus.setVisible(false);
    }
}
