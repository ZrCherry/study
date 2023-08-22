package com.cherry.test;

import com.cherry.entity.Emp;
import com.cherry.mapper.EmpMapper;
import com.cherry.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName: EmpMapperTest
 * Package: com.cherry.test
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/22 10:45
 * @Version 1.0
 */
public class EmpMapperTest {
    @Test
    public void testGetById(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getById(2);
        System.out.println(emp);
    }

    @Test
    public void testEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpDeptByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getByStepOne(1);
        System.out.println(emp.getDept().getDeptName());
    }

}
