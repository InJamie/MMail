package pers.jamie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import pers.jamie.entity.User;
import pers.jamie.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Controller
@RequestMapping("//user")
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("login")
    public String login(User user, HttpSession session){
        User login = service.login(user);
        String url;
        if (login!=null){
            session.setAttribute("user",login);
            url = "redirect:/";
        }else {
            url = "login";
            session.setAttribute("flag","账号或密码有误！");
        }
        return url;
    }

    @PostMapping("register")
    public String register(User user){
        boolean save = service.save(user);
        if (save){
            return"login";
        }else
            throw new RuntimeException("用户信息填写有误。");
    }

    @GetMapping("remove")
    public String remove(HttpSession session){
        session.removeAttribute("user");
          return "redirect:/";
    }

}

