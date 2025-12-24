package library.controller;

import library.model.Member;
import library.service.LoginService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginService();
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        addCorsHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }



    private void addCorsHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Member member = loginService.login(email, password);

        if (member == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Login failed");
        } else {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("Welcome " + member.getName());
        }
    }
}
