package com.nttdata.stepsdefinitions;

import com.nttdata.page.CompraPage;
import com.nttdata.steps.CompraSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StoreStepsDef {

    private WebDriver driver;
    private WebDriverWait wait;



    @Given("estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logue con mi usuario {string} y clave {string}")
    public void meLogueConMiUsuarioYClave(String user, String password) {
        Actions actions = new Actions(driver);
        LoginSteps loginSteps = new LoginSteps(driver);
        actions.pause(Duration.ofSeconds(1)).perform();
        loginSteps.userlogin();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        screenShot();
        Assertions.assertTrue(password.equals("nttdata.2025"),"Clave correcta");
        loginSteps.login();


    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        Actions actions = new Actions(driver);
        CompraSteps compraSteps = new CompraSteps(driver);
        Assertions.assertTrue(categoria.equals("Clothes"),"Correcto");
        compraSteps.clothes();
        actions.pause(Duration.ofSeconds(1)).perform();
        compraSteps.men();
        screenShot();

    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cant) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        Actions actions = new Actions(driver);
        CompraSteps compraSteps = new CompraSteps(driver);
        compraSteps.articulos();
        actions.pause(Duration.ofSeconds(1)).perform();
        compraSteps.cantidad();
        compraSteps.carrito();

        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        Actions actions = new Actions(driver);
        CompraSteps compraSteps = new CompraSteps(driver);
        compraSteps.validarProducto();
        screenShot();

    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        Actions actions = new Actions(driver);
        CompraSteps compraSteps = new CompraSteps(driver);
        compraSteps.validarTotal();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        CompraSteps compraSteps = new CompraSteps(driver);
        compraSteps.finCompra();
        screenShot();
    }


    @Then("valido el titulo de la pagina del {string}")
    public void validoElTituloDeLaPaginaDel(String expectedTitle) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        Actions actions = new Actions(driver);
        String actualTitle = driver.getTitle();
        System.out.println("Actual: " + actualTitle);
        System.out.println("Expected: " + expectedTitle);
        Assertions.assertEquals(expectedTitle, actualTitle);
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        Actions actions = new Actions(driver);
        CompraSteps compraSteps = new CompraSteps(driver);
        compraSteps.validarPrecioFinal();
        actions.pause(Duration.ofSeconds(1)).perform();
        screenShot();
    }
}
