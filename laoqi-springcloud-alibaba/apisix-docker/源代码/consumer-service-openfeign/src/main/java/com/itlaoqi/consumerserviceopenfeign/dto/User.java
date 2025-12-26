package com.itlaoqi.consumerserviceopenfeign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String uid;
    private String username;
    private String password;
    private String nickname;
}
