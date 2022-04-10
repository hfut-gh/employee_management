package com.ghnb.employee_management.dao;

import com.ghnb.employee_management.pojo.Department;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

@Component
public class DepartmentDao {
    private static HashMap<Integer, Department> departments=null;

    static{
        departments =new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"体育部"));
        departments.put(103,new Department(103,"后勤部"));
        departments.put(104,new Department(104,"文艺部"));
        departments.put(105,new Department(105,"财政部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

    public Integer addDepartment(){

        return 1;
    }


    public Integer deleteDepartmentById(Integer id){
        try{
            departments.remove(id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
