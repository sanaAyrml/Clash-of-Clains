package view;

import Exceptions.DontHaveAnyBuilderExp;
import Exceptions.DontHaveEnoughResourceExp;
import Exceptions.TownHallIsntAvailable;
import Exceptions.TownHallLevelUpgradeNeeded;
import controllers.MenuController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static view.QuestionBM.Exceptions;

public class Upgrade extends MenuIn{
    public Upgrade(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent, menuController,villageView);
    }
    @Override
    public void show(Group group) {

        basic(group);

        Text q = new Text("Upgrade Cost ~~~>");
        q.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        q.setFill(Color.WHEAT);
        String cost = getMenuController().getCost();
        Text c =new Text(cost +" Gold");
        c.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        c.setFill(Color.WHEAT);
        Text u =new Text("UPGRADE");
        u.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        u.setFill(Color.WHEAT);
        u.relocate(x+35,y+230);

//        ImageView photo = new I


        HBox hBox = new HBox();
        hBox.relocate(x+35,y+80);
        hBox.setSpacing(30);
        hBox.getChildren().addAll(q,c );
        getSubG().getChildren().addAll(hBox,u);

        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().add(getSubG());

        u.setOnMouseClicked(event -> {
            getSubG().getChildren().removeAll(hBox,u,imageView5,imageView5);
            question(group);
        });
    }
    public void question(Group group){
        Text q = new Text("Do you want to upgread?");
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

        yes.setOnMouseClicked(event -> {
            try {
                getMenuController().upgrade();
            } catch (TownHallIsntAvailable townHallIsntAvailable) {
                Exceptions(group, townHallIsntAvailable.error());
            } catch (DontHaveEnoughResourceExp dontHaveEnoughResourceExp) {
                Exceptions(group, dontHaveEnoughResourceExp.error());
            } catch (TownHallLevelUpgradeNeeded townHallLevelUpgradeNeeded) {
                Exceptions(group, townHallLevelUpgradeNeeded.error());
            } catch (DontHaveAnyBuilderExp dontHaveAnyBuilderExp) {
                Exceptions(group, dontHaveAnyBuilderExp.error());
            }
            group.getChildren().removeAll(getSubG());
            villageView.deleteLight();
        });
        no.setOnMouseClicked(event -> {
            group.getChildren().removeAll(getSubG());
            villageView.deleteLight();
        });
    }
}
