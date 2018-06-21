package com.romeroej.jsf;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import com.romeroej.jsf.model.CurrencyExchange;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

@Named
@SessionScoped
public class ViewController implements Serializable {
    private Double usd=0.0;
    private Double eur=0.0;
    CurrencyExchange cex;


    public void doCEX() {

        queryRestEndpoint4CEX();


        //1 EUR = Rate
        //X EUR  = DLR

        eur = usd / cex.getRates().getUsd();

    }


    public void queryRestEndpoint4CEX() {

        if (cex != null) {
            Instant now = Instant.now();


            Instant cexTimeStamp = Instant.ofEpochMilli(cex.getTimestampRest());

            long timeElapsed = Duration.between(cexTimeStamp, now).toMinutes();

            System.out.println("Elapsed time: " + timeElapsed);
            if (timeElapsed < 10) {
                return;

            }
        }

        System.out.println("REST CLIENT INVOKED");


        String urlStr = "http://127.0.0.1:8081/cex";

        //String urlStr = "http://data.fixer.io/api/latest?access_key=98389804f272658862bec77fd0af4f17&symbols=USD,AUD,CAD,PLN,MXN&format=1";

        try {

            URL url = new URL(urlStr);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            cex = gson.fromJson(IOUtils.toString(url), CurrencyExchange.class);
            System.out.println("GOT CEX"+ cex.toString());



        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }


    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Double getEur() {
        return eur;
    }

    public void setEur(Double eur) {
        this.eur = eur;
    }
}
