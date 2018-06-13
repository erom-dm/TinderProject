package webserver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletB extends HttpServlet {
    private final Database base;

    public ServletB(Database base) {
        this.base = base;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = base.get(0);
        base.put(0, "the value modified from servletB");
        resp.getWriter().write(s);
    }
}
