import entites.Message;
import entites.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@WebServlet(name = "chatService", urlPatterns = {"/chatService"})
public class ChatServiceServlet extends HttpServlet {

    ArrayList<Message> messages = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?

        messages.forEach(s -> {
            try {

                response.getWriter().println(s.getDate());
                response.getWriter().println(s.getUser().getName() + " :" + s.getContent()+"/n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("UId");
        String userName = req.getParameter("UName");
        String message = req.getParameter("UMsg");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        User currUser = new User(userName, userId);

        Message currMessage = new Message(message, localDateTime.format(dtf), currUser);
        messages.add(currMessage);
        resp.getWriter().println("<h1>Hello " + message + "!</h1>");
        resp.setStatus(200);



    }
}
