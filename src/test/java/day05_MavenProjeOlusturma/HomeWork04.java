package day05_MavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomeWork04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Bir class oluşturun: LocatorsIntro
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.navigate().to(" http://a.testaddressbook.com");
        // b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[@id='sign-in']")).click();

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement singIn = driver.findElement(By.xpath("//input[@type='submit']"));
        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        // ii.Password : Test1234!
        email.sendKeys("testtechproed@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("Test1234!");
        Thread.sleep(2000);
        singIn.click();
        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement userId=driver.findElement(By.xpath("//span[text()='testtechproed@gmail.com']"));
        String actualResult= userId.getText();
        String expectedResult="testtechproed@gmail.com";
        if(actualResult.equals(expectedResult)){
            System.out.println("User Id testi PASS");
        } else{
            System.out.println("User Id FAILED");
        }
        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
            WebElement actualResult1=driver.findElement(By.xpath("//a[@data-test='addresses']"));
        if(actualResult1.isDisplayed()){
            System.out.println("Adresses testi PASS");
        }else{
            System.out.println("Adresses testi FAILED");
        }
        WebElement actualResult2=driver.findElement(By.xpath("//a[@data-test='sign-out']"));
        if(actualResult2.isDisplayed()){
            System.out.println("Sing Out testi PASS");
        }else{
            System.out.println("Sing Out testi FAILED");
        }
        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkler=driver.findElements(By.tagName("a"));

        System.out.println(linkler.size());
        //4.Linklerin yazisini nasil yazdirabiliriz
        for (WebElement each:linkler) {
            System.out.println(each.getText());
        }
        //5. driver i kapatin
     //
        //   driver.close();

    }
}
