package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import tinder.dao.OpinionsDAO;
import tinder.dao.UsersDAO;
import tinder.models.Opinion;
import tinder.models.User;

import javax.servlet.ServletException;
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

public class UsersServlet extends HttpServlet{
    UsersDAO dao = new UsersDAO();
    OpinionsDAO daoOpinions = new OpinionsDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("src/main/java/tinder/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        Map<String, User> model = new HashMap<>();
        //TODO make input in getFirstUnseen dynamic, depending on currently logged user
        User user = dao.getFirstUnseen("female", 0);
        if(user != null) {
            model.put("ul_user", user);
        }else{
            resp.sendRedirect("/liked");
        }

        /*for(int i = 0; i < userStorage.size(); i++){
            model.put(Integer.toString(i), userStorage.InterfaceDAO(i));
        }*/

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
        //TODO pass inputs through the cookies
        User user = dao.getFirstUnseen("female", 0);
        if(name.equals("like")){
            daoOpinions.save(new Opinion(0, user.getUserId(), 1));
        }else if (name.equals("dislike")){
            daoOpinions.save(new Opinion(0, user.getUserId(), 0));
        }else if (name.equals("toLiked")){
            resp.sendRedirect("/liked");
        }
        resp.sendRedirect("/users");
    }
}
