package com.romeroej.microservice;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import static org.junit.Assert.assertTrue;


@RunWith(Arquillian.class)
public class RestApplicationIT  {

    @Drone
    WebDriver browser;

    @Test
    public void testIt() {
        browser.navigate().to("http://localhost:8080/cex");
        System.out.println(browser.getPageSource());
        assertTrue(browser.getPageSource().contains("\"success\":true"));

    }
}
