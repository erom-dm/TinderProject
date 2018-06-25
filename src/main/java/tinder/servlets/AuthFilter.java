package tinder.servlets;




import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        boolean loggedIn = false;


        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals("userID")) {
                    loggedIn = true;
                }
            }
        }
        if (loggedIn) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}