package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import tinder.dao.UsersDAO;
import tinder.models.User;
import tinder.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PeopleListServlet extends HttpServlet {
    UsersDAO dao = new UsersDAO();
    ServletUtil util = new ServletUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = util.getConfiguration();

        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");
        ckId.setMaxAge(60*5);
        ckGe.setMaxAge(60*5);
        resp.addCookie(ckId);
        resp.addCookie(ckGe);

        int loggedUserId = Integer.parseInt(ckId.getValue());

        Map<String, Object> model = new HashMap<>();
        List<User> likedUsers = dao.getAllLiked(loggedUserId);
        model.put("likedUsers", likedUsers);


        Template template = cfg.getTemplate("people-list.html");
        Writer out = resp.getWriter();

        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("backButton");

        if(name.equals("back")){
            resp.sendRedirect("/users");
        }
        else if(name.equals("logout")){
            if (req.getCookies() != null) {
                for (int i = 0; i < req.getCookies().length; i++) {
                    req.getCookies()[i].setMaxAge(0);
                    resp.addCookie(req.getCookies()[i]);
                }
            }

            resp.sendRedirect("/login");
        }
    }
}