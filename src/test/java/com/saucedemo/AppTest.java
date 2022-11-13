package com.saucedemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class AppTest {
    MainPage mainPage = new MainPage();
    InventoryPage inventoryPage = new InventoryPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://www.saucedemo.com/");
    }

    @Test
    public void login() {
        mainPage.username.sendKeys("standard_user");
        mainPage.password.sendKeys("secret_sauce");
        mainPage.loginButton.click();
    }

    @Test
    public void priceLowToHigh() {
        open("https://www.saucedemo.com/inventory.html");
        inventoryPage.filterButton.click();
        inventoryPage.priceLowHigh.click();
        List<Double> unsortedPrices = new ArrayList<>();

        for (SelenideElement el : inventoryPage.inventoryItems) {
            String dollarRemovedValue = el.text().substring(1);
            Double dollarPrice = Double.valueOf(dollarRemovedValue);

            unsortedPrices.add(dollarPrice);
        }

        List<Double> sorted = new ArrayList<>(unsortedPrices);
        Collections.sort(sorted);

        Assertions.assertEquals(unsortedPrices, sorted);
    }
}
