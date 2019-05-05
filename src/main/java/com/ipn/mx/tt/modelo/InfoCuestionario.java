/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

/**
 *
 * @author Axel Reyes
 */
public class InfoCuestionario {
    private Double idCuestionario;
    private Double status;
    private String paciente;
    private String Especialista;

    public InfoCuestionario(Double idCuestionario, Double status, String paciente, String Especialista) {
        this.idCuestionario = idCuestionario;
        this.status = status;
        this.paciente = paciente;
        this.Especialista = Especialista;
    }

    public Double getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Double idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEspecialista() {
        return Especialista;
    }

    public void setEspecialista(String Especialista) {
        this.Especialista = Especialista;
    }
    
    
    
}
