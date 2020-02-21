package server;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

import static server.ServerConstants.*;

public class OnlineBoardGUI {
    private Group group = new Group();
    private Rectangle background = new Rectangle(ONLINE_BOARD_BACKGROUND_X, VERTICAL_FREE_SPACE, BOARD_WIDTH, BOARD_HEIGHT);
    private VBox vBox = new VBox();
    private Group boxes = new Group();
    private Text title = new Text(ONLINE_BOARD_BACKGROUND_X + BOARD_WIDTH / 4, VERTICAL_FREE_SPACE, "Online Board");

    OnlineBoardGUI() {
        background.setFill(BOARD_COLOR);
        vBoxSetPosition(vBox);
        disignBoard(background);
        group.getChildren().add(background);
        boxes.getChildren().add(vBox);
        setScrollPane();
        setBoardsTitlesFont(title);
        group.getChildren().add(title);
        group.getStylesheets().addAll(new File("../AP_15/css.css").toURI().toString());

    }

    private void vBoxSetPosition(VBox vBox)
    {
        vBox.setTranslateX(ONLINE_BOARD_BACKGROUND_X + BOARD_HORIZONTAL_FREE_SPACE);
        vBox.setTranslateY(VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);

    }

    public void refresh(ArrayList<Client> clients)
    {
        boxes.getChildren().remove(vBox);
        vBox = new VBox();
        vBoxSetPosition(vBox);
        boxes.getChildren().add(vBox);
        for (Client client : clients) {
            if (client.isExist())
                vBox.getChildren().add(getText(client.getID()));
        }
    }

    public Group getGroup() {
        return group;
    }

    private void setScrollPane()
    {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefViewportHeight(BOARD_HEIGHT - 2 * BOARD_VERTICAL_FREE_SPACE);
        scrollPane.setPrefViewportWidth(BOARD_WIDTH - 2 * BOARD_HORIZONTAL_FREE_SPACE);
        scrollPane.setLayoutX(ONLINE_BOARD_BACKGROUND_X + BOARD_HORIZONTAL_FREE_SPACE);
        scrollPane.setTranslateY(VERTICAL_FREE_SPACE + BOARD_VERTICAL_FREE_SPACE);
        scrollPane.setContent(boxes);
        group.getChildren().add(scrollPane);
    }

}
