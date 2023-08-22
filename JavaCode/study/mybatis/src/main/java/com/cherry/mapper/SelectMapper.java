package com.cherry.mapper;

import com.cherry.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: SelectMapper
 * Package: com.cherry.mapper
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/21 16:24
 * @Version 1.0
 */
public interface SelectMapper {

    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();

    int count();

    //模糊查询
    List<User> selectBlur(@Param("username") String username);

    int deleteMoreUser(@Param("ids") String ids);

    List<User> getUserList(@Param("tableName") String tableName);

    int insert(User user);
}
