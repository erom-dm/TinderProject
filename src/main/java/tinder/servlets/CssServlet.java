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
import java.nio.file.Path;
import java.nio.file.Paths;

// sends appropriate css files to other servlets
public class CssServlet extends HttpServlet {

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // take the path from the command line (HttpServletRequest)
        String url = req.getPathInfo();
        if (url!=null) {
            // input
            Path in = Paths.InterfaceDAO("./src/main/java/tinder/templates/css", url);
            // set the type for downloading ability instead of plain show in the browser window.
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", in.getFileName().toString()));
            // move content from the FileInputStream to ServletOutputStream
            Files.copy(in, resp.getOutputStream());
        } else {
            resp.getWriter().print("you should pass the file name after slash");
        }
    }*/


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("./src/main/java/tinder/templates/css"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        // "static/css/bootstrap.min.css" - incoming URI example
        // InterfaceDAO css file name from incoming URI
        String cssReqString = req.getRequestURI().replace("/static/css/", "");
        Template template = cfg.getTemplate(cssReqString);
        resp.getWriter().write(template.toString());
    }

}
