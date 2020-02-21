package attack.soldiersGUI;

import attack.SolGui;
import attack.Soldier;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HealerGUI extends SolGui {
    public HealerGUI(Soldier soldier) {
        super(soldier);
        try {
            none();
            up();
            down();
            left();
            right();
            attack();
            die();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void none() throws FileNotFoundException {
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-0.png"));

        final Image DOG_2 =  new Image(inputStream2);

        final ImageView dog2 = new ImageView(DOG_2);

        none=new Group(dog2);
    }
    public void up() throws FileNotFoundException {
        InputStream inputStream1=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-0.png"));
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-1.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-2.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-3.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-0.png"));
        InputStream inputStream6=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-1.png"));
        InputStream inputStream7=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-2.png"));
        InputStream inputStream8=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-3.png"));
        InputStream inputStream9=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-0.png"));
        InputStream inputStream10=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-1.png"));
        InputStream inputStream11=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-2.png"));
        InputStream inputStream12=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-3.png"));
        InputStream inputStream13=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-0.png"));
        InputStream inputStream14=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-1.png"));
        InputStream inputStream15=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-2.png"));
        InputStream inputStream16=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-3.png"));

        final Image DOG_1 =  new Image(inputStream1);
        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);
        final Image DOG_6 =  new Image(inputStream6);
        final Image DOG_7 =  new Image(inputStream7);
        final Image DOG_8 =  new Image(inputStream8);
        final Image DOG_9 =  new Image(inputStream9);
        final Image DOG_10 =  new Image(inputStream10);
        final Image DOG_11 =  new Image(inputStream11);
        final Image DOG_12 =  new Image(inputStream12);
        final Image DOG_13 =  new Image(inputStream13);
        final Image DOG_14 =  new Image(inputStream14);
        final Image DOG_15 =  new Image(inputStream15);
        final Image DOG_16 =  new Image(inputStream16);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8= new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        final ImageView dog10 = new ImageView(DOG_10);
        final ImageView dog11 = new ImageView(DOG_11);
        final ImageView dog12 = new ImageView(DOG_12);
        final ImageView dog13 = new ImageView(DOG_13);
        final ImageView dog14 = new ImageView(DOG_14);
        final ImageView dog15 = new ImageView(DOG_15);
        final ImageView dog16 = new ImageView(DOG_16);

        ArcherGUI.closeStreams(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5, inputStream6, inputStream7, inputStream8, inputStream9);

        Timeline timeline=new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, dog10, dog11, dog12, dog13, dog14, dog15, dog16, timeline, up.getChildren());
        timeline.play();
    }
    public void left() throws FileNotFoundException {
        InputStream inputStream1=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-4.png"));
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-5.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-6.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-7.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-4.png"));
        InputStream inputStream6=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-5.png"));
        InputStream inputStream7=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-6.png"));
        InputStream inputStream8=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-7.png"));
        InputStream inputStream9=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-4.png"));
        InputStream inputStream10=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-5.png"));
        InputStream inputStream11=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-6.png"));
        InputStream inputStream12=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-7.png"));
        InputStream inputStream13=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-4.png"));
        InputStream inputStream14=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-5.png"));
        InputStream inputStream15=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-6.png"));
        InputStream inputStream16=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-7.png"));

        final Image DOG_1 =  new Image(inputStream1);
        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);
        final Image DOG_6 =  new Image(inputStream6);
        final Image DOG_7 =  new Image(inputStream7);
        final Image DOG_8 =  new Image(inputStream8);
        final Image DOG_9 =  new Image(inputStream9);
        final Image DOG_10 =  new Image(inputStream10);
        final Image DOG_11 =  new Image(inputStream11);
        final Image DOG_12 =  new Image(inputStream12);
        final Image DOG_13 =  new Image(inputStream13);
        final Image DOG_14 =  new Image(inputStream14);
        final Image DOG_15 =  new Image(inputStream15);
        final Image DOG_16 =  new Image(inputStream16);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8 = new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        final ImageView dog10 = new ImageView(DOG_10);
        final ImageView dog11 = new ImageView(DOG_11);
        final ImageView dog12 = new ImageView(DOG_12);
        final ImageView dog13 = new ImageView(DOG_13);
        final ImageView dog14 = new ImageView(DOG_14);
        final ImageView dog15 = new ImageView(DOG_15);
        final ImageView dog16 = new ImageView(DOG_16);

        ArcherGUI.closeStreams(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5, inputStream6, inputStream7, inputStream8, inputStream9);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, dog10, dog11, dog12, dog13, dog14, dog15, dog16, timeline, left.getChildren());
        timeline.play();
    }
    public void right() throws FileNotFoundException {
        InputStream inputStream1=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-0 copy.png"));
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-1 copy.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-2 copy.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-0-3 copy.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-0 copy.png"));
        InputStream inputStream6=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-1 copy.png"));
        InputStream inputStream7=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-2 copy.png"));
        InputStream inputStream8=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-1-3 copy.png"));
        InputStream inputStream9=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-0 copy.png"));
        InputStream inputStream10=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-1 copy.png"));
        InputStream inputStream11=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-2 copy.png"));
        InputStream inputStream12=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-2-3 copy.png"));
        InputStream inputStream13=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-0 copy.png"));
        InputStream inputStream14=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-1 copy.png"));
        InputStream inputStream15=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-2 copy.png"));
        InputStream inputStream16=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-3-3 copy.png"));

        final Image DOG_1 =  new Image(inputStream1);
        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);
        final Image DOG_6 =  new Image(inputStream6);
        final Image DOG_7 =  new Image(inputStream7);
        final Image DOG_8 =  new Image(inputStream8);
        final Image DOG_9 =  new Image(inputStream9);
        final Image DOG_10 =  new Image(inputStream10);
        final Image DOG_11 =  new Image(inputStream11);
        final Image DOG_12 =  new Image(inputStream12);
        final Image DOG_13 =  new Image(inputStream13);
        final Image DOG_14 =  new Image(inputStream14);
        final Image DOG_15 =  new Image(inputStream15);
        final Image DOG_16 =  new Image(inputStream16);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8 = new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        final ImageView dog10 = new ImageView(DOG_10);
        final ImageView dog11 = new ImageView(DOG_11);
        final ImageView dog12 = new ImageView(DOG_12);
        final ImageView dog13 = new ImageView(DOG_13);
        final ImageView dog14 = new ImageView(DOG_14);
        final ImageView dog15 = new ImageView(DOG_15);
        final ImageView dog16 = new ImageView(DOG_16);
        right = new Group(dog1);

        Timeline timeline=new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, dog10, dog11, dog12, dog13, dog14, dog15, dog16, timeline, right.getChildren());
        timeline.play();
    }
    public void down() throws FileNotFoundException {
        InputStream inputStream1=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-0.png"));
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-1.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-2.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-3.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-0.png"));
        InputStream inputStream6=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-1.png"));
        InputStream inputStream7=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-2.png"));
        InputStream inputStream8=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-3.png"));
        InputStream inputStream9=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-0.png"));
        InputStream inputStream10=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-1.png"));
        InputStream inputStream11=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-2.png"));
        InputStream inputStream12=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-3.png"));
        InputStream inputStream13=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-0.png"));
        InputStream inputStream14=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-1.png"));
        InputStream inputStream15=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-2.png"));
        InputStream inputStream16=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-3.png"));

        final Image DOG_1 =  new Image(inputStream1);
        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);
        final Image DOG_6 =  new Image(inputStream6);
        final Image DOG_7 =  new Image(inputStream7);
        final Image DOG_8 =  new Image(inputStream8);
        final Image DOG_9 =  new Image(inputStream9);
        final Image DOG_10 =  new Image(inputStream10);
        final Image DOG_11 =  new Image(inputStream11);
        final Image DOG_12 =  new Image(inputStream12);
        final Image DOG_13 =  new Image(inputStream13);
        final Image DOG_14 =  new Image(inputStream14);
        final Image DOG_15 =  new Image(inputStream15);
        final Image DOG_16 =  new Image(inputStream16);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8 = new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        final ImageView dog10 = new ImageView(DOG_10);
        final ImageView dog11 = new ImageView(DOG_11);
        final ImageView dog12 = new ImageView(DOG_12);
        final ImageView dog13 = new ImageView(DOG_13);
        final ImageView dog14 = new ImageView(DOG_14);
        final ImageView dog15 = new ImageView(DOG_15);
        final ImageView dog16 = new ImageView(DOG_16);
        right = new Group(dog1);

        Timeline timeline=new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, dog10, dog11, dog12, dog13, dog14, dog15, dog16, timeline, down.getChildren());
        timeline.play();
    }

    private void timelines(ImageView dog1, ImageView dog2, ImageView dog3, ImageView dog4, ImageView dog5, ImageView dog6, ImageView dog7, ImageView dog8, ImageView dog9, ImageView dog10, ImageView dog11, ImageView dog12, ImageView dog13, ImageView dog14, ImageView dog15, ImageView dog16, Timeline timeline, ObservableList<Node> children) {
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(100), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog1);
                    }
                }),
                new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog2);
                    }
                }),
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog3);
                    }
                }),
                new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog4);
                    }
                }),
                new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog5);
                    }
                }),
                new KeyFrame(Duration.millis(350), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog6);
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog7);
                    }
                }),
                new KeyFrame(Duration.millis(450), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog8);
                    }
                }),
                new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog9);
                    }
                }),
                new KeyFrame(Duration.millis(550), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog10);

                    }
                }),
                new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {

                        children.setAll(dog11);
                    }
                }),
                new KeyFrame(Duration.millis(650), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {

                        children.setAll(dog12);
                    }
                }),
                new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {

                        children.setAll(dog13);
                    }
                }),
                new KeyFrame(Duration.millis(750), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog14);
                    }
                }),
                new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog15);
                    }
                }),
                new KeyFrame(Duration.millis(850), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog16);
                    }
                }));
    }

    public void attack() throws FileNotFoundException {
        InputStream inputStream1=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-4.png"));
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-5.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-6.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-7.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-4.png"));
        InputStream inputStream6=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-5.png"));
        InputStream inputStream7=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-6.png"));
        InputStream inputStream8=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-7.png"));
        InputStream inputStream9=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-4.png"));
        InputStream inputStream10=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-5.png"));
        InputStream inputStream11=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-6.png"));
        InputStream inputStream12=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-7.png"));
        InputStream inputStream13=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-4.png"));
        InputStream inputStream14=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-5.png"));
        InputStream inputStream15=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-6.png"));
        InputStream inputStream16=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-7.png"));

        final Image DOG_1 =  new Image(inputStream1);
        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);
        final Image DOG_6 =  new Image(inputStream6);
        final Image DOG_7 =  new Image(inputStream7);
        final Image DOG_8 =  new Image(inputStream8);
        final Image DOG_9 =  new Image(inputStream9);
        final Image DOG_10 =  new Image(inputStream10);
        final Image DOG_11 =  new Image(inputStream11);
        final Image DOG_12 =  new Image(inputStream12);
        final Image DOG_13 =  new Image(inputStream13);
        final Image DOG_14 =  new Image(inputStream14);
        final Image DOG_15 =  new Image(inputStream15);
        final Image DOG_16 =  new Image(inputStream16);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8= new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        final ImageView dog10 = new ImageView(DOG_10);
        final ImageView dog11 = new ImageView(DOG_11);
        final ImageView dog12 = new ImageView(DOG_12);
        final ImageView dog13 = new ImageView(DOG_13);
        final ImageView dog14 = new ImageView(DOG_14);
        final ImageView dog15 = new ImageView(DOG_15);
        final ImageView dog16 = new ImageView(DOG_16);
        attack = new Group(dog1);


        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, dog10, dog11, dog12, dog13, dog14, dog15, dog16, timeline, attack.getChildren());
        timeline.play();
    }
    public void die() throws FileNotFoundException {
        InputStream inputStream1=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-4.png"));
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-5.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-6.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-4-7.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-4.png"));
        InputStream inputStream6=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-5.png"));
        InputStream inputStream7=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-6.png"));
        InputStream inputStream8=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-5-7.png"));
        InputStream inputStream9=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-4.png"));
        InputStream inputStream10=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-5.png"));
        InputStream inputStream11=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-6.png"));
        InputStream inputStream12=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-6-7.png"));
        InputStream inputStream13=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-4.png"));
        InputStream inputStream14=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-5.png"));
        InputStream inputStream15=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-6.png"));
        InputStream inputStream16=new FileInputStream(new File("../AP_15/src/photos/wizard/wizard [www.imagesplitter.net]-7-7.png"));

        final Image DOG_1 =  new Image(inputStream1);
        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);
        final Image DOG_6 =  new Image(inputStream6);
        final Image DOG_7 =  new Image(inputStream7);
        final Image DOG_8 =  new Image(inputStream8);
        final Image DOG_9 =  new Image(inputStream9);
        final Image DOG_10 =  new Image(inputStream10);
        final Image DOG_11 =  new Image(inputStream11);
        final Image DOG_12 =  new Image(inputStream12);
        final Image DOG_13 =  new Image(inputStream13);
        final Image DOG_14 =  new Image(inputStream14);
        final Image DOG_15 =  new Image(inputStream15);
        final Image DOG_16 =  new Image(inputStream16);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8= new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        final ImageView dog10 = new ImageView(DOG_10);
        final ImageView dog11 = new ImageView(DOG_11);
        final ImageView dog12 = new ImageView(DOG_12);
        final ImageView dog13 = new ImageView(DOG_13);
        final ImageView dog14 = new ImageView(DOG_14);
        final ImageView dog15 = new ImageView(DOG_15);
        final ImageView dog16 = new ImageView(DOG_16);
        die = new Group(dog1);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(100), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog1);
                    }
                }),
                new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog2);
                    }
                }),
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog3);
                    }
                }),
                new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog4);
                    }
                }),
                new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog5);
                    }
                }),
                new KeyFrame(Duration.millis(350), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog6);
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog7);
                    }
                }),
                new KeyFrame(Duration.millis(450), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog8);
                    }
                }),
                new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog9);
                    }
                }),
                new KeyFrame(Duration.millis(550), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog10);

                    }
                }),
                new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {

                        attack.getChildren().setAll(dog11);
                    }
                }),
                new KeyFrame(Duration.millis(650), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {

                        attack.getChildren().setAll(dog12);
                    }
                }),
                new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {

                        attack.getChildren().setAll(dog13);
                    }
                }),
                new KeyFrame(Duration.millis(750), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog14);
                    }
                }),
                new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog15);
                    }
                }),
                new KeyFrame(Duration.millis(850), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        attack.getChildren().setAll(dog16);
                    }
                }));
        timeline.play();
    }

}
