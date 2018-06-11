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
        base.put(1,"hello");
        super.doGet(req, resp);
    }
}
