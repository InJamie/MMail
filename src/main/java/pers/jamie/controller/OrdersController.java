package pers.jamie.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import pers.jamie.entity.*;
import pers.jamie.service.*;
import pers.jamie.vo.CartVo;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Controller
@RequestMapping("//orders")
public class OrdersController {


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/settlement2")
    public ModelAndView gotoStatement2(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User)session.getAttribute("user");
        List<CartVo> goods = cartService.findByUserid(user.getId());
        modelAndView.addObject("goods",goods);
////        删除购物车中商品
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("user_id",user.getId());
//        cartService.remove(wrapper);

//        ----------------------------------------------
        List<CartVo> lists = cartService.findByUserid(user.getId());
        modelAndView.addObject("lists",lists);

        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("user_id",user.getId());
        List<UserAddress> addresses  = userAddressService.list(wrapper1);
        modelAndView.addObject("addresses",addresses);
        modelAndView.setViewName("settlement2");
        return modelAndView;


    }

    @PostMapping("/createOrder")
    public String createOrder(String selectAddress,String address,String remark,Float cost,HttpSession session){
//        创建Orders  填入user信息
        User user = (User)session.getAttribute("user");
        Orders order = new Orders();
        order.setUserId(user.getId());
        order.setLoginName(user.getLoginName());
//        填入地址
//            ------------------------将全部默认地址制空，再将新地址存入为默认-----------------------------------
        QueryWrapper wrapperaddre = new QueryWrapper();
        wrapperaddre.eq("user_id",user.getId());
        wrapperaddre.eq("isdefault",1);
        UserAddress one = userAddressService.getOne(wrapperaddre);
        if (one !=null){
            one.setIsdefault(0);
            userAddressService.updateById(one);
        }

        if (selectAddress.equals("newAddress")){
            order.setUserAddress(address);
            UserAddress newadress = new UserAddress();
            newadress.setAddress(address);
            newadress.setIsdefault(1);
            newadress.setUserId(user.getId());
            newadress.setRemark(remark);
            userAddressService.save(newadress);

        }else {
            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("user_id",user.getId());
            wrapper1.eq("address",selectAddress);
            UserAddress one1 = userAddressService.getOne(wrapper1);
            one1.setIsdefault(1);
            userAddressService.updateById(one1);


            order.setUserAddress(selectAddress);

//            存储新地址并设置为默认选择
        }
//        存入serialnumber

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            String s = Integer.toHexString(new Random().nextInt(16));
            buffer.append(s);
        }
        String serialnumber = buffer.toString();
        order.setSerialnumber(serialnumber);
//        填入cost
        order.setCost(cost);
        ordersService.save(order);
//        --------------------------------获取购物车列表存储在OrderDetail中-------------------------------------------------------------
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
        List<OrderDetail> orderDetails = new ArrayList<>();

        List<Cart> list = cartService.list(wrapper);
        for (Cart c : list) {
            OrderDetail detail = new OrderDetail();
            BeanUtils.copyProperties(c,detail);
            detail.setOrderId(order.getId());
            orderDetails.add(detail);
        }
        orderDetailService.saveBatch(orderDetails);
//        ---------------------------------------------------------------------------------------------
        //        删除购物车中商品
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("user_id",user.getId());
        cartService.remove(wrapper1);
//        ---------------------------------------------------------------------------------------------
        return "redirect:/cart/goToSettlement3/"+order.getId()+"/"+user.getId();
    }

}

