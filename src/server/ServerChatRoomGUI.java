package server;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import map.Message;
import view.MessageGUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import static server.ServerConstants.*;

public class ServerChatRoomGUI {


    private Group group = new Group();
    private ImageView backgroundImageView = new ImageView(ServerConstants.chatroomBackground);
    private ImageView boarderImageView = new ImageView(ServerConstants.border);
    private Text title = new Text(200,30, "Chat Board");
    ImageView sendView;
    TextField messageField;
    private HashMap<Integer , Image> messageImages = new HashMap<>();
    VBox MessageBox = new VBox();
    Text messageText = new Text();


    public ImageView getSendView() {
        return sendView;
    }

    public TextField getMessageField() {
        return messageField;
    }

    public ServerChatRoomGUI() {
        putInHashMap();
        MessageBox.setSpacing(25);
        backgroundImageView.setX(HORIZONTAL_FREE_SPACE);
        backgroundImageView.setY(VERTICAL_FREE_SPACE);
        boarderImageView.relocate(HORIZONTAL_FREE_SPACE,VERTICAL_FREE_SPACE);
        boarderImageView.setFitHeight(1000);
        boarderImageView.setFitWidth(500);

        InputStream sendButtonAddress = null;
        try {
            sendButtonAddress = new FileInputStream(new File("../AP_15/src/Images/send-button-2.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image sendPicture = new Image(sendButtonAddress);
        sendView = new ImageView(sendPicture);

        sendView.relocate(400 , 950);
        sendView.setFitHeight(40);
        sendView.setFitWidth(40 );

        messageField = new TextField();
        messageField.setStyle("-fx-background-color: lightgray; -fx-foreground-color: lightgray");
        messageField.setPrefColumnCount(30);
        messageField.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));
        messageField.relocate(50,950);

        HBox hBox = new HBox();
        hBox.relocate(60,950);
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(messageField,sendView);


        setBoardsTitlesFont(title);

        MessageBox.setTranslateY(60);





        Platform.runLater(new Runnable(){
            @Override
            public void run() {

                group.getChildren().addAll(backgroundImageView ,hBox ,title ,boarderImageView , MessageBox);
            }
        });


    }

    public VBox getLeftMessageBox() {
        return MessageBox;
    }

    public void putInHashMap(){
        try {
            InputStream right1Address = new FileInputStream(new File("../AP_15/src/Images/rightBubble_3.png"));
            Image rightPic = new Image(right1Address);
            messageImages.put(1 , rightPic);
            InputStream leftAddress = new FileInputStream(new File("../AP_15/src/Images/leftBubble_3.png"));
            Image leftPic = new Image(leftAddress);
            messageImages.put(2 , leftPic);
        }
        catch (Exception e){
            e.printStackTrace();

        }


    }


    public void messageGUI(){

    }

    public void setMessageText(String text) {


        Group chatMessages = new Group();

        ImageView messageView = new ImageView();
        messageText = new Text(text);
        messageView.setImage(messageImages.get(1));
        Boolean flag = true;
        if(messageText.getText().length() <= 25)
        {
            messageView.setFitWidth((messageText.getText().length()+5)*8.5 );
            messageView.setFitHeight(60);
            messageText.setTranslateX(15);
            messageText.setTranslateY(45);
        }

        else
        {
            if(messageText.getText().charAt(25) ==' '){
                messageText.setText(messageText.getText().substring(0,19)+"\n"+messageText.getText().substring(20,messageText.getText().length()-1));
                messageView.setFitWidth((25+5)*8.6 );
            }
            else{
                for(int i = 1; i<=7;i++){
                    if(messageText.getText().charAt(25+i) ==' '){
                        messageText.setText(messageText.getText().substring(0,19+i)+"\n"+messageText.getText().substring(21+i,messageText.getText().length()-1));
                        messageView.setFitWidth((25+i+5)*8.6 );
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int i = 1; i<=7;i++){
                        if(messageText.getText().charAt(25-i) ==' '){
                            messageText.setText(messageText.getText().substring(0,19-i)+"\n"+messageText.getText().substring(21-i,messageText.getText().length()-1));
                            messageView.setFitWidth((25-i+5)*8.6 );
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    messageText.setText(messageText.getText().substring(0,19)+"\n"+messageText.getText().substring(19,messageText.getText().length()-1));
                    messageView.setFitWidth((26+5)*8.5 );
                }
            }
            messageText.setTranslateX(25);
            messageText.setTranslateY(55);
            messageView.setFitHeight(95);
        }


        messageView.setTranslateX(0);
        messageView.setTranslateY(0);
        messageText.setFont(Font.font(15));
        messageText.setFill(Color.SKYBLUE);
        chatMessages.getChildren().add(messageView);
        chatMessages.getChildren().add(messageText);
        chatMessages.setTranslateX(470-messageView.getFitWidth());

        if(!MessageBox.getChildren().contains(messageText))
            MessageBox.getChildren().add(chatMessages);


    }

    public void setClientChats( String id , String text){


        Group chatMessages = new Group();
        ImageView messageView = new ImageView();
        messageView.setImage(messageImages.get(2));
        messageText = new Text(text);
        Text textID = new Text(id+":");

        Boolean flag = true;
        if(messageText.getText().length() <= 25)
        {
            messageView.setFitWidth((messageText.getText().length() + 5) * 8.5 );
            messageView.setFitHeight(60);
            textID.setTranslateX(15);
            textID.setTranslateY(25);
            messageText.setTranslateX(17);
            messageText.setTranslateY(45);
        }

        else
        {
            if(messageText.getText().charAt(24) ==' '){
//                    System.out.println("okkkkk");
                messageText.setText(messageText.getText().substring(0,19)+"\n"+messageText.getText().substring(20,messageText.getText().length()-1));
                messageView.setFitWidth((24+5)*8.5 );
            }
            else{
                for(int i = 1; i<=7;i++){
                    if(messageText.getText().charAt(24+i) ==' '){
                        messageText.setText(messageText.getText().substring(0,19+i)+"\n"+messageText.getText().substring(21+i,messageText.getText().length()-1));
                        messageView.setFitWidth((24+i+5)*8.6 );
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int i = 1; i<=7;i++){
                        if(messageText.getText().charAt(24-i) ==' '){
                            messageText.setText(messageText.getText().substring(0,19-i)+"\n"+messageText.getText().substring(21-i,messageText.getText().length()-1));
                            messageView.setFitWidth((24-i+5)*8.56 );
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    messageText.setText(messageText.getText().substring(0,19)+"\n"+messageText.getText().substring(19,messageText.getText().length()-1));
                    messageView.setFitWidth((26+5)*8.56 );
                }
            }
            textID.setTranslateX(25);
            textID.setTranslateY(35);
            textID.setFont(Font.font("Luminari",17));
            messageText.setTranslateX(25);
            messageText.setTranslateY(55);
            messageView.setFitHeight(95);
        }

        messageView.setTranslateX(0);
        messageView.setTranslateY(0);
       // textID.setFont(Font.font(17));
        messageText.setFont(Font.font(15));
        messageText.setFill(Color.DARKBLUE);
        chatMessages.getChildren().add(messageView);
        chatMessages.getChildren().add(textID);
        chatMessages.getChildren().add(messageText);
        chatMessages.setTranslateX(110);


        if(!MessageBox.getChildren().contains(messageText))
            MessageBox.getChildren().add(chatMessages);
    }

    public Group getGroup() {
        return group;
    }

}

