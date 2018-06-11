package webserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main_explained(String[] args) throws Exception {
        DatabaseHashMap base = new DatabaseHashMap();
        Server s = new Server(8001);
        ServletContextHandler h = new ServletContextHandler();
        ServletA svA = new ServletA(base);
        ServletHolder svh = new ServletHolder(svA);
        h.addServlet(svh,"/a");
        s.setHandler(h);
        s.start();
        s.join();
    }

    public static void main(String[] args) throws Exception {
        Database base = new DatabaseAmazonRDS();
        new Server(8001) {{
            setHandler(new ServletContextHandler() {{
                           addServlet(new ServletHolder(new ServletA(base)) ,"/a/*");
                           addServlet(new ServletHolder(new ServletB(base)),"/b/*");
                       }}
            );
            start();
            join();
        }};
    }
}
