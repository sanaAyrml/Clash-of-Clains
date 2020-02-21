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

public class DragonGUI extends SolGui {
    public DragonGUI(Soldier soldier) {
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
    public  void up() throws FileNotFoundException {
        almost(up);
    }
    public  void left() throws FileNotFoundException {
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-1-0.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-1-1.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-1-2.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-1-3.png"));

        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);

        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);

        left = new Group(dog2);
        Timeline timeline=new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog2, dog3, dog4, dog5, timeline, left.getChildren());
        timeline.play();
    }
    public  void right() throws FileNotFoundException {
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-2-0.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-2-1.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-2-2.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-2-3.png"));

        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);

        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);

        right = new Group(dog2);
        Timeline timeline=new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog2, dog3, dog4, dog5, timeline, right.getChildren());
        timeline.play();
    }
    public  void down() throws FileNotFoundException {
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-0-0.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-0-1.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-0-2.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-0-3.png"));

        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);

        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);

        down = new Group(dog2);
        Timeline timeline=new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog2, dog3, dog4, dog5, timeline, down.getChildren());
        timeline.play();
    }

    private  void timelines(ImageView dog2, ImageView dog3, ImageView dog4, ImageView dog5, Timeline timeline, ObservableList<Node> children) {
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog2);
                    }
                }),
                new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog3);
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog4);
                    }
                }),
                new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        children.setAll(dog5);
                    }

                }));
    }

    public  void attack() throws FileNotFoundException {
        almost(attack);
    }
    public  void die() throws FileNotFoundException {
        almost(die);
    }
    public  void none() throws FileNotFoundException {
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-3-0.png"));

        final Image DOG_2 =  new Image(inputStream2);

        final ImageView dog2 = new ImageView(DOG_2);

        none=new Group(dog2);
    }
    private  void almost(Group group) throws FileNotFoundException {
        InputStream inputStream2=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-3-0.png"));
        InputStream inputStream3=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-3-1.png"));
        InputStream inputStream4=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-3-2.png"));
        InputStream inputStream5=new FileInputStream(new File("../AP_15/src/photos/dragon/0340-19396 [www.imagesplitter.net]-3-3.png"));

        final Image DOG_2 =  new Image(inputStream2);
        final Image DOG_3 =  new Image(inputStream3);
        final Image DOG_4 =  new Image(inputStream4);
        final Image DOG_5 =  new Image(inputStream5);

        final ImageView dog2 = new ImageView(DOG_2);
        final ImageView dog3 = new ImageView(DOG_3);
        final ImageView dog4 = new ImageView(DOG_4);
        final ImageView dog5 = new ImageView(DOG_5);

        group = new Group(dog2);
        Timeline timeline=new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timelines(dog2, dog3, dog4, dog5, timeline, group.getChildren());
        timeline.play();
    }

}
