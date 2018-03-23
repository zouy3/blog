package com.tls.blog.model;

import java.util.Date;

public class LoginTicket {
    private int id;
    private int userId;
    private Date expired;
    private int status;
    private String ticket;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Date getExpired() {
        return expired;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }
}
