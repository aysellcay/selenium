package Lesson2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;

public class HomeworkSeleniumBrowserNavigation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        // 1. Chrome tarayıcısını açın ve pencere boyutunu (300, 500) olarak ayarlayın.
        System.out.println("Browser size:" +driver.manage().window().getSize());
        driver.manage().window().setSize(new Dimension(300, 500));
        System.out.println("New size:" +driver.manage().window().getSize());

        // 2. Pencerenin ekran üzerindeki konumunu (100, 400) yapın.
        System.out.println("Curent position"+driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(100,400));
        System.out.println("Updated position"+driver.manage().window().getPosition());

        // 3. Bir URL'yi (https://www.orioninc.com/) açın ve sayfa başlığını konsola çıktı olarak yazdırın.
        driver.get("https://orioninc.com/");
        System.out.println("Current URL: "+driver.getCurrentUrl());
        System.out.println("Title: "+driver.getTitle());

        // 4. Üçüncü adımda açmış olduğunuz Orion sayfasını https://www.amazon.com/ yönlendirin.
        System.out.println("Current URL: "+driver.getCurrentUrl());
        driver.get("https://www.amazon.com/");
        System.out.println("Current URL: "+driver.getCurrentUrl());
        System.out.println("Window Handle: "+  driver.getWindowHandle());

        // 5.Tarayıcı geçmişinde geri navigasyon yaparak ilk sayfaya dönün ve URL'yi konsola çıktı olarak yazdırın.
        driver.navigate().back();
        System.out.println("Current URL: "+driver.getCurrentUrl());

        // 6. Tarayıcı geçmişinde ileri navigasyon yaparak ikinci sayfaya geri dönün.
        driver.navigate().forward();
        System.out.println("Current URL: "+driver.getCurrentUrl());

        // 7. Yeni bir sekme açarak https://www.google.com sayfasını yükleyin ve sayfanın kaynak kodunu konsola çıktı olarak yazdırın.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.google.com', '_blank');");
        System.out.println("Page Source: "+  driver.getPageSource());

        // 8. İlk sekmeye geri dönün ve URL'yi konsola çıktı olarak yazdırın.
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Current URL: "+driver.switchTo().window(tabs.getFirst()));
        //System.out.println("Current URL: "+driver.switchTo().window(tabs.get(0)));

        // 9. Son sekmeye geçiş yapın ve sayfayı yenileyin.
        System.out.println("Current URL: "+driver.switchTo().window(tabs.getLast()));
        driver.navigate().refresh();

        // 10. Tüm sekmeleri kapatın ve testi sonlandırın.
        driver.quit();
        System.out.println("Tüm sekmeler kapatıldı.");


    }
}
