package com.ghnb.employee_management.controller;

import com.ghnb.employee_management.dao.DepartmentDao;
import com.ghnb.employee_management.dao.EmployeeDao;
import com.ghnb.employee_management.pojo.Department;
import com.ghnb.employee_management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String getAll(Model modl){
        Collection<Employee> employees=employeeDao.getAllEmployees();
        modl.addAttribute("emps",employees);
        return "/emps/list";
    }

    //使用GetMapping，一般用作跳转
    @RequestMapping("/add")
    public String addEmp(Model model){
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departmens",departments);
        return "/emps/addEmp";
    }

    //Rest风格：url pattern一样，但是提交方式不一样是可以的，且走不同页面
    //使用PostMapping
    //对于视图解析器，redirect和forward对于视图的处理是不一样的，我们可以通过配置视图解析器  来自定义视图解析器！
    @PostMapping("add")
    public String addedEmp(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

}
