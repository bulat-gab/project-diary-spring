package com.gab.controllers.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gab on 09.Mar.2018
 */
public class WhiteList implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = (String) ((HttpServletRequest) request)
                .getSession()
                .getAttribute("username");
        if(username != null) {
            chain.doFilter(request, response);
        }
        else {
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/");
        }
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig filterConfig) {}
}
