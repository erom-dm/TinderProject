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
import java.util.Map;


public class RegisterServlet extends HttpServlet {
    private UsersDAO dao = new UsersDAO();
    private ServletUtil util = new ServletUtil();
    private Encryptor cyph = new Encryptor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Configuration cfg = util.getConfiguration();

        Map<String, String> model = new HashMap<>();
        model.put("output", "Please provide following info:");
        Template template = cfg.getTemplate("register.html");
        Writer out = resp.getWriter();
        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Configuration cfg = util.getConfiguration();

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        String passCheck = req.getParameter("passCheck");
        String picURL = req.getParameter("picURL");
        String gender = req.getParameter("gender");

        Map<String, String> model = new HashMap<>();
        Template template = cfg.getTemplate("register.html");
        Writer out = resp.getWriter();

        if(!password.equals(passCheck)){
            model.put("output", "Passwords do not match");
            try {
                template.process(model, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        else {
            User user = new User();
            user.setUserName(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setUserPicURL(picURL);
            user.setGender(gender);
            dao.save(user);

            String[] loginValidation = dao.loginValidation(email, password);
            Cookie ckId = new Cookie("userID", cyph.encrypt(loginValidation[1]));
            Cookie ckGe = new Cookie("gender", cyph.encrypt(loginValidation[2]));
            ckId.setMaxAge(60*5);
            ckGe.setMaxAge(60*5);
            resp.addCookie(ckId);
            resp.addCookie(ckGe);

            resp.sendRedirect("/users");
        }

    }


}
