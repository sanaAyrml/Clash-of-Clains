package server;

import server.refreshMessages.AttackRefreshMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Comparable, Serializable{
    private transient Socket chatRoomSocket;
    private transient Socket mainSocket;
    private transient Server server;

    private boolean exist=true;

    private transient ObjectInputStream mainIn;
    private transient ObjectOutputStream mainOut;

    private transient ObjectInputStream chatIn;
    private transient ObjectOutputStream chatOut;
    private boolean underAttack=false;

    private boolean attacking=false;


    private transient ServerListener serverListener;
    private  transient ServerMessageSender serverMessageSender;

    private transient ServerChatListener serverChatListener;
    private transient ChatRoomServerSender chatRoomServerSender;

    private ClientInfo clientInfo;
    private AttackRefreshMessage attackRefreshMessage=null;

    public ArrayList<AttackRecord> getAttackRecords() {
        return attackRecords;
    }

    private ArrayList<AttackRecord> attackRecords=new ArrayList<AttackRecord>();

    public void setAttackRefreshMessage(AttackRefreshMessage attackRefreshMessage) {
        this.attackRefreshMessage = attackRefreshMessage;
    }

    public ObjectOutputStream getChatOut() {
        return chatOut;
    }

    public ServerMessageSender getServerMessageSender() {
        return serverMessageSender;
    }

    public Client(Socket chatRoomSocket, Socket mainSocket, String ID,Server server,ObjectInputStream inputStream,ObjectOutputStream outputStream) throws IOException {
        clientInfo = new ClientInfo(0,ID, 0, null);
        this.server=server;
        this.chatRoomSocket = chatRoomSocket;
        this.mainSocket = mainSocket;
        mainOut=outputStream;
        mainIn=inputStream;
        serverMessageSender = new ServerMessageSender(mainOut);
        serverListener=new ServerListener(mainIn,this,server);
        serverListener.start();
        setChatRoomSocket(chatRoomSocket);

    }

    public void setChatRoomSocket(Socket chatRoomSocket){
        this.chatRoomSocket=chatRoomSocket;
        try {
            chatOut=new ObjectOutputStream(chatRoomSocket.getOutputStream());
            chatIn=new ObjectInputStream(chatRoomSocket.getInputStream());
//            System.out.println("here");
            chatRoomServerSender = new ChatRoomServerSender(server.getMessages(),server.getClients(),server.getCounter(),this);
            chatRoomServerSender.start();
            serverChatListener= new ServerChatListener(chatIn,this,server.getMessages(),chatRoomServerSender);
            serverChatListener.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getID() {
        return getClientInfo().getID();
    }

    public boolean equals(String ID)
    {

        if (ID.equals(this.getClientInfo().getID()))
            return true;
        return false;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    @Override
    public int compareTo(Object o) {

        return Integer.compare(clientInfo.getTotalPoint(), ((Client) o).getClientInfo().getTotalPoint());
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;

    }

    public Server getServer() {
        return server;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public AttackRefreshMessage getAttackRefreshMessage() {
        return attackRefreshMessage;
    }
    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isUnderAttack() {
        return underAttack;
    }

    public void setUnderAttack(boolean underAttack) {
        this.underAttack = underAttack;
    }

}
