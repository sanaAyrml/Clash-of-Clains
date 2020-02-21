package view;

import controllers.MenuController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import map.Images;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class NewBuilding extends MenuN{
    public NewBuilding(MenuN parent, MenuController menuController,VillageView villageView) {
        super(parent, menuController,villageView);
    }

    @Override
    public void show(Group group) {
        InputStream inputStream2 = null;
        try {
            inputStream2 = new FileInputStream(new File("../AP_15/src/Images/Sardar/newBuilding.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(inputStream2);
        ImageView imageView = new ImageView(image2);
        setTitle(imageView);
        basic(group);
        InputStream inputStream = null;
        {
            try {
                inputStream = new FileInputStream(new File("../AP_15/src/photos/Wall_1000.png"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Image image = new Image(inputStream);

        ImageView imageView1 = new ImageView(Images.getLevelImageAirDefense().get(1));
        ImageView imageView2 = new ImageView(Images.getLevelImageArcherTower().get(1));
        ImageView imageView3 = new ImageView(Images.getLevelImageBarracks().get(1));
        ImageView imageView4 = new ImageView(Images.getLevelImageCamp().get(1));
        ImageView imageView5 = new ImageView(Images.getLevelImageCannon().get(1));
        ImageView imageView6 = new ImageView(Images.getLevelImageElixirMine().get(1));
        ImageView imageView7 = new ImageView(Images.getLevelImageElixirStorage().get(1));
        ImageView imageView8 = new ImageView(Images.getLevelImageGiantCastle().get(1));
        ImageView imageView9 = new ImageView(Images.getLevelImageGoldMine().get(1));
        ImageView imageView10 = new ImageView(Images.getLevelImageGoldStorage().get(1));
        ImageView imageView11 = new ImageView(Images.getLevelImageTrap().get(1));
        ImageView imageView12 = new ImageView(image);
        ImageView imageView13 = new ImageView(Images.getLevelImageWizardTower().get(1));


        Text text1 = new Text("AirDefense");
        text1.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text1.setFill(Color.WHEAT);
        text1.relocate(x+210, y+80);

        Text text2 = new Text("ArcherTower");
        text2.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text2.setFill(Color.WHEAT);
        text2.relocate(x+210, y+80);

        Text text3 = new Text("Barracks");
        text3.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text3.setFill(Color.WHEAT);
        text3.relocate(x+210, y+80);

        Text text4 = new Text("Camp");
        text4.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text4.setFill(Color.WHEAT);
        text4.relocate(x+210, y+80);

        Text text5 = new Text("Cannon");
        text5.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text5.setFill(Color.WHEAT);
        text5.relocate(x+210, y+80);

        Text text6 = new Text("ElixirMine");
        text6.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text6.setFill(Color.WHEAT);
        text6.relocate(x+210, y+80);

        Text text7 = new Text("ElixirStorage");
        text7.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text7.setFill(Color.WHEAT);
        text7.relocate(x+210, y+80);

        Text text8 = new Text("GiantCastle");
        text8.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text8.setFill(Color.WHEAT);
        text8.relocate(x+210, y+80);

        Text text9 = new Text("GoldMine");
        text9.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text9.setFill(Color.WHEAT);
        text9.relocate(x+210, y+80);

        Text text10 = new Text("GoldStorage");
        text10.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text10.setFill(Color.WHEAT);
        text10.relocate(x+210, y+80);

        Text text11 = new Text("Trap");
        text11.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text11.setFill(Color.WHEAT);
        text11.relocate(x+210, y+80);

        Text text12 = new Text("Wall");
        text12.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text12.setFill(Color.WHEAT);
        text12.relocate(x+210, y+80);

        Text text13 = new Text("WizardTower");
        text13.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        text13.setFill(Color.WHEAT);
        text13.relocate(x+210, y+80);

        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().setAll(imageView1,text1);

        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().setAll(imageView2,text2);

        VBox vBox3 = new VBox();
        vBox3.setAlignment(Pos.CENTER);
        vBox3.getChildren().setAll(imageView3,text3);

        VBox vBox4 = new VBox();
        vBox4.setAlignment(Pos.CENTER);
        vBox4.getChildren().setAll(imageView4,text4);

        VBox vBox5 = new VBox();
        vBox5.setAlignment(Pos.CENTER);
        vBox5.getChildren().setAll(imageView5,text5);

        VBox vBox6 = new VBox();
        vBox6.setAlignment(Pos.CENTER);
        vBox6.getChildren().setAll(imageView6,text6);

        VBox vBox7 = new VBox();
        vBox7.setAlignment(Pos.CENTER);
        vBox7.getChildren().setAll(imageView7,text7);

        VBox vBox8 = new VBox();
        vBox8.setAlignment(Pos.CENTER);
        vBox8.getChildren().setAll(imageView8,text8);

        VBox vBox9 = new VBox();
        vBox9.setAlignment(Pos.CENTER);
        vBox9.getChildren().setAll(imageView9,text9);

        VBox vBox10 = new VBox();
        vBox10.setAlignment(Pos.CENTER);
        vBox10.getChildren().setAll(imageView10,text10);

        VBox vBox11 = new VBox();
        vBox11.setAlignment(Pos.CENTER);
        vBox11.getChildren().setAll(imageView11,text11);

        VBox vBox12 = new VBox();
        vBox12.setAlignment(Pos.CENTER);
        vBox12.getChildren().setAll(imageView12,text12);

        VBox vBox13 = new VBox();
        vBox13.setAlignment(Pos.CENTER);
        vBox13.getChildren().setAll(imageView13,text13);

        HBox hBox = new HBox();
        hBox.relocate(x+15,y+45);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().setAll(vBox1,vBox2,vBox3,vBox4,vBox5);

        HBox hBox1 = new HBox();
        hBox1.relocate(x+15,y+45);
        hBox1.setSpacing(20);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().setAll(vBox6,vBox7,vBox8,vBox9,vBox10);

        HBox hBox2 = new HBox();
        hBox2.relocate(x+15,y+45);
        hBox2.setSpacing(20);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().setAll(vBox11,vBox12,vBox13);

        VBox vBox = new VBox();
        vBox.relocate(x+35,y+70);
        vBox.setSpacing(25);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().setAll(hBox,hBox1,hBox2);

        ArrayList<String> s = getMenuController().available();
        for(String n : s){
            if(n.equals(1))
                text1.setFill(Color.RED);
            if(n.equals(2))
                text2.setFill(Color.RED);
            if(n.equals(3))
                text3.setFill(Color.RED);
            if(n.equals(4))
                text4.setFill(Color.RED);
            if(n.equals(5))
                text5.setFill(Color.RED);
            if(n.equals(6))
                text6.setFill(Color.RED);
            if(n.equals(7))
                text7.setFill(Color.RED);
            if(n.equals(8))
                text8.setFill(Color.RED);
            if(n.equals(9))
                text9.setFill(Color.RED);
            if(n.equals(10))
                text10.setFill(Color.RED);
            if(n.equals(11))
                text11.setFill(Color.RED);
            if(n.equals(12))
                text12.setFill(Color.RED);
            if(n.equals(13))
                text13.setFill(Color.RED);
        }

        getSubG().getChildren().add(vBox);
        if(group.getChildren().contains(getSubG())){
            group.getChildren().remove(getSubG());
        }
        group.getChildren().add(getSubG());

        imageView1.setOnMouseClicked(event -> {
            if(!text1.getFill().equals(Color.RED)){
//                System.out.println("hear");
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("1");
                ((QuestionBM)getChilderen().get(0)).setName(text1.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView2.setOnMouseClicked(event -> {
            if(!text2.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("2");
                ((QuestionBM)getChilderen().get(0)).setName(text2.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView3.setOnMouseClicked(event -> {
            if(!text3.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("3");
                ((QuestionBM)getChilderen().get(0)).setName(text3.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView4.setOnMouseClicked(event -> {
            if(!text4.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("4");
                ((QuestionBM)getChilderen().get(0)).setName(text4.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView5.setOnMouseClicked(event -> {
            if(!text5.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("5");
                ((QuestionBM)getChilderen().get(0)).setName(text5.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView6.setOnMouseClicked(event -> {
            if(!text6.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("6");
                ((QuestionBM)getChilderen().get(0)).setName(text6.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView7.setOnMouseClicked(event -> {
            if(!text7.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("7");
                ((QuestionBM)getChilderen().get(0)).setName(text7.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView8.setOnMouseClicked(event -> {
            if(!text8.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("8");
                ((QuestionBM)getChilderen().get(0)).setName(text8.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView9.setOnMouseClicked(event -> {
            if(!text9.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("9");
                ((QuestionBM)getChilderen().get(0)).setName(text9.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView10.setOnMouseClicked(event -> {
            if(!text10.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("10");
                ((QuestionBM)getChilderen().get(0)).setName(text10.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView11.setOnMouseClicked(event -> {
            if(!text11.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("11");
                ((QuestionBM)getChilderen().get(0)).setName(text11.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView12.setOnMouseClicked(event -> {
            if(!text12.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("12");
                ((QuestionBM)getChilderen().get(0)).setName(text12.getText());
                getChilderen().get(0).show(group);
            }
        });

        imageView13.setOnMouseClicked(event -> {
            if(!text13.getFill().equals(Color.RED)){
                group.getChildren().removeAll(getSubG());
                getChilderen().get(0).setTitle(getTitle());
                ((QuestionBM)getChilderen().get(0)).setKind("13");
                ((QuestionBM)getChilderen().get(0)).setName(text13.getText());
                getChilderen().get(0).show(group);
            }
        });

    }
}
