package com.manage.demo.pageaction;

import com.manage.demo.pagemanage.LoginPage;
import com.manage.demo.util.ElementAction;
import com.manage.demo.util.TestBaseCase;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class LoginAction extends TestBaseCase {
    public LoginAction(String Url,String UserName,String PassWord) throws IOException
    {
        ElementAction action=new ElementAction();
        action.sleep(10);
        //此driver变量继承自TestBase变量
        LoginPage loginPage=new LoginPage();
        loginPage.open(Url);
        System.out.println(driver.getCurrentUrl());
        action.sleep(1);
        action.clear(loginPage.loginusername());
        action.type(loginPage.loginusername(),UserName);
        action.sleep(1);
        action.clear(loginPage.loginupassword());
        action.type(loginPage.loginupassword(),PassWord);
        action.sleep(1);
        String currentWindow = driver.getWindowHandle();
        action.click(loginPage.loginbutton());
        //------得到所有窗口的句柄  ------//
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        while(it.hasNext()){
            String handle = it.next();
            if(currentWindow.equals(handle)) continue;
            WebDriver window = driver.switchTo().window(handle);
        }


    }
}