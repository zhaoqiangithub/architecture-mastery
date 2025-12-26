package com.itlaoqi.providerservicedubbo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private String uid;
    private String username;
    private String password;
    private String nickname;
}
