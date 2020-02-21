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

public class Dragon extends Soldier implements Serializable {
    public static Situation situation = Situation.AIR;

    static public void set(){
        setField(Field.Air);
        setElixirCost(Constants.getDragonCost());
        setMainTarget(Constants.getDragonTarget());
        setRange(Constants.getDragonRange());
        setType(Type.DRAGON);
        setTrainable(false);
    }

    public Dragon(int level) {
        group=new Group();
        health1=null;
        health2=null;
        health3=null;
         setHealth(Constants.getDragonHealth()+(level)*Constants.getDragonUpHealth());
        setDamagePerHit(Constants.getDragonDamage()+(level)*Constants.getDragonUpDamage());
        setLevel(level);
        setAttackCell(null);
        setProductionTime(Constants.getDragonTime());
        setTypee(Type.DRAGON);
        setMaxSpeed(Constants.getDragonSpeed());

    }

    public void heal(){
        setHealth(Constants.getDragonHealth()+(getLevel()-1)*Constants.getDragonUpHealth());
    }
}
