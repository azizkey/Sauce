package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.saucedemo.com/inventory.html
public class InventoryPage {
    public SelenideElement filterButton = $("select[class^='product']");
    public SelenideElement priceLowHigh = $("option[value='lohi']");
    public ElementsCollection inventoryItems = $$("div.inventory_item_price");
}