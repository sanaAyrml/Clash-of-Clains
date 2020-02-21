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

public class StorageM extends MenuIn {
    private int kind;
    public StorageM(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent,menuController,villageView);
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    @Override
    public void show(Group group) {
        try {
            InputStream inputStream2 = null;
        if(kind == 1) {
            inputStream2 = new FileInputStream(new File("../AP_15/src/Images/Sardar/GoldStorage.png"));
        }
        if(kind == 2){
           inputStream2=new FileInputStream(new File("../AP_15/src/Images/Sardar/ElixirStorage.png"));

        }
        Image image2=new Image(inputStream2);
        ImageView imageView2=new ImageView(image2);
        setTitle(imageView2);

        basic(group);


        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);


        InputStream inputStream3 = new FileInputStream(new File("../AP_15/src/Images/button/info.png"));
        Image image3 = new Image(inputStream3);
        ImageView imageView3 = new ImageView(image3);

        hBox.getChildren().setAll(imageView3);
        VBox vBox = new VBox();
        vBox.relocate(x + 22, y + 70);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().setAll(hBox);
        getSubG().getChildren().add(vBox);

            if(group.getChildren().contains(getSubG())){
                group.getChildren().remove(getSubG());
            }
        group.getChildren().addAll(getSubG());

            imageView3.setOnMouseClicked(event -> {
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                getChilderen().get(0).show(group);
            });
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
