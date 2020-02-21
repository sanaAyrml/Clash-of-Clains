package server;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import map.Message;
import server.refreshMessages.AttackRefreshMessage;

import java.util.ArrayList;

import static server.ServerConstants.*;

public class ServerGUI {
    private Server server;
    private Group group = new Group();
    private ServerChatRoomGUI serverChatRoomGUI = new ServerChatRoomGUI();
    private LeaderBoardGUI leaderBoardGUI = new LeaderBoardGUI();
    private OnlineBoardGUI onlineBoardGUI = new OnlineBoardGUI();
    private WarBoardGUI warBoardGUI = new WarBoardGUI(CostumerType.HOST);
    private Message message;
    private Rectangle warBoardBackground = new Rectangle(WAR_BOARD_BACKGROUND_X, VERTICAL_FREE_SPACE, BOARD_WIDTH, BOARD_HEIGHT);
    private Text warBoardTitle = new Text(WAR_BOARD_BACKGROUND_X + BOARD_WIDTH / 4, VERTICAL_FREE_SPACE, "War Board");

    public ServerGUI(Server server) {
        this.server = server;
        setBackground();
        group.getChildren().add(serverChatRoomGUI.getGroup());

        serverChatRoomGUI.sendView.setOnMouseClicked(event -> {
            message = new Message("Server",serverChatRoomGUI.getMessageField().getText());
            server.getMessages().add(message);
            serverChatRoomGUI.setMessageText(message.getText());



            synchronized (server.getChatRoomServerSender()) {
                if(server.getChatRoomServerSender().getState().equals(Thread.State.WAITING)){
                    server.getChatRoomServerSender().notify();

                }
            }


            serverChatRoomGUI.getMessageField().clear();
        });

        warBoardBackground.setFill(BOARD_COLOR);
        disignBoard(warBoardBackground);
        setBoardsTitlesFont(warBoardTitle);
        group.getChildren().add(warBoardTitle);
        group.getChildren().add(warBoardBackground);
        group.getChildren().add(onlineBoardGUI.getGroup());
        group.getChildren().add(leaderBoardGUI.getGroup());
        group.getChildren().add(warBoardGUI.getGroup());
    }



    private void setBackground()
    {
        ImageView backgroundImageView = new ImageView(ServerConstants.backgroundImage);
        backgroundImageView.setX(0);
        backgroundImageView.setY(0);
        group.getChildren().add(backgroundImageView);
    }

    public Group getGroup() {
        return group;
    }

    public void refreshLeaderBoard()
    {
        leaderBoardGUI.refresh(server.getClients());
    }

    public void refreshOnlineBoard()
    {
        onlineBoardGUI.refresh(server.getClients());
    }

    public void refreshWarBoard(ArrayList<AttackRefreshMessage> refreshMessages){
        warBoardGUI.refresh(refreshMessages);
    }



    public ServerChatRoomGUI getServerChatRoomGUI() {
        return serverChatRoomGUI;
    }
}
