package view;

import controllers.MenuController;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class MenuIn {
    private MenuIn parent;
    private ArrayList<MenuIn> childeren = new ArrayList<>();
    private ImageView title;
    public Group subG = new Group();
    public ImageView imageViewE;
    public ImageView imageView1;
    public ImageView imageView5;
    public VillageView villageView ;
    private MenuController menuController;
    int x = 1080;
    int y = 40;
    public ArrayList<MenuIn> getChilderen() {
        return childeren;
    }

    public MenuIn getParent() {
        return parent;
    }

    public MenuIn(MenuIn parent,MenuController menuController, VillageView villageView){
        this.parent = parent;
        this.menuController = menuController;
        this.villageView = villageView;

    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setSubG(Group subG) {
        this.subG = subG;
    }

    public Group getSubG() {
        return subG;
    }

    public void setTitle(ImageView title) {
        this.title = title;
    }

    public ImageView getTitle() {
        return title;
    }
     public void basic(Group group){

         InputStream inputStream1 = null;
         try {
             inputStream1 = new FileInputStream(new File("../AP_15/src/Images/menuBack.png"));

         Image image1=new Image(inputStream1);
         imageView1=new ImageView(image1);
         imageView1.relocate(x,y);



         InputStream inputStream5=new FileInputStream(new File("../AP_15/src/Images/Back.png"));
         Image image5=new Image(inputStream5);
         imageView5=new ImageView(image5);
         imageView5.relocate(x+10,y+20);

             imageView5.setOnMouseMoved(event -> {
                 imageView5.setStyle("-fx-opacity: 70%");
             });
             imageView5.setOnMouseExited(event -> {
                 imageView5.setStyle("-fx-opacity: 100%");
             });


             InputStream inputStreamE=new FileInputStream(new File("../AP_15/src/Images/Exit.png"));
         Image imageE=new Image(inputStreamE);
         imageViewE=new ImageView(imageE);
         imageViewE.relocate(x+440,y+22);
         title.relocate(x+110,y-40);
         subG.getChildren().addAll(imageView1,title,imageView5,imageViewE);

         imageView5.setOnMouseClicked(event -> {
             group.getChildren().removeAll(subG);
             if(parent != null){
                 parent.show(group);
             }
             else {
                 villageView.deleteLight();
             }
         });

         imageViewE.setOnMouseClicked(event -> {
             group.getChildren().removeAll(subG);
             villageView.deleteLight();
         });



         } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    }
    public void setChilderen(MenuIn child) {
        childeren.add(child);
    }

    public abstract void show(Group group);
}
