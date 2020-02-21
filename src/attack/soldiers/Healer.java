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
import map.Map;

import java.io.*;

public class Healer extends Soldier implements Serializable {
    public static Situation situation=Situation.AIR;

    public int getHealingtime() {
        return healingtime;
    }

    public void setHealingtime(int healingtime) {

        this.healingtime = healingtime;
    }

    private int healingtime;
    private int healingQuantity;
    static public void set(){
        setField(Field.Air);
        setElixirCost(Constants.getHealerCost());
        setRange(Constants.getHealerRange());
        setType(Type.HEALER);
        setTrainable(false);
    }

    public int getHealingQuantity() {
        return healingQuantity;
    }

    public Healer(int level) {
        group=new Group();
        health1=null;
        health2=null;
        health3=null;
       this.healingtime = Constants.getHealerHealingTime();
        setHealth(Constants.getHealerHealth());
        healingQuantity=Constants.getHealerHeal()+(level)*Constants.getHealerUpHeal();
        setLevel(level);
        setAttackCell(null);
        setTypee(Type.HEALER);
        setProductionTime(Constants.getHealerTime());
        setMaxSpeed(Constants.getHealerSpeed());
    }

    public void heal(){
        setHealth(Constants.getGuardianHealth()+(getLevel()-1)*Constants.getGuardianUpHealth());
    }
}
