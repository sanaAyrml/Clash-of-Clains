package view;

import Exceptions.DontHaveAnyBuilderExp;
import Exceptions.DontHaveEnoughResourceExp;
import Exceptions.FullCellExp;
import controllers.MenuController;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class QuestionBM extends MenuN{
    private String kind;
    private String name;

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public QuestionBM(MenuN parent, MenuController menuController,VillageView villageView) {
        super(parent, menuController,villageView);
    }

    @Override
    public void show(Group group) {
        basic(group);

        Text q = new Text("Do you want to build " + name + " for \n" + getMenuController().getGoldCost(kind) +" gold and "+getMenuController().getElixirCost(kind)+" elixir " + "?");
        q.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        q.setFill(Color.WHEAT);
        Text yes =new Text("Yes");
        yes.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        yes.setFill(Color.WHEAT);
        Text no =new Text("No");
        no.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        no.setFill(Color.WHEAT);


        HBox hBox = new HBox();
//        hBox.relocate(x+100,y+100);
        hBox.setSpacing(30);
        hBox.getChildren().addAll(yes,no);

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.relocate(x+35,y+80);
        vBox.getChildren().addAll(q,hBox);

        getSubG().getChildren().add(vBox);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().addAll(getSubG());

        yes.setOnMouseClicked(event -> {
            try {
                getMenuController().mainBuldingAvailableBuildings(name,kind);
            } catch (DontHaveAnyBuilderExp dontHaveAnyBuilderExp) {
                Exceptions(group, dontHaveAnyBuilderExp.error());
            } catch (DontHaveEnoughResourceExp dontHaveEnoughResourceExp) {
                Exceptions(group, dontHaveEnoughResourceExp.error());
            } catch (FullCellExp fullCellExp) {
                Exceptions(group, fullCellExp.error());
            }
            group.getChildren().removeAll(getSubG());
            villageView.deleteLight();
        });
        no.setOnMouseClicked(event -> {
            group.getChildren().removeAll(getSubG());
            villageView.deleteLight();
        });

    }

    public static void Exceptions(Group group, String error) {
        Text text1 = new Text(error);
        text1.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        text1.setFill(Color.WHEAT);
        text1.relocate(10,10);

        group.getChildren().addAll(text1);
        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(2)
        );
        visiblePause.setOnFinished(
                event1 -> {
                    group.getChildren().remove(text1);
                }
        );
        visiblePause.play();
    }
}
