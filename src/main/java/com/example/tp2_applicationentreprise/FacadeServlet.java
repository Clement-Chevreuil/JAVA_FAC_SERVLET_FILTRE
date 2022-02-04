package com.example.tp2_applicationentreprise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FacadeServlet", value = "/FacadeServlet")
public class FacadeServlet extends HttpServlet {

    int nb;
    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String password;

        username = request.getParameter("username");
        password = request.getParameter("password");

        HttpSession session = request.getSession(true);

        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("sessionNumero", nb = nb + 1);


        response.sendRedirect("WelcomeServlet");
    }
}
