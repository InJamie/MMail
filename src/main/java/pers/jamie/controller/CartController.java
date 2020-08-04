package pers.jamie.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import pers.jamie.entity.Cart;
import pers.jamie.entity.Orders;
import pers.jamie.entity.Product;
import pers.jamie.entity.User;
import pers.jamie.service.CartService;
import pers.jamie.service.OrdersService;
import pers.jamie.service.ProductService;
import pers.jamie.vo.CartVo;

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
@RequestMapping("//cart")
public class CartController {


    @Autowired
    private CartService service;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/addGoods/{id}/{price}/{quantity}")
    public ModelAndView addGoods(
            @PathVariable("id") Integer id,
            @PathVariable("price") Float price,
            @PathVariable("quantity") Integer quantity,
            HttpSession session) {
        try {
            ModelAndView modelAndView = new ModelAndView();
//            封装 存储Cart
            User user = (User) session.getAttribute("user");
            Cart cart = new Cart(id, quantity, price * quantity, user.getId());
            this.service.save(cart);
//            库存--(已实现)
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",cart.getProductId());
            Product product = productService.getOne(wrapper);

            product.setStock(product.getStock()-cart.getQuantity());
            productService.updateById(product);

            List<CartVo> list = new ArrayList<>();
            if (user!=null)
             list = service.findByUserid(user.getId());
            modelAndView.addObject("lists", list);
            modelAndView.setViewName("settlement1");
            return modelAndView;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    @GetMapping("removeCart/{id}")
    public ModelAndView removeCart(@PathVariable("id")Integer id,HttpSession session){
        //移除在购物车中商品
        Cart cart = this.service.getById(id);

        boolean b = service.removeById(id);
//            库存++(待实现)
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("id",cart.getProductId());
        Product product = productService.getOne(wrapper1);

        product.setStock(product.getStock()+cart.getQuantity());
        productService.updateById(product);
//

        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        List<CartVo> list = new ArrayList<>();
        if (user!=null) {
            list = service.findByUserid(user.getId());
        }
        modelAndView.addObject("lists", list);
        modelAndView.setViewName("settlement1");
        return modelAndView;
    }


    @GetMapping("goToSettlement3/{order_id}/{user_id}")
    public ModelAndView goToSettlement3(
            @PathVariable("order_id") Integer order_id,
            @PathVariable("user_id") Integer user_id
    ){
        ModelAndView modelAndView = new ModelAndView();
        QueryWrapper wrapper =new QueryWrapper();
        wrapper.eq("id",order_id);
        Orders one = ordersService.getOne(wrapper);
        modelAndView.addObject("order",one);
        List<CartVo> list = new ArrayList<>();
        list = service.findByUserid(user_id);
        modelAndView.addObject("lists", list);
        modelAndView.setViewName("settlement3");
        return modelAndView;


    }

}

