package com.itlaoqi.providerservicedubbo.dubbo;

import com.itlaoqi.providerservicedubbo.dto.User;

import java.util.List;
import java.util.Map;

public interface ProviderService {
    public Map hello();

    public User createUser(String uid, String username, String password, String nickname);

    public List<User> query(int page, int rows);
}
