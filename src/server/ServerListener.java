package server;

import client.ClientListeningMode;
import client.ClientTransferMessage;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import map.GameTransfer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ServerListener extends Thread {
    private ObjectInputStream objectInputStream;
    private Client client;
    private Server server;
    private String DefenderID=null;

    public ServerListener(ObjectInputStream objectInputStream,Client client,Server server) {
        this.server=server;
        this.client=client;
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {

        while (client.isExist()){
            recieveMessage();
        }
    }

    private void recieveMessage() {
        try {
            sleep(1000);
            Object object = objectInputStream.readObject();
            ServerTransferMessage serverTransferMessage= (ServerTransferMessage) object;
            checkMode(serverTransferMessage);
        } catch (Exception e) {
            try {
                sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            Platform.runLater(()->{
                new Alert(Alert.AlertType.ERROR, "connection of " + client.getID() + " lost...").show();
            });
            client.setExist(false);
        }
    }

    private void checkMode(ServerTransferMessage message) {
        try {
            ServerListeningMode mode=message.getServerListeningMode();
            if(mode.equals(ServerListeningMode.REFRESH_INFO)){
                refreshInfo(message);
            }
            else if (mode.equals(ServerListeningMode.WARBOARD_REQ))
            {
                warBoardReq(message.getID());
            }
            else if(mode.equals(ServerListeningMode.LEADERBOARD_REQ)){
                sendLeaderBoard();
            }
            else if(mode.equals(ServerListeningMode.VILAGE_REQ)){
                vilageReq(message);
            }
            else if(mode.equals(ServerListeningMode.VILAGE_ATTACK)){
                attackVilage(message);
            }
            else if(mode.equals(ServerListeningMode.ATTACK_ENDED)){
                endAttack(message);
            }
            else if(mode.equals(ServerListeningMode.MAP_REQ)){
                mapReq(message);
            }
            else if(mode.equals(ServerListeningMode.ATTACKED)){
                attacked(message);
            }
            else if(mode.equals(ServerListeningMode.REFRESH_ATTACK)){
                refreshAttack(message);
            }        } catch (Exception e) {
            e.getCause();
            e.printStackTrace();
        }
    }

    private void warBoardReq(String ID) {
        ClientTransferMessage clientTransferMessage = new ClientTransferMessage(ClientListeningMode.WARBOARD_REQ, server.getNewAttackRefreshMessages());
        Client client = server.findID(ID);
        client.getServerMessageSender().send(clientTransferMessage);
    }

    private void endAttack(ServerTransferMessage message) {
        client.getAttackRecords().add(new AttackRecord(message.getAttackRefreshMessage().getEarnedGold(),message.getAttackRefreshMessage().getEarnedElixir(),message.getAttackRefreshMessage().getEarnedPoint(),message.getID()));
        client.setAttacking(false);
        String ID=DefenderID;
        Client client=server.findID(ID);
        client.setUnderAttack(false);
        ClientTransferMessage clientTransferMessage = new ClientTransferMessage(ClientListeningMode.ATTACK_ENDED,null,null,null,null,null,null,null);
        clientTransferMessage.setElixir(message.getAttackRefreshMessage().getEarnedElixir());
        clientTransferMessage.setGold(message.getAttackRefreshMessage().getEarnedGold());
        client.getServerMessageSender().send(clientTransferMessage);
    }

    private void attacked(ServerTransferMessage message) {
        client.setUnderAttack(true);
        String ID=message.getID();
        Integer port = message.getPort();
        String IP = message.getIP();
        Client client=server.findID(ID);
        client.setAttacking(true);
        GameTransfer gameTransfer=message.getGameTransfer();

        ClientTransferMessage transferMessage=new ClientTransferMessage(ClientListeningMode.VILAGE_ATTACK,null,gameTransfer, null,port,IP,null,null);
        client.getServerMessageSender().send(transferMessage);
    }

    private void mapReq(ServerTransferMessage message) {
        String ID=message.getID();
        Client client=server.findID(ID);
        GameTransfer gameTransfer=message.getGameTransfer();
        ClientTransferMessage transferMessage=new ClientTransferMessage(ClientListeningMode.VILAGE_REQ,null,gameTransfer, this.client.getID(),null,null,null,null);
        client.getServerMessageSender().send(transferMessage);
    }

    private void refreshAttack(ServerTransferMessage message) {
        this.client.setAttackRefreshMessage(message.getAttackRefreshMessage());
        this.client.getAttackRefreshMessage().setDefenderID(DefenderID);
        this.client.getAttackRefreshMessage().setAttackerID(client.getID());
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                server.refreshWarBoard();
            }
        });

    }

    private void attackVilage(ServerTransferMessage message) {

        String ID=message.getID();
        DefenderID=ID;
        Client client=server.findID(ID);
        try {
//            System.out.println(message.getNumbers().get(0));
            ClientTransferMessage transferMessage=new ClientTransferMessage(ClientListeningMode.ATTACKED,null,null,this.client.getID(),null,null,message.getGuardianGiant(),message.getNumbers());
            client.getServerMessageSender().send(transferMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vilageReq(ServerTransferMessage message) {
        String ID=message.getID();
        Client client=server.findID(ID);
        ClientTransferMessage transferMessage=new ClientTransferMessage(ClientListeningMode.MAP_REQ,null,null,this.client.getID(),null,null,null,null);
        client.getServerMessageSender().send(transferMessage);
    }

    private void sendLeaderBoard() {
        ClientTransferMessage transferMessage=new ClientTransferMessage(ClientListeningMode.LEADERBOARD_REQ,getNewClientInfos(server.getClients()),null,null,null,null,null,null);
        client.getServerMessageSender().send(transferMessage);
    }

    private void refreshInfo(ServerTransferMessage message) throws IOException, ClassNotFoundException{
        server.refreshInfo(client.getID(), message.getClientInfo());

    }

    private ArrayList<ClientInfo> getNewClientInfos(ArrayList<Client> clients)
    {
        ArrayList<ClientInfo> clientInfos = new ArrayList<>();
        for (Client client : clients) {
            clientInfos.add(client.getClientInfo().getNewInstance());
        }
        return clientInfos;
    }

}
