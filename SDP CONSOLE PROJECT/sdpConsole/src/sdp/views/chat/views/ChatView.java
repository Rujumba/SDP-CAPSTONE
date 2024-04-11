package sdp.views.chat.views;

import java.util.Scanner;

public class ChatView {
    private Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine();
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
