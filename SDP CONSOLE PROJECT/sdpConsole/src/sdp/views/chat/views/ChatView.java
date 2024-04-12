package sdp.views.chat.views;

import java.time.LocalDateTime;
import java.util.Scanner;

import sdp.models.chat.ChatRoomManager;
import sdp.models.chat.Message;
import sdp.models.chat.User;
import sdp.repository.ChatRepository;

public class ChatView {
    private ChatRoomManager chatRoomManager;
    private Message message;
    private Scanner scanner = new Scanner(System.in);

    public ChatView(){
        this.message=new Message();
        this.chatRoomManager=new ChatRoomManager(new ChatRepository());
    }

    public String getUserInput() {
        String input = "";
            while (input.isEmpty()) {
                input = scanner.nextLine().trim();
            }
        return input;
    }
    public void addMessage(String sender,String message){
        this.message.setContent(message);
        this.message.setSender(sender);
        this.message.setSentAt(LocalDateTime.now());
        chatRoomManager.addMessage(this.message);
        this.message=new Message();
    }
    
    public ChatRoomManager getChatRoomManager() {
        return chatRoomManager;
    }
    public void setChatRoomManager(ChatRoomManager chatRoomManager) {
        this.chatRoomManager = chatRoomManager;
    }
    public void show(){
    System.out.println("...Enter your username....");
    String username = getUserInput();
    User user = new User(username);
    System.out.println("You have joined to the chat");
    chatRoomManager.addObserver(user);
    while (true) {
        System.out.println("Enter your message to send it to the chat or 'exit' to leave the chat");
        String content = getUserInput();
        
        if (content.equalsIgnoreCase("exit")) {
            chatRoomManager.removeObserver(user);
            System.out.println(user.getUsername()+" removed from the chat");
            break; // Exit the loop if user inputs "exit"
        } else {
            System.out.println("Message sent");
            addMessage(username, content);
            
        }
    }

}
    
}
