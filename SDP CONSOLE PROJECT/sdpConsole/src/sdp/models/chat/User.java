package sdp.models.chat;

import sdp.views.chat.ChatObserver;

public class User implements ChatObserver {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public void update(Message message) {
        System.out.println(username + " received message from " + message.getSender() + ": " + message.getContent());
    }
}
