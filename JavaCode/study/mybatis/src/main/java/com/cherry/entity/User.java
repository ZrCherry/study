package com.cherry.entity;

import lombok.Data;

/**
 * ClassName: User
 * Package: com.cherry.entity
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/18 9:18
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String email;
}
