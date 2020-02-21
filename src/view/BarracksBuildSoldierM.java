package view;

import controllers.MenuController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class BarracksBuildSoldierM extends MenuIn {
    public BarracksBuildSoldierM(MenuIn parent, MenuController menuController, VillageView villageView) {
        super(parent, menuController, villageView);
    }

    @Override
    public void show(Group group) {
        basic(group);

        HashMap<String, Integer> quantity = getMenuController().getNumbers();

        InputStream inputStreamW = null;
        try {
            inputStreamW = new FileInputStream(new File("../AP_15/src/photos/Dark_Elven_Archer.png"));

            Image imageW = new Image(inputStreamW);
            ImageView imageViewW = new ImageView(imageW);
            imageViewW.relocate(x + 20, y + 45);
            imageViewW.setFitWidth(75);
            imageViewW.setFitHeight(100);

            Text text = new Text("Archer X " + quantity.get("archer"));
            text.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
            if (quantity.get("archer") > 0)
                text.setFill(Color.WHEAT);
            else
                text.setFill(Color.RED);
            text.relocate(x + 210, y + 80);

            VBox vBox = new VBox();
            vBox.relocate(x + 15, y + 45);
            vBox.setAlignment(Pos.CENTER);
//            vBox.setSpacing(-20);
            vBox.getChildren().setAll(imageViewW, text);

            InputStream inputStreamW1 = new FileInputStream(new File("../AP_15/src/photos/Black_Dragon.png"));
            Image imageW1 = new Image(inputStreamW1);
            ImageView imageViewW1 = new ImageView(imageW1);
            imageViewW1.relocate(x + 20, y + 45);
            imageViewW1.setFitWidth(85);
            imageViewW1.setFitHeight(100);

            Text text1 = new Text("Dragon X " + quantity.get("dragon"));
            text1.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
            if (quantity.get("dragon") > 0)
                text1.setFill(Color.WHEAT);
            else
                text1.setFill(Color.RED);
            text1.relocate(x + 210, y + 80);

            VBox vBox1 = new VBox();
            vBox1.relocate(x + 15, y + 45);
            vBox1.setAlignment(Pos.CENTER);
//            vBox1.setSpacing(-20);
            vBox1.getChildren().setAll(imageViewW1, text1);

            InputStream inputStreamW2 = new FileInputStream(new File("../AP_15/src/photos/Ice-Giant.png"));
            Image imageW2 = new Image(inputStreamW2);
            ImageView imageViewW2 = new ImageView(imageW2);
            imageViewW2.relocate(x + 20, y + 45);
            imageViewW2.setFitWidth(75);
            imageViewW2.setFitHeight(110);

            Text text2 = new Text("Giant X " + quantity.get("giant"));
            text2.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
            if (quantity.get("giant") > 0)
                text2.setFill(Color.WHEAT);
            else
                text2.setFill(Color.RED);
            text2.relocate(x + 210, y + 80);

            VBox vBox2 = new VBox();
            vBox2.relocate(x + 15, y + 45);
            vBox2.setAlignment(Pos.CENTER);
//            vBox2.setSpacing(-20);
            vBox2.getChildren().setAll(imageViewW2, text2);

            InputStream inputStreamW3 = new FileInputStream(new File("../AP_15/src/photos/Class_render-MGuardian.png"));
            Image imageW3 = new Image(inputStreamW3);
            ImageView imageViewW3 = new ImageView(imageW3);
            imageViewW3.relocate(x + 20, y + 45);

            Text text3 = new Text("Guardian X " + quantity.get("guardian"));
            text3.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
            if (quantity.get("guardian") > 0)
                text3.setFill(Color.WHEAT);
            else
                text3.setFill(Color.RED);
            text3.relocate(x + 210, y + 80);

            VBox vBox3 = new VBox();
            vBox3.relocate(x + 15, y + 45);
            vBox3.setAlignment(Pos.CENTER);
//            vBox3.setSpacing(-20);
            vBox3.getChildren().setAll(imageViewW3, text3);
            imageViewW3.setFitWidth(85);
            imageViewW3.setFitHeight(100);

            InputStream inputStreamW4 = new FileInputStream(new File("../AP_15/src/photos/commission__blue_wizard_by_hakunaro-d57f9de [www.imagesplitter.net].png"));
            Image imageW4 = new Image(inputStreamW4);
            ImageView imageViewW4 = new ImageView(imageW4);
            imageViewW4.relocate(x + 20, y + 45);
            imageViewW4.setFitWidth(75);
            imageViewW4.setFitHeight(100);

            Text text4 = new Text("Healer X " + quantity.get("healer"));
            text4.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
            if (quantity.get("healer") > 0)
                text4.setFill(Color.WHEAT);
            else
                text4.setFill(Color.RED);
            text4.relocate(x + 210, y + 80);

            VBox vBox4 = new VBox();
            vBox4.relocate(x + 15, y + 45);
            vBox4.setAlignment(Pos.CENTER);
//            vBox4.setSpacing(-20);
            vBox4.getChildren().setAll(imageViewW4, text4);

            InputStream inputStreamW5 = new FileInputStream(new File("../AP_15/src/photos/wall_breaker_1.png"));
            Image imageW5 = new Image(inputStreamW5);
            ImageView imageViewW5 = new ImageView(imageW5);
            imageViewW5.relocate(x + 20, y + 45);
            imageViewW5.setFitWidth(75);
            imageViewW5.setFitHeight(90);

            Text text5 = new Text("WallBreaker X " + quantity.get("wall breaker"));
            text5.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
            if (quantity.get("wall breaker") > 0)
                text5.setFill(Color.WHEAT);
            else
                text5.setFill(Color.RED);
            text5.relocate(x + 210, y + 80);

            VBox vBox5 = new VBox();
            vBox5.relocate(x + 15, y + 45);
            vBox5.setAlignment(Pos.CENTER);
//            vBox5.setSpacing(-20);
            vBox5.getChildren().setAll(imageViewW5, text5);

            HBox hBox = new HBox();
            hBox.relocate(x + 100, y + 45);
            hBox.setSpacing(50);
            hBox.setAlignment(Pos.BOTTOM_LEFT);
            hBox.getChildren().setAll(vBox, vBox1, vBox2);

            HBox hBox1 = new HBox();
            hBox1.relocate(x + 25, y + 180);
            hBox1.setSpacing(50);
            hBox1.setAlignment(Pos.BOTTOM_CENTER);
            hBox1.getChildren().setAll(vBox3, vBox4, vBox5);

            if(group.getChildren().contains(getSubG())){
                group.getChildren().remove(getSubG());
            }
            getSubG().getChildren().addAll(hBox,hBox1);

            group.getChildren().add(getSubG());

            imageViewW.setOnMouseClicked(event -> {
                if (text.getFill().equals(Color.WHEAT)) {
                    group.getChildren().removeAll(getSubG());
                    getChilderen().get(0).setTitle(getTitle());
                    ((BarracksBuildNumberM) getChilderen().get(0)).setName("archer", quantity.get("archer"));
                    getChilderen().get(0).show(group);
                }
            });
            imageViewW1.setOnMouseClicked(event -> {
                if (text1.getFill().equals(Color.WHEAT)) {
                    group.getChildren().removeAll(getSubG());
                    getChilderen().get(0).setTitle(getTitle());
                    ((BarracksBuildNumberM) getChilderen().get(0)).setName("dragon", quantity.get("dragon"));
                    getChilderen().get(0).show(group);
                }
            });
            imageViewW2.setOnMouseClicked(event -> {
                if (text2.getFill().equals(Color.WHEAT)) {
                    group.getChildren().removeAll(getSubG());
                    getChilderen().get(0).setTitle(getTitle());
                    ((BarracksBuildNumberM) getChilderen().get(0)).setName("giant", quantity.get("giant"));
                    getChilderen().get(0).show(group);
                }
            });
            imageViewW3.setOnMouseClicked(event -> {
                if (text3.getFill().equals(Color.WHEAT)) {
                    group.getChildren().removeAll(getSubG());
                    getChilderen().get(0).setTitle(getTitle());
                    ((BarracksBuildNumberM) getChilderen().get(0)).setName("guardian", quantity.get("guardian"));
                    getChilderen().get(0).show(group);
                }
            });
            imageViewW4.setOnMouseClicked(event -> {
                if (text4.getFill().equals(Color.WHEAT)) {
                    group.getChildren().removeAll(getSubG());
                    getChilderen().get(0).setTitle(getTitle());
                    ((BarracksBuildNumberM) getChilderen().get(0)).setName("healer", quantity.get("healer"));
                    getChilderen().get(0).show(group);
                }
            });
            imageViewW5.setOnMouseClicked(event -> {
                if (text5.getFill().equals(Color.WHEAT)) {
                    group.getChildren().removeAll(getSubG());
                    getChilderen().get(0).setTitle(getTitle());
                    ((BarracksBuildNumberM) getChilderen().get(0)).setName("wallbreaker", quantity.get("wall breaker"));
                    getChilderen().get(0).show(group);
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
