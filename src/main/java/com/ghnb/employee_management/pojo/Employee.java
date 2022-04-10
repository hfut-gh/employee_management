package com.ghnb.employee_management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private  Integer gender;
    private Department department;
    private String birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date().toString();
    }
}
