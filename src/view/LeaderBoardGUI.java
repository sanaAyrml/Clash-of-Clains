package view;

import client.Client;
import client.ClientLeaderBoardGUI;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import server.ClientInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class LeaderBoardGUI {
    Group group = new Group();
    ImageView imageViewE;
    private ClientLeaderBoardGUI clientLeaderBoardGUI;

    public LeaderBoardGUI(Client client){
        clientLeaderBoardGUI = new ClientLeaderBoardGUI(client,group);
        InputStream inputStream2= null;
        try {
            inputStream2 = new FileInputStream(new File("../AP_15/src/Images/LeaderBoardBack.png"));

        Image image2=new Image(inputStream2);
        ImageView imageView2=new ImageView(image2);
        imageView2.relocate(540,50);

        InputStream inputStream = new FileInputStream(new File("../AP_15/src/Images/Sardar/leaderBoared.png"));
        Image image=new Image(inputStream);
        ImageView imageView=new ImageView(image);
        imageView.relocate(660,10);
            InputStream inputStreamE=new FileInputStream(new File("../AP_15/src/Images/Exit.png"));
            Image imageE=new Image(inputStreamE);
            imageViewE=new ImageView(imageE);
            imageViewE.relocate((540+540),50+30);
        group.getChildren().addAll(imageView2,imageView,imageViewE);
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
        group.getChildren().add(clientLeaderBoardGUI.getGroup());
    }
    public void setGTotal(Group gTotal){
        clientLeaderBoardGUI.setgTotal(gTotal);
    }
    public void refresh(ArrayList<ClientInfo> clientInfos)
    {
        clientLeaderBoardGUI.refresh(clientInfos);
    }

    public ImageView getImageViewE() {
        return imageViewE;
    }

    public Group getGroup() {
        return group;
    }

    public ClientLeaderBoardGUI getClientLeaderBoardGUI() {
        return clientLeaderBoardGUI;
    }
}
