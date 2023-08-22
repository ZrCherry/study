package com.cherry.mapper;

import com.cherry.entity.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: DeptMapper
 * Package: com.cherry.mapper
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/22 11:31
 * @Version 1.0
 */
public interface DeptMapper {
    Dept GetByStepTwo(@Param("deptId") Integer deptId);

    Dept getDeptEmp(@Param("deptId") Integer deptId);

    Dept getDeptEmpStepOne(@Param("deptId") Integer deptId);
}
