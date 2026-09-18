package ui;

import model.Message;
import service.MessageService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MessagesFrame extends JFrame {

    private MessageService messageService;

    private JTextField receiverField;
    private JTextField messageField;

    private JTextArea messageArea;

    private int currentUserId;

    public MessagesFrame(MessageService messageService,
                         int currentUserId) {

        this.messageService = messageService;
        this.currentUserId = currentUserId;

        setTitle("VIT Campus Marketplace - Messages");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createScreen();
    }

    private void createScreen() {

        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel(
                "MESSAGES",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        add(titleLabel, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel(
                new GridLayout(3, 2, 10, 10)
        );

        receiverField = new JTextField();

        messageField = new JTextField();

        JButton sendButton =
                new JButton("Send Message");

        JButton viewButton =
                new JButton("View Received Messages");

        inputPanel.add(
                new JLabel("Receiver User ID:")
        );

        inputPanel.add(receiverField);

        inputPanel.add(
                new JLabel("Message:")
        );

        inputPanel.add(messageField);

        inputPanel.add(sendButton);

        inputPanel.add(viewButton);

        add(inputPanel, BorderLayout.CENTER);

        // Message display area
        messageArea = new JTextArea();

        messageArea.setEditable(false);

        messageArea.setLineWrap(true);

        messageArea.setWrapStyleWord(true);

        JScrollPane scrollPane =
                new JScrollPane(messageArea);

        add(scrollPane, BorderLayout.SOUTH);

        // Set display area size
        scrollPane.setPreferredSize(
                new Dimension(600, 280)
        );

        // Send message
        sendButton.addActionListener(e ->
                sendMessage()
        );

        // View received messages
        viewButton.addActionListener(e ->
                viewMessages()
        );
    }

    private void sendMessage() {

        String receiverText =
                receiverField.getText().trim();

        String messageText =
                messageField.getText().trim();

        // Check empty fields
        if (receiverText.isEmpty()
                || messageText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );

            return;
        }

        int receiverId;

        try {

            receiverId =
                    Integer.parseInt(receiverText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid User ID."
            );

            return;
        }

        // Prevent sending message to yourself
        if (receiverId == currentUserId) {

            JOptionPane.showMessageDialog(
                    this,
                    "You cannot send a message to yourself."
            );

            return;
        }

        // Generate message ID
        int messageId =
                (int) (Math.random() * 10000);

        // Create Message object
        Message message = new Message(
                messageId,
                currentUserId,
                receiverId,
                messageText
        );

        // Send message using service
        messageService.sendMessage(message);

        JOptionPane.showMessageDialog(
                this,
                "Message sent successfully!"
        );

        // Clear fields
        receiverField.setText("");

        messageField.setText("");
    }

    private void viewMessages() {

        messageArea.setText("");

        ArrayList<Message> receivedMessages =
                messageService.getReceivedMessages(
                        currentUserId
                );

        if (receivedMessages.isEmpty()) {

            messageArea.setText(
                    "No messages received."
            );

            return;
        }

        messageArea.append(
                "===== RECEIVED MESSAGES =====\n\n"
        );

        for (Message message : receivedMessages) {

            messageArea.append(
                    "From User ID: "
                    + message.getSenderId()
                    + "\n"
            );

            messageArea.append(
                    "Message: "
                    + message.getMessage()
                    + "\n"
            );

            messageArea.append(
                    "-----------------------------\n"
            );
        }
    }
}