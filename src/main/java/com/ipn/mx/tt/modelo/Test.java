/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

import com.ipn.mx.tt.dao.CuestionarioPreguntaDAO;
import com.ipn.mx.tt.dao.PreguntaDAO;
import com.ipn.mx.tt.dao.SintomaPreguntaDAO;
import com.ipn.mx.tt.dao.TrastornoSintomaDAO;
import com.mongodb.DBObject;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Axel Reyes
 */
public class Test {

    PreguntaDAO pd;
    CuestionarioPreguntaDAO cpd;
    SintomaPreguntaDAO spd;
    TrastornoSintomaDAO tsd;
    List preguntas, tipoCuestionario, SintomaPregunta, TrastornoSintoma;
    int tipo;

    public Test(int tipo) {
        pd = new PreguntaDAO();
        cpd = new CuestionarioPreguntaDAO();
        spd = new SintomaPreguntaDAO();
        tsd=new TrastornoSintomaDAO();
        this.tipo = tipo;
        pd.conectar();
        cpd.conectar();
        spd.conectar();
        tsd.conectar();
        preguntas = pd.getPreguntas(tipo);
        tipoCuestionario = cpd.getCuestionario();
        SintomaPregunta = spd.traerSintomas();
        TrastornoSintoma = tsd.traerTrastornos();
        //System.out.println(SintomaPregunta.toString());
    }

    public Pregunta getPregunta(int i) {
        Pregunta p = new Pregunta((DBObject) preguntas.get(i - 1), tipo);
        return p;
    }

    public int getTipoCuestionario(int i) {
        return getEntero((DBObject) tipoCuestionario.get(i - 1));
    }

    public int getEntero(DBObject dbo) {
        int n;
        n = Integer.valueOf((String) dbo.get("_idCuestionario"));
        return n;
    }

    public LinkedList getSintoma(int pregunta) {
        LinkedList ls = new LinkedList();
        SintomaPregunta.forEach((sp) -> {
            SintomaPregunta spi = new SintomaPregunta((DBObject) sp);
            if (spi.getPregunta() == pregunta) {
                ls.add(spi);
            }
        });
        return ls;
    }

    public LinkedList getTrastorno(int sintoma) {
        LinkedList ls = new LinkedList();
        TrastornoSintoma.forEach((ts) -> {
            TrastornoSintoma tsi = new TrastornoSintoma((DBObject) ts);
            if (tsi.getSintoma() == sintoma) {
                ls.add(tsi);
            }
        });
        return ls;
    }
}
