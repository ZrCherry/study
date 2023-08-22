package com.cherry.test;

import com.cherry.entity.User;
import com.cherry.mapper.SelectMapper;
import com.cherry.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: SelectMapperTest
 * Package: com.cherry.test
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/21 16:28
 * @Version 1.0
 */
public class SelectMapperTest {
    @Test
    public void testGetById(){
        SqlSession instance = SqlSessionUtil.getInstance();
        SelectMapper mapper = instance.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        instance.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testCount(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int count = mapper.count();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testSelectBlur(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.selectBlur("e");
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int i = mapper.deleteMoreUser("5,6,7,8,9,10");
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> t_user = mapper.getUserList("t_user");
        t_user.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User();
        user.setAge(12);
        user.setEmail("222@qq.com");
        user.setGender("男");
        user.setUsername("cherry");
        user.setPassword("123456");
        int insert = mapper.insert(user);
        System.out.println("insert:"+insert);
        System.out.println("id:"+user.getId());
        sqlSession.close();
    }
}

