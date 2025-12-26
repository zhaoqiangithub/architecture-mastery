package com.italoqi.providerservicedubbo.dubbo;

import com.italoqi.providerservicedubbo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProviderService {
    public Map hello();

    public User createUser(String uid, String username, String password, String nickname);

    public ResponseEntity<List<User>> query(int page, int rows);
}
