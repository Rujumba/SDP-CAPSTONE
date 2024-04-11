package sdp.models.chat;

import sdp.repository.ChatRepository;
import sdp.views.chat.ChatObserver;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomManager {
    private ChatRepository chatRepository;
    private List<ChatObserver> observers = new ArrayList<>();

    public void addObserver(ChatObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ChatObserver observer) {
        observers.remove(observer);
    }

    public void addMessage(Message message) {
        chatRepository.addMessage(message);
        notifyObservers(message);
    }

    public void notifyObservers(Message message) {
        for (ChatObserver observer : observers) {
            observer.update(message);
        }
    }
}
