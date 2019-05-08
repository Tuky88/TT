/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

/**
 *
 * @author Temp
 */
public class Conducta {

    private boolean trabaja;
    private Double horarioTrabajo;
    private Double jornadaLaboral;
    private Double diasDeDescanso;
    private Double promedioHoras;
    private Double promedioHorasLaborales;
    private Double horasDeTrabajo;
    private Double promedioHorasDescanso;

    public Conducta(Double horas) {
        trabaja = false;
        horarioTrabajo = 0.0;
        jornadaLaboral = 0.0;
        diasDeDescanso = 7.0;
        promedioHorasLaborales = 0.0;
        horasDeTrabajo = 0.0;
        promedioHoras = horas;
        promedioHorasDescanso = 0.0;
    }

    public Conducta(Double horarioTrabajo, Double jornadaLaboral, Double diasDeDescanso, Double promedioHoras, Double promedioHorasLaborales, Double horasDeTrabajo, Double promedioHorasDescanso) {
        this.trabaja = true;
        this.horarioTrabajo = horarioTrabajo;
        this.jornadaLaboral = jornadaLaboral;
        this.diasDeDescanso = diasDeDescanso;
        this.promedioHoras = promedioHoras;
        this.promedioHorasLaborales = promedioHorasLaborales;
        this.horasDeTrabajo = horasDeTrabajo;
        this.promedioHorasDescanso = promedioHorasDescanso;
    }

    public Double getPromedioHoras() {
        return promedioHoras;
    }

    public void setPromedioHoras(Double promedioHoras) {
        this.promedioHoras = promedioHoras;
    }

    public boolean isTrabaja() {
        return trabaja;
    }

    public void setTrabaja(boolean trabaja) {
        this.trabaja = trabaja;
    }

    public Double getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(Double horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    public Double getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral(Double jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public Double getDiasDeDescanso() {
        return diasDeDescanso;
    }

    public void setDiasDeDescanso(Double diasDeDescanso) {
        this.diasDeDescanso = diasDeDescanso;
    }

    public Double getPromedioHorasLaborales() {
        return promedioHorasLaborales;
    }

    public void setPromedioHorasLaborales(Double promedioHorasLaborales) {
        this.promedioHorasLaborales = promedioHorasLaborales;
    }

    public Double getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    public void setHorasDeTrabajo(Double horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
    }

    public Double getPromedioHorasDescanso() {
        return promedioHorasDescanso;
    }

    public void setPromedioHorasDescanso(Double promedioHorasDescanso) {
        this.promedioHorasDescanso = promedioHorasDescanso;
    }

    @Override
    public String toString() {
        return "Conducta{" + "trabaja=" + trabaja + ", horarioTrabajo=" + horarioTrabajo + ", jornadaLaboral=" + jornadaLaboral + ", diasDeDescanso=" + diasDeDescanso + ", promedioHoras=" + promedioHoras + ", promedioHorasLaborales=" + promedioHorasLaborales + ", horasDeTrabajo=" + horasDeTrabajo + ", promedioHorasDescanso=" + promedioHorasDescanso + '}';
    }
    

}
