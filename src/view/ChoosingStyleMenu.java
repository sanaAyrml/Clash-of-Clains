package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ChoosingStyleMenu extends Menu{
    public ChoosingStyleMenu(Menu parent, String title) {
        super(parent, title);
    }

    @Override
    public void show(Stage primaryStage, Group group, Scene scene) {
        BorderPane pane = new BorderPane();
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream(new File("../AP_15/src/Images/playBack"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image=new Image(inputStream);
        ImageView imageView=new ImageView(image);
        imageView.fitHeightProperty().bind(primaryStage.heightProperty());
        imageView.fitWidthProperty().bind(primaryStage.widthProperty());
        pane.setCenter(imageView);

        InputStream inputStream1= null;
        try {
            inputStream1 = new FileInputStream(new File("../AP_15/src/Images/ok"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1=new Image(inputStream1);
        ImageView imageView1=new ImageView(image1);
        imageView1.relocate(610,200);
        InputStream inputStream2= null;



        try {
            inputStream2 = new FileInputStream(new File("../AP_15/src/Images/singlePlayer.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2=new Image(inputStream2);
        ImageView imageView2=new ImageView(image2);
        imageView2.setOnMouseClicked(event -> {
            group.getChildren().clear();
            getChilderen().get(0).show(primaryStage,group,scene);
        });
        imageView2.setOnMouseMoved(event -> {
            imageView2.setStyle("-fx-opacity: 70%");
        });
        imageView2.setOnMouseExited(event -> {
            imageView2.setStyle("-fx-opacity: 100%");
        });
        InputStream inputStream3= null;
        try {
            inputStream3 = new FileInputStream(new File("../AP_15/src/Images/multiPlayer.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3=new Image(inputStream3);
        ImageView imageView3=new ImageView(image3);
        imageView3.setOnMouseClicked(event -> {
            group.getChildren().clear();
            getChilderen().get(1).show(primaryStage,group,scene);
        });
        imageView3.setOnMouseMoved(event -> {
            imageView3.setStyle("-fx-opacity: 70%");
        });
        imageView3.setOnMouseExited(event -> {
            imageView3.setStyle("-fx-opacity: 100%");
        });
        InputStream inputStream4= null;
        try {
            inputStream4 = new FileInputStream(new File("../AP_15/src/Images/Back"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4=new Image(inputStream4);
        ImageView imageView4=new ImageView(image4);
        imageView4.setOnMouseClicked(event -> {
            try {
                group.getChildren().clear();
                getParent().show(primaryStage,group,scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        imageView4.setOnMouseMoved(event -> {
            imageView4.setStyle("-fx-opacity: 70%");
        });
        imageView4.setOnMouseExited(event -> {
            imageView4.setStyle("-fx-opacity: 100%");
        });
        VBox vBox = new VBox();
        vBox.relocate(695,390);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(60);
        vBox.getChildren().setAll(imageView2,imageView3,imageView4);
        group.getChildren().addAll(pane,imageView1,vBox);
    }
}
