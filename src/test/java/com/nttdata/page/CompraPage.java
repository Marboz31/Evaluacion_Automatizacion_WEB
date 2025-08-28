package com.nttdata.page;

import org.openqa.selenium.By;

public class CompraPage {

    public static By clothesButton = By.xpath("//*[@id=\"category-3\"]/a");
    public static By menButton = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");
    public static By articuloButton = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[2]/h2/a");
    public static By cantidadButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By carritoButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By prodName1 = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1");
    public static By prodName2 = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/h6");
    public static By price = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By priceF = By.cssSelector("span.price");
    public static By totaPrice = By.cssSelector("span.value");
    public static By finalizePurchase = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public static By carritoTitle = By.cssSelector("span.title");
    public static By totalPriceTitle = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");

}
