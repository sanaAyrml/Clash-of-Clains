package view;

import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import map.Game;
import map.GameGUI;

import java.io.*;

public class LoadGame extends Menu{
    public LoadGame(Menu parent, String title) {
        super(parent, title);
    }

    @Override
    public void show(Stage primaryStage,Group group,Scene scene) {
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

        Text q = new Text("Load Game:");
        q.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        q.setFill(Color.BLACK);

        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField.setPrefColumnCount(20);
        textField.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));

        InputStream inputStreamW3= null;
        try {
            inputStreamW3 = new FileInputStream(new File("../AP_15/src/Images/letsPlay.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageW3=new Image(inputStreamW3);
        ImageView imageViewW3=new ImageView(imageW3);

        InputStream inputStream4= null;
        try {
            inputStream4 = new FileInputStream(new File("../AP_15/src/Images/Back"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4=new Image(inputStream4);
        ImageView imageView4=new ImageView(image4);
        imageView4.setOnMouseMoved(event -> {
            imageView4.setStyle("-fx-opacity: 70%");
        });
        imageView4.setOnMouseExited(event -> {
            imageView4.setStyle("-fx-opacity: 100%");
        });
        imageView4.setOnMouseClicked(event -> {
            try {
                group.getChildren().clear();
                getParent().show(primaryStage,group,scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        VBox vBox = new VBox();
        vBox.setSpacing(25);
        vBox.relocate(640,380);
        vBox.getChildren().addAll(q,textField,imageViewW3,imageView4);


        imageViewW3.setOnMouseClicked(event -> {

            try {
                FileInputStream fis = new FileInputStream(new File(textField.getText()));
                ObjectInputStream ois = new ObjectInputStream(fis);
                Game game = (Game)ois.readObject();
                GameGUI gameGUI = new GameGUI(game);
                gameGUI.loadGameGUI();
                MenuController menuController = new MenuController(game,gameGUI);
                ((VillageView)(getChilderen().get(0))).setGame(game);
                ((VillageView)(getChilderen().get(0))).setGameGUI(gameGUI);
                ((VillageView)(getChilderen().get(0))).setMenuController(menuController);
                ((VillageView)(getChilderen().get(0))).setMenues(menuController);
                ((VillageView)getChilderen().get(0)).start();
                group.getChildren().clear();
                getChilderen().get(0).show(primaryStage,group,scene);
            } catch (IOException | ClassNotFoundException e) {
                Error(group, e);
            }
        });


        group.getChildren().addAll(pane,imageView1,vBox);

    }


}
