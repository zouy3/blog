package com.tls.blog.service;

import com.tls.blog.dao.UserDao;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Test
    public void register() {
        Map<String, String> map = new HashMap<>();
        map = userService.register("root", null);
        Assert.assertEquals("password cannot be null", map.get("msg"));
    }

    @Test
    public void login() {
        Map<String, String> map = new HashMap<>();
        map = userService.login("root", "123456");
        Assert.assertEquals("success", map.get("msg"));

    }

    @Test
    public void addLoginTicket() {
    }

    @Test
    public void test() {
        System.out.print("he");
    }
}