/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

import com.ipn.mx.tt.dao.PreguntaDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axel Reyes
 */
public class testerPrueba {

    public void ejecutar() throws IOException {
        FileReader fr = null;
        try {
            PreguntaDAO pd = new PreguntaDAO();
            File archivo = new File("C:\\Users\\Axel Reyes\\Documents\\preguntas.txt");
            fr = new FileReader(archivo);
            String linea;
            BufferedReader br = new BufferedReader(fr);

             pd.cjm.conectar();
            while ((linea = br.readLine()) != null) {
                String[] div=linea.split("//");
                System.out.println(div[0] +"----"+ div[1]);
                pd.insertarPregunta(new Pregunta(div[0], div[1]));
            }
            pd.cjm.cerrarConexion();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testerPrueba.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(testerPrueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
