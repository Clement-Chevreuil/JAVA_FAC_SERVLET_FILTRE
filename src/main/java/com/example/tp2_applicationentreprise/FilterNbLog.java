package com.example.tp2_applicationentreprise;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/WelcomeServlet"})
public class FilterNbLog implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);

        HttpSession session = ((HttpServletRequest) request).getSession(false);
        int nbConnexion = (int) session.getAttribute("sessionNumero");

        if(nbConnexion > 10){
            session.invalidate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.append("<form><h2> <font color=\"red\" >limite de connexion est atteint</font></h2>");
            out.append("<a href='index.jsp'> Deconnexion</a></form>");
        } else {
            System.out.println("nb : " + nbConnexion);
            chain.doFilter(request, response);
        }
    }
}
