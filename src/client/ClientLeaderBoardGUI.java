package client;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import server.AttackRecord;
import server.ClientInfo;
import server.ServerListeningMode;
import server.ServerTransferMessage;

import java.io.File;
import java.util.ArrayList;

import static client.ClientConstants.*;

public class ClientLeaderBoardGUI {
    private Group group = new Group();
    private Group boxes = new Group();
    private VBox IDVBox;
    private VBox goldVBox;
    private VBox elixirVBox;
    private Client client;
    private Group g1;
    private Group gTotal;

    private VBox pointVBox;
    private VBox attackHistoryVBox;
    ScrollPane scrollPane = new ScrollPane();
    ScrollPane attackHistoryScrollPane = new ScrollPane();

    private Group attackHistoryBoxes = new Group();
    private VBox attackDefenderIDVBox;
    private VBox attackEarnedGoldVBox;
    private VBox attackEarnedElixirVBox;
    private VBox attackEarnedPointVBox;

    public ClientLeaderBoardGUI(Client client,Group g1) {
        this.client = client;
        newBoxes();
        this.g1 = g1;
        group.getStylesheets().addAll(new File("../AP_15/css.css").toURI().toString());
        scrollPane.setTranslateX(BOARD_BACKGROUND_X);
        scrollPane.setTranslateY(VERTICAL_FREE_SPACE + 45);
        scrollPane.setContent(boxes);

        attackHistoryScrollPane.setTranslateX(BOARD_BACKGROUND_X);
        attackHistoryScrollPane.setTranslateY(VERTICAL_FREE_SPACE + 45);
        attackHistoryScrollPane.setContent(attackHistoryBoxes);
        group.getChildren().add(scrollPane);

    }

    public void setgTotal(Group gTotal) {
        this.gTotal = gTotal;
    }

    private void setVBoxPosition(VBox vBox, int x, int y)
    {
        vBox.setTranslateX(x);
        vBox.setTranslateY(y);
    }

    public void refresh(ArrayList<ClientInfo> clientInfos)
    {
        deleteAll();
        for (int rank = 0; rank < clientInfos.size(); rank++) {
            addClient(rank + 1, clientInfos.get(rank));
        }
    }

    private void addClient(int rank, ClientInfo clientInfo)
    {
        Text text = getLightText(rank + ". " + clientInfo.getID());
        text.setOnMouseClicked(e->{
            ServerTransferMessage transferMessage=new ServerTransferMessage(ServerListeningMode.VILAGE_REQ,clientInfo.getID(),null,null, null,null,null,null,null);
            client.getClientMessageSender().send(transferMessage);
            gTotal.getChildren().remove(g1);
        });
        IDVBox.getChildren().add(text);
        goldVBox.getChildren().add(getLightText(clientInfo.getGold().toString()));
        elixirVBox.getChildren().add(getLightText(clientInfo.getElixir().toString()));
        pointVBox.getChildren().add(getLightText(clientInfo.getTotalPoint().toString()));
        setAttackHistoryBotumn(clientInfo);
    }

    private void setAttackHistoryBotumn(ClientInfo clientInfo)
    {
        Text text = getLightText("history");
        text.setOnMouseClicked(e -> {
            setAttackHistoryGroup(clientInfo);
            setBack();
        });
        attackHistoryVBox.getChildren().add(text);
    }

    private void setBack()
    {
        Text back = new Text("Back");
        back.setFill(Color.WHEAT);
        back.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        back.setX(BOARD_BACKGROUND_X + BOARD_WIDTH - LEADER_BOARD_FIELDS_WIDTH);
        back.setY(BOARD_HEIGHT);
        group.getChildren().add(back);
        back.setOnMouseClicked(e -> {
            group.getChildren().remove(attackHistoryScrollPane);
            group.getChildren().remove(back);
            group.getChildren().add(scrollPane);
        });
    }

    private void setAttackHistoryGroup(ClientInfo clientInfo){
        deleteAttackHistory();
        for (AttackRecord attackRecord : clientInfo.getAttackRecords()) {
            addAttackRecord(attackRecord);
        }
        group.getChildren().remove(scrollPane);
        group.getChildren().add(attackHistoryScrollPane);
    }

    private void addAttackRecord(AttackRecord attackRecord)
    {
        attackDefenderIDVBox.getChildren().add(getLightText(attackRecord.getDefenderID()));
        attackEarnedGoldVBox.getChildren().add(getLightText(attackRecord.getEarnedGold().toString()));
        attackEarnedElixirVBox.getChildren().add(getLightText(attackRecord.getEarnedElixir().toString()));
        attackEarnedPointVBox.getChildren().add(getLightText(attackRecord.getEarnedPoint().toString()));
    }

    private void deleteAttackHistory()
    {
        attackHistoryBoxes.getChildren().removeAll(attackDefenderIDVBox, attackEarnedGoldVBox, attackEarnedElixirVBox, attackEarnedPointVBox);
        newAttackHistoryBoxex();
        attackDefenderIDVBox.getChildren().add(getLightText("Defender"));
        attackEarnedGoldVBox.getChildren().add(getLightText("Earned Gold"));
        attackEarnedElixirVBox.getChildren().add(getLightText("Earned Elixir"));
        attackEarnedPointVBox.getChildren().add(getLightText("Earned Point"));
    }


    private void deleteAll()
    {
        boxes.getChildren().removeAll(IDVBox, goldVBox, elixirVBox, pointVBox, attackHistoryVBox);
        newBoxes();
        IDVBox.getChildren().add(getLightText("ID"));
        goldVBox.getChildren().add(getLightText("Gold"));
        elixirVBox.getChildren().add(getLightText("Elixir"));
        pointVBox.getChildren().add(getLightText("Point"));
        attackHistoryVBox.getChildren().add(getLightText("Attacks"));
    }

    private void newBoxes()
    {
        IDVBox = new VBox();
        goldVBox = new VBox();
        elixirVBox = new VBox();
        pointVBox = new VBox();
        attackHistoryVBox = new VBox();

        boxes.getChildren().add(IDVBox);
        boxes.getChildren().add(goldVBox);
        boxes.getChildren().add(elixirVBox);
        boxes.getChildren().add(pointVBox);
        boxes.getChildren().add(attackHistoryVBox);

        setVBoxPosition(IDVBox, LEADER_BOARD_ID_VBOX_X, VERTICAL_FREE_SPACE + 45);
        setVBoxPosition(goldVBox, LEADER_BOARD_GOLD_VBOX_X, VERTICAL_FREE_SPACE + 45);
        setVBoxPosition(elixirVBox, LEADER_BOARD_ELIXIR_VBOX_X, VERTICAL_FREE_SPACE + 45);
        setVBoxPosition(pointVBox, LEADER_BOARD_POINT_VBOX_X, VERTICAL_FREE_SPACE + 45);
        setVBoxPosition(attackHistoryVBox, LEADER_BOARD_ATTACK_HISTORY_VBOX_X, VERTICAL_FREE_SPACE + 45);
    }

    private void newAttackHistoryBoxex()
    {
        attackDefenderIDVBox = new VBox();
        attackEarnedGoldVBox = new VBox();
        attackEarnedElixirVBox = new VBox();
        attackEarnedPointVBox = new VBox();

        attackHistoryBoxes.getChildren().add(attackDefenderIDVBox);
        attackHistoryBoxes.getChildren().add(attackEarnedGoldVBox);
        attackHistoryBoxes.getChildren().add(attackEarnedElixirVBox);
        attackHistoryBoxes.getChildren().add(attackEarnedPointVBox);

        setVBoxPosition(attackDefenderIDVBox, LEADER_BOARD_ID_VBOX_X, VERTICAL_FREE_SPACE + 45);
        setVBoxPosition(attackEarnedGoldVBox, LEADER_BOARD_GOLD_VBOX_X, VERTICAL_FREE_SPACE + 45);
        setVBoxPosition(attackEarnedElixirVBox, LEADER_BOARD_ELIXIR_VBOX_X, VERTICAL_FREE_SPACE + 45);
        setVBoxPosition(attackEarnedPointVBox, LEADER_BOARD_POINT_VBOX_X, VERTICAL_FREE_SPACE + 45);
    }
    public Group getGroup() {
        return group;
    }
}
