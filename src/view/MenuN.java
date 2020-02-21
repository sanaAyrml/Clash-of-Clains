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

public abstract class MenuN {
    private MenuN parent;
    private ArrayList<MenuN> childeren = new ArrayList<>();
    private ImageView title;
    public VillageView villageView ;
    public Group subG = new Group();
    public ImageView imageViewE;
    public ImageView imageView1;
    public ImageView imageView5;
    private MenuController menuController;
    int x = 1000;
    int y = 40;
    public ArrayList<MenuN> getChilderen() {
        return childeren;
    }

    public MenuN getParent() {
        return parent;
    }

    public MenuN(MenuN parent,MenuController menuController,VillageView villageView ){
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
            inputStream1 = new FileInputStream(new File("../AP_15/src/Images/menuBackCopy.png"));

            Image image1=new Image(inputStream1);
            imageView1=new ImageView(image1);
            imageView1.relocate(x,y);
            imageView1.setOnMouseMoved(event -> {
                imageView1.setStyle("-fx-opacity: 70%");
            });
            imageView1.setOnMouseExited(event -> {
                imageView1.setStyle("-fx-opacity: 100%");
            });



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
            imageViewE.relocate(x+540,y+22);
            title.relocate(x+150,y-40);
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
            imageViewE.setOnMouseMoved(event -> {
                imageViewE.setStyle("-fx-opacity: 70%");
            });
            imageViewE.setOnMouseExited(event -> {
                imageViewE.setStyle("-fx-opacity: 100%");
            });

            imageViewE.setOnMouseClicked(event -> {
                group.getChildren().removeAll(subG);
                villageView.deleteLight();
            });



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void setChilderen(MenuN child) {
        childeren.add(child);
    }

    public abstract void show(Group group);
}
