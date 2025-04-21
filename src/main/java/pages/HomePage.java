package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriverWait wait;
	private WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]")
	private WebElement producto_samsung_s6;	
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	private WebElement add_to_cart;
	
	@FindBy(id="cartur")
	private WebElement cart;
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	private WebElement place_order;
	
	@FindBy(id="name")
	private WebElement txtName;
	
	@FindBy(id="country")
	private WebElement txtCountry;
	
	@FindBy(id="city")
	private WebElement txtCity;
	
	@FindBy(id="card")
	private WebElement txtCard;
	
	@FindBy(id="month")
	private WebElement txtMonth;
	
	@FindBy(id="year")
	private WebElement txtYear;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	private WebElement btnPurchase;
	
	@FindBy(xpath="//h2[contains(text(),'Thank you for your purchase!')]")
	private WebElement msgSuccessfulOrder;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement cerrar;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void clicOnSamsungS6() {
		wait.until(ExpectedConditions.elementToBeClickable(producto_samsung_s6));
	    producto_samsung_s6.click();
	}
	
	public void clicOnAddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(add_to_cart));
        add_to_cart.click();
        
        // Esperar a que aparezca la alerta y aceptarla
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
	}
	
	public void clicOnCart() {
		cart.click();
	}
	
	public void clicOnPlaceOrder() {
		place_order.click();
	}
	
	public void completeOrderForm(String name, String country, String city, String card, String month, String year) {
		wait.until(ExpectedConditions.elementToBeClickable(txtName));
        txtName.sendKeys(name);
        txtCountry.sendKeys(country);
        txtCity.sendKeys(city);
        txtCard.sendKeys(card);
        txtMonth.sendKeys(month);
        txtYear.sendKeys(year);
        
        btnPurchase.click();
	}
	
	public String checkOrderIsCompleted() {
		wait.until(ExpectedConditions.visibilityOf(msgSuccessfulOrder));
		return msgSuccessfulOrder.getText();
	}
	
	public void cerrar() {
		cerrar.click();
	}
    
}
