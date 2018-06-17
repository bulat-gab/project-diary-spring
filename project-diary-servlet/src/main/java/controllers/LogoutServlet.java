package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by gab on 09.Mar.2018
 */
public class LogoutServlet extends HttpServlet{
    private static Logger LOGGER = Logger.getLogger(LogoutServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        session.invalidate();

        LOGGER.info("Logged out");

        try {
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
    }
}
