package com.ghnb.employee_management.dao;

import com.ghnb.employee_management.pojo.Department;
import com.ghnb.employee_management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

@Component
public class EmployeeDao {
    private static HashMap<Integer, Employee> employees=null;
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"A","A123456@qq.com",0,
                new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"B","B123456@qq.com",1,
                new Department(102,"教学部")));
        employees.put(1003,new Employee(1003,"C","C123456@qq.com",1,
                new Department(103,"教学部")));
        employees.put(1004,new Employee(1004,"D","D123456@qq.com",0,
                new Department(104,"教学部")));
        employees.put(1005,new Employee(1005,"E","E123456@qq.com",0,
                new Department(105,"教学部")));
    }

    public Collection<Employee> getAllEmployees(){
        Collection<Employee> a =employees.values();
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }


    //主键自增！！
    private static Integer initId=1006;

    public Integer addEmployee(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
        return 1;
    }

    public Integer deleteById(Integer id){
        try{
            employees.remove(id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

}
