package webserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main_explained(String[] args) throws Exception {
        Server s = new Server(8001);
        ServletContextHandler h = new ServletContextHandler();
        ServletA svA = new ServletA();
        ServletHolder svh = new ServletHolder(svA);
        h.addServlet(svh,"/a");
        s.setHandler(h);
        s.start();
        s.join();
    }

    public static void main(String[] args) throws Exception {
        new Server(8001) {{
            setHandler(new ServletContextHandler() {{
                           addServlet(new ServletHolder(new ServletA()),"/a");
                       }}
            );
            start();
            join();
        }};
    }
}
