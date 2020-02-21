package view;

import client.Client;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import server.CostumerType;
import server.WarBoardGUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ClientWarBoardGUI {
    Group group = new Group();
    ImageView imageViewE;
    WarBoardGUI warBoardGUI = new WarBoardGUI(CostumerType.CLIENT);

    public ClientWarBoardGUI(Client client){
        InputStream inputStream2= null;
        try {
            inputStream2 = new FileInputStream(new File("../AP_15/src/Images/LeaderBoardBack.png"));

            Image image2=new Image(inputStream2);
            ImageView imageView2=new ImageView(image2);
            imageView2.relocate(540,50);

            InputStream inputStream = new FileInputStream(new File("../AP_15/src/Images/Sardar/WarBoard1.png"));
            Image image=new Image(inputStream);
            ImageView imageView=new ImageView(image);
            imageView.relocate(660,10);
            InputStream inputStreamE=new FileInputStream(new File("../AP_15/src/Images/Exit.png"));
            Image imageE=new Image(inputStreamE);
            imageViewE=new ImageView(imageE);
            imageViewE.relocate((540+540),50+30);
            group.getChildren().addAll(imageView2,imageView);
            group.getChildren().add(warBoardGUI.getGroup());
            group.getChildren().addAll(imageViewE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ImageView getImageViewE() {
        return imageViewE;
    }

    public Group getGroup() {
        return group;
    }

    public WarBoardGUI getWarBoardGUI() {
        return warBoardGUI;
    }
}
