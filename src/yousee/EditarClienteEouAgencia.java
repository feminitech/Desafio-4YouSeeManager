package yousee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class EditarClienteEouAgencia {

	private static WebDriver driver;
	Faker faker = new Faker();

	@Before
	public void setUp() throws Exception {

		base base = new base();
		driver = base.test();

	}

	@Test
	public void testEditarClienteEouAgencia() {

		try {

			// Clica em Alterar
			Thread.sleep(5000);
			driver.findElement(By
					.xpath("//div[@id='managerContent']/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[7]/ul/li/a/i"))
					.click();

			// alterar a razão social
			Thread.sleep(5000);
			WebElement razao = driver.findElement(By.id("litempRazao"));
			razao.clear();
			razao.sendKeys(faker.name().fullName());

			// alterar o nome fantasia
			Thread.sleep(5000);
			WebElement fantasia = driver.findElement(By.id("litempFantasia"));
			fantasia.clear();
			fantasia.sendKeys(faker.name().fullName());
			String nomeFantasiaNovo = fantasia.getAttribute("value");

			// clica em alterar
			driver.findElement(By.name("alterar")).click();

			// Pesquisa pelo nome fantasia alterado
			Thread.sleep(5000);
			WebElement nomeFantasiaPesquisa = driver.findElement(By.name("nome_fantasia"));
			nomeFantasiaPesquisa.clear();
			nomeFantasiaPesquisa.sendKeys(nomeFantasiaNovo);
			driver.findElement(By.name("Pesquisar")).click();

			// Valida se o nome presquisado esta presente no grid
			Thread.sleep(5000);
			assertEquals(nomeFantasiaNovo,
					driver.findElement(By
							.xpath("html/body/div[4]/div[1]/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[4]"))
							.getText());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After
	public void posCondicao() throws Exception {

		// Aguarda 5 segundos
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// fecha o navegador
		driver.quit();

	}

}
