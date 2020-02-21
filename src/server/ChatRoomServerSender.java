package server;


import map.Message;

import java.io.IOException;
import java.util.ArrayList;

public class ChatRoomServerSender extends Thread{
    private ArrayList<Message> messages;
    private ArrayList<Client> clients;
    private Counter counter;
    private Client client;
    public ChatRoomServerSender(ArrayList<Message> messages, ArrayList<Client> clients, Counter counter,Client client){
        this.clients = clients;
        this.messages = messages;
        this.counter = counter;
        this.client= client;
//        System.out.println(counter.getI());
        if(client!= null) {
            for (int j = 0; j < counter.getI(); j++) {
                try {
                    client.getChatOut().writeObject(messages.get(j));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public synchronized void run(){
//        System.out.println("started");
        while (true){
            if(messages.size()>counter.getI()){
//                System.out.println(messages.size() + "  "+clients.size());
                for (Client client : clients){
                    try {
                        client.getChatOut().writeObject(messages.get(counter.getI()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                counter.setI(counter.getI()+1);
//                messages.remove(0);
            }
            else {
                synchronized (this){
                    try {
//                        System.out.println("wait");
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
