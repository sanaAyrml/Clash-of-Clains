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

public class WallBreakerGUI extends SolGui {
    public WallBreakerGUI(Soldier soldier) {
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
        InputStream inputStream2 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-0.png"));

        final Image DOG_2 =  new Image(inputStream2);

        final ImageView dog2 = new ImageView(DOG_2);

        none=new Group(dog2);
    }
    public void up() throws FileNotFoundException {
        InputStream inputStream1 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-0.png"));
        InputStream inputStream2 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-1.png"));
        InputStream inputStream3 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-2.png"));
        InputStream inputStream4 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-3.png"));
        InputStream inputStream5 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-4.png"));
        InputStream inputStream6 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-5.png"));
        InputStream inputStream7 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-6.png"));
        InputStream inputStream8 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-7.png"));
        InputStream inputStream9 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-8-8.png"));

        final Image DOG_1 = new Image(inputStream1);
        final Image DOG_2 = new Image(inputStream2);
        final Image DOG_3 = new Image(inputStream3);
        final Image DOG_4 = new Image(inputStream4);
        final Image DOG_5 = new Image(inputStream5);
        final Image DOG_6 = new Image(inputStream6);
        final Image DOG_7 = new Image(inputStream7);
        final Image DOG_8 = new Image(inputStream8);
        final Image DOG_9 = new Image(inputStream9);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8 = new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);

        ArcherGUI.closeStreams(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5, inputStream6, inputStream7, inputStream8, inputStream9);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        createTimeline(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, timeline, up.getChildren());
        timeline.play();
    }
    public void down() throws FileNotFoundException {
        InputStream inputStream1 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-0.png"));
        InputStream inputStream2 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-1.png"));
        InputStream inputStream3 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-2.png"));
        InputStream inputStream4 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-3.png"));
        InputStream inputStream5 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-4.png"));
        InputStream inputStream6 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-5.png"));
        InputStream inputStream7 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-6.png"));
        InputStream inputStream8 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-7.png"));
        InputStream inputStream9 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-10-8.png"));

        final Image DOG_1 = new Image(inputStream1);
        final Image DOG_2 = new Image(inputStream2);
        final Image DOG_3 = new Image(inputStream3);
        final Image DOG_4 = new Image(inputStream4);
        final Image DOG_5 = new Image(inputStream5);
        final Image DOG_6 = new Image(inputStream6);
        final Image DOG_7 = new Image(inputStream7);
        final Image DOG_8 = new Image(inputStream8);
        final Image DOG_9 = new Image(inputStream9);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8 = new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);

        ArcherGUI.closeStreams(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5, inputStream6, inputStream7, inputStream8, inputStream9);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        createTimeline(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, timeline, down.getChildren());
        timeline.play();
    }
    public void left() throws FileNotFoundException {
        InputStream inputStream1 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-0.png"));
        InputStream inputStream2 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-1.png"));
        InputStream inputStream3 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-2.png"));
        InputStream inputStream4 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-3.png"));
        InputStream inputStream5 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-4.png"));
        InputStream inputStream6 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-5.png"));
        InputStream inputStream7 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-6.png"));
        InputStream inputStream8 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-7.png"));
        InputStream inputStream9 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-9-8.png"));

        final Image DOG_1 = new Image(inputStream1);
        final Image DOG_2 = new Image(inputStream2);
        final Image DOG_3 = new Image(inputStream3);
        final Image DOG_4 = new Image(inputStream4);
        final Image DOG_5 = new Image(inputStream5);
        final Image DOG_6 = new Image(inputStream6);
        final Image DOG_7 = new Image(inputStream7);
        final Image DOG_8 = new Image(inputStream8);
        final Image DOG_9 = new Image(inputStream9);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8 = new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        left = new Group(dog1);
//        left.anslateX(300);
//        left.anslateY(450);
//        left.anslateY(450);

        ArcherGUI.closeStreams(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5, inputStream6, inputStream7, inputStream8, inputStream9);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        createTimeline(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, timeline, left.getChildren());
        timeline.play();
    }
    public void right() throws FileNotFoundException {
        InputStream inputStream1 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-0.png"));
        InputStream inputStream2 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-1.png"));
        InputStream inputStream3 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-2.png"));
        InputStream inputStream4 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-3.png"));
        InputStream inputStream5 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-4.png"));
        InputStream inputStream6 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-5.png"));
        InputStream inputStream7 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-6.png"));
        InputStream inputStream8 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-7.png"));
        InputStream inputStream9 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-11-8.png"));

        final Image DOG_1 = new Image(inputStream1);
        final Image DOG_2 = new Image(inputStream2);
        final Image DOG_3 = new Image(inputStream3);
        final Image DOG_4 = new Image(inputStream4);
        final Image DOG_5 = new Image(inputStream5);
        final Image DOG_6 = new Image(inputStream6);
        final Image DOG_7 = new Image(inputStream7);
        final Image DOG_8 = new Image(inputStream8);
        final Image DOG_9 = new Image(inputStream9);
        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);
        final ImageView dog6 = new ImageView(DOG_6);
        final ImageView dog7 = new ImageView(DOG_7);
        final ImageView dog8 = new ImageView(DOG_8);
        final ImageView dog9 = new ImageView(DOG_9);
        right = new Group(dog1);
//        right.anslateX(300);
//        right.anslateY(450);
//        right.anslateY(450);

        ArcherGUI.closeStreams(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5, inputStream6, inputStream7, inputStream8, inputStream9);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        createTimeline(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, timeline, right.getChildren());
        timeline.play();
    }
    public void attack() throws FileNotFoundException {
        InputStream inputStream1 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-12-0.png"));
        InputStream inputStream2 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-12-1.png"));
        InputStream inputStream3 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-12-2.png"));
        InputStream inputStream4 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-12-3.png"));
        InputStream inputStream5 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-12-4.png"));


        final Image DOG_1 = new Image(inputStream1);
        final Image DOG_2 = new Image(inputStream2);
        final Image DOG_3 = new Image(inputStream3);
        final Image DOG_4 = new Image(inputStream4);
        final Image DOG_5 = new Image(inputStream5);

        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);

        attack = new Group(dog1);
//        right.anslateX(300);
//        right.anslateY(450);
//        right.anslateY(450);

        GiantGUI.closeInput(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        GuardianGUI.attackDie(dog1, dog2, dog3, dog4, dog5, timeline, attack.getChildren());
        timeline.play();
    }
    public void die() throws FileNotFoundException {
        InputStream inputStream1 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-20-0.png"));
        InputStream inputStream2 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-20-1.png"));
        InputStream inputStream3 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-20-2.png"));
        InputStream inputStream4 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-20-3.png"));
        InputStream inputStream5 = new FileInputStream(new File("../AP_15/src/photos/wallBreaker/wallBreaker [www.imagesplitter.net]-20-4.png"));


        final Image DOG_1 = new Image(inputStream1);
        final Image DOG_2 = new Image(inputStream2);
        final Image DOG_3 = new Image(inputStream3);
        final Image DOG_4 = new Image(inputStream4);
        final Image DOG_5 = new Image(inputStream5);

        final ImageView dog1 = new ImageView(DOG_1);
        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);

        GiantGUI.closeInput(inputStream1, inputStream2, inputStream3, inputStream4, inputStream5);


        die = new Group(dog1);
//        right.anslateX(300);
//        right.anslateY(450);
//        right.anslateY(450);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        GuardianGUI.attackDie(dog1, dog2, dog3, dog4, dog5, timeline, die.getChildren());
        timeline.play();
    }

    private void createTimeline(ImageView dog1, ImageView dog2, ImageView dog3, ImageView dog4, ImageView dog5, ImageView dog6, ImageView dog7, ImageView dog8, ImageView dog9, Timeline timeline, ObservableList<Node> children) {
        newKeyFrames(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, timeline, children);
    }

    void newKeyFrames(ImageView dog1, ImageView dog2, ImageView dog3, ImageView dog4, ImageView dog5, ImageView dog6, ImageView dog7, ImageView dog8, ImageView dog9, Timeline timeline, ObservableList<Node> children) {
        moveFrames(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8, dog9, timeline, children);
    }

    static void moveFrames(ImageView dog1, ImageView dog2, ImageView dog3, ImageView dog4, ImageView dog5, ImageView dog6, ImageView dog7, ImageView dog8, ImageView dog9, Timeline timeline, ObservableList<Node> children) {
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(100), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog1);
                    }
                }),
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog2);
                    }
                }),
                new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog3);
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog4);
                    }
                }),
                new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog5);
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog6);
                    }
                }),
                new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog7);
                    }
                }),
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog8);
                    }
                }),
                new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog9);
                    }
                }));
    }

}
