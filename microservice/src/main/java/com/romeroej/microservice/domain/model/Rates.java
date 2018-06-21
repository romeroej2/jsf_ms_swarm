package com.romeroej.microservice.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
public class Rates  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    public Rates() {

    }

    private Double USD;
    private Double AUD;
    private Double CAD;
    private Double PLN;
    private Double MXN;


}