package server;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import map.Message;
import server.refreshMessages.AttackRefreshMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Server {
    private ServerGUI serverGUI;
    private ServerSocket mainServerSocket;
    private ServerSocket chatServerSocket;
    private ArrayList<Client> clients = new ArrayList<>();
    private Server server=this;
    private ArrayList<Message> messages = new ArrayList<>();
    private Counter counter = new Counter();
    private ChatRoomServerSender chatRoomServerSender = new ChatRoomServerSender(messages,clients,counter,null);

    public Server() {
        System.err.println("Server:");
        serverGUI = new ServerGUI(this);
        try {
            chatRoomServerSender.start();
            mainServerSocket = new ServerSocket(ServerConstants.MAIN_SERVER_PORT);
            chatServerSocket = new ServerSocket(ServerConstants.CHAT_SERVER_PORT);
            waitForClientToConnect.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread refreshonlineBoardThread = new Thread(() -> {
            while (true) {
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        refreshOnlineBoard();
                    }
                });
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        refreshonlineBoardThread.start();
    }

    public Counter getCounter() {
        return counter;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ChatRoomServerSender getChatRoomServerSender() {
        return chatRoomServerSender;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    Thread waitForClientToConnect = new Thread()
    {
        @Override
        public void run() {
            while (true)
            {
                try {

                    Socket mainSocket=mainServerSocket.accept();
                    Socket chatSocket=chatServerSocket.accept();
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(mainSocket.getOutputStream());
                    ObjectInputStream objectInputStream =new ObjectInputStream(mainSocket.getInputStream());
                    String ID= ((String) objectInputStream.readObject());
                    ClientInfo clientInfo = ((ClientInfo) objectInputStream.readObject());
                    Client client = findID(ID);
//                    System.out.println("hereeeeee");
                    if (client == null) {
//                        System.out.println("hereeeeee2");
                        client=new Client( chatSocket,mainSocket,ID,server,objectInputStream,objectOutputStream);
                        clients.add(client);
                    }
                    refreshInfo(ID, clientInfo);


                } catch (IOException  | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public Client findID(String id) {
        for (Client client : clients) {
            if(client.equals(id)){
                client.setExist(true);
                return client;
            }
        }
        return null;
    }

    public void refreshLeaderBoard()
    {
        Collections.sort(clients);
        serverGUI.refreshLeaderBoard();
    }

    public ServerGUI getServerGUI() {
        return serverGUI;
    }

    public void refreshInfo(String ID, ClientInfo clientInfo)
    {
        findID(ID).setClientInfo(clientInfo);
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                refreshLeaderBoard();
            }
        });

    }


    public void refreshWarBoard()
    {
        serverGUI.refreshWarBoard(getRefreshMessages());
    }

    private ArrayList<AttackRefreshMessage> getRefreshMessages()
    {
        ArrayList<AttackRefreshMessage> refreshMessages = new ArrayList<>();
        for (Client client : clients) {
            if (client.getAttackRefreshMessage() != null)
            {
                refreshMessages.add(client.getAttackRefreshMessage());
            }
        }
        return refreshMessages;
    }

    public ArrayList<AttackRefreshMessage> getNewAttackRefreshMessages()
    {
        ArrayList<AttackRefreshMessage> refreshMessages = new ArrayList<>();
        for (Client client : clients) {
            if (client.getAttackRefreshMessage() != null)
            {
                refreshMessages.add(client.getAttackRefreshMessage().getNewInstance());
            }
        }
        return refreshMessages;
    }

    public void refreshOnlineBoard()
    {
        serverGUI.refreshOnlineBoard();
    }

}
