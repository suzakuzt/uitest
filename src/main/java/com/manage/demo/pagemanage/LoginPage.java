package com.manage.demo.pagemanage;
import java.io.IOException;
import java.io.InputStream;
import com.manage.demo.util.BaseAction;
import com.manage.demo.util.Locator;
import com.manage.demo.pageobjectconfig.PageObjectAutoCode;//CPP登陆页面_对象库类
public class LoginPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/manage/demo/pageObjectConfig/UILibrary.xml";
 public   LoginPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 快捷登陆
* @return
* @throws IOException
*/
public Locator loginusername() throws IOException
 {
   Locator locator=getLocator("loginusername");
   return locator;
 }

/***
* 用户名输入框
* @return
* @throws IOException
*/
public Locator loginupassword() throws IOException
 {
   Locator locator=getLocator("loginupassword");
   return locator;
 }

/***
* 登陆按钮
* @return
* @throws IOException
*/
public Locator loginbutton() throws IOException
 {
   Locator locator=getLocator("loginbutton");
   return locator;
 }
}