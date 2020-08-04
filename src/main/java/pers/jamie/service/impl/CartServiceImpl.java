package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.jamie.entity.Cart;
import pers.jamie.entity.Product;
import pers.jamie.mapper.CartMapper;
import pers.jamie.mapper.ProductMapper;
import pers.jamie.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.jamie.vo.CartVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<CartVo> findByUserid(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        List<CartVo> lists = new ArrayList<>();
        List<Cart> list = cartMapper.selectList(wrapper);
        for (Cart cart : list) {
            CartVo cartVo = new CartVo();
            BeanUtils.copyProperties(cart,cartVo);

            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("id",cart.getProductId());
            Product product = productMapper.selectOne(wrapper1);
            BeanUtils.copyProperties(product,cartVo);
            cartVo.setId(cart.getId());
            lists.add(cartVo);
        }
        return lists;
    }
}
