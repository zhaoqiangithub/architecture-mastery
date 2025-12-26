package com.italoqi.providerservicedubbo.dubbo.impl;

import com.italoqi.providerservicedubbo.dubbo.ProviderService;
import com.italoqi.providerservicedubbo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DubboService
public class ProviderServiceImpl implements ProviderService {
    public Map hello() {
        Map result = new HashMap();
        result.put("code", "0");
        result.put("message", "hello world~");
        return result;
    }

    public User createUser(String uid, String username , String password , String nickname) {
        return new User(uid,username,password,nickname);
    }

    public ResponseEntity<List<User>> query(int page, int rows) {
        List<User> users = new ArrayList<>();
        for (int i = rows * (page - 1); i < rows * page; i++) {
            String uid = "uid:" + i;
            String username = "username-" + i;
            String password = "password-" + i;
            String nickname = "nickname-" + i;
            User user = new User(uid, username, password, nickname);
            users.add(user);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
