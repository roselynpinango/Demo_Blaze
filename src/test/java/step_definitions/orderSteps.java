package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class orderSteps {
	private WebDriver driver;
    private HomePage homePage;
    
	@Given("^I access into DemoBlaze webpage$")
	public void i_access_into_demoblaze_webpage() {
		// Configurar el driver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        // Navegar a la página
        driver.get("https://www.demoblaze.com/");
        homePage = new HomePage(driver);
	}
	
	@When("^I clic in a product$")
	public void i_clic_in_a_product() {
		homePage.clicOnSamsungS6();
	}
	
	@When("^I clic on Add to Cart button$")
	public void i_clic_on_add_to_cart_button() {
		homePage.clicOnAddToCart();
	}
	
	@When("^I clic on Cart menu option$")
	public void i_clic_on_cart_menu_option() {
		homePage.clicOnCart();
	}
	
	@When("^I clic on Place Order button$")
	public void i_clic_on_place_order_button() {
		homePage.clicOnPlaceOrder();
	}
	
	@When("^I complete the form with my personal information$")
	public void i_complete_the_form_with_my_personal_information() {
		homePage.completeOrderForm( "Usuario Test", 
									"Argentina",
									"CABA",
									"4111111111111111",
									"12",
									"2026");	
	}
	
	@Then("^the order is completed$")
	public void the_order_is_completed() {
		Assert.assertTrue(homePage.checkOrderIsCompleted().equalsIgnoreCase("Thank you for your purchase!"), "No se muestra el mensaje de confirmación de compra");
		homePage.cerrar();	
		
		// Cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
	}
}
