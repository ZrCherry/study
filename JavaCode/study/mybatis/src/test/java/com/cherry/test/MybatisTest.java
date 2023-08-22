package com.cherry.test;

import com.cherry.entity.User;
import com.cherry.mapper.UserMapper;
import com.cherry.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * ClassName: MybatisTest
 * Package: com.cherry.test
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/18 9:43
 * @Version 1.0
 */
public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        int result = user.insertUser();
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int update = mapper.update();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete();
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.list();
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetOne(){
        String name = "cherry";
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userByName = mapper.getUserByName(name);
        System.out.println(userByName);
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(3);
        user.setAge(12);
        user.setEmail("222@qq.com");
        user.setGender("男");
        user.setUsername("cherry");
        user.setPassword("123456");
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateById(user);
        System.out.println(i);
        sqlSession.close();
    }

}
