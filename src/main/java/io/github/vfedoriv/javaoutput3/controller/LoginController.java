package io.github.vfedoriv.javaoutput3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;

@WebServlet("/login")
@MultipartConfig
public class LoginController extends HttpServlet {
    private static final String USRNAME = "username";
    private static final String USRPWD = "password";
    private static final String MSG_LOGIN = "loginMessage";

    private UserService userService;

    public LoginController() {
        this.userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(USRNAME);
        String password = request.getParameter(USRPWD);
        HttpSession session = request.getSession();
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute(MSG_LOGIN, "Username and password cannot be empty.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        if (userService.authenticate(username, password)) {
            session.setAttribute("user", username);
            response.sendRedirect("mainMenu.jsp");
        } else {
            request.setAttribute(MSG_LOGIN, "Invalid username or password.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}