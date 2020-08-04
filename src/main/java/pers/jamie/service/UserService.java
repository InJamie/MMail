package pers.jamie.service;

import pers.jamie.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
public interface UserService extends IService<User> {

    public User login(User user);

}
