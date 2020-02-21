package server;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

import static server.ServerConstants.*;

public class LeaderBoardGUI {
    private Group group = new Group();
    private Group boxes = new Group();
    private VBox IDVBox;
    private VBox goldVBox;
    private VBox elixirVBox;

    private VBox pointVBox;
    private VBox attackHistoryVBox;

    ScrollPane scrollPane = new ScrollPane();
    ScrollPane attackHistoryScrollPane = new ScrollPane();

    private Group attackHistoryBoxes = new Group();
    private VBox attackDefenderIDVBox;
    private VBox attackEarnedGoldVBox;
    private VBox attackEarnedElixirVBox;
    private VBox attackEarnedPointVBox;


    public LeaderBoardGUI() {
        Rectangle background = new Rectangle(LEADER_BOARD_BACKGROUND_X, VERTICAL_FREE_SPACE, BOARD_WIDTH, BOARD_HEIGHT);
        background.setFill(BOARD_COLOR);
        newBoxes();
        disignBoard(background);
        group.getChildren().add(background);

        setScrollPane(scrollPane, boxes);
        group.getChildren().add(scrollPane);
        group.getChildren().add(setBoardsTitlesFont(new Text(LEADER_BOARD_BACKGROUND_X + BOARD_WIDTH / 4, VERTICAL_FREE_SPACE, "Leader Board")));
        group.getStylesheets().addAll(new File("../AP_15/css.css").toURI().toString());
    }

    private void setScrollPane(ScrollPane scrollPane, Group boxes)
    {
        scrollPane.setPrefViewportHeight(BOARD_HEIGHT - 2 * BOARD_VERTICAL_FREE_SPACE);
        scrollPane.setPrefViewportWidth(BOARD_WIDTH - 2 * BOARD_HORIZONTAL_FREE_SPACE);
        scrollPane.setLayoutX(LEADER_BOARD_ID_VBOX_X);
        scrollPane.setTranslateY(VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        scrollPane.setContent(boxes);
    }

    public void refresh(ArrayList<Client> clients)
    {
        deleteAll();
        for (int rank = 0; rank < clients.size(); rank++) {
            addClient(rank + 1, clients.get(rank));
        }
    }

    private void addClient(int rank, Client client)
    {
        IDVBox.getChildren().add(getText(rank + ". " + client.getID()));
        goldVBox.getChildren().add(getText(client.getClientInfo().getGold().toString()));
        elixirVBox.getChildren().add(getText(client.getClientInfo().getElixir().toString()));
        pointVBox.getChildren().add(getText(client.getClientInfo().getTotalPoint().toString()));
        setAttackHistoryBotumn(client.getClientInfo());
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
        Text back = getText("Back");
        back.setX(LEADER_BOARD_BACKGROUND_X + BOARD_WIDTH - LEADER_BOARD_FIELDS_WIDTH);
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

        setVBoxPosition(attackDefenderIDVBox, LEADER_BOARD_ID_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        setVBoxPosition(attackEarnedGoldVBox, LEADER_BOARD_GOLD_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        setVBoxPosition(attackEarnedElixirVBox, LEADER_BOARD_ELIXIR_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        setVBoxPosition(attackEarnedPointVBox, LEADER_BOARD_POINT_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
    }

    private void setVBoxPosition(VBox vBox, int x, int y)
    {
        vBox.setTranslateX(x);
        vBox.setTranslateY(y);
    }

    private void deleteAll()
    {
        boxes.getChildren().removeAll(IDVBox, goldVBox, elixirVBox, pointVBox, attackHistoryVBox);
        newBoxes();
        IDVBox.getChildren().add(getText("ID"));
        goldVBox.getChildren().add(getText("Gold"));
        elixirVBox.getChildren().add(getText("Elixir"));
        pointVBox.getChildren().add(getText("Point"));
        attackHistoryVBox.getChildren().add(getText("Attacks"));
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

        setVBoxPosition(IDVBox, LEADER_BOARD_ID_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        setVBoxPosition(goldVBox, LEADER_BOARD_GOLD_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        setVBoxPosition(elixirVBox, LEADER_BOARD_ELIXIR_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        setVBoxPosition(pointVBox, LEADER_BOARD_POINT_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        setVBoxPosition(attackHistoryVBox, LEADER_BOARD_ATTACK_HISTORY_VBOX_X, VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);

    }

    public Group getGroup() {
        return group;
    }
}
