package server;

import client.ClientConstants;
import javafx.scene.paint.Color;

import static server.ServerConstants.*;

public class Positions {
    private int verticalFreeSpace;
    private int boardHorizontalFreeSpace;
    private int boardWidth;
    private int boardHeight;
    private int warBoardBackgroundX;
    private int boardVerticalFreeSpace;
    private int fieldWidth = 65;
    private Color textColor;

    public Positions(CostumerType costumerType) {
        if (costumerType == CostumerType.HOST){
            verticalFreeSpace = VERTICAL_FREE_SPACE;
            boardHorizontalFreeSpace = BOARD_HORIZONTAL_FREE_SPACE;
            boardWidth = BOARD_WIDTH;
            boardHeight = BOARD_HEIGHT;
            warBoardBackgroundX = WAR_BOARD_BACKGROUND_X;
            boardVerticalFreeSpace = BOARD_VERTICAL_FREE_SPACE;
            textColor = boardTextsColor;
        }
        else {
            verticalFreeSpace = ClientConstants.VERTICAL_FREE_SPACE;
            boardHorizontalFreeSpace = ClientConstants.BOARD_HORIZONTAL_FREE_SPACE;
            boardWidth = ClientConstants.BOARD_WIDTH;
            boardHeight = 980;
            warBoardBackgroundX = ClientConstants.BOARD_BACKGROUND_X;
            boardVerticalFreeSpace = 25;
            textColor = Color.WHEAT;
        }
    }

    public int getVerticalFreeSpace() {
        return verticalFreeSpace;
    }

    public int getBoardHorizontalFreeSpace() {
        return boardHorizontalFreeSpace;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getWarBoardBackgroundX() {
        return warBoardBackgroundX;
    }

    public int getBoardVerticalFreeSpace() {
        return boardVerticalFreeSpace;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public Color getTextColor() {
        return textColor;
    }
}
