package com.tls.blog.service;

import com.tls.blog.dao.LoginTicketDao;
import com.tls.blog.dao.UserDao;
import com.tls.blog.model.LoginTicket;
import com.tls.blog.model.User;
import com.tls.blog.util.BlogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginTicketDao loginTicketDao;

    public Map<String, String> register(String userName, String password) {
        Map<String, String> map = new HashMap<>();
        Random random = new Random();
        if (StringUtils.isBlank(userName)) {
            map.put("msg", "username cannot be null");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("msg", "password cannot be null");
            return map;
        }
        User u = userDao.selectByName(userName);
        if (u != null) {
            map.put("msg", "user already exist");
            return map;
        }
        User user = new User();
        user.setName(userName);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png",random.nextInt(1000)));
        user.setPassword(BlogUtil.MD5(password+user.getSalt()));
        user.setRol("user");
        userDao.insertUser(user);
        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }

    public Map<String, String> login(String userName, String password) {
        Map<String, String> map = new HashMap<>();
        Random random = new Random();
        if (StringUtils.isBlank(userName)) {
            map.put("msg", "username cannot be null");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("msg", "password cannot be null");
            return map;
        }
        User u = userDao.selectByName(userName);
        if (u == null) {
            map.put("msg","failed");
            return map;
        }

        String md5Password = BlogUtil.MD5(password+u.getSalt());
        if (!md5Password.equals(u.getPassword())) {
            map.put("msg","failed");
            return map;
        }
        String ticket = addLoginTicket(u.getId());
        map.put("ticket",ticket);
        return map;

    }


    public String addLoginTicket(int userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*30);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        loginTicketDao.insertLoginTicket(loginTicket);
        return loginTicket.getTicket();
    }
}
