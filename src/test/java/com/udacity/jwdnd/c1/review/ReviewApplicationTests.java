package com.udacity.jwdnd.c1.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@Test
	void contextLoads() {
	}

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private ChatPage chat;
	private LoginPage login;
	private RegistrationPage signup;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

//	@BeforeEach
//	public void beforeEach() {
//		driver.get("http://localhost:" + port + "/chat");
//		chat = new ChatPage(driver);
//	}

	@Test
	public void testAll() throws InterruptedException {
		driver.get("http://localhost:" + port + "/login");
		login = new LoginPage(driver);
		Thread.sleep(2000);
		login.signUp();

		driver.get("http://localhost:" + port + "/registration");
		signup = new RegistrationPage(driver);

		signup.setInputFirstNameField("Kei");
		Thread.sleep(2000);
		signup.setInputLastNameField("Tester");
		Thread.sleep(2000);
		signup.setInputUsernameField("KeyTester");
		Thread.sleep(2000);
		signup.setInputPasswordField("password");
		Thread.sleep(2000);
		signup.signUp();

		driver.get("http://localhost:" + port + "/login");
		login = new LoginPage(driver);
		Thread.sleep(2000);
		login.setInputUsernameField("KeyTester");
		Thread.sleep(2000);
		login.setInputPasswordField("password");
		Thread.sleep(2000);
		login.signIn();

		driver.get("http://localhost:" + port + "/chat");
		chat = new ChatPage(driver);
		Thread.sleep(2000);
		chat.setMessageField("Hello World!");
		Thread.sleep(2000);
		chat.sendMessage();
		Thread.sleep(5000);

		chat.logout();
	}


}
