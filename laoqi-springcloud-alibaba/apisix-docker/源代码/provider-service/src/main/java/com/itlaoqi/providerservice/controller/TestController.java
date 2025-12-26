package com.itlaoqi.providerservice.controller;

import com.itlaoqi.providerservice.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @GetMapping("/hello")
    public Map sendMessage(HttpServletRequest request){
        Map result = new HashMap();
        result.put("code", "0");
        result.put("host", request.getLocalAddr());
        result.put("message", "hello world~");
        return result;
    }

    @PostMapping("/user/{uid}")
    public ResponseEntity<User> createUser(@PathVariable("uid") String uid , @RequestBody User user) {
        user.setUid(uid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> query(int page,int rows) {
        List<User> users = new ArrayList<>();

        for (int i = rows*(page-1); i < rows * page; i++) {
            String uid = "uid:" + i;
            String username = "username-" + i;
            String password = "password-" + i;
            String nickname = "nickname-" + i;

            User user = new User(uid,username, password, nickname);
            users.add(user);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
