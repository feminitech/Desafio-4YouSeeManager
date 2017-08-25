package yousee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisarClientesEAgencias {

	private static WebDriver driver;

	@Before
	public void setUp() throws Exception {

		base base = new base();
		driver = base.test();

	}

	@Test
	public void testPesquisarClientesEAgencias() {
		try {

			// Preeche e imprime no console nome fantasia preenchido
			Thread.sleep(5000);
			WebElement nomeFantasia = driver.findElement(By
					.name("nome_fantasia"));
			nomeFantasia.clear();
			nomeFantasia.sendKeys("Agência 01");
			String nome = nomeFantasia.getAttribute("value");
			System.out.println(nome);

			// Clica em Pesquisar
			Thread.sleep(5000);
			driver.findElement(By.name("Pesquisar")).click();

			// Valida se o resultado esperado aparece no grid
			Thread.sleep(5000);
			assertEquals(
					nome,
					driver.findElement(
							By.xpath(".//*[@id='managerContent']/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[4]"))
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
