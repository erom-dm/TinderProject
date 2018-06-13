package tinder.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tinder.servlets.CssServlet;
import tinder.servlets.UsersServlet;

import javax.servlet.Servlet;

public class ServerApp {
    public static void main_explained(String[] args) throws Exception {
        //DatabaseHashMap base = new DatabaseHashMap();
        Server s = new Server(8001);
        ServletContextHandler h = new ServletContextHandler();
        UsersServlet svA = new UsersServlet();
        ServletHolder svh = new ServletHolder(svA);
        h.addServlet(svh,"/users");
        s.setHandler(h);
        s.start();
        s.join();
    }

    public static void main(String[] args) throws Exception {
        //Database base = new DatabaseHashMap();
        //base.put(0,"Value modified from main");
        new Server(8001) {{
            setHandler(new ServletContextHandler() {{
                           addServlet(new ServletHolder(new UsersServlet()) ,"/users");
                           addServlet(new ServletHolder(new CssServlet()),"/static/*");
                           //addServlet(new ServletHolder(new ServletB()),"/b/*");
                       }}
            );
            start();
            join();
        }};
    }
}
