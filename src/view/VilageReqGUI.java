package view;

import building.GuardianGiant;
import client.Client;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import map.GameGUI;
import map.GameTransfer;
import server.ServerListeningMode;
import server.ServerTransferMessage;
import server.refreshMessages.AttackRefreshMessage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class VilageReqGUI {
    private Group root;
    private GameTransfer gameTransfer=null;
    private Client client;
    private String defenderID;
    private ImageView leaderBoard;
    private static LeaderBoardGUI leaderBoardGUI;
    private GuardianGiant guardianGiant;
    private ArrayList<Integer> numbers;

    public static void setLeaderBoardGUI(LeaderBoardGUI leaderBoardGUI) {
        VilageReqGUI.leaderBoardGUI = leaderBoardGUI;
    }

    public void setGameTransfer(GameTransfer gameTransfer) {
        this.gameTransfer = gameTransfer;
    }

    public VilageReqGUI(Group root, Client client,String defenderID,GuardianGiant guardianGiant,ArrayList<Integer> numbers) {
        this.defenderID=defenderID;
        this.root = root;
        this.client = client;
        this.numbers = numbers;
        this.guardianGiant = guardianGiant;
    }
    public void show(){
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (gameTransfer != null) {
                    GameGUI gameGUI = new GameGUI(gameTransfer);
                    Group groupCopy = new Group();
                    groupCopy.getChildren().setAll(root.getChildren());
                    root.getChildren().setAll(gameGUI.getCanvas());
                    try {
                        InputStream inputStreamL = null;
                        try {
                            inputStreamL = new FileInputStream(new File("../AP_15/src/Images/button/LeaderBoard.png"));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image imageL=new Image(inputStreamL);
                        leaderBoard =new ImageView(imageL);

                        InputStream inputStream = new FileInputStream(new File("../AP_15/src/Images/button/attack.png"));
                        Image image = new Image(inputStream);
                        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(image);

                        InputStream inputStream1 = new FileInputStream(new File("../AP_15/src/Images/button/ExitS.png"));
                        Image image1 = new Image(inputStream1);
                        javafx.scene.image.ImageView imageView1 = new javafx.scene.image.ImageView(image1);

                        VBox vBox = new VBox(imageView,leaderBoard, imageView1);
                        vBox.setSpacing(5);
                        vBox.setTranslateX(1460);
                        vBox.setTranslateY(700);
                        root.getChildren().add(vBox);

                        leaderBoard.setOnMouseClicked(event -> {
                            ServerTransferMessage transferMessage=new ServerTransferMessage(ServerListeningMode.LEADERBOARD_REQ,null,null,null, null,null,null,null,null);
                            client.getClientMessageSender().send(transferMessage);
                            root.getChildren().addAll(leaderBoardGUI.getGroup());
                        });
                        leaderBoardGUI.getImageViewE().setOnMouseClicked(event -> {
                            root.getChildren().remove(leaderBoardGUI.getGroup());
                        });

                        imageView.setOnMouseClicked(e -> {
                            ServerTransferMessage transferMessage = new ServerTransferMessage(ServerListeningMode.VILAGE_ATTACK,defenderID,null,null,null,null,null,guardianGiant,numbers);
                            AttackRefreshMessage refreshMessage=new AttackRefreshMessage(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
                            transferMessage.setAttackRefreshMessage(refreshMessage);
                            client.getClientMessageSender().send(transferMessage);
                        });

                        imageView1.setOnMouseClicked(e -> {
                            root.getChildren().setAll(groupCopy);
                        });


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    gameTransfer=null;
                } else {
                    this.stop();
                }
            }
        };
        timer.start();

    }

}
