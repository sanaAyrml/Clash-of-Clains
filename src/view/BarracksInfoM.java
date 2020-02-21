package view;

import controllers.MenuController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BarracksInfoM extends MenuIn{
    public BarracksInfoM(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent,menuController,villageView);
    }

    @Override
    public void show(Group group) {
        try {
            basic(group);
        HBox hBox = new HBox();
//        hBox.relocate(x+22,y+80);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);


        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/Images/button/infoUpgrade.png"));
        Image image3=new Image(inputStream3);
        ImageView imageView3=new ImageView(image3);

        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/Images/button/infoOverall.png"));
        Image image4=new Image(inputStream4);
        ImageView imageView4=new ImageView(image4);

        hBox.getChildren().setAll(imageView4,imageView3);

        VBox vBox = new VBox();
        vBox.relocate(x+22,y+70);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().setAll(hBox);
            if(group.getChildren().contains(getSubG())){
                group.getChildren().remove(getSubG());
            }
        getSubG().getChildren().add(vBox);

        group.getChildren().addAll(getSubG());
            imageView4.setOnMouseClicked(event -> {
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                getChilderen().get(0).show(group);
            });
            imageView3.setOnMouseClicked(event -> {
                group.getChildren().removeAll(getSubG());
                getChilderen().get(1).setTitle(getTitle());
                getChilderen().get(1).show(group);
            });
        }
        catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
}
