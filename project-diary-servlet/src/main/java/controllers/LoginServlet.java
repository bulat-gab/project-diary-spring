package controllers;

import model.pojo.User;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by gab on 05.Mar.2018
 */

public class LoginServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
    private static UserServiceImpl userService = new UserServiceImpl() ;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = userService.auth(username, password);
            if(user != null){
                LOGGER.info(username + " has successfully logged in.");
                HttpSession session = req.getSession();
                session.setAttribute("username", username);

                resp.sendRedirect("showdiaries");
            }
            else{
                resp.sendRedirect("index.jsp");
                //req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
        catch (/*ServletException | */IOException e) {
            LOGGER.warning(e.getMessage());
        }
    }
}
