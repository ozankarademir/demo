package Pages;

import org.openqa.selenium.By;

public class PageConstants {
    public static By SEARCH_BOX = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    public static By SEARCH_BUTTON = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    public static By TITLE = By.cssSelector("#search > div.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.s-right-column.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(4) > div.s-result-list.s-search-results.sg-row > div:nth-child(1) > div > span > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-8-of-16.sg-col-16-of-24.sg-col-12-of-20.sg-col-24-of-32.sg-col.sg-col-28-of-36.sg-col-20-of-28 > div > div:nth-child(1) > div > div > div:nth-child(1) > h2 > a > span");
    public static By PRICE_ONE = By.id("priceblock_ourprice");
    public static By PRICE_TWO = By.id("mbc-price-2");
    public static By ADD_TO_CHART_BUTTON = By.id("add-to-cart-button");
    public static By OTHER_SELLERS_ADD_TO_CHART_BUTTON = By.id("mbc-buybutton-addtocart-2-announce");
}
