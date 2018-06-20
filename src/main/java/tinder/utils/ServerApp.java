package tinder.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tinder.models.*;
import tinder.servlets.ChatServlet;
import tinder.servlets.CssServlet;
import tinder.servlets.PeopleListServlet;
import tinder.servlets.UsersServlet;

public class ServerApp {

    public static void main(String[] args) throws Exception {

        new Server(8001) {{
            setHandler(new ServletContextHandler() {{
                           addServlet(new ServletHolder(new UsersServlet()) ,"/users");
                           addServlet(new ServletHolder(new CssServlet()),"/static/*");
                           addServlet(new ServletHolder(new PeopleListServlet()) ,"/liked");
                           addServlet(new ServletHolder(new ChatServlet()) ,"/messages/*");
                       }}
            );
            start();
            join();
        }};
    }

}
