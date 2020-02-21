package view;

import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class Menu {
    private Menu parent;
    private String title;
    private ArrayList<Menu> childeren = new ArrayList<>();


    public ArrayList<Menu> getChilderen() {
        return childeren;
    }

    public Menu getParent() {
        return parent;
    }

    public Menu(Menu parent, String title){
        this.parent = parent;
        this.title = title;
    }

    public void Error(Group group, Exception e) {
        Text text1 = new Text("No such a file");
        text1.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        text1.setFill(Color.WHEAT);
        text1.relocate(10,10);

        group.getChildren().addAll(text1);
        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(3)
        );
        visiblePause.setOnFinished(
                event2 -> {
                    group.getChildren().remove(text1);
                }
        );
        visiblePause.play();
        e.printStackTrace();
    }
    public void setChilderen(Menu child) {
        childeren.add(child);
    }

    public abstract void show(Stage primaryStage, Group group, Scene scene);
}
