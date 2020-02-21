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

public class Guardian extends Soldier implements Serializable {
    public static Situation situation = Situation.GROUND;

    static public void set(){
        setField(Field.Ground);
        setElixirCost(Constants.getGuardianCost());
        setMainTarget(Constants.getGuardianTarget());
        setRange(Constants.getGuardianRange());
        setType(Type.GUARDIAN);
        setTrainable(false);
    }

    public Guardian(int level) {
        group=new Group();
        health1=null;
        health2=null;
        health3=null;
       setHealth(Constants.getGuardianHealth()+(level)*Constants.getGuardianUpHealth());
        setDamagePerHit(Constants.getGuardianDamage()+(level)*Constants.getGuardianUpDamage());
        setLevel(level);
        setAttackCell(null);
        setProductionTime(Constants.getGuardianTime());
        setTypee(Type.GUARDIAN);
        setMaxSpeed(Constants.getGuardianSpeed());

    }

    public void heal(){
        setHealth(Constants.getGuardianHealth()+(getLevel()-1)*Constants.getGuardianUpHealth());
    }
}
