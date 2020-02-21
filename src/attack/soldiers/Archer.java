package attack.soldiers;

import attack.Field;
import attack.Soldier;
import attack.Type;
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
import map.Cell;
import map.Constants;
import map.Map;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Archer extends Soldier implements Serializable{
    public static Situation situation = Situation.GROUND;
    static public void set(){
        setField(Field.Ground);
        setElixirCost(Constants.getArcherCost());
        setMainTarget(Constants.getArcherTarget());
        setRange(Constants.getArcherRange());
        setType(Type.ARCHER);
        setTrainable(false);
    }

    public Archer(int level) {
        group=new Group();
        health1=null;
        health2=null;
        health3=null;
        setHealth(Constants.getArcherHealth()+(level)*Constants.getArcherUpHealth());
        setDamagePerHit(Constants.getArcherDamage()+(level)*Constants.getArcherUpDamage());
        setLevel(level);
        setAttackCell(null);
        setTypee(Type.ARCHER);
        setMaxSpeed(Constants.getArcherSpeed());
        setProductionTime(Constants.getArcherTime());
    }

    public void heal(){
        setHealth(Constants.getArcherHealth()+(getLevel()-1)*Constants.getArcherUpHealth());
    }


}
