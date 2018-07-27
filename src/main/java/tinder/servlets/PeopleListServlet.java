package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tinder.dao.UsersDAO;
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
import java.util.List;
import java.util.Map;


public class PeopleListServlet extends HttpServlet {
    private UsersDAO dao = new UsersDAO();
    private ServletUtil util = new ServletUtil();
    private Encryptor cyph = new Encryptor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Configuration cfg;
        cfg = util.getConfiguration(this.getClass());

        Cookie ckId = util.getCookiesByName(req, "userID");

        int loggedUserId = Integer.parseInt(cyph.decrypt(ckId.getValue()));

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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