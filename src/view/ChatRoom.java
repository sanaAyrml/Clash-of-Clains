package view;


import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import map.Constants;
import map.Message;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class ChatRoom {
    Group chatRoomGroup = new Group();
    Boolean flag = true;
    private MessageGUI messageGUI;

    client.Client client;

    public ChatRoom(client.Client client){




        this.client = client;
        messageGUI=client.getClientChatListener().getMessageGUI();
        ScrollPane scrollPane = new ScrollPane(messageGUI.getLeftMessageBox());


        try {
            TextField messageField = new TextField();

            InputStream chatBackGroundAddress = new FileInputStream(new File("../AP_15/src/Images/chatBackground.jpg"));
            Image chatImage = new Image(chatBackGroundAddress);
            ImageView chatView = new ImageView(chatImage);

            chatView.setFitHeight(Constants.MAP_HEGHT * Constants.CELL_HEIGHT);
            chatView.setFitWidth(500);

            chatView.setX(-470);
            chatView.setY(0);

            InputStream exitButton = new FileInputStream(new File("../AP_15/src/Images/Exit.png"));
            Image exitImage = new Image(exitButton);
            ImageView exitView = new ImageView(exitImage);
            exitView.relocate( -50 , 15);

            InputStream sendButtonAddress = new FileInputStream(new File("../AP_15/src/Images/send-button-2.png"));
            Image sendPicture = new Image(sendButtonAddress);
            ImageView sendView = new ImageView(sendPicture);

            sendView.relocate(-50 , 950);
            sendView.setFitHeight(40);
            sendView.setFitWidth(40 );


            messageField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
            messageField.setPrefColumnCount(25);
            messageField.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));
            messageField.relocate(-380,950);


            chatView.setOnMouseClicked((MouseEvent event) ->  {
                    AnimationTimer timer=new AnimationTimer() {
                        @Override
                        public void handle(long now) {

                                if (chatView.getX() <= 0 && exitView.getX() <= 420 &&  sendView.getX() <=390  )  {
                                    chatView.setX(chatView.getX() + 5);
                                    exitView.setX(exitView.getX() + 5);
                                    messageField.setTranslateX(messageField.getTranslateX()+5);
                                    sendView.setX(sendView.getX() + 5);
                                    scrollPane.setTranslateX(scrollPane.getTranslateX() + 5);
//                                    System.out.println(scrollPane.getTranslateX());
//                                    messageGUI.getLeftMessageBox().setTranslateX(messageGUI.getLeftMessageBox().getTranslateX() + 5);
//                                    messageGUI.getRightMessageBox().setTranslateX(messageGUI.getRightMessageBox().getTranslateX() + 5);


                            }

                        }

                    }; timer.start();


            });
            exitView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    AnimationTimer inTimer = new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                            if(chatView.getX() > -470 && exitView.getX() > -20 && sendView.getX()> -20) {
                                chatView.setX(chatView.getX() - 5);
                                exitView.setX(exitView.getX() - 5);

                                messageField.setTranslateX(messageField.getTranslateX()-5);
                                sendView.setX(sendView.getX() - 5);

//                                messageGUI.getLeftMessageBox().setTranslateX(messageGUI.getLeftMessageBox().getTranslateX() -  5);
//                                messageGUI.getRightMessageBox().setTranslateX(messageGUI.getRightMessageBox().getTranslateX() - 5);
                                scrollPane.setTranslateX(scrollPane.getTranslateX() - 5);


                            }


                        }
                    };
                    inTimer.start();

                }
            });

            sendView.setOnMouseClicked(event -> {
                Message message = new Message(client.getID(), messageField.getText());
                client.getClientChatSender().send(message);
                messageField.clear();


            });

            chatRoomGroup.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    Message message = new Message(client.getID(), messageField.getText());
                    client.getClientChatSender().send(message);
                    messageField.clear();

            }});


            chatRoomGroup.getStylesheets().addAll(new File("../AP_15/css.css").toURI().toString());

            scrollPane.setPrefViewportHeight(700);
            scrollPane.setPrefViewportWidth(500);
            scrollPane.setTranslateX(-510);
            scrollPane.setTranslateY(80);

            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);


//            scrollPane.setContent(messageGUI.getLeftMessageBox());
            chatRoomGroup.getChildren().addAll(chatView  , exitView , sendView, messageField  , scrollPane);

//            scrollPane.toFront();


        }
        catch (Exception e){
            e.printStackTrace();

        }

    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Group getChatRoomGroup() {
        return chatRoomGroup;
    }
}
