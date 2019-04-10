/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.util;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Axel Reyes
 */
public class Validador {

    public String validarTF(JFXTextField jf) {
        if (jf.getText().length() > 0) {
            return jf.getText();
        } else {
            return "";
        }
    }

    public String validarDP(JFXDatePicker dp) {
        if (dp.getValue() != null) {
            LocalDate ld=dp.getValue();
            String cadena=ld.format(DateTimeFormatter.ISO_DATE);
            return cadena;
        } else {
            return "";
        }
    }
    
}
