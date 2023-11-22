package com.jdbc.bootjdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDao(){

    }

    //create table
    public int createTable(){
        String query = "CREATE TABLE IF NOT EXISTS User(id int primary key, name varchar(200), age int, city varchar(100))";
        int update = this.jdbcTemplate.update(query);
        return update;
    }

    //inserting user to database
    public int insertUser(Integer id,String name,Integer age,String city){
        String query = "insert into user(id,name,age,city) values(?,?,?,?)";
        int update = this.jdbcTemplate.update(query, new Object[]{id, name, age, city});
        return update;
    }

    //update user from database
    public int updateUser(Integer id, String name, Integer age, String city) {
        String query = "UPDATE User SET name = ?, age = ?, city = ? WHERE id = ?";
        int update = this.jdbcTemplate.update(query, new Object[]{name, age, city, id});
        return update;
    }

    //delete user from database
    public int deleteUser(Integer id) {
        String query = "DELETE FROM User WHERE id = ?";
        int update = this.jdbcTemplate.update(query, new Object[]{id});
        return update;
    }

    //search user from database
    public List<Map<String, Object>> search(Integer id) {
        String query = "select * from User where id= ?";
        List<Map<String, Object>> result = this.jdbcTemplate.queryForList(query, id);
        return result;
    }
}