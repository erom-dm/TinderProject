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
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("src/main/java/tinder/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");
        ckId.setMaxAge(60*60);
        ckGe.setMaxAge(60*60);
        resp.addCookie(ckId);
        resp.addCookie(ckGe);

        //String secondUserName = req.getRequestURI().replace("/messages/", ""); //  /messages/JanePoole
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


        //TODO cookies. Get logged in user ID and second user ID -> load appropriate chat data into the freemarker.
        //https://www.javatpoint.com/cookies-in-servlet
        
        //Cookie ck=new Cookie("user","sonoo jaiswal")  - create new cookie
        //resp.addCookie(ck);  - add cookie to server response
        //Cookie ck=new Cookie("user","");//deleting value of cookie  
        //ck.setMaxAge(0);//changing the maximum age to 0 seconds  
        //resp.addCookie(ck);//adding cookie in the response
        
        //Cookie ck[]=req.getCookies();  - how to get all the cookies
        //for(int i=0;i<ck.length;i++){  
        //  out.print("<br>"+ck[i].getName()+" "+ck[i].getValue());//printing name and value of cookie  
        //} 
        
        
        //public void addCookie(Cookie ck):method of HttpServletResponse interface is used to add cookie in response object.
        //public Cookie[] getCookies()    :method of HttpServletRequest interface is used to return all the cookies from the browser.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("textInput");

        Cookie ckId = util.getCookiesByName(req, "userID");
        Cookie ckGe = util.getCookiesByName(req, "gender");
        ckId.setMaxAge(60*60);
        ckGe.setMaxAge(60*60);
        resp.addCookie(ckId);
        resp.addCookie(ckGe);


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
