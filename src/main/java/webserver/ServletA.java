package webserver;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import webserver.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ServletA extends HttpServlet{
    private final Database base;

    public ServletA(Database base) {
        this.base = base;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("./src/main/java/webserver/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        Map<String, Object> model = new HashMap<>();
        model.put("path", req.getRequestURI());
        model.put("requrl", req.getRequestURL().toString());
        String qs = req.getQueryString();
        model.put("params", qs==null ? "" : qs);
        model.put("user", "Andy");
        Product latest = new Product("http://www.ua", "new site");
        model.put("latestProduct", latest);
        model.put("items", new RemoteData().get());

        Template template = cfg.getTemplate("template1.ftlh");
        Writer out = resp.getWriter();
        base.get(1);

        try {
            template.process(model, out);
            String s = base.get(0);
            base.put(0, "the value modified from servletA");
            resp.getWriter().write(s);

        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
