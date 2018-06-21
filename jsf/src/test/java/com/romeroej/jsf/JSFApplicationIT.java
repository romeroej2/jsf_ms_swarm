package com.romeroej.jsf;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.Assertions.assertThat;


@RunWith(Arquillian.class)
public class JSFApplicationIT {

    @Drone
    WebDriver browser;


    @FindBy(id = "form:usd")                                  // 2. injects an element
    private WebElement usd;

    @FindBy(id = "form:eur")
    private WebElement eur;

    @FindBy(id = "form:btn")
    private WebElement btn;

    @Test
    public void testIt() {
        browser.navigate().to("http://localhost:8080/");
        assertThat(browser.getPageSource()).contains("CALCULATE");

        usd.sendKeys("100");


        System.out.println(eur.getText());

        btn.click();

        System.out.println(eur.getText());

        assertThat(!eur.getText().equals("0.0"));

        // assertEquals("Welcome", facesMessage.getText().trim());

    }
}
