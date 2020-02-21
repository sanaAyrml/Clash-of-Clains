package attack;

import attack.soldiers.*;
import attack.soldiersGUI.*;
import building.GuardianGiant;
import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import map.Constants;
import map.Direction;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class soldierGUI{
    ArrayList<SolGui> soldiers;
    Group root;
    int turnToSec;
    GuardianGiant guardianGiant;
    GuardianGiantGui guardianGiantGui;
    ArrayList<Group> solGuis=new ArrayList<>();
    HashMap <Group,Group> groupHashMap=new HashMap<>();
    ArrayList<Soldier> soldierss;
    ArcherGUI archerGUI=new ArcherGUI(null);
    GuardianGUI guardianGUI=new GuardianGUI(null);
    HealerGUI healerGUI=new HealerGUI(null);
    WallBreakerGUI wallBreakerGUI=new WallBreakerGUI(null);
    GiantGUI giantGUI=new GiantGUI(null);
    DragonGUI dragonGUI=new DragonGUI(null);
    public javafx.scene.image.ImageView health1;
    public javafx.scene.image.ImageView health2;
    public javafx.scene.image.ImageView health3;

    private Timeline timeline1 = new Timeline();
    public soldierGUI(GuardianGiantGui guardianGiantGui,GuardianGiant guardianGiant,Group group) {
        this.guardianGiantGui=guardianGiantGui;
        this.guardianGiant=guardianGiant;
        this.turnToSec=Constants.TURN_TO_TIME;
        root=group;
        this.soldiers = new ArrayList<>();
        soldierss=new ArrayList<>();
        health1();
        health2();
        health3();
    }
    public void run() {
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        if(guardianGiant!=null) {
                            if (guardianGiant.getHealth() <= 0) {
                                root.getChildren().remove(guardianGiant.group);
                                guardianGiant = null;
                            }
                            if (!root.getChildren().contains(guardianGiant.group)) {
                                root.getChildren().add(guardianGiant.group);
                            }
                            if (guardianGiant.getDirection() == Direction.DOWN) {
                                guardianGiant.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) guardianGiantGui.down.getChildren().get(0))).getImage()));
                                guardianGiant.group.setTranslateX(guardianGiant.getGraphicalX());
                                guardianGiant.group.setTranslateY(guardianGiant.getGraphicalY());
                            } else if (guardianGiant.getDirection() == Direction.UP) {
                                guardianGiant.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) guardianGiantGui.up.getChildren().get(0))).getImage()));
                                guardianGiant.group.setTranslateX(guardianGiant.getGraphicalX());
                                guardianGiant.group.setTranslateY(guardianGiant.getGraphicalY());
                            } else if (guardianGiant.getDirection() == Direction.LEFT) {
                                guardianGiant.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) guardianGiantGui.left.getChildren().get(0))).getImage()));
                                guardianGiant.group.setTranslateX(guardianGiant.getGraphicalX());
                                guardianGiant.group.setTranslateY(guardianGiant.getGraphicalY());
                            } else if (guardianGiant.getDirection() == Direction.RIGHT) {
                                guardianGiant.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) guardianGiantGui.right.getChildren().get(0))).getImage()));
                                guardianGiant.group.setTranslateX(guardianGiant.getGraphicalX());
                                guardianGiant.group.setTranslateY(guardianGiant.getGraphicalY());
                            } else if (guardianGiant.getDirection() == Direction.REACHED) {
                                guardianGiant.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) guardianGiantGui.attack.getChildren().get(0))).getImage()));
                                guardianGiant.group.setTranslateX(guardianGiant.getGraphicalX());
                                guardianGiant.group.setTranslateY(guardianGiant.getGraphicalY());
                            } else if (guardianGiant.getDirection() == Direction.DIE) {
                                guardianGiant.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) guardianGiantGui.die.getChildren().get(0))).getImage()));
                                guardianGiant.group.setTranslateX(guardianGiant.getGraphicalX());
                                guardianGiant.group.setTranslateY(guardianGiant.getGraphicalY());
                            } else if (guardianGiant.getDirection() == Direction.NONE) {
                                guardianGiant.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) guardianGiantGui.none.getChildren().get(0))).getImage()));
                                guardianGiant.group.setTranslateX(guardianGiant.getGraphicalX());
                                guardianGiant.group.setTranslateY(guardianGiant.getGraphicalY());
                            }
                        }
                        for (Soldier soldier : soldierss) {

                            if(!root.getChildren().contains(soldier.group)) {
                                root.getChildren().add(soldier.group);
                            }
                            SolGui solGui=soldierType(soldier);
                                if(soldier.getDirection()==Direction.DOWN) {
                                    soldier.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) solGui.down.getChildren().get(0))).getImage()));
                                    soldier.group.setTranslateX(soldier.getGraphicalX());
                                    soldier.group.setTranslateY(soldier.getGraphicalY());
                                }
                                else if(soldier.getDirection()==Direction.UP) {
                                    soldier.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) solGui.up.getChildren().get(0))).getImage()));
                                    soldier.group.setTranslateX(soldier.getGraphicalX());
                                    soldier.group.setTranslateY(soldier.getGraphicalY());
                                }
                                else if(soldier.getDirection()==Direction.LEFT) {
                                    soldier.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) solGui.left.getChildren().get(0))).getImage()));
                                    soldier.group.setTranslateX(soldier.getGraphicalX());
                                    soldier.group.setTranslateY(soldier.getGraphicalY());
                                }
                                else if(soldier.getDirection()==Direction.RIGHT) {
                                    soldier.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) solGui.right.getChildren().get(0))).getImage()));
                                    soldier.group.setTranslateX(soldier.getGraphicalX());
                                    soldier.group.setTranslateY(soldier.getGraphicalY());
                                }
                                else if(soldier.getDirection()==Direction.DIE) {
                                    soldier.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) solGui.die.getChildren().get(0))).getImage()));
                                    soldier.group.setTranslateX(soldier.getGraphicalX());
                                    soldier.group.setTranslateY(soldier.getGraphicalY());
                                }
                                else if(soldier.getDirection()==Direction.NONE) {
                                    soldier.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) solGui.none.getChildren().get(0))).getImage()));
                                    soldier.group.setTranslateX(soldier.getGraphicalX());
                                    soldier.group.setTranslateY(soldier.getGraphicalY());
                                }
                                else if(soldier.getDirection()==Direction.REACHED) {
                                    soldier.group.getChildren().setAll(new javafx.scene.image.ImageView((((javafx.scene.image.ImageView) solGui.attack.getChildren().get(0))).getImage()));
                                    soldier.group.setTranslateX(soldier.getGraphicalX());
                                    soldier.group.setTranslateY(soldier.getGraphicalY());
                                }
                        }
                        for (Soldier soldier : soldierss) {
                            if(soldier.getHealth()>60){
                                if(soldier.health3==null) {
                                    soldier.health3 = new javafx.scene.image.ImageView(health3.getImage());
                                    soldier.health3.setTranslateX(15);
                                }
                                if(!soldier.group.getChildren().contains(soldier.health3)) {
                                    soldier.group.getChildren().add(soldier.health3);
                                }
                            }
                            else if(soldier.getHealth()>30){
                                if(soldier.health3!=null){
                                    soldier.group.getChildren().remove(soldier.health3);
                                    soldier.health3=null;
                                }
                                if(soldier.health2==null) {
                                    soldier.health2 = new javafx.scene.image.ImageView(health2.getImage());
                                    soldier.health2.setTranslateX(15);
                                }
                                if(!soldier.group.getChildren().contains(soldier.health2)) {
                                    soldier.group.getChildren().add(soldier.health2);
                                }
                            }
                            else {

                                if(soldier.health2!=null){
                                    soldier.group.getChildren().remove(soldier.health2);
                                    soldier.health2=null;
                                }
                                if(soldier.health1==null) {
                                    soldier.health1 = new javafx.scene.image.ImageView(health1.getImage());
                                    soldier.health1.setTranslateX(15);
                                }
                                if(!soldier.group.getChildren().contains(soldier.health1)) {
                                    soldier.group.getChildren().add(health1);
                                }
                            }
                        }
                        for (int i = 0; i <soldierss.size() ; i++) {
                            if(soldierss.get(i).getHealth()<=0){
                                root.getChildren().remove(soldierss.get(i).group);
                                soldierss.remove(i);
                            }
                        }
                    }
                }));
        timeline1.play();
    }

    private SolGui soldierType(Soldier soldier) {
        if(soldier instanceof Archer){
            return archerGUI;
        }
        if(soldier instanceof Giant){
            return giantGUI;
        }
        if(soldier instanceof Guardian){
            return guardianGUI;
        }
        if(soldier instanceof Dragon){
            return dragonGUI;
        }
        if(soldier instanceof WallBreaker){
            return wallBreakerGUI;
        }
        return healerGUI;

    }
    public void addSoldier(Soldier soldier){
        soldierss.add(soldier);
    }
    public void stop(){
        timeline1.stop();
    }
    private void health1(){
        InputStream inputStream12=null;
        try {
            inputStream12 = new FileInputStream(new File("../AP_15/src/photos/health1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image12 = new Image(inputStream12);
        health1 = new javafx.scene.image.ImageView(image12);
        health1.setX(15);
        try {
            inputStream12.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }private void health2(){
        InputStream inputStream12=null;
        try {
            inputStream12 = new FileInputStream(new File("../AP_15/src/photos/health2.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image12 = new Image(inputStream12);
        health2 = new javafx.scene.image.ImageView(image12);
        health2.setX(15);
        try {
            inputStream12.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void health3(){
        InputStream inputStream12=null;
        try {
            inputStream12 = new FileInputStream(new File("../AP_15/src/photos/health3.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image12 = new Image(inputStream12);
        health3 = new javafx.scene.image.ImageView(image12);
        health3.setX(15);
        try {
            inputStream12.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Soldier> getSoldierss() {
        return soldierss;
    }
}
