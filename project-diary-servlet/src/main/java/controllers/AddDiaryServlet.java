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
import java.util.logging.Logger;

/**
 * Created by gab on 07.Mar.2018
 */
public class AddDiaryServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(AddDiaryServlet.class.getName());
    private static DiaryService diaryService = new DiaryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.info("Add diary");
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        Diary diary = new Diary(
                req.getParameter("diary-name"),
                req.getParameter("diary-note"));
        boolean isSaved = diaryService.saveDiaryByUserName(username, diary);
        LOGGER.info("New diary for user " + username + " " + isSaved);
        try {
            resp.sendRedirect("/showdiaries");
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }

    }
}
