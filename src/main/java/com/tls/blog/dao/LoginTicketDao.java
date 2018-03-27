package com.tls.blog.dao;

import com.tls.blog.model.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginTicketDao {
    final String TABLE_NAME = " login_ticket ";
    final String INSERT_FIELDS = " user_id, expired, status, ticket";
    final String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where id=#{id}"})
    LoginTicket selectById(int id);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ")values(#{userId}, #{expired}, #{status}, #{ticket})"})
    void insertLoginTicket(LoginTicket loginTicket);

    @Update({"update", TABLE_NAME, "set status = #{status} where ticket=#{ticket}"})
    void updateStatus(@Param("status") int status, @Param("ticket") String ticket);

    @Delete({"Delete from", TABLE_NAME, "where id = #{id}"})
    void deleteLoginTicket(int id);


}


