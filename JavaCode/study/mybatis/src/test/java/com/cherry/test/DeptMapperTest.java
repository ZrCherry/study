package com.cherry.test;

import com.cherry.entity.Dept;
import com.cherry.mapper.DeptMapper;
import com.cherry.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName: DeptMapperTest
 * Package: com.cherry.test
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/22 14:53
 * @Version 1.0
 */
public class DeptMapperTest {
    @Test
    public void testDeptEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptEmp = mapper.getDeptEmp(1);
        System.out.println(deptEmp);
    }


    @Test
    public void testDeptEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getInstance();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptEmp = mapper.getDeptEmpStepOne(1);
        System.out.println(deptEmp);
    }
}
