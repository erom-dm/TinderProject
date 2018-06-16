package tinder.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tinder.models.*;
import tinder.servlets.CssServlet;
import tinder.servlets.PeopleListServlet;
import tinder.servlets.UsersServlet;

public class ServerApp {

    public static void main(String[] args) throws Exception {
        Database base = new DatabaseHashMap();
        Storage userList = new UserStorage();
        User liM = new User(0, "Li Ming", "female" , "https://images.pexels.com/photos/356185/pexels-photo-356185.jpeg?auto=compress&cs=tinysrgb&h=350");
        User annN = new User(1, "Anna Nord", "female", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQF5gxTQ9yQIu4NN1aOQFfNbIOzCcAbsV-Uuax5DyAg-KBP-Sfl");
        User katV = new User(2, "Katarina Visconti", "female", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGsNRX2WRXZFgGV9t60roY-AS3jB1WM8wZmDaVOhb7N0fTL3KnTw");
        userList.put(liM);
        userList.put(annN);
        userList.put(katV);


        new Server(8001) {{
            setHandler(new ServletContextHandler() {{
                           addServlet(new ServletHolder(new UsersServlet(base, userList)) ,"/users");
                           addServlet(new ServletHolder(new CssServlet()),"/static/*");
                           addServlet(new ServletHolder(new PeopleListServlet(base, userList)) ,"/liked");
                       }}
            );
            start();
            join();
        }};
    }

}
