package sdp.views.chat.views;

import java.util.Scanner;

import sdp.models.chat.ChatRoomManager;
import sdp.models.chat.Message;
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
        return scanner.nextLine();
    }
    public void addMessage(String sender,String message){
        this.message.setContent(message);
        this.message.setSender(sender);
        chatRoomManager.addMessage(this.message);
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
    public ChatRoomManager getChatRoomManager() {
        return chatRoomManager;
    }
    public void setChatRoomManager(ChatRoomManager chatRoomManager) {
        this.chatRoomManager = chatRoomManager;
    }
    
}
