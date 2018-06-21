package com.romeroej.microservice.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class CurrencyExchange implements Serializable {
    public CurrencyExchange() {
    }

    private Boolean success;
    private Integer timestamp;

    private Long timestampRest;

    @Id
    private String base;
    private String date;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id")
    private Rates rates;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTimestampRest() {
        return timestampRest;
    }

    public void setTimestampRest(Long timestampRest) {
        this.timestampRest = timestampRest;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
}

