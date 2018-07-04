package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tinder.dao.UsersDAO;
import tinder.utils.ServletUtil;
import tinder.utils.Encryptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


public class LoginServlet extends HttpServlet {
    private UsersDAO dao = new UsersDAO();
    private ServletUtil util = new ServletUtil();
    private Encryptor cyph = new Encryptor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
            Cookie ckId = new Cookie("userID", cyph.encrypt(loginValidation[1]));
            Cookie ckGe = new Cookie("gender", cyph.encrypt(loginValidation[2]));
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

