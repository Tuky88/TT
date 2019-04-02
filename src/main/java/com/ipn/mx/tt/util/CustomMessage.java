/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Axel Reyes
 */
public class CustomMessage {

    Alert am;
    String texto;
    String titulo;
    int tipo;

    Image icon = new Image("/imagenes/brain.png");

    public CustomMessage(String titulo,String texto, int tipo) {
        this.texto = texto;
        this.tipo = tipo;
        this.titulo=titulo;
        switch (this.tipo) {
            case 0:
                //Mensaje
                am = new Alert(Alert.AlertType.NONE, texto, ButtonType.OK);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:

        }
        Stage s = (Stage) am.getDialogPane().getScene().getWindow();
        s.getIcons().add(icon);
        am.setTitle(titulo);
        am.show();

    }
}
