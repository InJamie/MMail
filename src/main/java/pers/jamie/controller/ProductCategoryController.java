package pers.jamie.controller;


import org.apache.velocity.util.ArrayListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
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
@RequestMapping("//productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;

    @Autowired
    private CartService cartService;


    @GetMapping("getall")
    public ModelAndView getall(HttpSession session){
        ModelAndView modelAndView  = new ModelAndView();
        modelAndView.addObject("list",service.getall());

        User user = (User)session.getAttribute("user");
        List<CartVo> list = new ArrayList<>();
        if (user!=null)
            list = cartService.findByUserid(user.getId());
        modelAndView.addObject("lists", list);
        modelAndView.setViewName("main");
        return modelAndView;
    }

}

