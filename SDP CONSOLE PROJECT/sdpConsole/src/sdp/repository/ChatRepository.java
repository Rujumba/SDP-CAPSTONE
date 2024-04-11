package sdp.repository;

import sdp.models.chat.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatRepository {
    private List<Message> messages =new ArrayList<>();
    public void addMessage(Message message) {
        messages.add(message);
    }
}
