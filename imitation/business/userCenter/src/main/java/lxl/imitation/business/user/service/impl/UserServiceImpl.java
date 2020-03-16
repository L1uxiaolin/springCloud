package lxl.imitation.business.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lxl.imitation.business.user.mapper.UserMapper;
import lxl.imitation.business.user.model.User;
import lxl.imitation.business.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lxl
 * @date 2020/3/16  18:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
