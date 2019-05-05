/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.CuestionarioAplicadoDAO;
import com.ipn.mx.tt.dao.PacienteDAO;
import com.ipn.mx.tt.modelo.InfoCuestionario;
import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.Validador;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteNuevoController implements Initializable {

    private CuestionarioAplicadoDAO cad;
    menuController c;
    Validador validador;
    @FXML
    private ToggleGroup grupoPregunta;
    @FXML
    private ToggleGroup grupoPregunta1;
    @FXML
    private ToggleGroup grupoPregunta11;
    @FXML
    private ToggleGroup grupoPregunta112;
    @FXML
    private ToggleGroup grupoPregunta1111;
    @FXML
    private ToggleGroup grupoPregunta111;
    @FXML
    private JFXButton btnPnguardar;

    public menuController getC() {
        return c;
    }

    public void setC(menuController c) {
        this.c = c;
    }

    @FXML
    private AnchorPane panelP;

    @FXML
    private JFXTextField txtPnCURP;

    @FXML
    private JFXTextField txtPnnombre;

    @FXML
    private JFXTextField txtPnapellido;

    @FXML
    private JFXRadioButton rbPfemenino;

    @FXML
    private JFXRadioButton rbPmasculino;

    @FXML
    private JFXTextField txtPncorreo;

    @FXML
    private JFXDatePicker datePn;

    @FXML
    private JFXTextField txtPndireccion;

    @FXML
    private JFXTextField txtPntelefono;

    @FXML
    private JFXButton btnPnregistrar;

    @FXML
    private JFXTextField txtPnesco;

    @FXML
    private JFXTextField txtPhorario;

    @FXML
    private JFXTextField txtPhorasl;

    @FXML
    private JFXTextField txtPhorasd;

    @FXML
    private JFXRadioButton rbPtrabajan;

    @FXML
    private JFXRadioButton rbPtrabajas;

    @FXML
    private JFXRadioButton rbPhorarioturnos;

    @FXML
    private JFXRadioButton rbPhorariof;

    @FXML
    private JFXRadioButton rbPls;

    @FXML
    private JFXTextField txtPdescansos;

    @FXML
    private JFXRadioButton rbPlv;

    @FXML
    private Spinner<Integer> spnhoras;

    @FXML
    private JFXButton btnPnsiguiente;

    @FXML
    private JFXRadioButton rbPhorarionof;

    /**
     * Initializes the controller class.
     */
    cargadorVista cv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        validador = new Validador();
        cv = new cargadorVista();
        cad = new CuestionarioAplicadoDAO();
        cad.conectar();
        // TODO
    }

    public void hacerCuestionario(Paciente p,InfoCuestionario i) {
        ComenzarTestController ctc = (ComenzarTestController) cv.cambiarVista("/Center/ComenzarTest.fxml", c.getPanelPrin());
        ctc.setC(c);
        ctc.setPaciente(p);
        ctc.setDatosPaciente(true);
        ctc.setIc(i);

    }

    void registrarPaciente(Paciente p) {
        PacienteDAO pd = new PacienteDAO();
        pd.insertarPaciente(p);
    }

    @FXML
    void peciente(ActionEvent event) {

        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource("/Center/PacienteNuevo2.fxml"));
            AnchorPane ap = fx.load();
            panelP.getChildren().setAll(ap);
        } catch (IOException ex) {
            Logger.getLogger(PacienteNuevoController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

            System.out.println(c.getUsuario().toString());
            InfoCuestionario ic = new InfoCuestionario(cad.buscarSiguiente() + 1, 0.0, CURP, c.getUsuario().getId());
            cad.insertarInfoCuestionario(ic);
            registrarPaciente(p);
            CustomMessage cm = new CustomMessage("MENSAJE", "Registrado con éxito", 2);
            CustomMessage cm1 = new CustomMessage("MENSAJE", "¿Desea realizar el Cuestionario?", 4);

            if (cm1.getMessage().getButtonData().equals(ButtonType.OK.getButtonData())) {

                hacerCuestionario(p,ic);
            } else {
                CustomMessage cm2 = new CustomMessage("MENSAJE", "El cuestionario se guardó para más tarde", 2);
            }

        } else {
            System.out.println(cad.buscarSiguiente());
            //CustomMessage cm = new CustomMessage("ERROR", "Hubo un error en alguno de los campos...", 2);

        }

    }

    public void configurarObjetos() {

        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 23, 7, 1);
        spnhoras.setValueFactory(svf);
    }

}
