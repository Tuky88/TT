/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.UsuarioDAO;
import com.ipn.mx.tt.modelo.Usuario;
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.Validador;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class AñadirEspecialistaController implements Initializable {

    private Validador v;
    private UsuarioDAO ud;
    @FXML
    private JFXButton btnCacguardar;

    @FXML
    private JFXTextField txtCanombre;

    @FXML
    private JFXTextField txtCaapellido;

    @FXML
    private JFXPasswordField txtCapass;

    @FXML
    private JFXPasswordField txtCarpass;

    @FXML
    private JFXTextField txtCausuario;

    @FXML
    private JFXTextField txtCacorreo;

    @FXML
    private JFXTextField txtCanoempleado;
    @FXML
    private JFXTextField txtAtelefono;

    @FXML
    private JFXTextField txtAhorario;

    @FXML
    private JFXComboBox<?> cbxpregunta;

    @FXML
    private JFXTextField txtrespuesta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        v = new Validador();
        ud=new UsuarioDAO();
    }

    @FXML
    void cargarUsuario(ActionEvent event) {
        Usuario u;
        String c1 = txtCapass.getText(), cc = txtCarpass.getText();
        if (c1.equals(cc)) {
            String nombre = v.validarTF(txtCanombre);
            String apellido = v.validarTF(txtCaapellido);
            String usuario = v.validarTF(txtCausuario);
            String correo = v.validarTF(txtCacorreo);
            String telefono = v.validarTF(txtAtelefono);
            String horario = v.validarTF(txtCanombre);
            Double num = Double.valueOf(txtCanoempleado.getText());
            if (nombre.length() > 3 && apellido.length() > 3
                    && usuario.length() > 3 && correo.length() > 3
                    && (num != 0.0 && num.toString().length() > 3)
                    && horario.length() > 3 && telefono.length() > 3) {
                u = new Usuario(usuario, cc, nombre, apellido, correo, num, telefono, horario);
                ud.insertarUsuario(u);
                CustomMessage cm = new CustomMessage("CARGADO CON ÉXITO", "El usuario se agregó correctamente.", 1);
            } else {
                CustomMessage cm = new CustomMessage("AVISO", "Los campos no pueden estar vacíos", 2);
            }
        } else {
            CustomMessage cm = new CustomMessage("ERROR", "Las contraseñas no coinciden", 2);
        }

    }
}
