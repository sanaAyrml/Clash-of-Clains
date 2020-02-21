package server;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import map.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ServerChatListener extends Thread {

    private ObjectInputStream objectInputStream;
    private Client client;
    private ArrayList<Message> messages;
    private ChatRoomServerSender chatRoomServerSender;



    public ServerChatListener(ObjectInputStream objectInputStream, Client client, ArrayList<Message> messages,ChatRoomServerSender chatRoomServerSender) {
        this.client=client;
        this.objectInputStream = objectInputStream;
        this.messages = messages;
        this.chatRoomServerSender = chatRoomServerSender;
    }


    @Override
    public void run() {
        while (client.isExist()){
            try {
                Message message = (Message) objectInputStream.readObject();
                messages.add(message);
                if (chatRoomServerSender.getState().equals(State.WAITING)){
                    synchronized (chatRoomServerSender) {
                        chatRoomServerSender.notify();
                    }
                }
                // this part is used to make fx and threads work together

                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        client.getServer().getServerGUI().getServerChatRoomGUI().setClientChats(message.getId() , message.getText());
                    }
                });

            } catch (IOException | ClassNotFoundException e) {
                Platform.runLater(()->{
                    new Alert(Alert.AlertType.ERROR, "connection of " + client.getID() + " lost...").show();
                });
                client.setExist(false);
            }
        }
    }
}
