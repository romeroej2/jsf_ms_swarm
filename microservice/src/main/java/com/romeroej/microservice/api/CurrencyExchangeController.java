package com.romeroej.microservice.api;

import com.romeroej.microservice.domain.model.CurrencyExchange;
import com.romeroej.microservice.domain.service.CurrencyExchangeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@ApplicationScoped
@Path("/cex")
public class CurrencyExchangeController {

    @Inject
    private CurrencyExchangeService currencyExchangeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CurrencyExchange findAll() {
       //System.out.println("REST SERVICE CONSUMED");
        CurrencyExchange results = currencyExchangeService.find();
        //System.err.println(results);
        return results;
    }

}
