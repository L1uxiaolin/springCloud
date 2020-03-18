package lxl.imitation.business.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户相关页面跳转
 * @author lxl
 * @date 2020/3/18  15:11
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/loginPage")
    public ModelAndView loginPage(){
        return new ModelAndView("/user/login/login");
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(){
        return "success";
    }
}
