package sdp.views.chat;

import sdp.models.chat.Message;

public interface ChatObservable {
    void addObserver(ChatObserver observer);
    void removeObserver(ChatObserver observer);
    void notifyObservers(Message message);
}
