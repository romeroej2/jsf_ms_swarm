package com.romeroej.jsf.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


public class Rates  implements Serializable {

    private Long id;

    public Rates() {

    }

    private Double usd;
    private Double aud;
    private Double cad;
    private Double pln;
    private Double mxn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Double getAud() {
        return aud;
    }

    public void setAud(Double aud) {
        this.aud = aud;
    }

    public Double getCad() {
        return cad;
    }

    public void setCad(Double cad) {
        this.cad = cad;
    }

    public Double getPln() {
        return pln;
    }

    public void setPln(Double pln) {
        this.pln = pln;
    }

    public Double getMxn() {
        return mxn;
    }

    public void setMxn(Double mxn) {
        this.mxn = mxn;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "id=" + id +
                ", usd=" + usd +
                ", aud=" + aud +
                ", cad=" + cad +
                ", pln=" + pln +
                ", mxn=" + mxn +
                '}';
    }
}