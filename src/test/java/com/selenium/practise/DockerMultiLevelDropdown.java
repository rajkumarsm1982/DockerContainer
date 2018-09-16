package com.selenium.practise;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DockerMultiLevelDropdown {
	WebDriver driver= null;
	Actions action;
	DesiredCapabilities cap;
	
	@Parameters("browser")
	@BeforeTest
	public void setupDriver(String browser) {
		if(browser.equals("chrome")) {
		cap = DesiredCapabilities.chrome();
		} else if(browser.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else {
			System.out.println("Wrong Parameter");
		}
		cap.setCapability("version", "");
		cap.setCapability("platform", "LINUX");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		action = new Actions(driver);
	}
	

	@Test
	public void multiLevelDropDown() {
		
		
		driver.get("https://www.bootply.com/render/6FC76YQ4Nh");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hover.accept(By.linkText("Dropdown"));
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 hover.accept(By.linkText("Dropdown Link 5"));
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        hover.accept(By.linkText("Dropdown Submenu Link 5.4"));
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        hover.accept(By.linkText("Dropdown Submenu Link 5.4.1"));
	        
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		driver.quit();
		
	}
	
	Consumer<By> hover = (By by) -> {
		action.moveToElement(driver.findElement(by)).build().perform();
	};	

}