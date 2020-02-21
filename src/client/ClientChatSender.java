package client;

import map.Message;
import server.refreshMessages.AttackRefreshMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientChatSender {
    private ObjectOutputStream objectOutputStream;

    public ClientChatSender(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public void send(Message message){
        try {
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
