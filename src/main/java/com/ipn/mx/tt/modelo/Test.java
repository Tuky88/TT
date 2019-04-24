/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.modelo;

import com.ipn.mx.tt.dao.CuestionarioPreguntaDAO;
import com.ipn.mx.tt.dao.PreguntaDAO;
import com.ipn.mx.tt.dao.PreguntaEquivalenciaDAO;
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
    PreguntaEquivalenciaDAO ped;
    List preguntas, tipoCuestionario, SintomaPregunta, TrastornoSintoma,equivalencias;
    int tipo;
    int[] trastornos;

    public Test(int tipo) {
        pd = new PreguntaDAO();
        cpd = new CuestionarioPreguntaDAO();
        spd = new SintomaPreguntaDAO();
        tsd = new TrastornoSintomaDAO();
        ped=new PreguntaEquivalenciaDAO();
        this.tipo = tipo;
        pd.conectar();
        cpd.conectar();
        spd.conectar();
        tsd.conectar();
        ped.conectar();
        preguntas = pd.getPreguntas(tipo);
        tipoCuestionario = cpd.getCuestionario();
        SintomaPregunta = spd.traerSintomas();
        TrastornoSintoma = tsd.traerTrastornos();
        equivalencias=ped.getEquivalencia();
        trastornos = new int[8];
        for (int i = 0; i < 8; i++) {
            trastornos[i] = 0;
        }
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
    public void levantarBandera(int trastorno)
    {
        trastornos[trastorno]=1;
    }
    public void reiniciarBanderas()
    {
        for (int i = 0; i < 8; i++) {
            trastornos[i]=0;
        }
    }
    public boolean banderaLevantada(int trastorno)
    {
        return trastornos[trastorno]!=0;
    }
    public LinkedList obtenerEquivalente(int pregunta)
    {
        LinkedList ls=new LinkedList();
        equivalencias.forEach((equivalencia)-> { 
            PreguntaEquivalente pe=new PreguntaEquivalente((DBObject)equivalencia);
            if(pe.getIdPregunta()==pregunta)
            {
                ls.add(pe);
            }
        });
        return ls;
    }
}
