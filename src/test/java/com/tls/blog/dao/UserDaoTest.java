package com.tls.blog.dao;

import com.tls.blog.model.User;
import javafx.application.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Before


    @After


    @Test
    public void insertUser() {
        User user = userDao.selectByName("root");
        Assert.assertEquals(user, null);
    }
}