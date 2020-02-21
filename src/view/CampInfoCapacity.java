package view;

import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CampInfoCapacity extends MenuIn{
    public CampInfoCapacity(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent, menuController,villageView);
    }

    @Override
    public void show(Group group) {
        basic(group);
        ArrayList<String> s = getMenuController().campCapacity();
        Text text1 = new Text("Your camps capacity is "+s.get(0)+" / "+s.get(1)+".");
        text1.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text1.setFill(Color.WHEAT);
        text1.relocate(x+35, y+100);

        getSubG().getChildren().add(text1);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().add(getSubG());
    }
}
