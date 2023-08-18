package com.cherry.mapper;

import com.cherry.entity.User;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.cherry.mapper
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/18 9:29
 * @Version 1.0
 */
public interface UserMapper {
    int insertUser();

    int update();

    int delete();

    List<User> list();
}
