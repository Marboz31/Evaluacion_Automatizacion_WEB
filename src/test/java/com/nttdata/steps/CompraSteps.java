package com.nttdata.steps;

import com.nttdata.page.CompraPage;
import org.openqa.selenium.WebDriver;

public class CompraSteps {

    private WebDriver driver;

    public CompraSteps(WebDriver driver) {this.driver = driver;}

    public void clothes() {this.driver.findElement(CompraPage.clothesButton).click();}

    public void men() {this.driver.findElement(CompraPage.menButton).click();}

    public void articulos() {this.driver.findElement(CompraPage.articuloButton).click();}

    public void cantidad() {this.driver.findElement(CompraPage.cantidadButton).click();}

    public void carrito() {this.driver.findElement(CompraPage.carritoButton).click();}

    public void validarProducto() {
        String name1 = this.driver.findElement(CompraPage.prodName1).getText().toUpperCase();
        String name2 = this.driver.findElement(CompraPage.prodName2).getText().toUpperCase();
        if (name1.equals(name2)) {
            System.out.println("Producto valido");
        }else  {
            System.out.println("Producto nulo");
        }
    }



    public void validarTotal(){
        double precio = Double.parseDouble(this.driver.findElement(CompraPage.price).getText().replace("S/ ","").trim()) * 2;
        double total = Double.parseDouble(this.driver.findElement(CompraPage.totaPrice).getText().replace("S/ ","").trim());
        if (total == precio) {
            System.out.println("Cantidad valida");
        }else  {
            System.out.println("Cantidad nula");
        }

    }

    public void finCompra(){this.driver.findElement(CompraPage.finalizePurchase).click();}

    public String getTitle(){
        return this.driver.findElement(CompraPage.carritoTitle).getText();
    }

    public void validarPrecioFinal(){
        double precioT = Double.parseDouble(this.driver.findElement(CompraPage.priceF).getText().replace("S/ ","").trim()) * 2;
        double totalPago = Double.parseDouble(this.driver.findElement(CompraPage.totalPriceTitle).getText().replace("S/ ","").trim());
        if (totalPago == precioT) {
            System.out.println("Precio verificado");
        }else   {
            System.out.println("Precio invalido");
        }


    }


}
