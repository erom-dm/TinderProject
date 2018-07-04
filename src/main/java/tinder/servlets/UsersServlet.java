package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tinder.dao.OpinionsDAO;
import tinder.dao.UsersDAO;
import tinder.models.Opinion;
import tinder.models.User;
import tinder.utils.Encryptor;
import tinder.utils.ServletUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class UsersServlet extends HttpServlet{
    private UsersDAO dao = new UsersDAO();
    private OpinionsDAO daoOpinions = new OpinionsDAO();
    private ServletUtil util = new ServletUtil();
    private Encryptor cyph = new Encryptor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Configuration cfg = util.getConfiguration();

        Map<String, User> model = new HashMap<>();

        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");

        int loggedUserId = Integer.parseInt(cyph.decrypt(ckId.getValue()));
        String genderInterest = util.reverseGender(cyph.decrypt(ckGe.getValue()));

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("likeButton");

        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");

        int loggedUserId = Integer.parseInt(cyph.decrypt(ckId.getValue()));
        String genderInterest = util.reverseGender(cyph.decrypt(ckGe.getValue()));

        User user = dao.getFirstUnseen(genderInterest, loggedUserId);
        switch (name) {
            case "like":
                daoOpinions.save(new Opinion(loggedUserId, user.getUserId(), 1));
                break;
            case "dislike":
                daoOpinions.save(new Opinion(loggedUserId, user.getUserId(), 0));
                break;
            case "toLiked":
                resp.sendRedirect("/liked");
                break;
        }
        resp.sendRedirect("/users");
    }
}
