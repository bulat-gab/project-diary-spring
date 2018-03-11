package com.gab.controllers;

import com.gab.model.pojo.User;
import com.gab.services.impl.UserServiceImpl;
import com.gab.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

/**
 * Created by gab on 05.Mar.2018
 */

@Controller
@SessionAttributes("username")
public class SessionController {
    private static Logger LOGGER = Logger.getLogger(SessionController.class.getName());
    private static UserService userService = new UserServiceImpl() ;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    protected ModelAndView login(@ModelAttribute User inputUser, ModelMap model) {
        LOGGER.info("Logging in");

        try {
            User user = userService.auth(inputUser);
            if(inputUser != null && inputUser.equals(user)){
                LOGGER.info(user.getUsername()+ " has successfully logged in.");
                model.addAttribute("username", user.getUsername());
                return new ModelAndView("redirect:/showdiaries", model);
            }
        }
        catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected ModelAndView logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        LOGGER.info("User has logged out");

        return new ModelAndView("redirect:/index.jsp");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    protected ModelAndView doPost(@ModelAttribute User user, ModelMap model) {
        LOGGER.info("Registration");

        try {
            boolean isRegistered = userService.register(user.getUsername(), user.getPassword());

            if (isRegistered) {
                LOGGER.info("User " + user.getUsername() + " has registered.");
                model.addAttribute("username", user.getUsername());
                return new ModelAndView("redirect:/register-success.jsp", model);
            }
        }
        catch (Exception e){
            LOGGER.warning("Error registering user: " + e.getMessage());
        }
        return new ModelAndView("redirect:/register-fail.jsp");
    }
}
