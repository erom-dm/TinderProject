package tinder.servlets;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// sends appropriate css files to other servlets
public class CssServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // take the path from the command line (HttpServletRequest)
        String url = req.getPathInfo();

        Path filePath = null;
        try {
            filePath = Paths.get(this.getClass().getResource(url).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Files.copy(filePath, resp.getOutputStream());


        /*String url = req.getPathInfo();
        url = url.substring(1,url.length());
        String out = FileUtils.readFileToString(new File(url),"UTF-8");
        byte[] buffer = out.getBytes();
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(buffer);
        outputStream.close();*/
    }




    /*@Override
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
    }*/

}
