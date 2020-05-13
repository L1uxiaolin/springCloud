package lxl.imitation.business.user.controller;

import lombok.extern.slf4j.Slf4j;
import lxl.imitation.business.user.model.Ticket;
import lxl.imitation.business.user.model.User;
import lxl.imitation.business.user.service.TicketService;
import lxl.imitation.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用户相关页面跳转
 * @author lxl
 * @date 2020/3/18  15:11
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    private Lock lock = new ReentrantLock();
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;

    @GetMapping("/loginPage")
    public ModelAndView loginPage(){
        return new ModelAndView("/user/login/login");
    }

    @ResponseBody
    @GetMapping("/login")
    public int login() throws InterruptedException {
        User user;
        for(int i = 0;i < 100000;i++){
            user = new User();
            user.setUserNickname("测试账号_" + i);
            user.setUserSex((byte) (i % 2));
            user.setUserHeadPortraitId(i);
            Thread.sleep(1);
            userService.save(user);
        }
        return 1;
    }

    @ResponseBody
    @PostMapping("/test")
    public String test(Integer id) {
        lock.lock();
        User user = userService.getById(id);
        if(null != user){
            Ticket ticket = ticketService.getById(1);
            log.info(user.getUserNickname() + "拿到了票务信息");
            if(null != ticket && (null == ticket.getPayerId() || ticket.getPayerId() <= 0)){
                ticket.setPayerId(user.getId());
                ticketService.updateById(ticket);
                log.info("购票成功：" + user.getUserNickname());
                return "购票成功：" + user.getUserNickname();
            }else{
                log.info("已无余票：" + user.getUserNickname());
                return "已无余票" + user.getUserNickname();
            }
        }else{
            log.info("id为" + id + "的用户不存在");
            return "id为" + id + "的用户不存在";
        }
    }
}
