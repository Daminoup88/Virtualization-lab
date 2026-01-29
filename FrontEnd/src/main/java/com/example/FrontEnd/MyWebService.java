package com.example.FrontEnd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyWebService {

    @Value("${backEndURL}")
    String backEndURL;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(){
        return "<!DOCTYPE html>" +
            "<html>" +
            "<body>" +
            "<h1>User Management</h1>" +
            "<form method='POST' action='/add-user'>" +
            "<input type='text' name='username' placeholder='Enter username' required>" +
            "<button type='submit'>Add User</button>" +
            "</form>" +
            "<h2>Last 10 Users</h2>" +
            "<div id='users'>" + getUsers() + "</div>" +
            "</body>" +
            "</html>";
    }

    @RequestMapping(path = "/add-user", method = RequestMethod.POST)
    public String addUser(@RequestParam String username){
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(backEndURL + "/users?username=" + username, null, String.class);
            return "<!DOCTYPE html>" +
                "<html>" +
                "<body>" +
                "<h1>User Added!</h1>" +
                "<p><a href='/'>Back</a></p>" +
                "</body>" +
                "</html>";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    private String getUsers() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(backEndURL + "/users", String.class);
            return "<pre>" + response + "</pre>";
        } catch (Exception e) {
            return "Error loading users: " + e.getMessage();
        }
    }
}
