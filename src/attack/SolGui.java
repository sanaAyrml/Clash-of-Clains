package attack;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;

public class SolGui {
    Soldier soldier;

    public Group right=new Group();
    public Group left=new Group();
    public Group up=new Group();
    public Group down=new Group();
    public Group attack=new Group();
    public Group die=new Group();
    public Group none=new Group();



    public SolGui(Soldier soldier) {

        this.soldier = soldier;
    }
   }
