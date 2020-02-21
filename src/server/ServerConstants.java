package server;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ServerConstants {
    public static final int MAIN_SERVER_PORT = 8050;
    public static final int CHAT_SERVER_PORT = 8060;
    public static final String SERVER_ADDRESS  = "127.0.0.1"; // 127.0.0.1

    static final int SERVER_SCENE_WIDTH = 1672;
    static final int SERVER_SCENE_HEIGHT = 1056;
    static final int BOARD_TITLE_HEIGHT = 54;
    static final int VERTICAL_FREE_SPACE = 28;
    static final int HORIZONTAL_FREE_SPACE = 30;

    static final int ELIXIR_RATIO = 2;
    static final int GOLD_RATIO = 1;

    static final String IMAGES_ADDRESS = "src/server/serverImages/";

    static Image backgroundImage;
    static Image border;

    //chatroom
    static final int CHATROOM_WIDTH = 502;
    static final int CHATROOM_HEIGHT = 1000;
    static Image chatroomBackground;

    //bord
    static final int BOARD_VERTICAL_FREE_SPACE = 15;
    static final int BOARD_HORIZONTAL_FREE_SPACE = 5;

    static final int BOARD_WIDTH = 340;
    static final int BOARD_HEIGHT = 1000;
    static final Color BOARD_COLOR = new Color(0.772549, 0.847058, 0.92549, 0.5);

    //leaderbord
    static Image closeBotumn;
    static final int LEADER_BOARD_CLOSE_BOTUMN_WIDTH = 50;
    static final int LEADER_BOARD_BACKGROUND_X = CHATROOM_WIDTH + 2 * HORIZONTAL_FREE_SPACE;
    static final int LEADER_BOARD_FIELDS_WIDTH = (BOARD_WIDTH - 2 * BOARD_HORIZONTAL_FREE_SPACE) / 5;
    static final int LEADER_BOARD_ID_VBOX_X = LEADER_BOARD_BACKGROUND_X + BOARD_HORIZONTAL_FREE_SPACE;
    static final int LEADER_BOARD_GOLD_VBOX_X = LEADER_BOARD_ID_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;
    static final int LEADER_BOARD_ELIXIR_VBOX_X = LEADER_BOARD_GOLD_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;
    static final int LEADER_BOARD_POINT_VBOX_X = LEADER_BOARD_ELIXIR_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;
    static final int LEADER_BOARD_ATTACK_HISTORY_VBOX_X = LEADER_BOARD_POINT_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;


    //onlineboard
    static final int ONLINE_BOARD_BACKGROUND_X = LEADER_BOARD_BACKGROUND_X + BOARD_WIDTH + HORIZONTAL_FREE_SPACE;


    //warboard
    static final int WAR_BOARD_BACKGROUND_X = ONLINE_BOARD_BACKGROUND_X + BOARD_WIDTH + HORIZONTAL_FREE_SPACE;

    static Color boardTextsColor = new Color(0.2,0.2,0.2,1);

    static {
        try {
            backgroundImage = new Image(new FileInputStream(new File(ServerConstants.IMAGES_ADDRESS + "serverbackground.jpg")));
            border = new Image(new FileInputStream(new File(ServerConstants.IMAGES_ADDRESS + "boarderrrr.png")));
            chatroomBackground = new Image(new FileInputStream(new File(ServerConstants.IMAGES_ADDRESS + "chatbackground.jpg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    static void disignBoard(Rectangle background)
    {
        background.setArcWidth(30);
        background.setArcHeight(30);
        background.setStroke(Color.SILVER);
    }

    static Text setBoardsTitlesFont(Text title)
    {
        title.setFill(Color.DARKGRAY);
        title.setFont(Font.font ("Luminari", FontWeight.BOLD, 30));
        return title;
    }

    static Text getText(String string)
    {
        Text text = new Text(string);
        text.setFill(boardTextsColor);
        text.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        return text;
    }

    static Text getLightText(String string)
    {
        Text text = new Text(string);
        text.setFill(Color.SILVER);
        text.setFont(Font.font ("Luminari", FontWeight.BOLD, 15));
        return text;
    }
}