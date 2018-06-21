package com.romeroej.microservice;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.MalformedJsonException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.StringBuilderWriter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.romeroej.microservice.domain.model.CurrencyExchange;
import com.romeroej.microservice.domain.service.CurrencyExchangeService;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Arquillian.class)
public class TestIT {


    @Deployment
    public static Archive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(CurrencyExchange.class.getPackage())
                .addPackage(CurrencyExchangeService.class.getPackage())
                .addPackage(GsonBuilder.class.getPackage())
                .addPackage(Excluder.class.getPackage())
                .addPackage(JsonTreeReader.class.getPackage())
                .addPackage(TypeToken.class.getPackage())
                .addPackage(IOUtils.class.getPackage())
                .addPackage(StringBuilderWriter.class.getPackage())
                .addPackage(JsonAdapter.class.getPackage())


                .addPackage(MalformedJsonException.class.getPackage())
                .addAsResource("META-INF/persistence.xml",  "META-INF/persistence.xml")
                .addAsResource("META-INF/load.sql",  "META-INF/load.sql")
                 .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }





    @Inject
    CurrencyExchangeService currencyExchangeService;

    @Test
    public void initTest() {
        assertEquals("Init Test!", "Init Test!");
    }

    @Test
    public void jpaTestIt() {
        CurrencyExchange currencyExchange = currencyExchangeService.find();
        assertTrue(currencyExchange != null);
        assertTrue(currencyExchange.getBase().equals("EUR"));
    }





}
