package view;

import Exceptions.DontHaveEnoughResourceExp;
import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BarracksBuildNumberM extends MenuIn{
    private String name;
    private Integer num;
    public BarracksBuildNumberM(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent, menuController,villageView);
    }

    public void setName(String name,Integer num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public void show(Group group) {
        basic(group);

        Text q = new Text("How many?");
        q.setFont(Font.font ("Luminari", FontWeight.BOLD, 40));
        q.setFill(Color.WHEAT);

        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField.setPrefColumnCount(2);
        textField.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));

        Text ok = new Text("OK");
        ok.setFont(Font.font ("Luminari", FontWeight.BOLD, 50));
        ok.setFill(Color.WHEAT);

        HBox hBox = new HBox();
//        hBox.relocate(x+100,y+100);
        hBox.setSpacing(40);
        hBox.getChildren().addAll(q,textField);

        VBox vBox = new VBox();
        vBox.setSpacing(25);
        vBox.relocate(x+50,y+80);
        vBox.getChildren().addAll(hBox,ok);

        getSubG().getChildren().add(vBox);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().add(getSubG());

        ok.setOnMouseClicked(event -> {
            try {
                getMenuController().barracksBuildSoldier(textField.getText(),num,name);
            } catch (DontHaveEnoughResourceExp dontHaveEnoughResourceExp) {
                QuestionBM.Exceptions(group, dontHaveEnoughResourceExp.error());
            }
//            System.out.println("sanaaaa");
            villageView.deleteLight();
            group.getChildren().removeAll(getSubG());
        });
    }
}
