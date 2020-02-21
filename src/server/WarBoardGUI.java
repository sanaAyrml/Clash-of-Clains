package server;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import server.refreshMessages.AttackRefreshMessage;

import java.io.File;
import java.util.ArrayList;


public class WarBoardGUI {
    private Group group = new Group();
    private ScrollPane scrollPane = new ScrollPane();
    private ScrollPane warInfoScrollPane = new ScrollPane();
    private VBox warInfoVBox = new VBox();
    private VBox vBox = new VBox();
    private Group norm = new Group();
    private Group info = new Group();
    private Positions positions;

    public WarBoardGUI(CostumerType costumerType) {
        positions = new Positions(costumerType);
        group.getStylesheets().addAll(new File("../AP_15/css.css").toURI().toString());
        setScrollPanePosition(scrollPane);
        setScrollPanePosition(warInfoScrollPane);
        newVBox(vBox, norm);
        scrollPane.setContent(norm);
        newVBox(warInfoVBox, info);
        warInfoScrollPane.setContent(info);
        group.getChildren().add(scrollPane);
    }

    private void setScrollPanePosition(ScrollPane scrollPane){
        scrollPane.setPrefViewportHeight(positions.getBoardHeight() - 2 * positions.getBoardVerticalFreeSpace());
        scrollPane.setPrefViewportWidth(positions.getBoardWidth() - 2 * positions.getBoardHorizontalFreeSpace());
        scrollPane.setLayoutX(positions.getWarBoardBackgroundX() + positions.getBoardHorizontalFreeSpace());
        scrollPane.setTranslateY(positions.getVerticalFreeSpace() + positions.getBoardVerticalFreeSpace());
    }

    public void refresh(ArrayList<AttackRefreshMessage> refreshMessages){
        norm.getChildren().remove(vBox);
        vBox = new VBox();
        newVBox(vBox, norm);
        for (AttackRefreshMessage refeshmessage : refreshMessages) {
            addClient(refeshmessage);

        }
    }

    private void newVBox(VBox vBox, Group group)
    {
        vBox.setTranslateX(positions.getWarBoardBackgroundX() + positions.getBoardHorizontalFreeSpace());
        vBox.setTranslateY(positions.getVerticalFreeSpace() + positions.getBoardVerticalFreeSpace());
        group.getChildren().add(vBox);
    }

    private void addClient(AttackRefreshMessage refreshMessage)
    {
        Text attackerVSdefender = getBoldVSText(refreshMessage.getAttackerID(), refreshMessage.getDefenderID());
        attackerVSdefender.setOnMouseClicked(e -> {
            info.getChildren().remove(warInfoVBox);
            warInfoVBox = new VBox();
            newVBox(warInfoVBox, info);
            group.getChildren().remove(scrollPane);
            group.getChildren().add(warInfoScrollPane);
            setInfo(refreshMessage);
            setBack();
        });
        vBox.getChildren().add(attackerVSdefender);
    }

    private void setBack()
    {
        Text back = getText("Back");
        back.setX(positions.getWarBoardBackgroundX() + positions.getBoardWidth() - positions.getFieldWidth());
        back.setY(positions.getBoardHeight() - positions.getBoardVerticalFreeSpace());
        info.getChildren().add(back);
        back.setOnMouseClicked(e -> {
            group.getChildren().remove(warInfoScrollPane);
            info.getChildren().remove(back);
            group.getChildren().add(scrollPane);
        });
    }

    private void setInfo(AttackRefreshMessage attackRefreshMessage)
    {
        warInfoVBox.getChildren().add(getText("Earned Gold : " + attackRefreshMessage.getEarnedGold()));
        warInfoVBox.getChildren().add(getText("Earned Elixir : " + attackRefreshMessage.getEarnedElixir()));
        warInfoVBox.getChildren().add(getText("Earned Point : " + attackRefreshMessage.getEarnedPoint()));
        warInfoVBox.getChildren().add(getText("Number Of Alive Soldiers : " + attackRefreshMessage.getAliveSoldiers()));
        warInfoVBox.getChildren().add(getText("Number Of Dead Soldiers : " + attackRefreshMessage.getDeadSoldiers()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Gold Mines : " + attackRefreshMessage.getDistructedGoldMines()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Elixir Mines : " + attackRefreshMessage.getDistructedElixirMines()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Gold Storages : " + attackRefreshMessage.getDistructedGoldStorages()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Elixir Storages : " + attackRefreshMessage.getDistructedElixirStorages()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Barracks : " + attackRefreshMessage.getDistructedBarracks()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Camps : " + attackRefreshMessage.getDistructedCamps()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Walls : " + attackRefreshMessage.getDistructedWalls()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Wizard Towers : " + attackRefreshMessage.getDistructedWizaradTowers()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Archer Towers : " + attackRefreshMessage.getDistructedArcherTowers()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Air Defenses : " + attackRefreshMessage.getDistructedAirDefenses()));
        warInfoVBox.getChildren().add(getText("Number Of Distructed Cannons : " + attackRefreshMessage.getDistructedCannons()));
        warInfoVBox.getChildren().add(getText("Giant Castle " + checkDistruction(attackRefreshMessage.getDistructedGiantCastle())));
        warInfoVBox.getChildren().add(getText("Town Hall " + checkDistruction(attackRefreshMessage.getDistructedTownHalls())));
    }

    private String checkDistruction(int num)
    {
        if (num == 0)
            return "is distructed";
        else
            return "isn't distructed";
    }

    public Group getGroup() {
        return group;
    }

    private Text getBoldVSText(String attacker, String defender)
    {
        Text text = new Text(attacker + " VS " + defender);
        text.setFill(positions.getTextColor());
        text.setFont(Font.font ("Luminari", FontWeight.BOLD, 25));
        return text;
    }

    private Text getText(String string)
    {
        Text text = new Text(string);
        text.setFill(positions.getTextColor());
        text.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        return text;
    }
}
