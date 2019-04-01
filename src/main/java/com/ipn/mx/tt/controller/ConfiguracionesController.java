/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.modelo.Usuario;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class ConfiguracionesController implements Initializable {

    private Usuario usuario;
    @FXML
    private Pane panelLeft;

  @FXML
    private JFXButton btnCcuenta;

    @FXML
    private JFXButton btnCañadir;
   
     @FXML
    private BorderPane panelRight;

    @FXML
    void abrirCuenta(ActionEvent event) {
        CuentaEspecialistaController cec=(CuentaEspecialistaController)
                abrirMenu("/Center/CuentaEspecialista.fxml");
        System.out.println(usuario.toString());
        cec.colocarDatos(usuario);
        
        
    }
        @FXML
    void abrirEspecialista(ActionEvent event) {
        abrirMenu("/Center/AñadirEspecialista.fxml");
    }

    public Object abrirMenu(String menu) {
        Object o=null;
        try {
            FXMLLoader fx=new FXMLLoader(getClass().getResource(menu));
            Parent root = fx.load();
            o=fx.getController();
            panelRight.setCenter(root);

        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }
    public void setUsuario(Usuario u)
    {
        this.usuario=u;
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
