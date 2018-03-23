package com.tls.blog.service;

import com.tls.blog.dao.UserDao;
import com.tls.blog.model.LoginTicket;
import com.tls.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    LoginTicket loginTicket;

    public Map<String, String> register(String userName, String password) {
        Map<String, String> map = new HashMap<>();
        Random random = new Random();
        if (StringUtils.isBlank(userName)) {
            map.put("msg", "username cannot be null");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("msg", "password cannot be null");
        }
        User u = userDao.selectByName(userName);
        if (u != null) {
            map.put("msg", "user already exist");
        }
        User user = new User();
        user.setName(userName);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png",random.nextInt(1000)));





        return map;
    }
}
