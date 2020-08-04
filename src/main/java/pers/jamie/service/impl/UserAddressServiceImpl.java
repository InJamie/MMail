package pers.jamie.service.impl;

import pers.jamie.entity.UserAddress;
import pers.jamie.mapper.UserAddressMapper;
import pers.jamie.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

    public static void main(String[] args) {
    }

}
