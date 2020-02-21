package view;

import building.*;
import client.AttackPosition;
import client.Client;
import controllers.AttackController;
import controllers.MenuController;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import map.Game;
import map.GameDef;
import map.GameGUI;
import server.ServerListeningMode;
import server.ServerTransferMessage;

import java.io.*;

public class VillageView extends Menu{


    InputStream inputStream2;
    {
        try {
            inputStream2 = new FileInputStream(new File("../AP_15/src/Images/light2.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    int x = 1080;
    int y = 40;

    Image image2=new Image(inputStream2);
    ImageView light=new ImageView(image2);

    Game game ;
    GameGUI gameGUI ;
    Client client;
    ChatRoom chatRoom;
    LeaderBoardGUI leaderBoardGUI;
    ClientWarBoardGUI clientWarBoardGUI;
    MenuController menuController = null;
    PannableCanvas canvas;
    ImageView attack;
    ImageView leaderBoard;
    ImageView warBoard;
    ImageView saveGame;
    ImageView option;
    ImageView exit;
    MessageGUI messageGUI;
    Group gTotal;

    BarracksM barracksM = new BarracksM(null,menuController,this);
    CampM campM = new CampM(null,menuController,this);
    MineM mineM = new MineM(null,menuController,this);
    StorageM storageM = new StorageM(null,menuController,this);
    DefenceM defenceM = new DefenceM(null,menuController,this);
    TownHallM townHallM = new TownHallM(null,menuController,this);


    BarracksInfoM barracksInfoM = new BarracksInfoM(barracksM,menuController,this);
    CampInfoM campInfoM = new CampInfoM(campM,menuController,this);
    MineInfoM mineInfoM = new MineInfoM(mineM,menuController,this);
    StorageInfoM storageInfoM = new StorageInfoM(storageM,menuController,this);
    DefenceInfoM defenceInfoM = new DefenceInfoM(defenceM,menuController,this);
    TownHallInfoM townHallInfoM = new TownHallInfoM(townHallM,menuController,this);

    BarracksStatusM barracksStatusM = new BarracksStatusM(barracksM,menuController,this);
    CampSoldiersM campSoldiersM = new CampSoldiersM(campM,menuController,this);
    DefenceTargetM defenceTargetM = new DefenceTargetM(defenceM,menuController,this);
    BarracksBuildSoldierM barracksBuildSoldierM = new BarracksBuildSoldierM(barracksM,menuController,this);

    InfoOverallM townHallInfoOverallM = new InfoOverallM(townHallInfoM,menuController,this);
    InfoOverallM barracksInfoOverallM = new InfoOverallM(barracksInfoM,menuController,this);
    InfoOverallM campInfoOverallM = new InfoOverallM(campInfoM,menuController,this);
    InfoOverallM mineInfoOverallM = new InfoOverallM(mineInfoM,menuController,this);
    InfoOverallM storageInfoOverallM = new InfoOverallM(storageInfoM,menuController,this);
    InfoOverallM defenceInfoOverallM = new InfoOverallM(defenceInfoM,menuController,this);

    Upgrade townHallUpgrade = new Upgrade(townHallInfoM,menuController,this);
    Upgrade barracksUpgrade = new Upgrade(barracksInfoM,menuController,this);
    Upgrade campUpgrade = new Upgrade(campInfoM,menuController,this);
    Upgrade mineUpgrade = new Upgrade(mineInfoM,menuController,this);
    Upgrade storageUpgrade = new Upgrade(storageInfoM,menuController,this);
    Upgrade defenceUpgrade = new Upgrade(defenceInfoM,menuController,this);

    CampInfoCapacity campInfoCapacity = new CampInfoCapacity(campInfoM,menuController,this);
    StorageInfoSource storageInfoSource = new StorageInfoSource(storageInfoM,menuController,this);
    DefenceTargetM defenceTargeInfotM = new DefenceTargetM(defenceInfoM,menuController,this);
    BarracksBuildNumberM barracksBuildNumberM = new BarracksBuildNumberM(barracksBuildSoldierM,menuController,this);
    TownHallStatusM townHallStatusM = new TownHallStatusM(townHallM,menuController,this);

    NewBuilding newBuilding = new NewBuilding(null,menuController,this);
    QuestionBM questionBM = new QuestionBM(newBuilding,menuController,this);

    private boolean end = false;

        Media media1 = new Media(new File("../AP_15/src/Music/melodyloops-preview-rise-of-legends-5m30s.mp3").toURI().toString()); //replace /Movies/test.mp3 with your file
    MediaPlayer player1 = new MediaPlayer(media1);
    Media mediaAttack = new Media(new File("../AP_15/src/Music/bensound-epic.mp3").toURI().toString()); //replace /Movies/test.mp3 with your file
    MediaPlayer playerAttack = new MediaPlayer(mediaAttack);
    public void setMenues(MenuController menuController){
         barracksM = new BarracksM(null,menuController,this);
         campM = new CampM(null,menuController,this);
         mineM = new MineM(null,menuController,this);
         storageM = new StorageM(null,menuController,this);
         defenceM = new DefenceM(null,menuController,this);
         townHallM = new TownHallM(null,menuController,this);


         barracksInfoM = new BarracksInfoM(barracksM,menuController,this);
         campInfoM = new CampInfoM(campM,menuController,this);
         mineInfoM = new MineInfoM(mineM,menuController,this);
         storageInfoM = new StorageInfoM(storageM,menuController,this);
         defenceInfoM = new DefenceInfoM(defenceM,menuController,this);
         townHallInfoM = new TownHallInfoM(townHallM,menuController,this);

         barracksStatusM = new BarracksStatusM(barracksM,menuController,this);
         campSoldiersM = new CampSoldiersM(campM,menuController,this);
         defenceTargetM = new DefenceTargetM(defenceM,menuController,this);
         barracksBuildSoldierM = new BarracksBuildSoldierM(barracksM,menuController,this);

         townHallInfoOverallM = new InfoOverallM(townHallInfoM,menuController,this);
         barracksInfoOverallM = new InfoOverallM(barracksInfoM,menuController,this);
         campInfoOverallM = new InfoOverallM(campInfoM,menuController,this);
         mineInfoOverallM = new InfoOverallM(mineInfoM,menuController,this);
         storageInfoOverallM = new InfoOverallM(storageInfoM,menuController,this);
         defenceInfoOverallM = new InfoOverallM(defenceInfoM,menuController,this);

         townHallUpgrade = new Upgrade(townHallInfoM,menuController,this);
         barracksUpgrade = new Upgrade(barracksInfoM,menuController,this);
         campUpgrade = new Upgrade(campInfoM,menuController,this);
         mineUpgrade = new Upgrade(mineInfoM,menuController,this);
         storageUpgrade = new Upgrade(storageInfoM,menuController,this);
         defenceUpgrade = new Upgrade(defenceInfoM,menuController,this);

         campInfoCapacity = new CampInfoCapacity(campInfoM,menuController,this);
         storageInfoSource = new StorageInfoSource(storageInfoM,menuController,this);
        defenceTargeInfotM = new DefenceTargetM(defenceInfoM,menuController,this);
        barracksBuildNumberM = new BarracksBuildNumberM(barracksBuildSoldierM,menuController,this);
        townHallStatusM = new TownHallStatusM(townHallM,menuController,this);

        newBuilding = new NewBuilding(null,menuController,this);
        questionBM = new QuestionBM(newBuilding,menuController,this);

    }
    public void setGame(Game game) {
        this.game = game;
    }

    public void setGameGUI(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    public GameGUI getGameGUI() {
        return gameGUI;
    }

    public VillageView(Menu parent, String title) {
        super(parent, title);
    }

    public void makeNew(){

    }
    public void start(){
        setChilds();
        Platform.runLater(new Runnable() {
            @Override public void run() {
                game.start();
            }
        });
        Platform.runLater(new Runnable() {
            @Override public void run() {
                gameGUI.start();
            }
        });

    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    private void setChilds(){
        barracksM.setChilderen(barracksInfoM);
        barracksM.setChilderen(barracksBuildSoldierM);
        barracksM.setChilderen(barracksStatusM);
        campM.setChilderen(campInfoM);
        campM.setChilderen(campSoldiersM);
        mineM.setChilderen(mineInfoM);
        storageM.setChilderen(storageInfoM);
        defenceM.setChilderen(defenceInfoM);
        defenceM.setChilderen(defenceTargetM);
        townHallM.setChilderen(townHallInfoM);
        townHallM.setChilderen(townHallStatusM);

        townHallInfoM.setChilderen(townHallInfoOverallM);
        townHallInfoM.setChilderen(townHallUpgrade);
        campInfoM.setChilderen(campInfoOverallM);
        campInfoM.setChilderen(campUpgrade);
        campInfoM.setChilderen(campInfoCapacity);
        barracksInfoM.setChilderen(barracksInfoOverallM);
        barracksInfoM.setChilderen(barracksUpgrade);
        mineInfoM.setChilderen(mineInfoOverallM);
        mineInfoM.setChilderen(mineUpgrade);
        storageInfoM.setChilderen(storageInfoOverallM);
        storageInfoM.setChilderen(storageUpgrade);
        storageInfoM.setChilderen(storageInfoSource);
        defenceInfoM.setChilderen(defenceInfoOverallM);
        defenceInfoM.setChilderen(defenceUpgrade);
        defenceInfoM.setChilderen(defenceTargeInfotM);

        newBuilding.setChilderen(questionBM);
        barracksBuildSoldierM.setChilderen(barracksBuildNumberM);
    }

    public void addClient(String ID,String IP,String clientPort, String serverPort){
//        System.out.println("");
        client = new Client(ID, gameGUI,IP,Integer.parseInt(clientPort),Integer.parseInt(serverPort),this);
//        System.out.println("heree1");
        chatRoom = new ChatRoom(client);
        leaderBoardGUI = new LeaderBoardGUI(client);
        clientWarBoardGUI = new ClientWarBoardGUI(client);
        client.setWarBoardGUI(clientWarBoardGUI.getWarBoardGUI());
        VilageReqGUI.setLeaderBoardGUI(leaderBoardGUI);
    }


    private Stage primaryStage;
    private Scene scene;
    private Group subGroup;


    @Override
    public void show(Stage primaryStage,Group group,Scene scene) {

        gTotal = group;
        this.primaryStage = primaryStage;
        if(client!= null)
        leaderBoardGUI.setGTotal(gTotal);
        canvas = gameGUI.getCanvas();
        this.scene = scene;
        canvas.getChildren().add(gameGUI.getResourceCanvas());
//        group.getChildren().add(chatRoom.getChatRoomGroup());
        subGroup = new Group();
        if(client!=null) {
            client.getClientListener().setRoot(group);

        }
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream(new File("../AP_15/src/Images/button/attack.png"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image=new Image(inputStream);
        attack =new ImageView(image);
        attack.relocate(1450,750);
        InputStream inputStreamExit= null;
        try {
            inputStreamExit = new FileInputStream(new File("../AP_15/src/Images/button/ExitS.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageExit=new Image(inputStreamExit);
        exit =new ImageView(imageExit);
        exit.relocate(1450,750);
        InputStream inputStreamL = null;
        try {
            inputStreamL = new FileInputStream(new File("../AP_15/src/Images/button/LeaderBoard.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageL=new Image(inputStreamL);
        leaderBoard =new ImageView(imageL);
        leaderBoard.relocate(1450,750);

        InputStream inputStreamW = null;
        try {
            inputStreamW = new FileInputStream(new File("../AP_15/src/Images/button/WarBoard.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageW=new Image(inputStreamW);
        warBoard =new ImageView(imageW);
        warBoard.relocate(1450,750);

        InputStream inputStream1= null;
        try {
            inputStream1 = new FileInputStream(new File("../AP_15/src/Images/button/saveGame.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1=new Image(inputStream1);
        saveGame =new ImageView(image1);
        InputStream inputStream2= null;
        try {
            inputStream2 = new FileInputStream(new File("../AP_15/src/Images/button/Option.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2=new Image(inputStream2);
        option =new ImageView(image2);

        VBox vBox = new VBox();
        vBox.setSpacing(-20);
        vBox.relocate(1450,y+720);
        if(client == null)
        vBox.getChildren().addAll(attack,option,saveGame);
        else {
            vBox.relocate(1450,y+620);
            vBox.getChildren().addAll(leaderBoard, warBoard, option, exit);
        }

        leaderBoard.setOnMouseClicked((MouseEvent event) -> {
            if (!game.isAttacked()){
                end = false;
//            if(!group.getChildren().contains(leaderBoardGUI.getGroup())) {
            ServerTransferMessage transferMessage=new ServerTransferMessage(ServerListeningMode.LEADERBOARD_REQ,null,null,null, null,null,null,null,null);
            client.getClientMessageSender().send(transferMessage);


            AnimationTimer leaderBoardTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (client.getServerClientInfos() != null) {
                        client.getClientListener().setRoot(group);
                        leaderBoardGUI.refresh(client.getServerClientInfos());
                        client.setServerClients(null);
                    }
                    if (end)
                    {
                        this.stop();
                    }
                }
            };
            leaderBoardTimer.start();

            Thread refreshLeaderBoard = new Thread(() -> {
                while (!end) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ServerTransferMessage transferMessage1 =new ServerTransferMessage(ServerListeningMode.LEADERBOARD_REQ,null,null,null, null,null,null,null,null);
                    client.getClientMessageSender().send(transferMessage1);
                }
            });
            refreshLeaderBoard.start();
            group.getChildren().addAll(leaderBoardGUI.getGroup());
//            }
                if(client!= null){
                    leaderBoardGUI.getImageViewE().setOnMouseClicked(event1 -> {
                        end = true;
                        group.getChildren().remove(leaderBoardGUI.getGroup());
                    });
                }
        }

        });
        warBoard.setOnMouseClicked(event -> {
//            if (!game.isAttacked()) {
            ServerTransferMessage transferMessage=new ServerTransferMessage(ServerListeningMode.WARBOARD_REQ, client.getID());
            client.getClientMessageSender().send(transferMessage);

            group.getChildren().addAll(clientWarBoardGUI.getGroup());
                    clientWarBoardGUI.getImageViewE().setOnMouseClicked(event1 -> {
                        System.out.println("ok");
                        group.getChildren().remove(clientWarBoardGUI.getGroup());
                    });
//            }
        });
        exit.setOnMouseClicked(event -> {
            exit();
        });

        attack.setOnMouseClicked(event -> {
            if (!game.isAttacked()){
            InputStream inputStream11 = null;
            try {
                inputStream11 = new FileInputStream(new File("../AP_15/src/Images/menuBack.png"));

                Image image11 = new Image(inputStream11);
                ImageView imageView11 = new ImageView(image11);
                imageView11.relocate(x, y);

                InputStream inputStream21 = new FileInputStream(new File("../AP_15/src/Images/Sardar/Attack.png"));
                Image image21 = new Image(inputStream21);
                ImageView imageView21 = new ImageView(image21);
                imageView21.relocate(x + 110, y - 40);


                InputStream inputStreamE = new FileInputStream(new File("../AP_15/src/Images/Exit.png"));
                Image imageE = new Image(inputStreamE);
                ImageView imageViewE = new ImageView(imageE);
                imageViewE.relocate(x + 440, y + 22);

                Text q = new Text("Load Map:");
                q.setFont(Font.font("Luminari", FontWeight.BOLD, 30));
                q.setFill(Color.WHEAT);

                TextField textField = new TextField();
                textField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
                textField.setPrefColumnCount(26);
                textField.setFont(Font.font("Luminari", FontWeight.BOLD, 15));

                InputStream inputStreamW3 = new FileInputStream(new File("../AP_15/src/Images/button/letsAttack1.png"));
                Image imageW3 = new Image(inputStreamW3);
                ImageView imageViewW3 = new ImageView(imageW3);
                imageViewW3.relocate(x + 20, y + 45);
                VBox vBox1 = new VBox();
                vBox1.setSpacing(25);
                vBox1.relocate(x + 50, y + 80);
                vBox1.getChildren().addAll(q, textField, imageViewW3);
                subGroup.getChildren().addAll(imageView11, imageView21, imageViewE, vBox1);
                if (!group.getChildren().contains(subGroup))
                    group.getChildren().addAll(subGroup);

                imageViewE.setOnMouseClicked(event1 -> {
                    group.getChildren().remove(subGroup);
                });
                imageViewW3.setOnMouseClicked(event1 -> {
                    try {
                        FileInputStream fis = new FileInputStream(textField.getText());
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Game game = (Game) ois.readObject();
                        GameGUI gameGUI = new GameGUI(game);
                        gameGUI.loadGameGUI();
                        GameDef gameDef = new GameDef(gameGUI, AttackPosition.DEFENDER);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameDef.start();
                            }
                        });
                        Group defGroup = new Group();
                        defGroup.getChildren().add(gameDef.getGameGUI().getCanvas());
                        defGroup.getChildren().add(gameDef.getBuildingsHealthCanvas());
                        defGroup.getChildren().add(gameDef.getDefenseSoldierCanvas());

                    player1.stop();

                    playerAttack.play();
                        Group groupCopy = new Group();
                        groupCopy.getChildren().setAll(group.getChildren());
                        groupCopy.getChildren().remove(subGroup);
                        group.getChildren().setAll(defGroup);
                        AttackController attackController = new AttackController(player1, playerAttack, groupCopy, this.game, game, primaryStage, defGroup);
                        attackController.start();
                        group.getChildren().remove(subGroup);

                        //TODO sana defGroup o game o be soroosh bede bade tamum shodane attack gameDef.setEnd(true)
                    } catch (ClassNotFoundException | IOException e) {
                        Error(group, e);
                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        });

        saveGame.setOnMouseClicked(event -> {
            if (!game.isAttacked()){

            InputStream inputStream11 = null;
            try {
                inputStream11 = new FileInputStream(new File("../AP_15/src/Images/menuBack.png"));

                Image image11 = new Image(inputStream11);
                ImageView imageView11 = new ImageView(image11);
                imageView11.relocate(x, y);

                InputStream inputStream21 = new FileInputStream(new File("../AP_15/src/Images/Sardar/Save.png"));
                Image image21 = new Image(inputStream21);
                ImageView imageView21 = new ImageView(image21);
                imageView21.relocate(x + 110, y - 40);


                InputStream inputStreamE = new FileInputStream(new File("../AP_15/src/Images/Exit.png"));
                Image imageE = new Image(inputStreamE);
                ImageView imageViewE = new ImageView(imageE);
                imageViewE.relocate(x + 440, y + 22);

                Text q = new Text("Enter adress:");
                q.setFont(Font.font("Luminari", FontWeight.BOLD, 30));
                q.setFill(Color.WHEAT);

                TextField textField = new TextField();
                textField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
                textField.setPrefColumnCount(26);
                textField.setFont(Font.font("Luminari", FontWeight.BOLD, 15));

                InputStream inputStreamW3;
                inputStreamW3 = new FileInputStream(new File("../AP_15/src/Images/button/save.png"));
                Image imageW3 = new Image(inputStreamW3);
                ImageView imageViewW3 = new ImageView(imageW3);
                imageViewW3.relocate(x + 20, y + 45);
                VBox vBox1 = new VBox();
                vBox1.setSpacing(25);
                vBox1.relocate(x + 50, y + 80);
                vBox1.getChildren().addAll(q, textField, imageViewW3);
                subGroup.getChildren().addAll(imageView11, imageView21, imageViewE, vBox1);
                group.getChildren().addAll(subGroup);

                imageViewE.setOnMouseClicked(event1 -> {
                    group.getChildren().remove(subGroup);
                });
                imageViewW3.setOnMouseClicked(event1 -> {
                    try {
                        FileOutputStream fos = new FileOutputStream(textField.getText());
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(game);
                        fos.close();
                        oos.close();
                        group.getChildren().remove(subGroup);
                    } catch (IOException e) {
//                        e.printStackTrace();
                    }
                });
            } catch (FileNotFoundException e) {
//                e.printStackTrace();
            }

        }
        });
        option.setOnMouseClicked(event -> {
            if (!game.isAttacked()){
                InputStream inputStream11 = null;
            try {
                inputStream11 = new FileInputStream(new File("../AP_15/src/Images/menuBack.png"));

                Image image11 = new Image(inputStream11);
                ImageView imageView11 = new ImageView(image11);
                imageView11.relocate(x, y);

                InputStream inputStream21 = new FileInputStream(new File("../AP_15/src/Images/Sardar/options.png"));
                Image image21 = new Image(inputStream21);
                ImageView imageView21 = new ImageView(image21);
                imageView21.relocate(x + 110, y - 40);


                InputStream inputStreamE = new FileInputStream(new File("../AP_15/src/Images/Exit.png"));
                Image imageE = new Image(inputStreamE);
                ImageView imageViewE = new ImageView(imageE);
                imageViewE.relocate(x + 440, y + 22);

                Text q = new Text("Turn per second:");
                q.setFont(Font.font("Luminari", FontWeight.BOLD, 30));
                q.setFill(Color.WHEAT);

                TextField textField = new TextField();
                textField.setStyle("-fx-background-color: wheat; -fx-foreground-color: wheat");
                textField.setPrefColumnCount(5);
                textField.setFont(Font.font("Luminari", FontWeight.BOLD, 15));

                InputStream inputStreamW3 = new FileInputStream(new File("../Ap_15/src/Images/button/set.png"));
                Image imageW3 = new Image(inputStreamW3);
                ImageView imageViewW3 = new ImageView(imageW3);
                imageViewW3.relocate(x + 20, y + 45);

                HBox hBox = new HBox();
                hBox.setSpacing(25);
                hBox.getChildren().addAll(q, textField);
                VBox vBox1 = new VBox();
                vBox1.setSpacing(25);
                vBox1.relocate(x + 50, y + 80);
                vBox1.getChildren().addAll(hBox, imageViewW3);

                subGroup.getChildren().addAll(imageView11, imageView21, imageViewE, vBox1);
                group.getChildren().addAll(subGroup);
                imageViewE.setOnMouseClicked(event1 -> {
                    group.getChildren().remove(subGroup);
                });
                imageViewW3.setOnMouseClicked(event1 -> {
                    if (!textField.getText().equals("")) {
                        game.setTurn(Integer.parseInt(textField.getText()));
                        group.getChildren().remove(subGroup);
                    } else {
                        Text text1 = new Text("Enter number");
                        text1.setFont(Font.font("Luminari", FontWeight.BOLD, 30));
                        text1.setFill(Color.WHEAT);
                        text1.relocate(10, 10);

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
                    }

                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        });
        canvas.setOnMouseClicked(event -> {
            if (!game.isAttacked()){
            Building building;
            int x = (int) (event.getX() / 88);
            int y = (int) (event.getY() / 88);
            building = menuController.findBuilding(x, y);

            if (building != null) {
                if (building instanceof TownHall) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    townHallM.show(group);
                }
                if (building instanceof Barracks) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    barracksM.show(group);
                }
                if (building instanceof Camp) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    campM.show(group);
                }
                if (building instanceof Storage) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    if (building instanceof GoldStorage) {
                        storageM.setKind(1);
                    }
                    if (building instanceof ElixirStorage) {
                        storageM.setKind(2);
                    }
                    storageM.show(group);
                }
                if (building instanceof Mine) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    if (building instanceof GoldMine) {
                        mineM.setKind(1);
                    }
                    if (building instanceof ElixirMine) {
                        mineM.setKind(2);
                    }
                    mineM.show(group);
                }
                if (building instanceof DefenseTower) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    if (building instanceof AirDefense) {
                        defenceM.setKind(1);
                    }
                    if (building instanceof ArcherTower) {
                        defenceM.setKind(2);
                    }
                    if (building instanceof Cannon) {
                        defenceM.setKind(3);
                    }
                    if (building instanceof WizardTower) {
                        defenceM.setKind(5);
                    }
                    if (building instanceof Trap) {
                        defenceM.setKind(6);
                    }
                    defenceM.show(group);
                }
                if (building instanceof GiantCastle) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    defenceM.setKind(4);
                    defenceM.show(group);
                }
                if (building instanceof Wall) {
                    light.relocate(x * 88, y * 88);
                    if (!canvas.getChildren().contains(light))
                        canvas.getChildren().add(light);
                    defenceM.setKind(7);
                    defenceM.show(group);
                }
                if (building instanceof Stuff) {
                    Text text1 = new Text(building.getClass().getName());
                    text1.setFont(Font.font("Luminari", FontWeight.BOLD, 15));
                    text1.setFill(Color.WHEAT);
                    text1.relocate(event.getX(), event.getY());

                    canvas.getChildren().addAll(text1);
                    PauseTransition visiblePause = new PauseTransition(
                            Duration.seconds(3)
                    );
                    visiblePause.setOnFinished(
                            event1 -> {
                                canvas.getChildren().remove(text1);
                            }
                    );
                    visiblePause.play();

                }
            } else {
                light.relocate(x * 88, y * 88);
                if (!canvas.getChildren().contains(light))
                    canvas.getChildren().add(light);
                newBuilding.show(group);
            }
        }
        });


        group.getChildren().addAll(canvas,vBox);
        if(chatRoom != null)
            group.getChildren().addAll(chatRoom.getChatRoomGroup());
        // create scene which can be dragged and zoomed
        scene.setFill(Color.DARKKHAKI);

        SceneGestures sceneGestures = new SceneGestures(canvas);
        scene.addEventFilter( MouseEvent.MOUSE_PRESSED, sceneGestures.getOnMousePressedEventHandler());
        scene.addEventFilter( MouseEvent.MOUSE_DRAGGED, sceneGestures.getOnMouseDraggedEventHandler());
        scene.addEventFilter( ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());
    }

    public void exit() {
        if (!game.isAttacked()) {
            try {
                FileOutputStream fos = new FileOutputStream("../AP_15/" + client.getID() + ".txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(game);
                fos.close();
                oos.close();
                gTotal.getChildren().remove(subGroup);
                gTotal.getChildren().clear();
                getParent().show(primaryStage, gTotal, scene);
            } catch (IOException e) {
//                        e.printStackTrace();
            }
        }
    }

    public void deleteLight(){
        canvas.getChildren().remove(light);
    }
}
