package client;

import map.Game;
import map.GameGUI;
import server.*;
import udp.Reciever;
import udp.Sender;
import view.VillageView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private Socket mainSocket;
    private Socket chatroomSocket;

    private ObjectOutputStream chatOutputStream;
    private ObjectInputStream chatInputStream;

    private ObjectOutputStream mainOutputStream;
    private ObjectInputStream mainInputStream;

    ClientListener clientListener;

    private VillageView villageView;

    public ClientMessageSender getClientMessageSender() {
        return clientMessageSender;
    }
    private ArrayList<ClientInfo> serverClientInfos = null;

    ClientMessageSender clientMessageSender;

    ClientChatListener clientChatListener;
    ClientChatSender clientChatSender;

    Reciever reciever;
    Sender sender;

    private String ID;
    private Game game;
    private GameGUI gameGUI;
    private String IP;
    private Integer port;

    private WarBoardGUI warBoardGUI;

    public Sender getSender() {
        return sender;
    }

    public VillageView getVillageView() {
        return villageView;
    }

    public Game getGame() {
        return game;
    }

    public String getIP() {
        return IP;
    }

    public Integer getPort() {
        return port;
    }

    public GameGUI getGameGUI() {
        return gameGUI;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ClientChatSender getClientChatSender() {
        return clientChatSender;
    }

    private boolean connected = true;

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public Client(String ID, GameGUI gameGUI, String IP, Integer clientPort, Integer serverPort,VillageView villageView) {
            System.err.println("Client " + ID +" :");
        this.gameGUI = gameGUI;
        game = gameGUI.getGame();
        this.ID= ID;
        this.IP = IP;
        this.villageView = villageView;

        try {
            mainSocket=new Socket(ServerConstants.SERVER_ADDRESS, ServerConstants.MAIN_SERVER_PORT);
            chatroomSocket=new Socket(ServerConstants.SERVER_ADDRESS, ServerConstants.CHAT_SERVER_PORT);
//            IP=mainSocket.getLocalAddress().getHostAddress();
            port=mainSocket.getPort();
            mainOutputStream = new ObjectOutputStream(mainSocket.getOutputStream());
            mainInputStream = new ObjectInputStream(mainSocket.getInputStream());
            System.err.println("in out connected");
            mainOutputStream.writeObject(ID);
            mainOutputStream.flush();
            mainOutputStream.writeObject(new ClientInfo(game.getTotalGold(), ID, game.getTotalElixir(), game.getAttackRecords()));
            mainOutputStream.flush();
            System.err.println("writed");
            clientListener=new  ClientListener(mainInputStream,this);
            clientListener.start();
            clientMessageSender=new ClientMessageSender(mainOutputStream);
            Thread refreshServerClientInfo = new Thread(() -> {
                while (connected) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clientMessageSender.send(new ServerTransferMessage(ServerListeningMode.REFRESH_INFO, null, null, null, new ClientInfo(game.getTotalGold(),ID,  game.getTotalElixir(), game.getAttackRecords()),null,null,null,null));
                }

            });
            refreshServerClientInfo.start();
            System.err.println("end try");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            chatOutputStream = new ObjectOutputStream(chatroomSocket.getOutputStream());
            chatInputStream = new ObjectInputStream(chatroomSocket.getInputStream());
            clientChatListener = new ClientChatListener(chatInputStream,this);
            clientChatListener.start();
            clientChatSender = new ClientChatSender(chatOutputStream);
            System.err.println("end chat try");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientChatListener getClientChatListener() {
        return clientChatListener;
    }

    public ArrayList<ClientInfo> getServerClientInfos() {
        return serverClientInfos;
    }

    public void setServerClients(ArrayList<ClientInfo> serverClientInfos) {
        this.serverClientInfos = serverClientInfos;
    }

    public ClientListener getClientListener() {
        return clientListener;
    }

    public void beSender(String sIp, Integer sPort){
        sender = new Sender(sIp,sPort);
        sender.start();
    }

    public void beReciver(){
        reciever = new Reciever(port);
        reciever.start();
    }

    public void setWarBoardGUI(WarBoardGUI warBoardGUI) {
        this.warBoardGUI = warBoardGUI;
    }

    public WarBoardGUI getWarBoardGUI() {
        return warBoardGUI;
    }
}
