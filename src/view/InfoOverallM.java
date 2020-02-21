package view;

import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InfoOverallM extends MenuIn{
    public InfoOverallM(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent,menuController,villageView);
    }

    @Override
    public void show(Group group) {
        basic(group);
        Text level = new Text("Level ~~~>");
        level.setFont(Font.font ("Luminari", FontWeight.BOLD, 40));
        level.setFill(Color.WHEAT);
        Text health =new Text("Health ~~~>");
        health.setFont(Font.font ("Luminari", FontWeight.BOLD, 40));
        health.setFill(Color.WHEAT);
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.getChildren().addAll(level,health);

        String levelS = getMenuController().getLevel();
        String healthS = getMenuController().getHealth();


        Text levelN = new Text(levelS);
        levelN.setFont(Font.font ("Luminari", FontWeight.BOLD, 40));
        levelN.setFill(Color.WHEAT);
        Text healthN =new Text(healthS);
        healthN.setFont(Font.font ("Luminari", FontWeight.BOLD, 40));
        healthN.setFill(Color.WHEAT);
        VBox vBoxN = new VBox();
        vBoxN.setSpacing(20);
        vBoxN.getChildren().addAll(levelN,healthN);

        HBox hBox = new HBox();
        hBox.relocate(x+100,y+100);
        hBox.setSpacing(40);
        hBox.getChildren().addAll(vBox,vBoxN);

        getSubG().getChildren().addAll(hBox);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().addAll(getSubG());
    }
}
