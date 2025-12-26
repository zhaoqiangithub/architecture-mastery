package com.itlaoqi.gatewayuserservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final List<User> users = new ArrayList<>();

    public UserController() {
        // Initialize with some sample users
        for (int i = 1; i <= 50; i++) {
            users.add(new User((long) i, "User " + i, i + 18));
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        int limit = (int) (Math.random() * 20) + 1;
        return users.stream().limit(limit).collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam("query") String query) {
        int limit = (int) (Math.random() * 10) + 1;
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(query)) {
                result.add(user);
            }
            if (result.size() >= limit) {
                break;
            }
        }
        return result;
    }
}