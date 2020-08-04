package pers.jamie.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import pers.jamie.entity.OrderDetail;
import pers.jamie.entity.Orders;
import pers.jamie.entity.Product;
import pers.jamie.entity.User;
import pers.jamie.service.CartService;
import pers.jamie.service.OrderDetailService;
import pers.jamie.service.OrdersService;
import pers.jamie.service.ProductService;
import pers.jamie.vo.CartVo;
import pers.jamie.vo.OrderDetailVo;
import pers.jamie.vo.OrdersVo;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Controller
@RequestMapping("//orderDetail")
public class OrderDetailController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;



    @GetMapping("/orderDetail")
    public ModelAndView orderDetail(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

        List<OrdersVo> ordersVos = new ArrayList<>();

        User user = (User) session.getAttribute("user");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
//        1.查找orders
        List<Orders> list = ordersService.list(wrapper);
        for (Orders orders:list) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setLoginName(user.getLoginName());
            BeanUtils.copyProperties(orders,ordersVo);

//      2.查找order_detail
            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("order_id", orders.getId());
            List<OrderDetail> list1 = orderDetailService.list(wrapper1);

            List<OrderDetailVo> orderDetailVos = new ArrayList<>();

            for (OrderDetail orderDetail:list1) {
//                封装orderDetail
                OrderDetailVo orderDetailVo = new OrderDetailVo();
                BeanUtils.copyProperties(orderDetail,orderDetailVo);
//                封装product
                QueryWrapper wrapper2 = new QueryWrapper();
                wrapper2.eq("id",orderDetail.getProductId());
                Product product = productService.getOne(wrapper2);
                BeanUtils.copyProperties(product,orderDetailVo);

                orderDetailVos.add(orderDetailVo);

            }
            ordersVo.setOrderDetails(orderDetailVos);
            ordersVos.add(ordersVo);

        }

        modelAndView.addObject("orders",ordersVos);

        List<CartVo> lists = new ArrayList<>();
        lists = cartService.findByUserid(user.getId());
        modelAndView.addObject("lists", lists);


        modelAndView.setViewName("orderList");
        return modelAndView;
    }

}

