package com.manage.demo.pageobjectconfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class GetXmlPageObject {

	public  static void getXmlPageObject()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://test.cppchina.com.cn");
		String tString=driver.getPageSource();
		System.out.println(tString);
	}
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		GetXmlPageObject.getXmlPageObject();
	}
}