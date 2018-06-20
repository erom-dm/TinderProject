package tinder.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ChatServlet extends HttpServlet {

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
    
        //Map<String, Object> model = new HashMap<>();
        

        Template template = cfg.getTemplate("chat.html");
        resp.getWriter().write(template.toString());

        /*try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }*/
        
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
        String name = req.getParameter("button");
        if(name.equals("back")){
            resp.sendRedirect("/liked");
        }
    }
}
