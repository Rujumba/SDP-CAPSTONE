package sdp.models.chat;

import sdp.views.chat.ChatObserver;

public class User implements ChatObserver {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public void update(Message msg) {
                System.out.println(msg.getSender()+": "+msg.getContent());  
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
