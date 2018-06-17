package controllers;

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
public class DeleteDiaryServlet extends HttpServlet{
    private static Logger LOGGER = Logger.getLogger(DeleteDiaryServlet.class.getName());
    private static DiaryService diaryService = new DiaryServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.info("Delete diary");
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String diaryName = req.getParameter("diary-to-delete");
        boolean isDeleted = diaryService.deleteDiaryByUserName(username, diaryName);
        LOGGER.info("Diary for user " + username + " " + isDeleted);
        try {
            resp.sendRedirect("/showdiaries");
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
    }
}
