package sdp;

import sdp.models.chat.ChatRoomManager;
import sdp.models.chat.User;
import sdp.views.chat.views.ChatController;
import sdp.views.chat.views.ChatView;

public class sdpMain {

    public static void main(String[] args) {

        ChatRoomManager chatRoom = new ChatRoomManager();

        // Create users
        User user1 = new User("User1");
        User user2 = new User("User2");

        // Add users to chat room
        chatRoom.addObserver(user1);
        chatRoom.addObserver(user2);

        // Create controller
        ChatController controller = new ChatController(chatRoom, new ChatView());

        // Continuously prompt for user input
        while (true) {
            System.out.println("Enter your message (or 'exit' to leave): ");
            String input = controller.getChatView().getUserInput();

            if (input.equalsIgnoreCase("exit")) {
                 // Assume user1 wants to leave add method to detach the user
                break;
            } else {
                controller.sendMessage(user1, input);
            }
        }
    }

}
