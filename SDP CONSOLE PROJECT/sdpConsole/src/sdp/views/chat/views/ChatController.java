package sdp.views.chat.views;

import sdp.models.chat.ChatRoomManager;
import sdp.models.chat.User;

public class ChatController {
    private ChatRoomManager chatRoomManager;
    private ChatView chatView;

    public ChatController(ChatRoomManager chatRoomManager,ChatView chatView) {
        this.chatRoomManager = chatRoomManager;
        this.chatView = chatView;
    }

    public void sendMessage(User user, String content) {
        user.sendMessage(chatRoomManager, content);
    }

    public ChatView getChatView() {
        return chatView;
    }

    public void setChatView(ChatView chatView) {
        this.chatView = chatView;
    }
}
