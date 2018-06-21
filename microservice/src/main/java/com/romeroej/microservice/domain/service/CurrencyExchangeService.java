package com.romeroej.microservice.domain.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import com.romeroej.microservice.domain.model.CurrencyExchange;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;


import javax.ejb.Stateless;


@Stateless
public class CurrencyExchangeService {


    @PersistenceContext
    private EntityManager entityManager;




    public CurrencyExchange find() {

        //System.out.println("SERVICE INVOKED");

        CurrencyExchange currencyExchange = null;

        try {
            currencyExchange = entityManager.find(CurrencyExchange.class, "EUR");
        } catch (Exception ex) {
           ex.printStackTrace();
        }


        if (currencyExchange != null) {

            //System.out.println("DB OBJ: " + currencyExchange);

            Instant now = Instant.now();

            //System.out.println("InstantNow: "+ now.toString());

            Instant cexTimeStamp = Instant.ofEpochMilli(currencyExchange.getTimestampRest());

            //System.out.println("InstantRest: "+ cexTimeStamp.toString());


            long timeElapsed = Duration.between(cexTimeStamp, now).toMinutes();

            System.out.println("Elapsed time: " + timeElapsed);
            if (timeElapsed > 10) {
                entityManager.remove(currencyExchange);
                currencyExchange = queryRestEndpoint4CEX();
                entityManager.persist(currencyExchange);

            }


        }else {
            currencyExchange = queryRestEndpoint4CEX();

            if(currencyExchange != null) {
                //System.out.println("new DB OBJ: " + currencyExchange);
                currencyExchange.setTimestampRest(Instant.now().toEpochMilli());
                entityManager.persist(currencyExchange);
            }
        }


        return currencyExchange;


    }


    public CurrencyExchange queryRestEndpoint4CEX() {
        //System.out.println("REST CLIENT INVOKED");

        String urlStr = "http://data.fixer.io/api/latest?access_key=98389804f272658862bec77fd0af4f17&symbols=USD,AUD,CAD,PLN,MXN&format=1";

        try {

            URL url = new URL(urlStr);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            CurrencyExchange cex = gson.fromJson(IOUtils.toString(url), CurrencyExchange.class);


            //System.out.println(cex);

            return cex;

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;

    }
}
