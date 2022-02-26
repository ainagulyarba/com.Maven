package day05_MavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   //    1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
   //    2. Signin buttonuna tiklayin
       WebElement signinButonu= driver.findElement(By.xpath("//button[@id='signin_button'] "));
       signinButonu.click();
   //    3. Login alanine  “username” yazdirin
      WebElement login=driver.findElement(By.xpath("//input[@id='user_login']"));
       login.sendKeys("username");

   //    4. Password alanine “password” yazdirin
        WebElement password =driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");

   //    5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

   //    6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=pay-bills.html']")).click();
        Thread.sleep(2000);

   //    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
       WebElement amount= driver.findElement(By.xpath("//input[@name='amount']"));
       amount.sendKeys("100");
       Thread.sleep(2000);

   //    8. tarih kismina “2020-09-10” yazdirin
       WebElement date= driver.findElement(By.xpath("//input[@name='date']"));
        date.sendKeys("21/01/2021");
        Thread.sleep(2000);

   //    9. Pay buttonuna tiklayin
        WebElement pay = driver.findElement(By.xpath("//input[@type='submit']"));
        pay.click();

   //    10. “The payment was successfully submitted.” mesajinin ciktigini control edin
       WebElement actualResult=driver.findElement(By.xpath("//*[@id=alert_content]/span"));
       if(actualResult.isDisplayed()){
           System.out.println("The payment was successfully submitted.");
       }else{
           System.out.println("The payment was not sent successfully .");
       }
       driver.close();
    }
}
