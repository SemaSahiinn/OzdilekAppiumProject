import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest{
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    @Step("<wait> saniye kadar bekle")
    public void waitForSeconds(int wait) throws InterruptedException {
        Thread.sleep(wait * 1000);
    }
    @Step("id <id> li elemente tıkla")
    public void clickById(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }
    @Step("id <id> li elementi kontrol et")
    public void checkText(String id) {
        String chectText = appiumDriver.findElement(By.id(id)).getText();
        Assert.assertEquals("ALIŞVERİŞE BAŞLA", chectText);
    }
    @Step("id<id> li elementli kontrol et")
    public void checkText1(String id) {
        String controlText = appiumDriver.findElement(By.id(id)).getText();
        Assert.assertEquals("Market", controlText);
    }
    @Step("id<id> kategoriye tıkla")
    public void clickBykategori(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }
    @Step("xpath<xpath> kadın kategorisine tıkla")
    public void clickBykadın(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }
    @Step("xpath<xpath> pantolon kategorisine tıkla")
    public void clickBypantolon(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }
    @Step("<scroll et>")
    public void scrollEt(String scroll) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(530,1530)).moveTo(PointOption.point(530,420)).release().perform();
        logger.info("Scroll yapıldı.");
    }

    @Step("Rastgele bir <product> seç")
    public void selectRandomProduct(String product){
        Random rdn = new Random();
        List<MobileElement> productList = appiumDriver.findElementsByXPath(product);
        int size = productList.size();
        Random rnd = new Random();
        int randNum = rnd.nextInt(size);
        productList.get(randNum).click();
    }
    @Step("Urun product detail acildigi kontrol edilir")
    public void checkProductDetail() throws InterruptedException {
        Thread.sleep(1000);
        String checkProductText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvSizeDesc")).getText();
        Assert.assertEquals("Beden:", checkProductText);
        System.out.println("Urun detayına girildi.");
        logger.info("Urun detayına girildi.");
    }
    @Step("Urun favorilere eklenir")
    public void addToFav() throws InterruptedException {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/imgFav")).click();
        System.out.println("Favorilere ekle butonuna basildi.");
        logger.info("Favorilere ekle butonuna basildi.");
    }






}

