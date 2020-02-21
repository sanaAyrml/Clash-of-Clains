package view;

import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import map.Game;
import map.GameGUI;

import java.io.*;

import static view.QuestionBM.Exceptions;

public class ClientM extends Menu{
    public ClientM(Menu parent, String title) {
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

        Text q3 = new Text("ID:");
        q3.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        q3.setFill(Color.BLACK);

        TextField textField3 = new TextField();
        textField3.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField3.setPrefColumnCount(24);
        textField3.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));

        HBox hBox3 = new HBox();
        hBox3.setSpacing(13);
        hBox3.relocate(640,380);
        hBox3.getChildren().addAll(q3,textField3);

        Text q = new Text("Server Port:");
        q.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        q.setFill(Color.BLACK);

        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField.setPrefColumnCount(17);
        textField.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));

        HBox hBox = new HBox();
        hBox.setSpacing(13);
        hBox.relocate(640,380);
        hBox.getChildren().addAll(q,textField);

        Text q1 = new Text("Client Port:");
        q1.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        q1.setFill(Color.BLACK);

        TextField textField1 = new TextField();
        textField1.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField1.setPrefColumnCount(17);
        textField1.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));

        HBox hBox1 = new HBox();
        hBox1.setSpacing(13);
        hBox1.relocate(640,380);
        hBox1.getChildren().addAll(q1,textField1 );



        Text q2 = new Text("IP:");
        q2.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        q2.setFill(Color.BLACK);

        TextField textField2 = new TextField();
        textField2.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField2.setPrefColumnCount(24);
        textField2.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));

        HBox hBox2 = new HBox();
        hBox2.setSpacing(13);
        hBox2.relocate(640,380);
        hBox2.getChildren().addAll(q2,textField2);

        InputStream inputStreamW3= null;
        try {
            inputStreamW3 = new FileInputStream(new File("../AP_15/src/Images/connect.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageW3=new Image(inputStreamW3);
        ImageView imageViewW3=new ImageView(imageW3);
        imageViewW3.setOnMouseMoved(event -> {
            imageViewW3.setStyle("-fx-opacity: 70%");
        });
        imageViewW3.setOnMouseExited(event -> {
            imageViewW3.setStyle("-fx-opacity: 100%");
        });

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
        vBox.setSpacing(15);
        vBox.relocate(640,385);
        vBox.getChildren().addAll(hBox3,hBox,hBox1,hBox2,imageViewW3,imageView4);


        imageViewW3.setOnMouseClicked(event -> {
            if(textField3.getText() != "" && textField.getText() != "" && textField2.getText() != "" && textField1.getText() != "") {

                try {
                    Integer.parseInt(textField.getText());
                    Integer.parseInt(textField1.getText());
                    try {
                        FileInputStream fis = new FileInputStream(new File(("../AP_15/" + textField3.getText() + ".txt")));
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Game game = (Game) ois.readObject();
                        GameGUI gameGUI = new GameGUI(game);
                        gameGUI.loadGameGUI();
                        MenuController menuController = new MenuController(game, gameGUI);
                        ((VillageView) (getChilderen().get(0))).setGame(game);
                        ((VillageView) (getChilderen().get(0))).setGameGUI(gameGUI);
                        ((VillageView) (getChilderen().get(0))).setMenuController(menuController);
                        ((VillageView) (getChilderen().get(0))).setMenues(menuController);
                        ((VillageView) getChilderen().get(0)).start();
                        group.getChildren().clear();
//                System.out.println("here");
                        ((VillageView) (getChilderen().get(0))).addClient(textField3.getText(), textField2.getText(), textField1.getText(), textField.getText());
//                System.out.println("here2");
                        getChilderen().get(0).show(primaryStage, group, scene);
                    } catch (IOException | ClassNotFoundException e) {
                        Game game = new Game();
                        GameGUI gameGUI = new GameGUI(game);
                        MenuController menuController = new MenuController(game, gameGUI);
                        ((VillageView) (getChilderen().get(0))).setGame(game);
                        ((VillageView) (getChilderen().get(0))).setGameGUI(gameGUI);
                        ((VillageView) (getChilderen().get(0))).setMenuController(menuController);
                        ((VillageView) (getChilderen().get(0))).setMenues(menuController);
                        ((VillageView) getChilderen().get(0)).start();
//            ((MainMenu)getParent()).getPlayer().stop();
                        group.getChildren().clear();
                        ((VillageView) (getChilderen().get(0))).addClient(textField3.getText(), textField2.getText(), textField1.getText(), textField.getText());
                        getChilderen().get(0).show(primaryStage, group, scene);
                    }
                }
                catch (Exception e){
                    Exceptions(group, "Wrong entery!!!");
                }
            }
        });


        group.getChildren().addAll(pane,imageView1,vBox);
    }
}
