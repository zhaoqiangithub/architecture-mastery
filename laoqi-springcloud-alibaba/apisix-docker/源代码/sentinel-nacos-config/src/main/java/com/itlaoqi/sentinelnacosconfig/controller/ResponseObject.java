package com.itlaoqi.sentinelnacosconfig.controller;

import lombok.Data;

/**
 * 封装响应数据的对象
 */
@Data
public class ResponseObject {
    private String code; //结果编码，0-固定代表处理成功
    private String message;//响应消息
    private Object data;//响应附加数据（可选）

    public ResponseObject(String code, String message) {
        this.code = code;
        this.message = message;
    }
    //Getter/Setter省略
}