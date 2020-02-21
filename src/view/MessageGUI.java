package view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class MessageGUI {

    HashMap<Integer , Image> rightPerson = new HashMap<>();
    HashMap<Integer , Image> leftPerson = new HashMap<>();

    VBox leftMessageBox = new VBox();

    client.Client client;
    public boolean called=false;


    public MessageGUI(client.Client client){
        setToHashMaps();

        leftMessageBox.relocate(0 , 0);
        leftMessageBox.setSpacing(30);
        this.client = client;
    }

    String id;



    public void addToGroup(String text, String id){



        ImageView messageView = new ImageView();
        Text messageText = new Text(text);
        Text textID = new Text(id+":");

// the right person
        if(id.equals(client.getID()))
        {
            Group chatMessages = new Group();
            messageView.setImage(rightPerson.get(1));
            Boolean flag = true;
            if(messageText.getText().length() <= 25)
            {
                messageView.setFitWidth((messageText.getText().length()+5)*8.5 );
                messageView.setFitHeight(60);
                textID.setTranslateX(15);
                textID.setTranslateY(25);
                messageText.setTranslateX(15);
                messageText.setTranslateY(45);
           }

            else
            {
                if(messageText.getText().charAt(25) ==' '){
                    messageText.setText(messageText.getText().substring(0,19)+"\n"+messageText.getText().substring(20,messageText.getText().length()-1));
                    messageView.setFitWidth((25+5)*8.5 );
                }
                else{
                    for(int i = 1; i<=7;i++){
                        if(messageText.getText().charAt(25+i) ==' '){
                            messageText.setText(messageText.getText().substring(0,19+i)+"\n"+messageText.getText().substring(21+i,messageText.getText().length()-1));
                            messageView.setFitWidth((25+i+5)*8.5 );
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        for(int i = 1; i<=7;i++){
                            if(messageText.getText().charAt(25-i) ==' '){
                                messageText.setText(messageText.getText().substring(0,19-i)+"\n"+messageText.getText().substring(21-i,messageText.getText().length()-1));
                                messageView.setFitWidth((25-i+5)*8.5 );
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
                textID.setTranslateX(25);
                textID.setTranslateY(35);
                messageText.setTranslateX(25);
                messageText.setTranslateY(55);
                messageView.setFitHeight(95);
            }


            messageView.setTranslateX(0);
            messageView.setTranslateY(0);
            textID.setFont(Font.font(17));
            messageText.setFont(Font.font(15));
            messageText.setFill(Color.SKYBLUE);
            chatMessages.getChildren().add(messageView);
            chatMessages.getChildren().add(textID);
            chatMessages.getChildren().add(messageText);
            chatMessages.setTranslateX(470-messageView.getFitWidth());

            if(!leftMessageBox.getChildren().contains(messageText))
                 leftMessageBox.getChildren().add(chatMessages);

        }


        // the other clients
        else{

            Group leftChatMessages = new Group();
            messageView.setImage(leftPerson.get(1));

            Boolean flag = true;
            if(messageText.getText().length() <= 25)
            {
                messageView.setFitWidth((messageText.getText().length()+5)*8.5 );
                messageView.setFitHeight(60);
                textID.setTranslateX(15);
                textID.setTranslateY(25);
                messageText.setTranslateX(16);
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
                            messageView.setFitWidth((24+i+5)*8.5 );
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        for(int i = 1; i<=7;i++){
                            if(messageText.getText().charAt(24-i) ==' '){
                                messageText.setText(messageText.getText().substring(0,19-i)+"\n"+messageText.getText().substring(21-i,messageText.getText().length()-1));
                                messageView.setFitWidth((24-i+5)*8.5 );
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
                textID.setTranslateX(25);
                textID.setTranslateY(35);
                messageText.setTranslateX(25);
                messageText.setTranslateY(55);
                messageView.setFitHeight(95);
            }

            messageView.setTranslateX(0);
            messageView.setTranslateY(0);
            textID.setFont(Font.font(17));
            messageText.setFont(Font.font(15));
            messageText.setFill(Color.DARKBLUE);
            leftChatMessages.getChildren().add(messageView);
            leftChatMessages.getChildren().add(textID);
            leftChatMessages.getChildren().add(messageText);
            leftChatMessages.setTranslateX(110);


            if(!leftMessageBox.getChildren().contains(messageText))
            leftMessageBox.getChildren().add(leftChatMessages);
        }



//        chatMessagesGroup.getChildren().addAll(leftMessageBox , rightMessageBox);

    }

    public VBox getLeftMessageBox() {
        return leftMessageBox;
    }


    public void setText(String text , String id ){
        called=true;
        this.id = id;

        addToGroup(text,id);

    }


    public void setToHashMaps() {

        try {
            InputStream right1Address = new FileInputStream(new File("../AP_15/src/Images/rightBubble_3.png"));
            Image right1Pic = new Image(right1Address);
            InputStream right2Address = new FileInputStream(new File("../AP_15/src/Images/rightBubble_2.png"));
            Image right2Pic = new Image(right2Address);
            InputStream right3Address = new FileInputStream(new File("../AP_15/src/Images/rightBubble_1.png"));
            Image right3Pic = new Image(right3Address);
            rightPerson.put(1 , right1Pic);
            rightPerson.put(2 , right2Pic);
            rightPerson.put(3 , right3Pic);

            right1Address.close();
            right2Address.close();
            right3Address.close();

            InputStream leftAddress = new FileInputStream(new File("../AP_15/src/Images/leftBubble_3.png"));
            Image left1Pic = new Image(leftAddress);
            InputStream left2Address = new FileInputStream(new File("../AP_15/src/Images/leftBubble_2.png"));
            Image left2Pic = new Image(left2Address);
            InputStream left3Address = new FileInputStream(new File("../AP_15/src/Images/leftBubble_1.png"));
            Image left3Pic = new Image(left3Address);
            leftPerson.put(1 , left1Pic);
            leftPerson.put(2 , left2Pic);
            leftPerson.put(3 , left3Pic);

            left2Address.close();
            left3Address.close();
            leftAddress.close();





        }
        catch (Exception e){
            e.printStackTrace();

        }

    }




}
