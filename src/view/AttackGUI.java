package view;

import Exceptions.PutSoldierException;
import attack.SolGui;
import attack.Soldier;
import attack.Type;
import attack.soldierGUI;
import attack.soldiers.*;
import attack.soldiersGUI.*;
import building.GuardianGiant;
import controllers.AttackController;
import controllers.AttackTimeHandler;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import map.Constants;
import map.Game;

import java.io.*;
import java.util.ArrayList;

public class AttackGUI {
    private Stage stage;
    private Game gameDefender;
    private Game gameAttacker;
    private Group root;
    private ArrayList<Guardian> guardians;
    private ArrayList<WallBreaker> wallBreakers;
    private ArrayList<Giant> giants;
    private ArrayList<Dragon> dragons;
    private ArrayList<Archer> archers;
    private ArrayList<Healer> healers;
    private AttackController controller;
    private ArrayList<Type> soldiersToAdd = new ArrayList<>();
    private soldierGUI soldierGUI;
    private boolean ended = false;
    private AttackTimeHandler timeHandler;
    private Group villageRoot;
    private GuardianGiant guardianGiant;
    private AnimationTimer timer=null;
    private AnimationTimer timer1=null;
    private MediaPlayer player1;
    private MediaPlayer playerAttack;


    public AttackGUI(MediaPlayer player1,MediaPlayer playerAttack,GuardianGiant guardianGiant, Group villageRoot, AttackController controller, Stage stage, Game gameDefender, Game gameAttacker, Group root, ArrayList<Guardian> guardians, ArrayList<WallBreaker> wallBreakers, ArrayList<Giant> giants, ArrayList<Dragon> dragons, ArrayList<Archer> archers, ArrayList<Healer> healers) {
        this.player1=player1;
        this.playerAttack=playerAttack;
        this.guardianGiant = guardianGiant;
        this.villageRoot = villageRoot;
        this.controller = controller;
        timeHandler = new AttackTimeHandler(controller);
        this.stage = stage;
        this.gameDefender = gameDefender;
        this.gameAttacker = gameAttacker;
        this.root = root;
        this.guardians = (ArrayList<Guardian>) guardians.clone();
        this.wallBreakers = (ArrayList<WallBreaker>) wallBreakers.clone();
        this.giants = (ArrayList<Giant>) giants.clone();
        this.dragons = (ArrayList<Dragon>) dragons.clone();
        this.archers = (ArrayList<Archer>) archers.clone();
//        System.err.println(guardians.size());
        soldierGUI = new soldierGUI(new GuardianGiantGui(guardianGiant), guardianGiant, root);
        this.healers = (ArrayList<Healer>) healers.clone();
        try {
            soldierGUI.run();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void addSoldier(Soldier soldier) {

    }

    public void startAttack() {
//        System.err.println("oomad start");
        InputStream inputStream11 = null;
        InputStream inputStream111 = null;
        InputStream inputStream113 = null;
        InputStream inputStream112 = null;
        try {
            inputStream11 = new FileInputStream(new File("../AP_15/src/photos/black-linen-2.png"));
            inputStream113 = new FileInputStream(new File("../AP_15/src/photos/Elixir.png"));
            inputStream111 = new FileInputStream(new File("../AP_15/src/Images/Sardar/Attack.png"));
            inputStream112 = new FileInputStream(new File("../AP_15/src/photos/Gold.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image11 = new Image(inputStream11);
        ImageView imageView11 = new ImageView(image11);
        Image image111 = new Image(inputStream111);
        ImageView imageView111 = new ImageView(image111);
        Image image112 = new Image(inputStream112);
        ImageView imageView112 = new ImageView(image112);
        Image image113 = new Image(inputStream113);
        ImageView imageView113 = new ImageView(image113);
        Text text3 = new Text(Integer.toString( gameDefender.getTotalGold()));
        text3.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text3.setFill(Color.WHITE);
        text3.setX(800);
        text3.setY(330);
        Text text4 = new Text(Integer.toString(gameDefender.getTotalElixir()));
        text4.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text4.setFill(Color.WHITE);
        text4.setX(800);
        text4.setY(540);
        imageView111.setX(700);
        imageView111.setY(700);
        imageView112.setX(700);
        imageView112.setY(300);
        imageView113.setX(700);
        imageView113.setY(500);
        closeStreams(inputStream11, inputStream111, inputStream113, inputStream112);

        Group group = new Group();
        imageView11.setFitWidth(2850);
        imageView11.setFitHeight(1800);
        group.getChildren().addAll(imageView11,imageView111,imageView112,imageView113,text3,text4);

        root.getChildren().add(group);
//        stage.setScene(scene);

        imageView111.setOnMouseClicked(e->{
            root.getChildren().remove(group);
            try {
//                System.err.println("att");
                attack();
            } catch (FileNotFoundException e1) {

            }
        });


    }

    public void closeStreams(InputStream inputStream11, InputStream inputStream111, InputStream inputStream113, InputStream inputStream112) {
        try {
            inputStream11.close();
            inputStream111.close();
            inputStream112.close();
            inputStream113.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void attack() throws FileNotFoundException {
//        System.err.println("oomad att");
        InputStream inputStreamm = new FileInputStream(new File("../AP_15/src/photos/Class_render-MGuardian.png"));
        Image imagee = new Image(inputStreamm);
        ImageView imageeView = new ImageView(imagee);

        InputStream inputStreammm = new FileInputStream(new File("../AP_15/src/photos/Dark_Elven_Archer.png"));
        Image imageee = new Image(inputStreammm);
        ImageView imageeeView = new ImageView(imageee);

        InputStream inputStreammmm= new FileInputStream(new File("../AP_15/src/photos/commission__blue_wizard_by_hakunaro-d57f9de [www.imagesplitter.net].png"));
        Image imageeee = new Image(inputStreammmm);
        ImageView imageeeeView = new ImageView(imageeee);

        InputStream inputStream0 = new FileInputStream(new File("../AP_15/src/photos/black-linen-2.png"));
        Image image0 = new Image(inputStream0);
        ImageView imageView0 = new ImageView(image0);
        imageView0.setTranslateX(1530);
        imageView0.setTranslateY(0);
        closeStreams(inputStream0, inputStreamm, inputStreammm, inputStreammmm);


        imageView0.setOnMouseMoved(e->{
            rectangleResize(imageView0,0.07);

        });
        imageView0.setOnMouseExited(e->{
            rectangleResize(imageView0,-0.07);

        });
        imageeView.setOnMouseMoved(e->{
            rectangleResize(imageView0,0.07);


        });
        imageeView.setOnMouseExited(e->{
            rectangleResize(imageView0,-0.07);


        });imageeeView.setOnMouseMoved(e->{
            rectangleResize(imageView0,0.07);


        });
        imageeeView.setOnMouseExited(e->{
            rectangleResize(imageView0,-0.07);


        });imageeeeView.setOnMouseMoved(e->{
            rectangleResize(imageView0,0.07);


        });
        imageeeeView.setOnMouseExited(e->{
            rectangleResize(imageView0,-0.07);


        });
        InputStream inputStream00 = new FileInputStream(new File("../AP_15/src/photos/black-linen-2.png"));
        Image image00 = new Image(inputStream00);
        ImageView imageView00 = new ImageView(image00);
        imageView00.setTranslateX(0);
        imageView00.setTranslateY(0);

        imageeeView.setTranslateX(45);
        imageeeeView.setTranslateX(60);
        VBox vBox=new VBox(imageeeView,imageeView,imageeeeView);
        vBox.setTranslateX(1480);
        vBox.setTranslateY(100);
        vBox.setSpacing(20);
        vBox.setMaxWidth(230);

        InputStream inputStreamm1 = new FileInputStream(new File("../AP_15/src/photos/Black_Dragon.png"));
        Image imagee1 = new Image(inputStreamm1);
        ImageView imageeView1 = new ImageView(imagee1);

        InputStream inputStreammm1 = new FileInputStream(new File("../AP_15/src/photos/Ice-Giant.png"));
        Image imageee1 = new Image(inputStreammm1);
        ImageView imageeeView1 = new ImageView(imageee1);

        InputStream inputStreammmm1= new FileInputStream(new File("../AP_15/src/photos/wall_breaker_1.png"));
        Image imageeee1 = new Image(inputStreammmm1);
        ImageView imageeeeView1 = new ImageView(imageeee1);

        inputStreamm= new FileInputStream(new File("../AP_15/src/Images/button/ExitS.png"));
        Image iimageeee1 = new Image(inputStreamm);
        ImageView iimageeeeView1 = new ImageView(iimageeee1);

        InputStream iiinputStreammmm1= new FileInputStream(new File("../AP_15/src/Images/button/barracksStatus.png"));
        Image iiimageeee1 = new Image(iiinputStreammmm1);
        ImageView iiimageeeeView1 = new ImageView(iiimageeee1);


        closeStreams(inputStream00, inputStreamm, inputStreamm1,iiinputStreammmm1);


        imageeView1.setTranslateX(-20);
        imageeeView1.setTranslateX(-20);
        imageeeeView1.setTranslateX(-20);
        iimageeeeView1.setTranslateY(850);
        iimageeeeView1.setTranslateX(1450);
        iiimageeeeView1.setTranslateX(1450);
        iiimageeeeView1.setTranslateY(950);

        imageView00.setOnMouseMoved(e->{
            rectangleResize(imageView00,0.07);


        });
        imageView00.setOnMouseExited(e->{
            rectangleResize(imageView00,-0.07);


        });
        imageeView1.setOnMouseMoved(e->{
            rectangleResize(imageView00,0.07);


        });
        imageeView1.setOnMouseExited(e->{
            rectangleResize(imageView00,-0.07);


        });imageeeView1.setOnMouseMoved(e->{
            rectangleResize(imageView00,0.07);


        });
        imageeeView1.setOnMouseExited(e->{
            rectangleResize(imageView00,-0.07);


        });imageeeeView1.setOnMouseMoved(e->{
            rectangleResize(imageView00,0.07);


        });
        imageeeeView1.setOnMouseExited(e->{
            rectangleResize(imageView00,-0.07);


        });

        VBox vBox1=new VBox(imageeeView1,imageeView1,imageeeeView1);
        vBox1.setTranslateX(30);
        vBox1.setTranslateY(150);
        vBox1.setSpacing(30);

        InputStream inputStream = new FileInputStream(new File("../AP_15/src/photos/Simple_Rectangle_-_Semi-Transparent.svg-2.png"));
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);

        Group soldierGroups=new Group();
        soldierGroups.getChildren().addAll(imageView0,imageView00,vBox,vBox1);

        root.getChildren().addAll(iimageeeeView1,iiimageeeeView1);
        root.getChildren().add(soldierGroups);


        iiimageeeeView1.setOnMouseClicked(e ->{
            controller.achievement();
        });
        iimageeeeView1.setOnMouseClicked(e->{
            controller.endGame();
        });
        imageView.setOnDragOver(event ->{
            event.acceptTransferModes(TransferMode.COPY);
        });
        imageView.setOnDragDropped(event -> {
            event.setDropCompleted(true);
//            System.err.println("Dropped");
            if(event.getDragboard().getString().equals("a")) {
//                System.err.println("getstring oomad");
                if (soldiersToAdd.size() > 0) {
//                    System.err.println("bozorgtare sefre");
                    if ((int) (event.getSceneX() / 88) == Constants.getMapWidth() || (int) (event.getSceneX() / 88) == Constants.getMapWidth() - 1 || (int) (event.getSceneX() / 88) == 0 || (int) (event.getSceneY() / 88) == 0 || (int) (event.getSceneY() / 88) == Constants.getMapHeght() || (int) (event.getSceneY() / 88) == Constants.getMapHeght() - 1) {
//                        System.err.println(event.getSceneX());
//                        System.err.println(event.getSceneY());
                        try {
                            SolGui solGui = null;
                            Soldier soldier = controller.putUnit(soldiersToAdd.get(0), (int) (event.getSceneX() / 88), (int) (event.getSceneY() / 88));
                            soldiersToAdd.remove(0);
                            soldierGUI.addSoldier(soldier);
                            root.getChildren().remove(imageView);
                            root.getChildren().add(soldierGroups);
                        } catch (PutSoldierException e) {
                            Text text1 = new Text("Wrong Place");
                            text1.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
                            text1.setFill(Color.WHEAT);
                            text1.relocate(event.getSceneX() - 150, event.getSceneY());

                            root.getChildren().addAll(text1);
                            PauseTransition visiblePause = new PauseTransition(
                                    Duration.seconds(3)
                            );
                            visiblePause.setOnFinished(
                                    event1 -> {
                                        root.getChildren().remove(text1);
                                    }
                            );
                            visiblePause.play();
                        }
                        if (guardians.size() == 0 && healers.size() == 0 && archers.size() == 0 && giants.size() == 0 && wallBreakers.size() == 0 && dragons.size() == 0) {
                            root.getChildren().remove(imageView);
                            root.getChildren().remove(soldierGroups);
                            timeHandler.start();
                        }
                    }
                }
                event.consume();
            }

        });

       //____ _____ ____ ___ ____ ____ ___ ____ ___ ____ ____ ___ ___ ____  ____ ____ ___ __ ____

        imageeView1.setOnDragDetected(event -> {
            Dragboard db = imageeView1.startDragAndDrop(TransferMode.COPY);
            db.setDragView(imagee1);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imagee1);
            content.putString("a");
            db.setContent(content);
            event.consume();

            if (dragons.size()>0) {
                root.getChildren().remove(soldierGroups);
                root.getChildren().add(imageView);
                soldiersToAdd.add(Type.DRAGON);
                dragons.remove(0);
            }
            else{
                notEnough(event);
            }

        });

        imageeeView1.setOnDragDetected(event -> {
            Dragboard db = imageeeView1.startDragAndDrop(TransferMode.COPY);
            db.setDragView(imageee1);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imageee1);
            content.putString("a");
            db.setContent(content);
            event.consume();

            if (giants.size()>0) {
                root.getChildren().remove(soldierGroups);
                root.getChildren().add(imageView);
                soldiersToAdd.add(Type.GIANT);
                giants.remove(0);
            }
            else{
                notEnough(event);
            }


        });

        imageeeeView1.setOnDragDetected(event -> {
            Dragboard db = imageeeeView1.startDragAndDrop(TransferMode.COPY);
            db.setDragView(imageeee1);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imageeee1);
            content.putString("a");
            db.setContent(content);
            event.consume();

            if (wallBreakers.size()>0) {
                root.getChildren().remove(soldierGroups);
                root.getChildren().add(imageView);
                soldiersToAdd.add(Type.WALLBREAKER);
                wallBreakers.remove(0);
            }
            else{
                notEnough(event);
            }
        });


        imageeView.setOnDragDetected(event -> {
//            System.out.println(guardians.size());
            Dragboard db = imageeView.startDragAndDrop(TransferMode.COPY);
            db.setDragView(imagee);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imagee);
            content.putString("a");
            db.setContent(content);
            event.consume();

            if (guardians.size()>0) {
                root.getChildren().remove(soldierGroups);
                root.getChildren().add(imageView);
                soldiersToAdd.add(Type.GUARDIAN);
                guardians.remove(0);
            }
            else{
                notEnough(event);
            }

        });
        imageeeView.setOnDragDetected(event -> {
            Dragboard db = imageeeView.startDragAndDrop(TransferMode.COPY);
            db.setDragView(imageee);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imageee);
            content.putString("a");
            db.setContent(content);
            event.consume();

            if (archers.size()>0) {
                root.getChildren().remove(soldierGroups);
                root.getChildren().add(imageView);
                soldiersToAdd.add(Type.ARCHER);
                archers.remove(0);
            }
            else{
                notEnough(event);
            }

        });
        imageeeeView.setOnDragDetected(event -> {
            Dragboard db = imageeeeView.startDragAndDrop(TransferMode.COPY);
            db.setDragView(imageeee);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imageeee);
            content.putString("a");
            db.setContent(content);
            event.consume();

            if (healers.size()>0) {
                root.getChildren().remove(soldierGroups);
                root.getChildren().add(imageView);
                soldiersToAdd.add(Type.HEALER);
                healers.remove(0);
            }
            else{
                notEnough(event);
            }

        });

        imageeView1.setOnDragOver(event ->  {


        });

        imageeView1.setOnDragDropped(event -> {

        });



        // end of drag and drop



        // set on mouse clicked
//        imageeView.setOnMouseClicked(event -> {
//            if (guardians.size()>0) {
//                root.getChildren().remove(soldierGroups);
//                root.getChildren().add(imageView);
//                soldiersToAdd.add(Type.GUARDIAN);
//                guardians.remove(0);
//            }
//            else{
//                notEnough(event);
//            }
//        });
//        imageeeView.setOnMouseClicked(event -> {
//            if (archers.size()>0) {
//                root.getChildren().remove(soldierGroups);
//                root.getChildren().add(imageView);
//                soldiersToAdd.add(Type.ARCHER);
//                archers.remove(0);
//            }
//            else{
//                notEnough(event);
//            }
//        });
//        imageeeeView.setOnMouseClicked(event -> {
//            if (healers.size()>0) {
//                root.getChildren().remove(soldierGroups);
//                root.getChildren().add(imageView);
//                soldiersToAdd.add(Type.HEALER);
//                healers.remove(0);
//            }
//            else{
//                notEnough(event);
//            }
//        });
//        imageeView1.setOnMouseClicked(event -> {
//            if (dragons.size()>0) {
//                root.getChildren().remove(soldierGroups);
//                root.getChildren().add(imageView);
//                soldiersToAdd.add(Type.DRAGON);
//                dragons.remove(0);
//            }
//            else{
//                notEnough(event);
//            }
//        });
//        imageeeView1.setOnMouseClicked(event -> {
//            if (giants.size()>0) {
//                root.getChildren().remove(soldierGroups);
//                root.getChildren().add(imageView);
//                soldiersToAdd.add(Type.GIANT);
//                giants.remove(0);
//            }
//            else{
//                notEnough(event);
//            }
//        });
//        imageeeeView1.setOnMouseClicked(event -> {
//            if (wallBreakers.size()>0) {
//                root.getChildren().remove(soldierGroups);
//                root.getChildren().add(imageView);
//                soldiersToAdd.add(Type.WALLBREAKER);
//                wallBreakers.remove(0);
//            }
//            else{
//                notEnough(event);
//            }
//        });

    }

    public void rectangleResize(ImageView imageView0, double x) {
        if(timer==null&&x>0) {
            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if(imageView0.getScaleX()<=1.8) {
                        imageView0.setScaleX(imageView0.getScaleX() + x);
                    }
                }
            };
            timer.start();
            if(timer1!=null) {
                timer1.stop();
            }
            timer1=null;
        }
        if(timer1==null&&x<0) {
            timer1 = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if(imageView0.getScaleX()>=1) {
                        imageView0.setScaleX(imageView0.getScaleX() + x);
                    }
                }
            };
            timer1.start();
            timer.stop();
            timer=null;
        }
    }

    public void notEnough(MouseEvent event){
        Text text1 = new Text("Not Enough Soldier");
        text1.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text1.setFill(Color.WHEAT);
        text1.relocate(event.getSceneX()-150, event.getSceneY());

        root.getChildren().addAll(text1);
        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(3)
        );
        visiblePause.setOnFinished(
                event1 -> {
                    root.getChildren().remove(text1);
                }
        );
        visiblePause.play();
    }

    public void end(int gold, int elixir, int point) {
        timeHandler.alive = false;
        soldierGUI.stop();
        InputStream inputStream11 = null;
        InputStream inputStream111 = null;
        InputStream inputStream113 = null;
        InputStream inputStream112 = null;
        try {
            inputStream11 = new FileInputStream(new File("../AP_15/src/photos/black-linen-2.png"));
            inputStream113 = new FileInputStream(new File("../AP_15/src/photos/Elixir.png"));
            inputStream111 = new FileInputStream(new File("../AP_15/src/Images/exit"));
            inputStream112 = new FileInputStream(new File("../AP_15/src/photos/Gold.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image image11 = new Image(inputStream11);
        ImageView imageView11 = new ImageView(image11);
        Image image111 = new Image(inputStream111);
        ImageView imageView111 = new ImageView(image111);
        Image image112 = new Image(inputStream112);
        ImageView imageView112 = new ImageView(image112);
        Image image113 = new Image(inputStream113);
        ImageView imageView113 = new ImageView(image113);
        Text text3 = new Text(Integer.toString(gold));
        closeStreams(inputStream11, inputStream111, inputStream113, inputStream112);
        text3.setFont(Font.font("Luminari", FontWeight.BOLD, 35));
        text3.setFill(Color.WHITE);
        text3.setX(800);
        text3.setY(330);
        Text text4 = new Text(Integer.toString(elixir));
        text4.setFont(Font.font("Luminari", FontWeight.BOLD, 35));
        text4.setFill(Color.WHITE);
        text4.setX(800);
        text4.setY(540);
        Text text5 = new Text(Integer.toString(point));
        text5.setFont(Font.font("Luminari", FontWeight.BOLD, 35));
        text5.setFill(Color.WHITE);
        text5.setX(800);
        text5.setY(740);
        Text text6 = new Text("points:");
        text6.setFont(Font.font("Luminari", FontWeight.BOLD, 35));
        text6.setFill(Color.WHITE);
        text6.setX(680);
        text6.setY(740);
        Text text7 = new Text(Double.toString(timeHandler.time));
        text7.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text7.setFill(Color.WHITE);
        text7.setX(800);
        text7.setY(200);
        Text text8 = new Text(("time:"));
        text8.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text8.setFill(Color.WHITE);
        text8.setX(680);
        text8.setY(200);
        imageView111.setX(700);
        imageView111.setY(800);
        imageView112.setX(700);
        imageView112.setY(300);
        imageView113.setX(700);
        imageView113.setY(500);


        Group group=new Group();
        imageView11.setFitWidth(2850);
        imageView11.setFitHeight(1800);
        group.getChildren().addAll(imageView11,imageView111,imageView112,imageView113,text3,text4,text5,text6,text7,text8);
        ended=true;
        Timeline timeline1=new Timeline();
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        if(ended) {
                            ended=false;
                            root.getChildren().add(group);
                            timeline1.stop();
                        }
                    }
                }));
        timeline1.play();


        imageView111.setOnMouseClicked(e->{
            timeHandler.alive=false;
            root.getChildren().remove(group);
            controller.setEnded(true);
            playerAttack.stop();
            player1.play();


            root.getChildren().setAll(villageRoot);

        });

    }

    public void achivement(int gold, int elixir, int point) {
        InputStream inputStream11 = null;
        InputStream inputStream111 = null;
        InputStream inputStream113 = null;
        InputStream inputStream112 = null;
        try {
            inputStream11 = new FileInputStream(new File("../AP_15/src/photos/black-linen-2.png"));
            inputStream113 = new FileInputStream(new File("../AP_15/src/photos/Elixir.png"));
            inputStream111 = new FileInputStream(new File("../AP_15/src/Images/Back"));
            inputStream112 = new FileInputStream(new File("../AP_15/src/photos/Gold.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image11 = new Image(inputStream11);
        ImageView imageView11 = new ImageView(image11);
        Image image111 = new Image(inputStream111);
        ImageView imageView111 = new ImageView(image111);
        Image image112 = new Image(inputStream112);
        ImageView imageView112 = new ImageView(image112);
        Image image113 = new Image(inputStream113);
        ImageView imageView113 = new ImageView(image113);
        closeStreams(inputStream11, inputStream111, inputStream113, inputStream112);

        Text text3 = new Text(Integer.toString( gold));
        text3.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text3.setFill(Color.WHITE);
        text3.setX(800);
        text3.setY(330);
        Text text4 = new Text(Integer.toString(elixir));
        text4.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text4.setFill(Color.WHITE);
        text4.setX(800);
        text4.setY(540);
        Text text5 = new Text(Integer.toString(point));
        text5.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text5.setFill(Color.WHITE);
        text5.setX(800);
        text5.setY(740);
        Text text6 = new Text(("points:"));
        text6.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text6.setFill(Color.WHITE);
        text6.setX(680);
        text6.setY(740);
        Text text7 = new Text(Double.toString(timeHandler.time));
        text7.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text7.setFill(Color.WHITE);
        text7.setX(800);
        text7.setY(200);
        Text text8 = new Text(("time:"));
        text8.setFont(Font.font ("Luminari", FontWeight.BOLD, 35));
        text8.setFill(Color.WHITE);
        text8.setX(680);
        text8.setY(200);
        imageView111.setX(700);
        imageView111.setY(800);
        imageView112.setX(700);
        imageView112.setY(300);
        imageView113.setX(700);
        imageView113.setY(500);


        Group group=new Group();
        imageView11.setFitWidth(2850);
        imageView11.setFitHeight(1800);
        group.getChildren().addAll(imageView11,imageView111,imageView112,imageView113,text3,text4,text5,text6,text7,text8);

        root.getChildren().add(group);


        imageView111.setOnMouseClicked(e->{
            root.getChildren().remove(group);
            root.getChildren().remove(group);
        });

    }


}
