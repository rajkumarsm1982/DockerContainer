package com.selenium.practice;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest {
	WebDriver driver= null;
	
	@Test
	public void setup() {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("version", "");
		cap.setCapability("platform", "LINUX");
		try {
			 driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("http://www.google.com");
	}

}
/*
Docker stop containers
docker stop $(docker ps -a -q)

remove the process
docker rm $(docker ps -a -q)

start the selenium hub
docker run -d -p 4444:4446 --name selenium-hub -P selenium/hub

start the chrome node and link to the hub
docker run -d -P --link selenium-hub:hub selenium/node-chrome-debug

to get the vnc viewer port
docker ps -a
will give you exposed port
*/