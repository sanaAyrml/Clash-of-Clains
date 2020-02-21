package view;

import controllers.MenuController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CampSoldiersM extends MenuIn{
    public CampSoldiersM(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent, menuController,villageView);
    }

    @Override
    public void show(Group group) {
        basic(group);
        Text text1 = new Text(getMenuController().getArcher());
        text1.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        text1.setFill(Color.WHEAT);
        Text text2 = new Text(getMenuController().getGiants());
        text2.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        text2.setFill(Color.WHEAT);
        Text text3 = new Text(getMenuController().getDragoons());
        text3.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        text3.setFill(Color.WHEAT);
        Text text4 = new Text(getMenuController().getGuardians());
        text4.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        text4.setFill(Color.WHEAT);
        Text text5 = new Text(getMenuController().getHealer());
        text5.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        text5.setFill(Color.WHEAT);
        Text text6 = new Text(getMenuController().getWallBreaker());
        text6.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        text6.setFill(Color.WHEAT);

        VBox vBox = new VBox();
        vBox.relocate(x+170,y+80);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().setAll(text1,text2,text3,text4,text5,text6);

        getSubG().getChildren().add(vBox);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().add(getSubG());

    }
}
