package Stepdefinition;

import CucumberOptions.Base;
import Pages.PageConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStepdefs {
    public WebDriver driver;

    @Given("^User is on Amazon Landing page$")
    public void userIsOnAmazonLandingPage() throws InterruptedException {
        driver = Base.getDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.amazon.com.tr"); // amazon web sayfasına girer.
        Thread.sleep(3000); // 3 saniye web-browserda css lerin yüklenmesi için bekletilir.
    }

    @When("^User searched for \"([^\"]*)\" phones$")
    public void userSearchedForPhones(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(PageConstants.SEARCH_BOX).sendKeys(arg0); //Cucumber steplerinden aldığı "iPhone X" parametresini search box'a girer.
        driver.findElement(PageConstants.SEARCH_BUTTON).click(); // Arama butonuna tıklatılır.
    }

    @Then("^\"([^\"]*)\" results are displayed$")
    public void resultsAreDisplayed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(PageConstants.TITLE).getText().contains(arg0));//Arama sonucu çıkan ilk ürünün başlığında "iPhone X" varmı kontrol edilir.
    }

    @And("^User click the first product$")
    public void userClickTheFirstProduct() {
        driver.findElement(PageConstants.TITLE).click();//Arama sonucu çıkan ilk ürünün detayına girilir.
    }

    @Given("^User is on Product detail page$")
    public void userIsOnProductDetailPage() {
        String title = driver.getTitle(); // Ürün detayı sayfasında olduğumuzun kontrolü için sayfa title'ı kontrol edilir.
        Assert.assertTrue(title.contains("Apple iPhone X, 64 GB, Uzay Gri (Apple Türkiye Garantili): Amazon.com.tr: KimSatar"));
    }

    @When("^User compare prices and add to chart of lower price item$")
    public void userComparePricesAndAddToChartOfLowerPriceItem() {
        WebElement element = driver.findElement(PageConstants.PRICE_ONE);

        String string_price = element.getText();
        String modified_string_price = string_price.replace("₺", "0");
        String modifyend = modified_string_price.replace(",00", "00");
        Double price1 = Double.parseDouble(modifyend); //Ürün fiyatı "₺" ibarisinden dolayı string bir değerden double bir değere çevirilemediğinden replace metoduyla doğru formata getirilir.

        WebElement element2 = driver.findElement(PageConstants.PRICE_TWO);
        String other_seller_price = element2.getText();
        String modified_other_seller_price = other_seller_price.replace("₺", "0");
        String modifyend2 = modified_other_seller_price.replace(",00", "00");
        Double price2 = Double.parseDouble(modifyend2); //Diğer satıcı ürününün fiyatıda "₺" ibarisinden dolayı string bir değerden double bir değere çevirilemediğinden replace metoduyla doğru formata getirilir.

        if (price1 < price2) { // Seçtiğimiz telefon ile diğer satıcılar tablosundaki 2. telefon fiyatı karşılaştırılıp düşük ücretli olan sepete eklenir.
            driver.findElement(PageConstants.ADD_TO_CHART_BUTTON).click();
        } else {
            driver.findElement(PageConstants.OTHER_SELLERS_ADD_TO_CHART_BUTTON).click();
        }
    }
}
