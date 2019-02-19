/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class AlertMessage {

    public int ALERT_MESSAGE = 0;
    public int ERROR_MESSAGE = 1;
    public int HELP_MESSAGE = 2;
    public int LADO = 30;
    public AlertMessage(int code, String Titulo, String Mensaje)
    {
        Alert(code, Titulo, Mensaje);
    }

    public void Alert(int code, String Titulo, String Mensaje) {
        String codigo;
        switch (code) {
            case 0:
                codigo = "advertencia.png";
                break;
            case 1:
                codigo = "error.png";
                break;
            case 2:
                codigo = "ayuda.png";
                break;
            default:
                codigo = "default.png";

        }
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Titulo);
        window.setMinWidth(400);
        window.setMinHeight(100);
        Label label = new Label(Mensaje);
        ImageView image = new ImageView("/iconos/" + codigo);
        image.setFitHeight(LADO);
        image.setFitWidth(LADO);
        Button b = new Button("Aceptar");
        b.setOnAction(e -> window.close());
        HBox layoutH = new HBox(10);
        VBox layoutV = new VBox(10);
        layoutH.getChildren().addAll(image, label);
        layoutV.getChildren().addAll(layoutH, b);
        layoutV.setAlignment(Pos.BOTTOM_RIGHT);
        layoutH.setAlignment(Pos.CENTER);
        b.setAlignment(Pos.BOTTOM_RIGHT);
        layoutH.setPadding(new Insets(5));
        layoutV.setPadding(new Insets(5));
        Image icon = new Image("/imagenes/brain.png");
        window.getIcons().add(icon);
        Scene scene = new Scene(layoutV);
        window.setScene(scene);
        window.showAndWait();

    }
}
