package com.cherry.entity;

import lombok.Data;

import java.util.List;

/**
 * ClassName: Dept
 * Package: com.cherry.entity
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/22 10:40
 * @Version 1.0
 */
@Data
public class Dept extends Emp {
    private Integer deptId;
    private String deptName;
    private List<Emp> emps;
}
