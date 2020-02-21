package server;

import client.ClientListeningMode;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ServerMessageSender{
    private ObjectOutputStream objectOutputStream;

    public ServerMessageSender(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public void send(ClientListeningMode clientListeningMode,Object object){
        try {
            send(clientListeningMode);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(ClientListeningMode clientListeningMode){
        try {
            objectOutputStream.writeObject(clientListeningMode);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(Object object){
        try {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
