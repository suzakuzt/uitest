package com.manage.demo.util;
//import org.eclipse.jetty.util.preventers.DriverManagerLeakPreventer;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestBaseCase {
	public static WebDriver driver;
	//方法描述
	public static String description;
	public Log log=new Log(this.getClass().getSuperclass());
	@BeforeTest
	@Parameters({"driver","nodeURL"})
	public void  setup( String driver,String nodeURL) throws MalformedURLException {
		log.info("------------------开始执行测试---------------");
		if(nodeURL.equals("")||nodeURL.isEmpty())
		{
			log.info("读取testng.xml配置的"+driver+"浏览器并将其初始化\n");
			try {
				this.driver=setDriver(driver);
			} catch (Exception e) {
				log.error("没有成功浏览器环境配置错误");
				e.printStackTrace();
			}
			System.out.println(nodeURL);
			this.driver.manage().window().maximize();
		}
		else {
			log.info("读取xml配置：浏览器:"+driver+"；gridNodeURL:"+nodeURL);
			try {
				this.driver=setRemoteDriver(driver,nodeURL);
			} catch (Exception e) {
				// TODO: handle exception
				log.error("没有成功浏览器环境配置错误");
			}

			this.driver.manage().window().maximize();
		}

	}

	@AfterTest
	public void tearDown() {
		this.driver.close();
		this.driver.quit();
		log.info("-------------结束测试，并关闭退出浏览器-------------");
	}

	/**
	 * 用枚举类型列出浏览器列表，用于设置浏览器类型的函数参数
	 *
	 */
	private WebDriver setDriver(String browsername)
	{

		switch (browsername)
		{

			case "FirefoxDriver" :
				 System.setProperty("Webdriver.gecko.driver","C:/Program Files/Mozilla Firefox/geckodriver.exe");
				  System.setProperty("Webdriver.firefox.bin","C:/Program Files/Mozilla Firefox/firefox.exe");
				  FirefoxProfile firefoxProfile=new FirefoxProfile();
				 // this.driver=new FirefoxDriver((Capabilities) firefoxProfile);
				this.driver =new FirefoxDriver();
				break;
			case "ChromeDriver":
				System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
				this.driver=new ChromeDriver();
				break;
			case "InternetExplorerDriver":
				System.setProperty("webdriver.ie.driver", "C:/Program Files (x86)/Internet Explorer/IEDriverServer.exe");
		//	System.setProperty("webdriver.ie.driver", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
				 this.driver=new InternetExplorerDriver();
				break;
			case "HtmlUnitDriver":
				this.driver=new HtmlUnitDriver();
				break;
			default:
				this.driver=new FirefoxDriver();
				break;
		}
		return driver;
	}



	private WebDriver setRemoteDriver(String browsername,String nodeURL) throws MalformedURLException
	{
		switch (browsername)
		{

			case "FirefoxDriver" :
				DesiredCapabilities capabilities=DesiredCapabilities.firefox();
				capabilities.setBrowserName("firefox");
				capabilities.setPlatform(Platform.WINDOWS);
				//driver= new RemoteWebDriver(new URL("http://192.168.0.205:4455/wd/hub"), capabilities);
				driver= new RemoteWebDriver(new URL(nodeURL), capabilities);
				break;
			case "ChromeDriver":
				// System.setProperty("webdriver.chrome.driver", "E:\\autotest\\autotmaiton\\resource\\chromedriver.exe");
				//driver=new ChromeDriver();
				DesiredCapabilities dcchorme=DesiredCapabilities.chrome();
				dcchorme.setBrowserName("chrome");
				dcchorme.setVersion("46.0.2490.86 m");
				dcchorme.setPlatform(Platform.WINDOWS);
				driver=new RemoteWebDriver(new URL(nodeURL), dcchorme);
				break;

			case "InternetExplorerDriver":
			DesiredCapabilities dc2 = DesiredCapabilities.internetExplorer();
//				dc2.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//				dc2.setCapability("ignoreProtectedModeSettings", true);
//				dc2.setBrowserName("internet explorer");
//				//dc2.setVersion("11.309.16299.0");
//				dc2.setPlatform(Platform.WINDOWS);
//				//driver= new RemoteWebDriver(new URL(nodeURL), dc2);
//		       WebDriver	  driver=new InternetExplorerDriver();
		       
			dc2.setPlatform(Platform.WINDOWS);
			//driver= new RemoteWebDriver(new URL("http://192.168.0.205:4455/wd/hub"), capabilities);
			driver= new RemoteWebDriver(new URL(nodeURL), dc2);
			break;

			case "HtmlUnitDriver":
				this.driver=new HtmlUnitDriver();
				break;
			default:
				this.driver=new FirefoxDriver();
				break;
		}
		return driver;
	}
	public static void main(String args[])
	{
		WebDriver driver2=new FirefoxDriver();
		driver2.get("http://121.40.197.16:3000/index.html#/login");
	}


}
