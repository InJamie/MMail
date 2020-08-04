package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pers.jamie.entity.User;
import pers.jamie.mapper.UserMapper;
import pers.jamie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public User login(User user) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("login_name",user.getLoginName());
        wrapper.eq("password",user.getPassword());
        return this.mapper.selectOne(wrapper);
    }
}
