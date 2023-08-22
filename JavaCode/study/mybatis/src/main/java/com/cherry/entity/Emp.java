package com.cherry.entity;

import lombok.Data;

/**
 * ClassName: Emp
 * Package: com.cherry.entity
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/22 10:38
 * @Version 1.0
 */
@Data
public class Emp {
    private Integer empId;
    private String empName;
    private Integer age;
    private String gender;
    private Dept dept;
}
