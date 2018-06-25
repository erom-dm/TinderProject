package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import tinder.dao.MessagesDAO;
import tinder.dao.UsersDAO;
import tinder.models.Message;
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
import java.util.List;
import java.util.Map;

public class ChatServlet extends HttpServlet {
    UsersDAO dao = new UsersDAO();
    MessagesDAO daoM = new MessagesDAO();
    ServletUtil util = new ServletUtil();

    public ChatServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = util.getConfiguration();
        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");
        /*ckId.setMaxAge(60*5);
        ckGe.setMaxAge(60*5);
        resp.addCookie(ckId);
        resp.addCookie(ckGe);*/

        String[] uriParse = stringConverter(req);
        Map<String, Object> model = new HashMap<>();
        int loggedUserId = Integer.parseInt(ckId.getValue());
        int secondUserId = Integer.parseInt(uriParse[0]);
        String secondUserName = uriParse[1].replace("_", " ");
        List<Message> messages = daoM.getAllChatRoomMessages(loggedUserId,secondUserId);

        model.put("chatLabel", secondUserName);
        model.put("messages", messages);
        model.put("user1", dao.get(loggedUserId));
        model.put("user2", dao.get(secondUserId));

        Template template = cfg.getTemplate("chat.html");
        Writer out = resp.getWriter();

        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");
        /*ckId.setMaxAge(60*5);
        ckGe.setMaxAge(60*5);
        resp.addCookie(ckId);
        resp.addCookie(ckGe);*/

        String name = req.getParameter("textInput");
        String[] uriParse = stringConverter(req);

        int loggedUserId = Integer.parseInt(ckId.getValue());
        int secondUserId = Integer.parseInt(uriParse[0]);

        Message msg = new Message(loggedUserId, secondUserId, name);
        StringBuffer url = req.getRequestURL();

        try {
            daoM.save(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(url.toString());
    }

    private String[] stringConverter(HttpServletRequest req){
        String[] temp = req.getRequestURI().replace("/messages/ID:", "").split("_", 2);
        return temp;
    }
}
