package entites;

import java.time.LocalDateTime;
import java.util.Date;

public class Message {
    private String content;
    private String date;
    private User user;

    public Message(String content, String date, User user) {
        this.content = content;
        this.date = date;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
