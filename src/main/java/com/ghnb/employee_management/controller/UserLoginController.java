package com.ghnb.employee_management.controller;

import com.ghnb.employee_management.dao.EmployeeDao;
import com.ghnb.employee_management.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserLoginController {
    @RequestMapping("/user/login")
    public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        if(!StringUtils.isEmpty(username)&& "123".equals(password)){
            session.setAttribute("loginUser",username);
            return "dashboard";
        }
        else{
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }


}
