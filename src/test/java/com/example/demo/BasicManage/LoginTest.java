package com.example.demo.BasicManage;

import com.manage.demo.pageaction.LoginAction;
import com.manage.demo.util.Assertion;
import com.manage.demo.util.ElementAction;
import com.manage.demo.util.TestBaseCase;
import org.testng.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.io.IOException;

@SpringBootTest
//@Listeners({com.example.demo.util.AssertionListener.class})
public class LoginTest extends TestBaseCase {
    ElementAction action=new ElementAction();
    @Test(description="登录成功测试")
    @Parameters({"BaseUrl"})//读取testng.xml参数
    public void login(String BaseUrl) throws IOException {
        //BaseUrl="http://test.cppchina.com.cn/login";
        //调用登录方法，输入正确的用户名和密码
        LoginAction loginAction=new LoginAction(BaseUrl,"user1","cpp2017");
        action.sleep(2);
//        //设置检查点
//        Assertion.VerityTextPresentPrecision("","");
//        //设置用例断言，判断用例是否失败
//        Assertion.VerityError();
    }

}
