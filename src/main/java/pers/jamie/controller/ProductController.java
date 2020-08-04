package pers.jamie.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import pers.jamie.entity.Cart;
import pers.jamie.entity.Product;
import pers.jamie.entity.User;
import pers.jamie.service.CartService;
import pers.jamie.service.ProductCategoryService;
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
@RequestMapping("//product")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private CartService cartService;

    @ResponseBody
    @GetMapping("list")
    public List<Product> list(){
        return service.list();
    }



    @GetMapping("find2level/{level}/{levelid}")
    public ModelAndView find2level(@PathVariable("level") Integer level, @PathVariable("levelid") Integer levelid, HttpSession session){
        List<Product> products = service.findByLevle(level, levelid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",products);
        User user = (User)session.getAttribute("user");
        List<CartVo> list = new ArrayList<>();
        if (user!=null)
            list = cartService.findByUserid(user.getId());
        modelAndView.addObject("lists", list);
        modelAndView.addObject("list",productCategoryService.getall());
        modelAndView.setViewName("productList");
        return modelAndView;
    }

    @PostMapping("/findByKey")
    public ModelAndView findByKey(String keyWord,HttpSession session){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name",keyWord);
        List products = service.list(wrapper);
        ModelAndView modelAndView = new ModelAndView();
        User user = (User)session.getAttribute("user");
        List<CartVo> list = new ArrayList<>();
        if (user!=null)
            list = cartService.findByUserid(user.getId());
        modelAndView.addObject("lists", list);
        modelAndView.addObject("list",productCategoryService.getall());
        modelAndView.addObject("products",products);
        modelAndView.setViewName("productList");
        return modelAndView;
    }


    @GetMapping("/productDetail/{id}")
    public ModelAndView productDetail(@PathVariable("id") Integer id,HttpSession session){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        Product product = (Product)service.getOne(wrapper);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",product);
        User user = (User)session.getAttribute("user");
        List<CartVo> list = new ArrayList<>();
        if (user!=null)
            list = cartService.findByUserid(user.getId());
        modelAndView.addObject("lists", list);
        modelAndView.addObject("list",productCategoryService.getall());
        modelAndView.setViewName("productDetail");
        return modelAndView;
    }

    @PostMapping("updateCart/{id}/{quantity}/{cost}")
    @ResponseBody
    public String updateCart(
            @PathVariable("id")Integer id,
            @PathVariable("quantity")Integer quantity,
            @PathVariable("cost")Float cost,
            HttpSession session
    ){
        ModelAndView modelAndView = new ModelAndView();
//        增加购物车数量
        Cart cart = this.cartService.getById(id);
//
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",cart.getProductId());
        Product product = service.getOne(wrapper);

        product.setStock(product.getStock()-(quantity-cart.getQuantity()));
        service.updateById(product);
//
        cart.setQuantity(quantity);
        cart.setCost(cost);
        boolean update = this.cartService.updateById(cart);
        if (update==true){
            return "success";
        }else
            return "fail";

//        库存--


    }

}

