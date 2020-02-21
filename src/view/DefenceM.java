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

public class DefenceM extends MenuIn {
    public DefenceM(MenuIn parent, MenuController menuController,VillageView villageView) {
        super(parent,menuController,villageView);
    }
    private int kind;

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    @Override
    public void show(Group group) {


        try {
            InputStream inputStream2 = null;
            if(kind == 1) {
                inputStream2 = new FileInputStream(new File("../AP_15/src/Images/Sardar/AirDefence.png"));
            }
            if(kind == 2){
                inputStream2=new FileInputStream(new File("../AP_15/src/Images/Sardar/ArcherTower.png"));
            }
            if(kind == 3){
                inputStream2=new FileInputStream(new File("../AP_15/src/Images/Sardar/Cannon.png"));
            }
            if(kind == 4){
                inputStream2=new FileInputStream(new File("../AP_15/src/Images/Sardar/GiantCastle.png"));
            }
            if(kind == 5){
                inputStream2=new FileInputStream(new File("../AP_15/src/Images/Sardar/WizardTower.png"));
            }
            if(kind == 6){
                inputStream2=new FileInputStream(new File("../AP_15/src/Images/Sardar/Trap.png"));
            }
            if(kind == 7){
                inputStream2=new FileInputStream(new File("../AP_15/src/Images/Sardar/Wall.png"));
            }
            Image image2=new Image(inputStream2);
            ImageView imageView2=new ImageView(image2);
            setTitle(imageView2);

            basic(group);


            HBox hBox = new HBox();
    //        hBox.relocate(x+22,y+80);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(20);


            InputStream inputStream3=new FileInputStream(new File("../AP_15/src/Images/button/info.png"));
            Image image3=new Image(inputStream3);
            ImageView imageView3=new ImageView(image3);

            InputStream inputStream4=new FileInputStream(new File("../AP_15/src/Images/button/defenceTarget.png"));
            Image image4=new Image(inputStream4);
            ImageView imageView4=new ImageView(image4);


            hBox.getChildren().setAll(imageView3,imageView4);
            if(kind == 7){
                hBox.getChildren().remove(imageView4);
            }
            VBox vBox = new VBox();
            vBox.relocate(x+22,y+70);
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
            imageView4.setOnMouseClicked(event -> {
                group.getChildren().removeAll(getSubG());
                getChilderen().get(1).setTitle(getTitle());
                getChilderen().get(1).show(group);
            });
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }


}
