package pers.jamie.service;

import pers.jamie.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.jamie.vo.CartVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
public interface CartService extends IService<Cart> {

    public List<CartVo> findByUserid(Integer id);

}
