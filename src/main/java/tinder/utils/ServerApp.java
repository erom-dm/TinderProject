package tinder.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tinder.filters.AuthFilter;
import tinder.servlets.*;
import javax.servlet.DispatcherType;
import java.util.Arrays;
import java.util.EnumSet;

public class ServerApp {

    public static void main(String[] args) throws Exception{
        System.out.println("Command line arguments:");
        System.out.println(Arrays.toString(args));
        String port = null;

        port = args.length > 0 ? args[0] : "8001";

        new Server(Integer.parseInt(port)) {{

            setHandler(new ServletContextHandler() {{
                           addServlet(new ServletHolder(new UsersServlet()) ,"/users");
                           addServlet(new ServletHolder(new CssServlet()),"/static/*");
                           addServlet(new ServletHolder(new PeopleListServlet()) ,"/liked");
                           addServlet(new ServletHolder(new ChatServlet()) ,"/messages/*");
                           addServlet(new ServletHolder(new LoginServlet()) ,"/login");
                           addServlet(new ServletHolder(new RegisterServlet()) ,"/register");
                           addFilter(new FilterHolder(new AuthFilter()), "/users", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
                           addFilter(new FilterHolder(new AuthFilter()), "/messages/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
                           addFilter(new FilterHolder(new AuthFilter()), "/liked", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
                       }}
            );

            try {
                start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }};
    }

}
