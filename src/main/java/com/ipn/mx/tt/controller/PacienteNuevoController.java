/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.PacienteDAO;
import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.Validador;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteNuevoController implements Initializable {

    menuController c;
    Validador validador;

    public menuController getC() {
        return c;
    }

    public void setC(menuController c) {
        this.c = c;
    }
    @FXML
    private JFXTextField txtPnCURP;
    @FXML
    private JFXButton btnPnregistrar;

    @FXML
    private JFXTextField txtPnnombre;

    @FXML
    private AnchorPane panelP;
    @FXML
    private JFXTextField txtPnapellido;

    @FXML
    private JFXTextField txtPncorreo;

    @FXML
    private JFXTextField txtPndireccion;

    @FXML
    private JFXTextField txtPntelefono;

    @FXML
    private JFXRadioButton rbPfemenino;

    @FXML
    private JFXRadioButton rbPmasculino;

    @FXML
    private JFXDatePicker datePn;

    /**
     * Initializes the controller class.
     */
    cargadorVista cv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        validador = new Validador();
        cv = new cargadorVista();
        // TODO
    }

    public void hacerCuestionario(Paciente p) {
        ComenzarTestController ctc = (ComenzarTestController) cv.cambiarVista("/Center/ComenzarTest.fxml", c.getPanelPrin());
        ctc.setC(c);
        ctc.setPaciente(p);
        ctc.setDatosPaciente(true);
        
        

    }

    void registrarPaciente(Paciente p) {
        PacienteDAO pd = new PacienteDAO();
        pd.insertarPaciente(p);
    }

    @FXML
    void registrarPaciente(ActionEvent event) {

        String Nombre = validador.validarTF(txtPnnombre),
                Apellido = validador.validarTF(txtPnapellido),
                Sexo,
                Correo = validador.validarTF(txtPncorreo),
                Fecha = validador.validarDP(datePn),
                Direccion = validador.validarTF(txtPndireccion),
                Telefono = validador.validarTF(txtPntelefono),
                CURP = validador.validarTF(txtPnCURP);
        if (rbPfemenino.isSelected()) {
            Sexo = "F";
        } else {
            Sexo = "M";
        }
        if (!Nombre.equals("") && !Apellido.equals("") && !CURP.equals("") && !Correo.equals("") && !Fecha.equals("")
                && !Direccion.equals("") && !Telefono.equals("")) {

            Paciente p = new Paciente(Nombre, Apellido, Sexo, Correo, Fecha, Direccion, Telefono, CURP);
             registrarPaciente(p);
            CustomMessage cm = new CustomMessage("MENSAJE", "Registrado con éxito", 2);
            CustomMessage cm1 = new CustomMessage("MENSAJE", "¿Desea realizar el Cuestionario?", 4);

            if (cm1.getMessage().getButtonData().equals(ButtonType.OK.getButtonData())) {
                
                hacerCuestionario(p);
            } else {
                CustomMessage cm2 = new CustomMessage("MENSAJE", "El cuestionario se guardó para más tarde", 2);
            }

        } else {
            CustomMessage cm = new CustomMessage("ERROR", "Hubo un error en alguno de los campos...", 2);

        }
        
    }

}
