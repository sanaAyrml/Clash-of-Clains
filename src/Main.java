
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.*;

public class Main extends Application {
    MainMenu mainMenu = new MainMenu(null,"Start");
    ChoosingStyleMenu choosingStyleMenu = new ChoosingStyleMenu(mainMenu,"Map");
    PlayMenu playMenu = new PlayMenu(choosingStyleMenu,"Play Menu");
    MultiPlayer multiPlayer = new MultiPlayer(choosingStyleMenu,"Map");
    HostM hostM = new HostM(multiPlayer,"host");
    ClientM clientM = new ClientM(multiPlayer,"client");
    VillageView villageView = new VillageView(choosingStyleMenu,"Map");
    LoadGame loadGame = new LoadGame(playMenu,"Load game");
    VillageView villageView1 = new VillageView(loadGame,"Map");
    VillageView villageViewClient = new VillageView(clientM,"Map");
    Group group=new Group();
    Scene scene = new Scene(group);

    @Override
    public void start(Stage primaryStage) {

        setChilds();
        primaryStage.setTitle("Clash Of SRS");
        mainMenu.show(primaryStage,group,scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setChilds(){
        mainMenu.setChilderen(choosingStyleMenu);
        choosingStyleMenu.setChilderen(playMenu);
        choosingStyleMenu.setChilderen(multiPlayer);
        multiPlayer.setChilderen(hostM);
        multiPlayer.setChilderen(clientM);
        playMenu.setChilderen(villageView);
        playMenu.setChilderen(loadGame);
        loadGame.setChilderen(villageView1);
        clientM.setChilderen(villageViewClient);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
