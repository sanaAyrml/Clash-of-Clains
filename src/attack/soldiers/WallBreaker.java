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
import map.Constants;

import java.io.*;

public class WallBreaker extends Soldier implements Serializable {
    public static Situation situation = Situation.GROUND;

    static public void set(){
        setField(Field.Ground);
        setElixirCost(Constants.getWallBreakerCost());
        setMainTarget(Constants.getWallBreakerTarget());
        setRange(Constants.getWallBreakerRange());
        setType(Type.WALLBREAKER);
        setTrainable(false);
    }

    public WallBreaker(int level) {
        group=new Group();
        health1=null;
        health2=null;
        health3=null;
        setHealth(Constants.getWallBreakerHealth()+(level)*Constants.getWallBreakerUpHealth());
        setDamagePerHit(Constants.getWallBreakerDamage()+(level)*Constants.getWallBreakerUpDamage());
        setLevel(level);
        setAttackCell(null);
        setProductionTime(Constants.getWallBreakerTime());
        setTypee(Type.WALLBREAKER);
        setMaxSpeed(Constants.getWallBreakerSpeed());

    }

    public void heal(){
        setHealth(Constants.getWallBreakerHealth()+(getLevel()-1)*Constants.getWallBreakerUpHealth());
    }
}
