package com.gab.controllers;

import com.gab.model.pojo.User;
import com.gab.services.impl.UserServiceImpl;
import com.gab.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by gab on 05.Mar.2018
 */

@Controller
@SessionAttributes("username")
@RequestMapping("/login")
public class LoginController {
    private static Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    private static UserService userService = new UserServiceImpl() ;

    @RequestMapping(method = RequestMethod.POST)
    protected ModelAndView doPost(@ModelAttribute User inputUser, ModelMap model) {
        try {
            User user = userService.auth(inputUser);
            if(inputUser != null && inputUser.equals(user)){
                LOGGER.info(user.getUsername()+ " has successfully logged in.");
                model.addAttribute("username", user.getUsername());
                return new ModelAndView("redirect:/showdiaries", model);
            }
            else{
                return new ModelAndView("redirect:/index", model);
            }
        }
        catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
        return new ModelAndView("redirect:/index", model);
    }
}
