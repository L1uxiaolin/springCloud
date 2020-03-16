package lxl.imitation.business.user;

import lxl.imitation.business.user.model.User;
import lxl.imitation.business.user.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("lxl.imitation.business.user.mapper")
@RestController
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/testMybatis")
    public List<User> testMybatis(){
        return userService.list();
    }
}
