package sdp.views.chat.views;

import sdp.models.chat.ChatRoomManager;
import sdp.models.chat.User;

public class ChatApp {
private ChatView chatView;
public ChatApp(){
    chatView =new ChatView();
}
public void show(){
    System.out.println("Enter your username");
    String username = chatView.getUserInput();
    User user = new User(username);
    System.out.println("Adding you to the chat");
    chatView.getChatRoomManager().addObserver(user);
    while (true) {
        System.out.println("Enter your message to send it to the chat or 'exit' to leave the chat");
        String content = chatView.getUserInput();
        
        if (content.equalsIgnoreCase("exit")) {
            chatView.getChatRoomManager().removeObserver(user);
            System.out.println("Removed from the chat");
            break; // Exit the loop if user inputs "exit"
        } else {
            chatView.addMessage(username, content);
            System.out.println("Message sent");
        }
    }

}


       
    }
