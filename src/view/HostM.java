package view;

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
import server.Server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static view.QuestionBM.Exceptions;

public class HostM extends Menu{
    public HostM(Menu parent, String title) {
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

        Text q = new Text("Port:");
        q.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        q.setFill(Color.BLACK);

        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField.setPrefColumnCount(22);
        textField.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));

        HBox hBox = new HBox();
        hBox.setSpacing(13);
        hBox.relocate(640,380);
        hBox.getChildren().addAll(q,textField);

        Text q1 = new Text("IP:");
        q1.setFont(Font.font ("Luminari", FontWeight.BOLD, 20));
        q1.setFill(Color.BLACK);

        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        TextField textField1 = new TextField();
        textField1.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
        textField1.setPrefColumnCount(24);
        textField1.setFont(Font.font ("Luminari", FontWeight.BOLD, 12));
        textField1.setText( inetAddress.getHostAddress());
        textField1.setEditable(false);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(13);
        hBox1.relocate(640,380);
        hBox1.getChildren().addAll(q1,textField1 );

        InputStream inputStreamW3= null;
        try {
            inputStreamW3 = new FileInputStream(new File("../AP_15/src/Images/connect.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageW3=new Image(inputStreamW3);
        ImageView imageViewW3=new ImageView(imageW3);

        imageViewW3.setOnMouseClicked(event -> {
            if(textField.getText() != " " && textField1.getText() != " ") {
                try {
                    Integer.parseInt(textField.getText());
                    Server server = new Server();
                    group.getChildren().clear();
                    group.getChildren().add(server.getServerGUI().getGroup());
                }
                catch (Exception e){
                    Exceptions(group, "Wrong entery!!!");
                }
            }
        });
        // hover for the button

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
        // hover
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
        vBox.relocate(640,390);
        vBox.getChildren().addAll(hBox,hBox1,imageViewW3,imageView4);



        group.getChildren().addAll(pane,imageView1,vBox);
    }
}
