package client;

import server.ServerListeningMode;
import server.refreshMessages.AttackRefreshMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientMessageSender{
    private ObjectOutputStream objectOutputStream;

    public ClientMessageSender(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public synchronized void send(Object object){
        try {
//            objectOutputStream.reset();
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException e) {

        }
    }

}
