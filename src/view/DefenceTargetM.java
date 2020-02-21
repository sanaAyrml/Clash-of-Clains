package view;

import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DefenceTargetM extends MenuIn{
    public DefenceTargetM(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent, menuController,villageView);
    }

    @Override
    public void show(Group group) {
        basic(group);

        ArrayList<String> s = getMenuController().defenceTarget();
        String o = new String();
        for(String x: s){
            o = o + x + "\n";
        }

        Text text1 = new Text(o);
        text1.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text1.setFill(Color.WHEAT);
        text1.relocate(x+210, y+80);

        getSubG().getChildren().add(text1);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().add(getSubG());

    }
}
