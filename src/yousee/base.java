package yousee;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public WebDriver test() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/nvsantos/Dropbox/eclipse/workspace/4YouSee Manager/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qa.4yousee.com.br");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Login so sistema
		driver.findElement(By.name("usr_log")).clear();
		driver.findElement(By.name("usr_log")).sendKeys("avaliacao");
		driver.findElement(By.name("usr_sen")).clear();
		driver.findElement(By.name("usr_sen")).sendKeys("4yousee");
		driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div[2]/form/fieldset/input")).click();

		return driver;
	}

}
