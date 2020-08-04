package pers.jamie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pers.jamie.entity.User;
import pers.jamie.service.CartService;
import pers.jamie.vo.CartVo;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RedirectCOntroller {
    @Autowired
    private CartService service;
    @GetMapping("{url}")
    public ModelAndView redirect(@PathVariable("url") String url, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");

        List<CartVo> list = new ArrayList<>();
        if (user!=null)
            list = service.findByUserid(user.getId());
        modelAndView.addObject("lists", list);
        modelAndView.setViewName(url);
        return modelAndView;
    }

    @GetMapping("/")
    private String index(){
        return "redirect:/productCategory/getall";
    }
}
