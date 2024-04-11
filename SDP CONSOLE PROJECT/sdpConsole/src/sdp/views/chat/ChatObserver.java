package sdp.views.chat;

import sdp.models.chat.Message;

public interface ChatObserver {
    void update(Message message);
}
