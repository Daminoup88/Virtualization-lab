package com.example.BackEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.annotation.PostConstruct;

@RestController
public class MyWebService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        try {
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, username VARCHAR(255))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello(){
        return " Hello Damien !";
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<Map<String, Object>> getUsers() {
        return jdbcTemplate.queryForList("SELECT id, username FROM users ORDER BY id DESC LIMIT 10");
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String addUser(@RequestParam String username) {
        jdbcTemplate.update("INSERT INTO users (username) VALUES (?)", username);
        return "User added";
    }
}
