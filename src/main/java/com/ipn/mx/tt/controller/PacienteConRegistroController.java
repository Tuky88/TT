/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.controller;

import com.ipn.mx.tt.dao.PacienteDAO;
import com.ipn.mx.tt.modelo.Paciente;
import com.ipn.mx.tt.modelo.PacienteTabla;
import com.ipn.mx.tt.util.CustomMessage;
import com.ipn.mx.tt.util.Validador;
import com.ipn.mx.tt.util.cargadorVista;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.DBObject;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import java.util.List;
import javafx.event.ActionEvent;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 * FXML Controller class
 *
 * @author garci
 */
public class PacienteConRegistroController implements Initializable {

    Validador v;
    cargadorVista cv;
    menuController c;

    public menuController getC() {
        return c;
    }

    public void setC(menuController c) {
        this.c = c;
    }

    private List pacientes;
    @FXML
    private JFXButton btnPriniciar;

    @FXML
    private JFXTextField txtPrnombre;

    @FXML
    private TableView<PacienteTabla> tabla;
    @FXML
    private TableColumn<PacienteTabla, String> columnaCURP;

    @FXML
    private TableColumn<PacienteTabla, String> columnaNombre;

    @FXML
    private TableColumn<PacienteTabla, String> columnaEdad;
    private ObservableList<PacienteTabla> ol;

    @FXML
    void buscarPaciente(KeyEvent event) {
        String curp= toUpperCase(txtPrnombre.getText());
        
        String busqueda = v.validars(curp);
        if (busqueda.length() > 2) {
            ol.clear();
            LinkedList ls = new LinkedList();
            pacientes.forEach((l) -> {
                //TERMINO DE BUSQUEDA
                Paciente paciente = new Paciente((DBObject) l);
                if (paciente.getCURP().contains(busqueda)) {
                    ls.add(paciente);
                }
            });
            ls.forEach((termino) -> {
                //AÑADIR A LA VISTAs
                PacienteTabla pacienteTabla = new PacienteTabla((Paciente) termino);
                ol.add(pacienteTabla);
            });
        } else {
            ol.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        v = new Validador();
        cv = new cargadorVista();
        pacientes = new LinkedList();
        PacienteDAO pd = new PacienteDAO();
        pacientes = pd.buscarSimilar();
        ol = FXCollections.observableArrayList();

        columnaCURP.setCellValueFactory(cellData -> cellData.getValue().getCURP());
        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        columnaEdad.setCellValueFactory(cellData -> cellData.getValue().getEdad());
        tabla.setItems(ol);
    }

    @FXML
    void iniciarTest(ActionEvent event) {
        if (tabla.getSelectionModel().getSelectedItem() != null) {
            PacienteTabla pt = tabla.getSelectionModel().getSelectedItem();
            Paciente paciente = new Paciente(pt);
            ComenzarTestController ctc = (ComenzarTestController) cv.cambiarVista("/Center/ComenzarTest.fxml", c.getPanelPrin());
            ctc.setC(c);
            ctc.setPaciente(paciente);
            ctc.setDatosPaciente(true);
        } else {

            CustomMessage cm = new CustomMessage("Advertencia", "Seleccione un paciente", 0);
        }

    }

}
