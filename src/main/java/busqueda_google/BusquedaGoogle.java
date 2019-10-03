package busqueda_google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BusquedaGoogle {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.google.com/";
        driver.get(baseUrl);

        String xpathPaisActual = "//*[@id='fbar']/div/div/div/span";
        String xpathBarraBusqueda = "//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input";
        String xpathBotonBusqueda = "//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]";
        String xpathValidacionBusqueda = "//*[@id='rhs_block']/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/span";
        String textoBuscar = "Hola mundo!";
        String textoValidacion = "Hola mundo";

        WebElement paisActual = driver.findElement(By.xpath(xpathPaisActual));

        if (paisActual.getText().equals("Colombia")) {
           WebElement barraBusqueda = driver.findElement(By.xpath(xpathBarraBusqueda));
           barraBusqueda.sendKeys(textoBuscar);

           paisActual.click();
           WebElement botonBusqueda = driver.findElement(By.xpath(xpathBotonBusqueda));
           botonBusqueda.click();

           WebElement validacionBusqueda = driver.findElement(By.xpath(xpathValidacionBusqueda));

           if (validacionBusqueda.getText().equals(textoValidacion)){
               System.out.println("Pasó la prueba!!!!");
           }
           else {
               driver.close();
               throw new AssertionError("La busqueda no se realizó");
           }
        }
        else {
            driver.close();
            throw new AssertionError("El país en el que se está buscando no es Colombia");
        }
        driver.close();
    }

}
