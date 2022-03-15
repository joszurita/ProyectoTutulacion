/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavirac.ejemploImprimir.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

/**
 *
 * @author josue
 */
@Entity
public class Acta {    
    @javax.persistence.Id
    @GeneratedValue(strategy = AUTO)
    @Column(unique=true)
    private Long numero_acta;
    private String cod_anio;
    private String cod_mes;
    private String cod_dia;
    private String cod_carrera;
    private String cedula;
    private String presidente;
    private String vocal1;
    private String vocal2;

    public Long getNum_acta() {
        return numero_acta;
    }

    public void setNumero_acta(Long num_acta) {
        this.numero_acta = num_acta;
    }

    public String getCod_anio() {
        return cod_anio;
    }

    public void setCod_anio(String cod_anio) {
        this.cod_anio = cod_anio;
    }

    public String getCod_mes() {
        return cod_mes;
    }

    public void setCod_mes(String cod_mes) {
        this.cod_mes = cod_mes;
    }

    public String getCod_dia() {
        return cod_dia;
    }

    public void setCod_dia(String cod_día) {
        this.cod_dia = cod_día;
    }

    public String getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(String cod_carrera) {
        this.cod_carrera = cod_carrera;
    }


    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getVocal1() {
        return vocal1;
    }

    public void setVocal1(String vocal1) {
        this.vocal1 = vocal1;
    }

    public String getVocal2() {
        return vocal2;
    }

    public void setVocal2(String vocal2) {
        this.vocal2 = vocal2;
    }
    
}
