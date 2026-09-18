package service;

import model.Message;
import java.util.ArrayList;

public class MessageService {

    private ArrayList<Message> messages =
            new ArrayList<>();

    private ActivityLogger logger =
            new ActivityLogger();

    public void sendMessage(Message message) {

        messages.add(message);

        System.out.println(
                "Message sent successfully."
        );

        logger.logActivity(
                "Message sent from User ID "
                + message.getSenderId()
                + " to User ID "
                + message.getReceiverId()
        );
    }

    public void displayAllMessages() {

        System.out.println(
                "\n===== ALL MESSAGES ====="
        );

        for (Message message : messages) {

            System.out.println(
                    "Message ID: "
                    + message.getMessageId()
            );

            System.out.println(
                    "Sender ID: "
                    + message.getSenderId()
            );

            System.out.println(
                    "Receiver ID: "
                    + message.getReceiverId()
            );

            System.out.println(
                    "Message: "
                    + message.getMessage()
            );

            System.out.println(
                    "------------------------"
            );
        }
    }

    public ArrayList<Message> getReceivedMessages(
            int receiverId) {

        ArrayList<Message> receivedMessages =
                new ArrayList<>();

        for (Message message : messages) {

            if (message.getReceiverId()
                    == receiverId) {

                receivedMessages.add(message);
            }
        }

        logger.logActivity(
                "Messages checked for User ID "
                + receiverId
        );

        return receivedMessages;
    }
}