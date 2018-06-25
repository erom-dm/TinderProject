package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import tinder.dao.UsersDAO;
import tinder.models.User;
import tinder.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


public class LoginServlet extends HttpServlet {
    UsersDAO dao = new UsersDAO();
    ServletUtil util = new ServletUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = util.getConfiguration();

        Map<String, String> model = new HashMap<>();
        model.put("output", "Please sign in");
        Template template = cfg.getTemplate("login.html");
        Writer out = resp.getWriter();
        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = util.getConfiguration();

        String username = req.getParameter("username");
        String password = req.getParameter("pass");
        String register = req.getParameter("regButton");

        Map<String, String> model = new HashMap<>();
        Template template = cfg.getTemplate("login.html");
        Writer out = resp.getWriter();
        String[] loginValidation = dao.loginValidation(username, password);

        if(register == "reg"){
            resp.sendRedirect("/register");
        }
        else if(loginValidation[0].equals("true")){

            Cookie ckId = new Cookie("userID", loginValidation[1]);
            Cookie ckGe = new Cookie("gender", loginValidation[2]);
            ckId.setMaxAge(60*60);
            ckGe.setMaxAge(60*60);
            resp.addCookie(ckId);
            resp.addCookie(ckGe);

            resp.sendRedirect("/users");

        }
        else{
            model.put("output", "Login/Pass was incorrect");
            try {
                template.process(model, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }

    }


}

