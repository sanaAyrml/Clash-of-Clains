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

public class Giant extends Soldier implements Serializable {
    public static Situation situation = Situation.GROUND;

    static public void set(){
        setField(Field.Ground);
        setElixirCost(Constants.getGiantCost());
        setMainTarget(Constants.getGiantTarget());
        setRange(Constants.getGiantRange());
        setType(Type.GIANT);
        setTrainable(false);
    }

    public Giant(int level) {
        group=new Group();
        health1=null;
        health2=null;
        health3=null;
        setHealth(Constants.getGiantHealth()+(level)*Constants.getGiantUpHealth());
        setDamagePerHit(Constants.getGiantDamage()+(level)*Constants.getGiantUpDamage());
        setLevel(level);
        setAttackCell(null);
        setProductionTime(Constants.getGiantTime());
        setTypee(Type.GIANT);
        setMaxSpeed(Constants.getGiantSpeed());
    }

    public void heal(){
        setHealth(Constants.getGiantHealth()+(getLevel()-1)*Constants.getGiantUpHealth());
    }
}
