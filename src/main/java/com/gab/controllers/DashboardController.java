package com.gab.controllers;

import com.gab.model.pojo.Diary;
import com.gab.services.impl.DiaryServiceImpl;
import com.gab.services.interfaces.DiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gab on 06.Mar.2018
 */
@Controller
@SessionAttributes("username")
public class DashboardController {
    private static Logger LOGGER = Logger.getLogger(DashboardController.class.getName());
    private static DiaryService diaryService = new DiaryServiceImpl() ;

    @RequestMapping(value = "/showdiaries", method = RequestMethod.GET)
    protected ModelAndView showDiaries(ModelMap model) {
        LOGGER.info("Show diary");

        try{
            String username = "";
            if(model.containsAttribute("username")) {
                username = (String) model.get("username");

                List<Diary> diaries = diaryService.getAllDiariesByUserName(username);
                LOGGER.info("Diaries fetched for " + username);
                model.addAttribute("diaries", diaries);
                return new ModelAndView("/dashboard", model);
            }
        }
        catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
        return new ModelAndView("redirect:/index");
    }


    @RequestMapping(value = "/add-diary", method = RequestMethod.POST)
    protected ModelAndView addDiary(@ModelAttribute Diary diary, ModelMap model) {
        LOGGER.info("Add diary");
        try {
            String username;
            if(model.containsAttribute("username")){
                username = (String) model.get("username");
                boolean isSaved = diaryService.saveDiaryByUserName(username, diary);
                LOGGER.info("New diary for user " + username + " " + isSaved);
            }
            return showDiaries(model);
        }
        catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
        return new ModelAndView("redirect:/index");
    }


    @RequestMapping(value = "/delete-diary", method = RequestMethod.POST)
    protected ModelAndView deleteDiary(@RequestParam String diaryToDelete, ModelMap model) {
        LOGGER.info("Delete diary: " + diaryToDelete);
        try {
            String username;
            if(model.containsAttribute("username")) {
                username = (String) model.get("username");
                boolean isDeleted = diaryService.deleteDiaryByUserName(username, diaryToDelete);
                LOGGER.info("Diary for user " + username + " " + isDeleted);
            }

            return showDiaries(model);
        }
        catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
        return new ModelAndView("redirect:/index");
    }
}
