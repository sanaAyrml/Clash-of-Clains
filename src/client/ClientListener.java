package client;

import attack.attackStreaming.StreamGUI;
import building.Camp;
import building.GuardianGiant;
import controllers.AttackController;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import map.*;
import server.ClientInfo;
import server.ServerListeningMode;
import server.ServerTransferMessage;
import server.refreshMessages.AttackRefreshMessage;
import view.VilageReqGUI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ClientListener extends Thread{
    private ObjectInputStream objectInputStream;
    private client.Client client;
    private Group root;
    private StreamGUI streamGUI;

    public void setRoot(Group root) {
        this.root = root;
    }

    private GameDef gameDef;

    public ClientListener(ObjectInputStream objectInputStream, client.Client client) {
        this.client=client;
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {

        while (client.isConnected()){
            recieveMessage();
        }
    }

    private void recieveMessage() {
        try {
            ClientTransferMessage message = (ClientTransferMessage) objectInputStream.readObject();
            checkMode(message);
        } catch (IOException | ClassNotFoundException e) {
            Platform.runLater(()->{
                new Alert(Alert.AlertType.ERROR, "server connection lost...").showAndWait();
            });
            client.setConnected(false);
            client.getVillageView().exit();

        }
    }

    private void checkMode(ClientTransferMessage message) {
        ClientListeningMode mode=message.getClientListeningMode();
            if(mode.equals(ClientListeningMode.LEADERBOARD_REQ)){
                getLeaderBoard(message);
            }
            else if(mode.equals(ClientListeningMode.VILAGE_REQ)){
                vilageReq(message);
            }
            else if(mode.equals(ClientListeningMode.VILAGE_ATTACK)){
                attackVilage(message);
            }
            else if(mode.equals(ClientListeningMode.MAP_REQ)){
                mapReq(message);
            }
            else if(mode.equals(ClientListeningMode.ATTACKED)){
                attacked(message);
            }
            else if(mode.equals(ClientListeningMode.ATTACK_ENDED)){
                endAttack(message);
            }else if (mode.equals(ClientListeningMode.WARBOARD_REQ))
            {
                getWarBoard(message.getWarboardRefreshMessages());
            }

    }

    private void getWarBoard(ArrayList<AttackRefreshMessage> warboardRefreshMessages) {
        Platform.runLater(()->{
            client.getWarBoardGUI().refresh(warboardRefreshMessages);
        });
    }

    private void endAttack(ClientTransferMessage message) {
        System.err.println("attack ended    "+this.client.getID());
        Platform.runLater(()->{
            root.getChildren().remove(gameDef.getBuildingsHealthCanvas());
            root.getChildren().remove(gameDef.getDefenseSoldierCanvas());
            client.getGameGUI().loadGameGUI();
        });
        client.reciever.getStreamGUI().end();
        client.getGame().setAttacked(false);
        gameDef.setEnd(true);
        client.getGame().spendElixir(message.getElixir());
        client.getGame().spendGold(message.getGold());
        client.reciever.setCountinue(false);


    }

    private void attacked(ClientTransferMessage message) {
        client.getGame().setAttacked(true);
        String ID= message.getID();
        client.beReciver();
        streamGUI  = new StreamGUI(root,message.getGuardianGiant(),message.getNumbers().get(0),message.getNumbers().get(1),message.getNumbers().get(2),message.getNumbers().get(3),message.getNumbers().get(4),message.getNumbers().get(5));
        client.reciever.setStreamGUI(streamGUI);
        client.reciever.setGame(client.getGame());
        streamGUI.run();
        ServerTransferMessage serverTransferMessage=new ServerTransferMessage(ServerListeningMode.ATTACKED, ID,client.getGame().gameTransfer(),null, null,client.getIP(),client.getPort(),null,null);
        client.getClientMessageSender().send(serverTransferMessage);
        Platform.runLater(() -> {
                new Alert(Alert.AlertType.ERROR, "You're under attack by " + ID + " !!!").showAndWait();
                gameDef = new GameDef(client.getGameGUI(), AttackPosition.DEFENDER);
                gameDef.start();
                root.getChildren().add(gameDef.getBuildingsHealthCanvas());
                root.getChildren().add(gameDef.getDefenseSoldierCanvas());
        });

    }

    private void mapReq(ClientTransferMessage message) {

        String ID= message.getID();
        ServerTransferMessage serverTransferMessage=new ServerTransferMessage(ServerListeningMode.MAP_REQ, ID,client.getGame().gameTransfer(),null, null,null,null,null,null);
        client.getClientMessageSender().send(serverTransferMessage);
    }

    private void attackVilage(ClientTransferMessage message) {
        GameTransfer gameTransfer=message.getGameTransfer();
        Platform.runLater(new Runnable(){
            @Override
            public void run() {

                Group groupCopy=new Group();
                groupCopy.getChildren().setAll(root.getChildren());
                Game game=new Game();

                game.importGame(gameTransfer);
                GameGUI gameGUI = new GameGUI(game);
                gameGUI.loadGameGUI();
                GameDef gameDef = new GameDef(gameGUI, AttackPosition.ATTACKER);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        gameDef.start();
                    }
                });
                Group defGroup = new Group();
                defGroup.getChildren().add(gameDef.getGameGUI().getCanvas());
                defGroup.getChildren().add(gameDef.getBuildingsHealthCanvas());
                defGroup.getChildren().add(gameDef.getDefenseSoldierCanvas());
                root.getChildren().setAll(defGroup);
                AttackController attackController=new AttackController(null,null,groupCopy,client.getGame(),game,null,root);
                attackController.setClient(client);
                attackController.start();
                client.beSender(message.getIP(),message.getPort());
                game.setSender(client.sender);
            }
        });
    }

    private void vilageReq(ClientTransferMessage message) {
        GameTransfer gameTransfer=message.getGameTransfer();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        for (Cell cell : this.client.getGame().getCamps()) {
            numbers.set(0,((Camp) (cell.getBuilding())).getGuardians().size()+numbers.get(1));
            numbers.set(1,((Camp) (cell.getBuilding())).getArchers().size()+numbers.get(2));
            numbers.set(2,((Camp) (cell.getBuilding())).getGiants().size()+numbers.get(3));
            numbers.set(3,((Camp) (cell.getBuilding())).getWallBreakers().size()+numbers.get(4));
            numbers.set(4,((Camp) (cell.getBuilding())).getHealers().size()+numbers.get(5));
            numbers.set(5,((Camp) (cell.getBuilding())).getDragons().size()+numbers.get(6));
        }
        GuardianGiant guardianGiant = client.getGame().getGuardianGiant();
        for (Integer number : numbers) {
            System.err.println(number);
        }
        VilageReqGUI vilageReqGUI=new VilageReqGUI(root,client,message.getID(),guardianGiant,numbers);
        vilageReqGUI.setGameTransfer(gameTransfer);
        vilageReqGUI.show();
    }

    private void getLeaderBoard(ClientTransferMessage message) {
        ArrayList<ClientInfo> serverClientInfos=message.getServerClientInfos();
        client.setServerClients(serverClientInfos);
    }

}
