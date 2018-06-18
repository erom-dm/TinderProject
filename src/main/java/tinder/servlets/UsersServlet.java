package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import tinder.dao.UserStorage;
import tinder.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class UsersServlet extends HttpServlet{
    private final UserStorage userStorage;

    public UsersServlet(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("src/main/java/tinder/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        Map<String, Object> model = new HashMap<>();
        if(userStorage.getFirstUnseen() != null) {
            model.put("ul_user", userStorage.getFirstUnseen());
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
        if(name.equals("like")){
            User current = userStorage.getFirstUnseen();
            current.setLiked(true);
            current.setSeen(true);
        }else if (name.equals("dislike")){
            User current = userStorage.getFirstUnseen();
            current.setLiked(false);
            current.setSeen(true);
        }else if (name.equals("toLiked")){
            resp.sendRedirect("/liked");
        }

        resp.sendRedirect("/users");
    }
}
