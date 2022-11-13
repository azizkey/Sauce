package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://www.saucedemo.com/
public class MainPage {
    public SelenideElement username = $("input[id='user-name']");
    public SelenideElement password = $("input[id='password']");
    public SelenideElement loginButton = $("input[id='login-button']");
}
