package controllers;

import model.pojo.User;
import model.utils.DataSourceFactory;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

/**
 * Created by gab on 05.Mar.2018
 */
public class RegistrationServlet extends HttpServlet{
    private static Logger LOGGER = Logger.getLogger(RegistrationServlet.class.getName());
    private static UserServiceImpl userService = new UserServiceImpl() ;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.info("doPost");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            boolean isRegistered = userService.register(username, password);

            if (isRegistered) {
                req.getSession().setAttribute("username", username);
                LOGGER.info(username + " has registered.");
                resp.sendRedirect("/register-success.jsp");
            }
            else {
                resp.sendRedirect("/register-fail.jsp");
            }
        }
        catch (IOException e){
            LOGGER.warning("Error registering user: " + e.getMessage());
        }
    }
}
