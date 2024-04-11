package sdp.repository;

import sdp.models.chat.Message;

import java.util.List;

public class ChatRepository {
    private List<Message> messages;
    public void addMessage(Message message) {
        messages.add(message);
    }
}
