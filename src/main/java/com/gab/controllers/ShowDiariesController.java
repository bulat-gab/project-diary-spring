package com.gab.controllers;

import com.gab.model.pojo.Diary;
import com.gab.services.impl.DiaryServiceImpl;
import com.gab.services.interfaces.DiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gab on 06.Mar.2018
 */
@Controller
@SessionAttributes("username")
@RequestMapping("/showdiaries")
public class ShowDiariesController extends HttpServlet{
    private static Logger LOGGER = Logger.getLogger(ShowDiariesController.class.getName());
    private static DiaryService diaryService = new DiaryServiceImpl() ;

    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView doGet(ModelMap model) {
        LOGGER.info("Show diary");

        String username = "";
        if(model.containsAttribute("username")) {
            username = (String) model.get("username");

            List<Diary> diaries = diaryService.getAllDiariesByUserName(username);
            LOGGER.info("Diaries fetched for " + username);
            model.addAttribute("diaries", diaries);
            return new ModelAndView("/dashboard", model);
        }
        LOGGER.warning("User not found");
        return new ModelAndView("redirect:/index");
    }
}
