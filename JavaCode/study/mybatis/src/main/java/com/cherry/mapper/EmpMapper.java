package com.cherry.mapper;

import com.cherry.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: EmpMapper
 * Package: com.cherry.mapper
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/22 10:41
 * @Version 1.0
 */
public interface EmpMapper {
    Emp getById(@Param("id")Integer id);

    Emp getEmpDeptByEmpId(@Param("empId")Integer empId);

    Emp getByStepOne(@Param("empId") Integer empId);

    List<Emp> getDeptEmpStepTwo(@Param("deptId") Integer deptId);
}
