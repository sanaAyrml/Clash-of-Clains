package view;

import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TownHallStatusM extends MenuIn{
    public TownHallStatusM(MenuIn parent, MenuController menuController, VillageView villageView) {
        super(parent, menuController, villageView);
    }

    @Override
    public void show(Group group) {
        basic(group);
        TextArea textArea = new TextArea();
        textArea.setScrollTop(1);
        textArea.setPrefColumnCount(10);
        textArea.setPrefRowCount(3);
        textArea.relocate(x+75, y+90);
        textArea.setStyle("-fx-background-color: green; -fx-foreground-color: green");
        textArea.setFont(Font.font ("Luminari", FontWeight.BOLD, 28));
        String t = getMenuController().mainBuildingStatus();
        textArea.setText(t);
        textArea.setEditable(false);

        getSubG().getChildren().add(textArea);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().addAll(getSubG());
    }
}
