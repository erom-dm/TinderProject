package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import tinder.dao.OpinionsDAO;
import tinder.dao.UsersDAO;
import tinder.models.Opinion;
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
import java.util.HashMap;
import java.util.Map;

public class UsersServlet extends HttpServlet{
    UsersDAO dao = new UsersDAO();
    OpinionsDAO daoOpinions = new OpinionsDAO();
    ServletUtil util = new ServletUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = util.getConfiguration();

        Map<String, User> model = new HashMap<>();

        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");
       /* ckId.setMaxAge(60*5);
        ckGe.setMaxAge(60*5);
        resp.addCookie(ckId);
        resp.addCookie(ckGe);*/

        int loggedUserId = Integer.parseInt(ckId.getValue());
        String genderInterest = util.reverseGender(ckGe.getValue());

        User user = dao.getFirstUnseen(genderInterest, loggedUserId);
        if(user != null) {
            model.put("ul_user", user);
        }else{
            resp.sendRedirect("/liked");
        }

        Template template = cfg.getTemplate("like-page.html");
        Writer out = resp.getWriter();

        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("likeButton");

        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");
        /*ckId.setMaxAge(60*5);
        ckGe.setMaxAge(60*5);
        resp.addCookie(ckId);
        resp.addCookie(ckGe);*/

        int loggedUserId = Integer.parseInt(ckId.getValue());
        String genderInterest = util.reverseGender(ckGe.getValue());

        User user = dao.getFirstUnseen(genderInterest, loggedUserId);
        if(name.equals("like")){
            daoOpinions.save(new Opinion(loggedUserId, user.getUserId(), 1));
        }else if (name.equals("dislike")){
            daoOpinions.save(new Opinion(loggedUserId, user.getUserId(), 0));
        }else if (name.equals("toLiked")){
            resp.sendRedirect("/liked");
        }
        resp.sendRedirect("/users");
    }
}
