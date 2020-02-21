package attack.attackStreaming;

import attack.Soldier;
import attack.soldierGUI;
import attack.soldiers.*;
import attack.soldiersGUI.GuardianGiantGui;
import building.GuardianGiant;
import javafx.application.Platform;
import javafx.scene.Group;
import map.Direction;

import java.util.ArrayList;
import java.util.HashMap;

public class StreamGUI {
    private Group root;
    private GuardianGiant guardianGiant;
    private ArrayList<Guardian> guardians;
    private ArrayList<WallBreaker> wallBreakers;
    private ArrayList<Giant> giants;
    private ArrayList<Dragon> dragons;
    private ArrayList<Archer> archers;
    private ArrayList<Healer> healers;
    protected static HashMap<Integer,ArrayList> identifier=new HashMap<>();
    private Group vilageRoot;
    private soldierGUI soldierGUI;
    public static HashMap<Integer, ArrayList> getIdentifier() {
        return identifier;
    }

    public static HashMap<Integer, Direction> getDirectionIdentifier() {
        return directionIdentifier;
    }

    protected static HashMap<Integer, Direction> directionIdentifier=new HashMap<>();
    protected static HashMap<Direction, Integer> numDirectionIdentifier=new HashMap<>();

    public static HashMap<Direction, Integer> getNumDirectionIdentifier() {
        numDirectionIdentifier.put(Direction.UP,1);
        numDirectionIdentifier.put(Direction.DOWN,2);
        numDirectionIdentifier.put(Direction.LEFT,3);
        numDirectionIdentifier.put(Direction.RIGHT,4);
        numDirectionIdentifier.put(Direction.REACHED,5);
        numDirectionIdentifier.put(Direction.NONE,6);
        return numDirectionIdentifier;
    }

    public StreamGUI(Group root, GuardianGiant guardianGiant, int guardians, int wallBreakers, int giants, int dragons, int archers, int healers) {
        this.root = root;
        vilageRoot=new Group();
        this.guardianGiant = guardianGiant;
        this.guardians = new ArrayList<>();
        this.wallBreakers = new ArrayList<>();
        this.giants = new ArrayList<>();
        this.dragons = new ArrayList<>();
        this.archers = new ArrayList<>();
        this.healers = new ArrayList<>();
        identifier.put(1,this.guardians);
        identifier.put(2,this.archers);
        identifier.put(3,this.giants);
        identifier.put(4,this.wallBreakers);
        identifier.put(5,this.healers);
        identifier.put(6,this.dragons);
        directionIdentifier.put(1,Direction.UP);
        directionIdentifier.put(2,Direction.DOWN);
        directionIdentifier.put(3,Direction.LEFT);
        directionIdentifier.put(4,Direction.RIGHT);
        directionIdentifier.put(5,Direction.REACHED);
        directionIdentifier.put(6,Direction.NONE);
//        System.err.println(guardians);

        for (int i = 0; i <guardians ; i++) {
            this.guardians.add(new Guardian(0));
        }
        for (int i = 0; i <archers ; i++) {
            this.archers.add(new Archer(0));
        }
        for (int i = 0; i <wallBreakers ; i++) {
            this.wallBreakers.add(new WallBreaker(0));
        }
        for (int i = 0; i <giants ; i++) {
            this.giants.add(new Giant(0));
        }
        for (int i = 0; i <healers ; i++) {
            this.healers.add(new Healer(0));
        }
        for (int i = 0; i <dragons ; i++) {
            this.dragons.add(new Dragon(0));
        }
    }

    //add she chizaye marboot be gamegui va taghirate healthe sakhteman
    public void run(){
        soldierGUI=new soldierGUI(new GuardianGiantGui(guardianGiant),guardianGiant,root);
        for (Guardian guardian : guardians) {
            soldierGUI.addSoldier(guardian);
        }
        for (Archer archer : archers) {
            soldierGUI.addSoldier(archer);
        }
        for (Giant giant : giants) {
            soldierGUI.addSoldier(giant);
        }
        for (WallBreaker wallBreaker : wallBreakers) {
            soldierGUI.addSoldier(wallBreaker);
        }
        for (Dragon dragon : dragons) {
            soldierGUI.addSoldier(dragon);
        }
        for (Healer healer : healers) {
            soldierGUI.addSoldier(healer);
        }
        soldierGUI.run();

    }
    public void  updateSoldier(Event soldierEvent){
        Soldier soldier= (Soldier) identifier.get(soldierEvent.getSoldierType()).get(soldierEvent.getSoldierID());
        soldier.setGraphicalX(soldierEvent.getGraphicalX());
        soldier.setGraphicalY(soldierEvent.getGraphicaly());
        soldier.setDirection(directionIdentifier.get(soldierEvent.getSoldierDirection()));
//        System.err.println("no: "+soldierEvent.getSoldierType()+"       id: "+ soldierEvent.getSoldierID());
    }
    public void end(){
        Platform.runLater(()->{
            for (Soldier soldier : soldierGUI.getSoldierss()) {
                if(root.getChildren().contains(soldier.group)){
                    root.getChildren().remove(soldier.group);
                }
            }
        });

    }
}
