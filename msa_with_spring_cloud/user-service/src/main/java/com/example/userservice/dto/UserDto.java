package com.example.userservice.dto;

import java.util.*;

import com.example.userservice.vo.ResponseOrder;
import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;

    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
