package yousee;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.github.javafaker.Faker;

public class AdicionarNovoClienteOuAgencia {

	private static WebDriver driver;
	Faker faker = new Faker();

	@Before
	public void setUp() throws Exception {

		base base = new base();
		driver = base.test();

	}

	@Test
	public void testAdicionarNovoClienteOuAgencia() {

		try {

			// Clica em Adicionar
			Thread.sleep(5000);
			driver.findElement(By.linkText("Adicionar")).click();

			// Valida se a página foi carregada
			Thread.sleep(5000);
			assertEquals("Os campos em vermelho são obrigatórios.",
					driver.findElement(
							By.xpath(".//*[@id='managerContent']/table/tbody/tr/td[2]/table[2]/tbody/tr/td/div/ul/li"))
							.getText());

			// Preenche razão social
			Thread.sleep(5000);
			WebElement razaoSocial = driver.findElement(By.id("empRazao"));
			razaoSocial.clear();
			razaoSocial.sendKeys(faker.name().fullName());
			String razaoSocialPreenchida = razaoSocial.getAttribute("value");
			System.out.println(razaoSocialPreenchida);

			// Preenche nome fantasia
			Thread.sleep(5000);
			WebElement nomeFantasia = driver.findElement(By.id("empFantasia"));
			nomeFantasia.clear();
			nomeFantasia.sendKeys(faker.name().fullName());
			String nomeFantasiaPreenchido = nomeFantasia.getAttribute("value");
			System.out.println(nomeFantasiaPreenchido);

			// Clica em adicionar
			Thread.sleep(5000);
			driver.findElement(By.id("Adicionar")).click();

			// Pesquisa pelo nome fantasia do cadastro realizado
			Thread.sleep(5000);
			WebElement nomeFantasiaPesquisa = driver.findElement(By.name("nome_fantasia"));
			nomeFantasiaPesquisa.clear();
			nomeFantasiaPesquisa.sendKeys(nomeFantasiaPreenchido);
			driver.findElement(By.name("Pesquisar")).click();

			// Valida se o nome presquisado esta presente no grid
			Thread.sleep(5000);
			assertEquals(nomeFantasiaPreenchido,
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
