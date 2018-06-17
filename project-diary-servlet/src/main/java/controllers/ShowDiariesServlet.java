package controllers;

import model.pojo.Diary;
import services.impl.DiaryServiceImpl;
import services.interfaces.DiaryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gab on 06.Mar.2018
 */
public class ShowDiariesServlet extends HttpServlet{
    private static Logger LOGGER = Logger.getLogger(ShowDiariesServlet.class.getName());
    private static DiaryService diaryService = new DiaryServiceImpl() ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Show diary");
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        List<Diary> diaries = diaryService.getAllDiariesByUserName(username);
        LOGGER.info("Diaries fetched for " + username);
        req.setAttribute("diaries", diaries);
        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
