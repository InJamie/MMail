package pers.jamie.service.impl;

import pers.jamie.entity.Orders;
import pers.jamie.mapper.OrdersMapper;
import pers.jamie.service.OrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
