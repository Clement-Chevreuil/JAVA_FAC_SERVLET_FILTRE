package com.example.tp2_applicationentreprise;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/WelcomeServlet", "/FacadeServlet"})
public class FilterLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("filter execution");
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        System.out.println("session " + session);
        if (session == null) {
            System.out.println("session null");
            //((HttpServletRequest) request).getRequestDispatcher("index.jsp").include(request, response);
            ((HttpServletResponse) response).sendRedirect("connexion.html");
        } else
            chain.doFilter(request, response);

    }
}
