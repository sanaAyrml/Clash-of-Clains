package client;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ClientConstants {

    public static final int BOARD_WIDTH = 600;
    public static final int VERTICAL_FREE_SPACE = 50;
    public static final int BOARD_HEIGHT = 1000;
    public static final int BOARD_BACKGROUND_X = 545;
    public static final int BOARD_HORIZONTAL_FREE_SPACE = 5;

    //leaderbord
    static final int LEADER_BOARD_FIELDS_WIDTH = (BOARD_WIDTH - 10) / 5;
    static final int LEADER_BOARD_ID_VBOX_X = BOARD_BACKGROUND_X + 5;
    static final int LEADER_BOARD_GOLD_VBOX_X = LEADER_BOARD_ID_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;
    static final int LEADER_BOARD_ELIXIR_VBOX_X = LEADER_BOARD_GOLD_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;
    static final int LEADER_BOARD_POINT_VBOX_X = LEADER_BOARD_ELIXIR_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;
    static final int LEADER_BOARD_ATTACK_HISTORY_VBOX_X = LEADER_BOARD_POINT_VBOX_X + LEADER_BOARD_FIELDS_WIDTH;


    //packet
    static final int PACKET_SIZE = 184;

    static Text getLightText(String string)
    {
        Text text = new Text(string);
        text.setFill(Color.WHEAT);
        text.setFont(Font.font ("Luminari", FontWeight.BOLD, 17));
        return text;
    }
}
