package tinder.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class ServletUtil {
    public Cookie getCookiesByName(HttpServletRequest request, String name) {
        if (request.getCookies() == null) {
            return null;
        }
        for (int i = 0; i < request.getCookies().length; i++) {
            if (request.getCookies()[i].getName().equals(name)) {
                return request.getCookies()[i];
            }
        }
        return null;
    }

    public String reverseGender(String userGender){
        switch (userGender) {
            case "male":
                return "female";
            case "female":
                return "male";
            default:
                return null;
        }
    }

    public static Configuration getConfiguration(Class servletClass) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        //cfg.setDirectoryForTemplateLoading(new File("resources/static/html"));
        cfg.setClassLoaderForTemplateLoading(servletClass.getClassLoader(), "static/html");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        return cfg;
        /*Template template = cfg.getTemplate(templateName);

        try {
            template.process(variables, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }*/

    }
}
