package com.tls.blog.dao;


import com.tls.blog.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    final String TABLE_NAME = " user ";
    final String INSERT_FIELDS = " name, password, salt, head_url ,role ";
    final String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values (#{name},#{password},#{salt},#{headUrl},#{role})"})
    void insertUser(User user);

    @Select({"select", SELECT_FIELDS, "FROM", TABLE_NAME, "where id = {#id}"})
    User selectById(int id);

    @Select({"select", SELECT_FIELDS, "FROM", TABLE_NAME, "where name = {#name}"})
    User selectByName(String name);

    @Delete({"delete from",TABLE_NAME,"where id=#{id}"})
    void deleteById(int id);

}
