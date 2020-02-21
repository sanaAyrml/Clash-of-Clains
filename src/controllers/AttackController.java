package controllers;

import Exceptions.NotEnoughSodierInCampEXC;
import Exceptions.PutSoldierException;
import attack.Soldier;
import attack.Type;
import attack.soldiers.*;
import building.*;
import client.Client;
import javafx.scene.Group;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import map.Cell;
import map.Constants;
import map.Direction;
import map.Game;
import view.AttackGUI;

import java.util.ArrayList;
import java.util.HashMap;

public class AttackController {
    private ArrayList<Guardian> guardians;
    private ArrayList<WallBreaker> wallBreakers;
    private ArrayList<Giant> giants;
    private ArrayList<Dragon> dragons;
    private ArrayList<Archer> archers;
    private ArrayList<Healer> healers;
    private int totalSoldiers;
    private ArrayList<Camp> camps=new ArrayList<>();
    private ArrayList<Cell> cells;
    private int time;
    private Game gameAttacker;
    private Game gameDefender;
    protected HashMap<Type,ArrayList> identifier;
    private int totalGold=0;
    private int totalElixir=0;
    private int gold=0;
    private int elixir=0;
    private int point=0;
    private GuardianGiant guardianGiant=null;
    private AttackGUI gui;
    private boolean ended=false;
    private Client client=null;

    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {

        this.client = client;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    private int possElixir = 0;
    private int possGold = 0;

    public ArrayList<Guardian> getGuardians() {
        return guardians;
    }

    public ArrayList<WallBreaker> getWallBreakers() {
        return wallBreakers;
    }

    public ArrayList<Giant> getGiants() {
        return giants;
    }

    public ArrayList<Dragon> getDragons() {
        return dragons;
    }

    public ArrayList<Archer> getArchers() {
        return archers;
    }

    public ArrayList<Healer> getHealers() {
        return healers;
    }

    public AttackController(MediaPlayer player1, MediaPlayer playerAttack, Group groupCopy, Game gameAttacker, Game gameDefender, Stage primaryStage, Group group) {
        guardianGiant=gameDefender.getGuardianGiant();
        this.guardians = new ArrayList<>();
        this.wallBreakers = new ArrayList<>();
        this.giants = new ArrayList<>();
        this.dragons = new ArrayList<>();
        this.archers = new ArrayList<>();
        this.healers = new ArrayList<>();
        this.gameAttacker=gameAttacker;
        this.gameDefender=gameDefender;
        identifier = new HashMap<>();
        identifier.put(Type.GUARDIAN,guardians);
        identifier.put(Type.WALLBREAKER,wallBreakers);
        identifier.put(Type.GIANT,giants);
        identifier.put(Type.DRAGON,dragons);
        identifier.put(Type.HEALER,healers);
        identifier.put(Type.ARCHER,archers);
        for(Cell cell:gameAttacker.getCamps()){
            camps.add((Camp) cell.getBuilding());
        }
        time=0;
        for (Cell cell : getBuildingss(gameDefender.getAllBuildings())) {
            totalGold+=cell.getBuilding().getGoldCost();
            totalElixir+=cell.getBuilding().getElixirCost();

        }
        for (Cell cell : gameDefender.getElixirStorages()) {
            totalElixir+= ((Storage) cell.getBuilding()).getResource();
        }
        for (Cell cell : gameDefender.getGoldStorages()) {
            totalGold+= ((Storage) cell.getBuilding()).getResource();
        }
        addAllSoldiers();
        gui=new AttackGUI(player1,playerAttack,guardianGiant,groupCopy,this,primaryStage,gameDefender,gameAttacker,group,guardians,wallBreakers,giants,dragons,archers,healers);
    }
    public void start(){
        for (Cell cell : gameAttacker.getElixirStorages()) {
            possElixir = ((Storage) cell.getBuilding()).getFreeSpace();
        }
        for (Cell cell : gameAttacker.getGoldStorages()) {
            possGold = ((Storage) cell.getBuilding()).getFreeSpace();
        }

        gui.startAttack();


    }

    public int getTotalSoldiers() {
        return totalSoldiers;
    }

    public void addAllSoldiers(){
        try {
            addSoldier("guardian",1000);
            addSoldier("guardian",1000);
        } catch (NotEnoughSodierInCampEXC notEnoughSodierInCampEXC) {
            try {
                addSoldier("archer",1000);
                addSoldier("archer",1000);
            } catch (NotEnoughSodierInCampEXC notEnoughSodierInCampEXC1) {

                try {
                    addSoldier("giant",1000);
                    addSoldier("giant",1000);
                } catch (NotEnoughSodierInCampEXC notEnoughSodierInCampEXC2) {

                    try {
                        addSoldier("dragon",1000);
                        addSoldier("dragon",1000);
                    } catch (NotEnoughSodierInCampEXC notEnoughSodierInCampEXC3) {
                        try {
                            addSoldier("healer",1000);
                            addSoldier("healer",1000);
                        } catch (NotEnoughSodierInCampEXC notEnoughSodierInCampEXC4) {
                            try {
                                addSoldier("wallbreaker",1000);
                                addSoldier("wallbreaker",1000);
                            } catch (NotEnoughSodierInCampEXC notEnoughSodierInCampEXC5) {
                                totalSoldiers=healers.size()+guardians.size()+giants.size()+archers.size()+wallBreakers.size()+dragons.size();
                            }
                        }
                    }
                }
            }
        }


    }
    public void addSoldier(String name, int number) throws NotEnoughSodierInCampEXC{
        if(name.equalsIgnoreCase("guardian")){
            int counter=0;
            for (Camp camp : camps) {
                counter+=camp.getGuardians().size();

            }
            counter=0;

            outer:
            for (Camp camp : camps) {
                int constSize=camp.getGuardians().size();
                for (int i = 0; i <constSize ; i++) {
                    Guardian guardian=(Guardian) camp.borrowSodier(Type.GUARDIAN);
                    guardian.setTypee(Type.GUARDIAN);

                    guardians.add(guardian);

                    counter++;
                    if(counter==number){
                        break outer;
                    }
                }

            }

            if(counter<number){

                throw new NotEnoughSodierInCampEXC();


            }
        }
        else if(name.equalsIgnoreCase("archer")){
            int counter=0;
            for (Camp camp : camps) {
                counter+=camp.getArchers().size();

            }
            counter=0;

            outer:
            for (Camp camp : camps) {
                int constSize=camp.getArchers().size();
                for (int i = 0; i <constSize ; i++) {
                    Archer archer=(Archer) camp.borrowSodier(Type.ARCHER);
                    archer.setTypee(Type.ARCHER);

                    archers.add(archer);

                    counter++;
                    if(counter==number){
                        break outer;
                    }
                }

            }

            if(counter<number){

                throw new NotEnoughSodierInCampEXC();


            }
        }
        else if(name.equalsIgnoreCase("wallbreaker")){
            int counter=0;
            for (Camp camp : camps) {
                counter+=camp.getWallBreakers().size();

            }
            counter=0;

            outer:
            for (Camp camp : camps) {
                int constSize=camp.getWallBreakers().size();
                for (int i = 0; i <constSize ; i++) {
                    WallBreaker wallBreaker=(WallBreaker) camp.borrowSodier(Type.WALLBREAKER);
                    wallBreaker.setTypee(Type.WALLBREAKER);

                    wallBreakers.add(wallBreaker);

                    counter++;
                    if(counter==number){
                        break outer;
                    }
                }

            }

            if(counter<number){

                throw new NotEnoughSodierInCampEXC();


            }
        }
        else if(name.equalsIgnoreCase("healer")){
            int counter=0;
            for (Camp camp : camps) {
                counter+=camp.getHealers().size();

            }
            counter=0;

            outer:
            for (Camp camp : camps) {
                int constSize=camp.getHealers().size();
                for (int i = 0; i <constSize ; i++) {
                    Healer healer=(Healer) camp.borrowSodier(Type.HEALER);
                    healer.setTypee(Type.HEALER);

                    healers.add(healer);

                    counter++;
                    if(counter==number){
                        break outer;
                    }
                }

            }

            if(counter<number){

                throw new NotEnoughSodierInCampEXC();


            }
        }
        else if(name.equalsIgnoreCase("giant")){
            int counter=0;
            for (Camp camp : camps) {
                counter+=camp.getGiants().size();

            }
            counter=0;

            outer:
            for (Camp camp : camps) {
                int constSize=camp.getGiants().size();
                for (int i = 0; i <constSize ; i++) {
                    Giant giant=(Giant) camp.borrowSodier(Type.GIANT);
                    giant.setTypee(Type.GIANT);

                    giants.add(giant);

                    counter++;
                    if(counter==number){
                        break outer;
                    }
                }

            }

            if(counter<number){

                throw new NotEnoughSodierInCampEXC();


            }
        }
        else if(name.equalsIgnoreCase("dragon")){
            int counter=0;
            for (Camp camp : camps) {
                counter+=camp.getDragons().size();

            }
            counter=0;

            outer:
            for (Camp camp : camps) {
                int constSize=camp.getDragons().size();
                for (int i = 0; i <constSize ; i++) {
                    Dragon dragon=(Dragon) camp.borrowSodier(Type.DRAGON);
                    dragon.setTypee(Type.DRAGON);

                    dragons.add(dragon);

                    counter++;
                    if(counter==number){
                        break outer;
                    }
                }

            }

            if(counter<number){

                throw new NotEnoughSodierInCampEXC();


            }
        }


    }

    public Soldier putUnit(Type type,int x , int y) throws PutSoldierException {

        Soldier soldier = null;
        boolean flag=false;
        ArrayList<Soldier> soldiers=identifier.get(type);
        for (Soldier soldieer : soldiers) {
            if (soldieer.getAttackCell() == null) {
                flag = true;
                soldier = soldieer;
                break;
            }
        }
        for (Cell cell : gameDefender.getMap().getMap()) {
            if(x==Constants.getMapWidth())
                x=Constants.getMapWidth()-1;
            if(y==Constants.getMapHeght())
                x=Constants.getMapHeght()-1;

            if(cell.getX()==x&&cell.getY()==y&&soldier!=null) {

                    cell.addSoldier(soldier);
                    soldier.setGraphicalX(cell.getX()*Constants.CELL_WIDTH);
                    soldier.setGraphicalY(cell.getY()*Constants.CELL_HEIGHT);
                    soldier.setAttackCell(cell);
                soldier.setDirection(Direction.NONE);

            }
        }
        return soldier;

    }

    public Game getGameAttacker() {
        return gameAttacker;
    }

    public void passTime(int turn){
        time++;
        updateCells();
        if(time > 10000 || (gold == totalGold && elixir == totalElixir) || (possElixir <= elixir && possGold <= gold)||(wallBreakers.size()+guardians.size()+archers.size()+giants.size()+dragons.size()==0)||checkBuildings()){
            endGame();
            return;
        }
        for (int i = 0; i <turn ; i++) {

            for (Cell cell : gameDefender.getAirDefenses()) {
                DefenseTower defenseTower= (DefenseTower) cell.getBuilding();

                ArrayList<Soldier> soldiers = defenseTower.attackedsoldiers(gameDefender.getMap());
                if(soldiers!=null&& soldiers.size()>0)
                    soldiers.get(0).decraseHealth(defenseTower.getDamagePerHit());



            }
            for (Cell cell : gameDefender.getCannons()) {
                DefenseTower defenseTower= (DefenseTower) cell.getBuilding();
                ArrayList<Soldier> soldiers = defenseTower.attackedsoldiers(gameDefender.getMap());
                if(soldiers!=null&& soldiers.size()>0) {
                    for (Soldier soldier : soldiers) {
                        soldier.decraseHealth(defenseTower.getDamagePerHit());
                    }
                }
            }
            for (Cell cell : gameDefender.getArcherTowers()) {
                DefenseTower defenseTower= (DefenseTower) cell.getBuilding();
                ArrayList<Soldier> soldiers = defenseTower.attackedsoldiers(gameDefender.getMap());
                if(soldiers!=null&& soldiers.size()>0) {
                    soldiers.get(0).decraseHealth(defenseTower.getDamagePerHit());
                }

            }
            for (Cell cell : gameDefender.getWizardTowers()) {
                DefenseTower defenseTower= (DefenseTower) cell.getBuilding();
                ArrayList<Soldier> soldiers = defenseTower.attackedsoldiers(gameDefender.getMap());
                if(soldiers!=null&& soldiers.size()>0) {
                    for (Soldier soldier : soldiers) {
                        soldier.decraseHealth(defenseTower.getDamagePerHit());
                    }
                }
            }
            for (int j = 0; j <guardians.size() ; j++) {
                if(guardians.get(j).getHealth()<=0){
                    guardians.remove(j);
                    j--;
                }
            }
            for (int j = 0; j <dragons.size() ; j++) {
                if(dragons.get(j).getHealth()<=0){
                    dragons.remove(j);
                    j--;
                }
            }
            for (int j = 0; j <giants.size() ; j++) {
                if(giants.get(j).getHealth()<=0){
                    giants.remove(j);
                    j--;
                }
            }
            for (int j = 0; j <archers.size() ; j++) {
                if(archers.get(j).getHealth()<=0){
                    archers.remove(j);
                    j--;
                }
            }
            for (int j = 0; j <wallBreakers.size() ; j++) {
                if(wallBreakers.get(j).getHealth()<=0){
                    wallBreakers.remove(j);
                    j--;
                }
            }
            for (int j = 0; j <healers.size() ; j++) {
                if(healers.get(j).getHealingtime()<=0){
                    healers.remove(j);
                    j--;
                }
            }
            for (Guardian guardian : guardians) {
                guardian.isDamaging=false;
            }
            for (Archer archer : archers) {
                archer.isDamaging=false;
            }
            for (WallBreaker wallBreaker : wallBreakers) {
                wallBreaker.isDamaging=false;
            }
            for (Giant giant : giants) {
                giant.isDamaging=false;
            }
            for (Dragon dragon : dragons) {
                dragon.isDamaging=false;
            }
            for (Healer healer : healers) {
                healer.isDamaging=false;
            }
            /*
            dar inja aval tower ha shelik kardn
            bad sarbaz morde ha hazf shodn
            bad inja varede sarbaza mishe
            ye for zadam
            be tedade speede soldier ha seda zade miseh in tabe hashoon
            ba reayate nobat
            yani ye bar ta tah mire
            bad dobare miad har soldier
            hala mire too
            aval ye array list dess dorost mikone
            ke mishe cell haye ba fasele range az hadaf hash
            bad mide bfs
            bad direction set mishe
            bad age reached bud damage mikone
            ye boolean ham set mikone
            ke too oon fore ke goftm bara speede
            ye bar zarbe bezane
            na 6 bar
            hamin
             */
            for (int j = 0; j <1 ; j++) {
                if(guardianGiant!=null&&j<guardianGiant.getSpeed()) {
                        if(!guardianGiant.isDamaging) {
                            ArrayList<Cell> soldierCells = new ArrayList<>();
                            for (Guardian guardian : guardians) {
                                soldierCells.add(guardian.getAttackCell());
                            }
                            for (Archer archer : archers) {
                                soldierCells.add(archer.getAttackCell());
                            }
                            for (Giant giant : giants) {
                                soldierCells.add(giant.getAttackCell());
                            }
                            for (WallBreaker wallBreaker : wallBreakers) {
                                soldierCells.add(wallBreaker.getAttackCell());
                            }
                            ArrayList<Cell> dess = processCells(soldierCells, guardianGiant.getDamageRange());
                            guardianGiant.setDirection(gameDefender.getMap().move(guardianGiant.getCell(), dess, Situation.GROUND));
                            if (guardianGiant.getDirection() == Direction.REACHED) {

                                for (Cell cell : gameDefender.getMap().getMap()) {
                                    if (cell.getY() == guardianGiant.getCell().getY() && cell.getX() == guardianGiant.getCell().getX()) {

                                        for (Guardian guardian : guardians) {
                                            if (findDistance(guardian.getAttackCell(), guardianGiant.getCell()) <= guardianGiant.getDamageRange() * guardianGiant.getDamageRange()) {
                                                guardian.decraseHealth( guardianGiant.getDamagePerHit());
                                                break;

                                            }
                                        }
                                        for (Archer archer : archers) {
                                            if (findDistance(archer.getAttackCell(), guardianGiant.getCell()) <= guardianGiant.getDamageRange() * guardianGiant.getDamageRange()) {
                                                archer.decraseHealth( guardianGiant.getDamagePerHit());
                                                break;

                                            }
                                        }
                                        for (WallBreaker wallBreaker : wallBreakers) {
                                            if (findDistance(wallBreaker.getAttackCell(), guardianGiant.getCell()) <= guardianGiant.getDamageRange() * guardianGiant.getDamageRange()) {
                                                wallBreaker.decraseHealth( guardianGiant.getDamagePerHit());
                                                break;

                                            }
                                        }
                                        for (Giant giant : giants) {
                                            if (findDistance(giant.getAttackCell(), guardianGiant.getCell()) <= guardianGiant.getDamageRange() * guardianGiant.getDamageRange()) {
                                                giant.decraseHealth( guardianGiant.getDamagePerHit());
                                                break;

                                            }
                                        }

                                    }
                                }

                            }
                            guardianGiant.passTime();
                            guardianGiant.sync();
                        }

                }
                if(j<Constants.getGuardianSpeed()) {

                    for (Guardian guardian : guardians) {
                        if(!guardian.isDamaging) {
                            ArrayList<Cell> dess = processCells(getBuildingss(gameDefender.getAllBuildings()), Constants.getGuardianRange());
                            guardian.setDirection(gameDefender.getMap().move(guardian.getAttackCell(), dess, Guardian.situation));
                            if (guardian.getDirection() == Direction.REACHED) {

                                guardian.isDamaging = true;
                                for (Cell cell : gameDefender.getMap().getMap()) {
                                    if (cell.getY() == guardian.getAttackCell().getY() && cell.getX() == guardian.getAttackCell().getX()) {

                                        guardian.setTarget(findTarget(guardian, getBuildingss(gameDefender.getAllBuildings()), Constants.getGuardianRange()));

                                        guardian.getTarget().damage(guardian.getDamagePerHit());
                                        if (guardian.getTarget().getHealth() <= 0) {
                                            point += guardian.getTarget().getDistructionEarnedPoint();
                                            gold += guardian.getTarget().getGoldCost();
                                            elixir += guardian.getTarget().getElixirCost();

                                            if (guardian.getTarget().getType() == 5) {
                                                gold += 1000;
                                                elixir += 500;
                                            }
                                            if (guardian.getTarget().getType() == 3) {
                                                Storage storage = (Storage) (guardian.getTarget());
                                                gold += storage.getResource();
                                            }
                                            if (guardian.getTarget().getType() == 4) {
                                                Storage storage = (Storage) (guardian.getTarget());
                                                elixir += storage.getResource();
                                            }
                                        }

                                    }
                                }

                            }
                        }

                    }
                }

                if(j<Constants.getArcherSpeed()) {
                    for (Archer archer : archers) {
                        if(!archer.isDamaging) {
                            ArrayList<Cell> posdefs = new ArrayList<>();
                            posdefs.addAll(gameDefender.getAirDefenses());
                            posdefs.addAll(gameDefender.getArcherTowers());
                            posdefs.addAll(gameDefender.getCannons());
                            posdefs.addAll(gameDefender.getWizardTowers());
                            ArrayList<Cell> targets = removeDistructed(posdefs);

                            ArrayList<Cell> dess = processCells(targets, Constants.getArcherRange());
                            archer.setDirection(gameDefender.getMap().move(archer.getAttackCell(), dess, Archer.situation));

                            if (archer.getDirection() == Direction.REACHED) {
                                archer.isDamaging = true;
                                for (Cell cell : gameDefender.getMap().getMap()) {
                                    if (cell.getY() == archer.getAttackCell().getY() && cell.getX() == archer.getAttackCell().getX()) {

                                        archer.setTarget(findTarget(archer, targets, Constants.getArcherRange()));

                                        archer.getTarget().damage(archer.getDamagePerHit());
                                        if (archer.getTarget().getHealth() <= 0) {
                                            point += archer.getTarget().getDistructionEarnedPoint();
                                            gold += archer.getTarget().getGoldCost();
                                            elixir += archer.getTarget().getElixirCost();

                                            if (archer.getTarget().getType() == 5) {
                                                gold += 1000;
                                                elixir += 500;
                                            }
                                            if (archer.getTarget().getType() == 3) {
                                                Storage storage = (Storage) (archer.getTarget());
                                                gold += storage.getResource();
                                            }
                                            if (archer.getTarget().getType() == 4) {
                                                Storage storage = (Storage) (archer.getTarget());
                                                elixir += storage.getResource();
                                            }
                                        }

                                    }
                                }

                            } else if (archer.getDirection() == Direction.NONE) {
                                dess = processCells(getBuildingss(gameDefender.getAllBuildings()), Constants.getArcherRange());
                                archer.setDirection(gameDefender.getMap().move(archer.getAttackCell(), dess, Archer.situation));
                                if (archer.getDirection() == Direction.REACHED) {
                                    archer.isDamaging = true;
                                    for (Cell cell : gameDefender.getMap().getMap()) {
                                        if (cell.getY() == archer.getAttackCell().getY() && cell.getX() == archer.getAttackCell().getX()) {

                                            archer.setTarget(findTarget(archer, getBuildingss(gameDefender.getAllBuildings()), Constants.getArcherRange()));

                                            archer.getTarget().damage(archer.getDamagePerHit());
                                            if (archer.getTarget().getHealth() <= 0) {
                                                point += archer.getTarget().getDistructionEarnedPoint();
                                                gold += archer.getTarget().getGoldCost();
                                                elixir += archer.getTarget().getElixirCost();

                                                if (archer.getTarget().getType() == 5) {
                                                    gold += 1000;
                                                    elixir += 500;
                                                }
                                                if (archer.getTarget().getType() == 3) {
                                                    Storage storage = (Storage) (archer.getTarget());
                                                    gold += storage.getResource();
                                                }
                                                if (archer.getTarget().getType() == 4) {
                                                    Storage storage = (Storage) (archer.getTarget());
                                                    elixir += storage.getResource();
                                                }
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }
                }
                if(j<Constants.getGiantSpeed()) {
                    for (Giant giant : giants) {
                        if(!giant.isDamaging) {
                            ArrayList<Cell> posbuilds = new ArrayList<>();
                            posbuilds.addAll(gameDefender.getElixirStorages());
                            posbuilds.addAll(gameDefender.getGoldStorages());
                            posbuilds.addAll(gameDefender.getGoldMines());
                            posbuilds.addAll(gameDefender.getElixirMines());

                            ArrayList<Cell> targets = removeDistructed(posbuilds);
                            ArrayList<Cell> dess = processCells(targets, Constants.getGiantRange());

                            giant.setDirection(gameDefender.getMap().move(giant.getAttackCell(), dess, Giant.situation));
                            if (giant.getDirection() == Direction.NONE) {

                                dess = processCells(getBuildingss(gameDefender.getAllBuildings()), Constants.getGiantRange());
                                giant.setDirection(gameDefender.getMap().move(giant.getAttackCell(), dess, Giant.situation));
                                if (giant.getDirection() == Direction.REACHED) {

                                    giant.isDamaging = true;
                                    for (Cell cell : gameDefender.getMap().getMap()) {
                                        if (cell.getY() == giant.getAttackCell().getY() && cell.getX() == giant.getAttackCell().getX()) {

                                            giant.setTarget(findTarget(giant, getBuildingss(gameDefender.getAllBuildings()), Constants.getGiantRange()));

                                            giant.getTarget().damage(giant.getDamagePerHit());
                                            if (giant.getTarget().getHealth() <= 0) {
                                                point += giant.getTarget().getDistructionEarnedPoint();
                                                gold += giant.getTarget().getGoldCost();
                                                elixir += giant.getTarget().getElixirCost();

                                                if (giant.getTarget().getType() == 5) {
                                                    gold += 1000;
                                                    elixir += 500;
                                                }
                                                if (giant.getTarget().getType() == 3) {
                                                    Storage storage = (Storage) (giant.getTarget());
                                                    gold += storage.getResource();
                                                }
                                                if (giant.getTarget().getType() == 4) {
                                                    Storage storage = (Storage) (giant.getTarget());
                                                    elixir += storage.getResource();
                                                }
                                            }


                                        }
                                    }

                                }

                            } else if (giant.getDirection() == Direction.REACHED) {

                                giant.isDamaging = true;
                                for (Cell cell : gameDefender.getMap().getMap()) {
                                    if (cell.getY() == giant.getAttackCell().getY() && cell.getX() == giant.getAttackCell().getX()) {

                                        giant.setTarget(findTarget(giant, targets, Constants.getGiantRange()));

                                        giant.getTarget().damage(giant.getDamagePerHit());
                                        if (giant.getTarget().getHealth() <= 0) {
                                            point += giant.getTarget().getDistructionEarnedPoint();
                                            gold += giant.getTarget().getGoldCost();
                                            elixir += giant.getTarget().getElixirCost();

                                            if (giant.getTarget().getType() == 5) {
                                                gold += 1000;
                                                elixir += 500;
                                            }
                                            if (giant.getTarget().getType() == 3) {
                                                Storage storage = (Storage) (giant.getTarget());
                                                gold += storage.getResource();
                                            }
                                            if (giant.getTarget().getType() == 4) {
                                                Storage storage = (Storage) (giant.getTarget());
                                                elixir += storage.getResource();
                                            }
                                        }

                                    }
                                }

                            }
                            giant.passTime();
                            giant.sync();
                        }
                    }
                }
                if(j<Constants.getWallBreakerSpeed()) {
                    for (WallBreaker wallBreaker : wallBreakers) {
                        if(!wallBreaker.isDamaging) {
                            ArrayList<Cell> posbuilds = new ArrayList<>();
                            posbuilds.addAll(gameDefender.getWalls());

                            ArrayList<Cell> targets = removeDistructed(posbuilds);
                            ArrayList<Cell> dess = processCells(targets, Constants.getWallBreakerRange());

                            wallBreaker.setDirection(gameDefender.getMap().move(wallBreaker.getAttackCell(), dess, wallBreaker.situation));
                            if (wallBreaker.getDirection() == Direction.NONE) {

                                dess = processCells(getBuildingss(gameDefender.getAllBuildings()), Constants.getWallBreakerRange());
                                wallBreaker.setDirection(gameDefender.getMap().move(wallBreaker.getAttackCell(), dess, wallBreaker.situation));
                                if (wallBreaker.getDirection() == Direction.REACHED) {

                                    wallBreaker.isDamaging = true;
                                    for (Cell cell : gameDefender.getMap().getMap()) {
                                        if (cell.getY() == wallBreaker.getAttackCell().getY() && cell.getX() == wallBreaker.getAttackCell().getX()) {

                                            wallBreaker.setTarget(findTarget(wallBreaker, getBuildingss(gameDefender.getAllBuildings()), Constants.getWallBreakerRange()));

                                            wallBreaker.getTarget().damage(wallBreaker.getDamagePerHit());
                                            if (wallBreaker.getTarget().getHealth() <= 0) {
                                                point += wallBreaker.getTarget().getDistructionEarnedPoint();
                                                gold += wallBreaker.getTarget().getGoldCost();
                                                elixir += wallBreaker.getTarget().getElixirCost();

                                                if (wallBreaker.getTarget().getType() == 5) {
                                                    gold += 1000;
                                                    elixir += 500;
                                                }
                                                if (wallBreaker.getTarget().getType() == 3) {
                                                    Storage storage = (Storage) (wallBreaker.getTarget());
                                                    gold += storage.getResource();
                                                }
                                                if (wallBreaker.getTarget().getType() == 4) {
                                                    Storage storage = (Storage) (wallBreaker.getTarget());
                                                    elixir += storage.getResource();
                                                }
                                            }

                                            wallBreaker.setHealth(-1);


                                        }
                                    }

                                }

                            } else if (wallBreaker.getDirection() == Direction.REACHED) {

                                wallBreaker.isDamaging = true;
                                for (Cell cell : gameDefender.getMap().getMap()) {
                                    if (cell.getY() == wallBreaker.getAttackCell().getY() && cell.getX() == wallBreaker.getAttackCell().getX()) {

                                        wallBreaker.setTarget(findTarget(wallBreaker, targets, Constants.getWallBreakerRange()));

                                        wallBreaker.getTarget().damage(wallBreaker.getDamagePerHit());
                                        if (wallBreaker.getTarget().getHealth() <= 0) {
                                            point += wallBreaker.getTarget().getDistructionEarnedPoint();
                                            gold += wallBreaker.getTarget().getGoldCost();
                                            elixir += wallBreaker.getTarget().getElixirCost();

                                            if (wallBreaker.getTarget().getType() == 5) {
                                                gold += 1000;
                                                elixir += 500;
                                            }
                                            if (wallBreaker.getTarget().getType() == 3) {
                                                Storage storage = (Storage) (wallBreaker.getTarget());
                                                gold += storage.getResource();
                                            }
                                            if (wallBreaker.getTarget().getType() == 4) {
                                                Storage storage = (Storage) (wallBreaker.getTarget());
                                                elixir += storage.getResource();
                                            }
                                        }
                                        wallBreaker.setHealth(-1);

                                    }
                                }

                            }
                        }
                    }
                }
                if(j<Constants.getDragonSpeed()) {
                    for (Dragon dragon : dragons) {
                        if(!dragon.isDamaging) {
                            ArrayList<Cell> dess = processCells(getBuildingss(gameDefender.getAllBuildings()), Constants.getDragonRange());

                            dragon.setDirection(gameDefender.getMap().move(dragon.getAttackCell(), dess, Situation.AIR));
                            if (dragon.getDirection() == Direction.REACHED) {
                                dragon.isDamaging = true;
                                for (Cell cell : gameDefender.getMap().getMap()) {
                                    if (cell.getY() == dragon.getAttackCell().getY() && cell.getX() == dragon.getAttackCell().getX()) {

                                        dragon.setTarget(findTarget(dragon, getBuildingss(gameDefender.getAllBuildings()), Constants.getDragonRange()));

                                        dragon.getTarget().damage(dragon.getDamagePerHit());
                                        if (dragon.getTarget().getHealth() <= 0) {
                                            point += dragon.getTarget().getDistructionEarnedPoint();
                                            gold += dragon.getTarget().getGoldCost();
                                            elixir += dragon.getTarget().getElixirCost();

                                            if (dragon.getTarget().getType() == 5) {
                                                gold += 1000;
                                                elixir += 500;
                                            }
                                            if (dragon.getTarget().getType() == 3) {
                                                Storage storage = (Storage) (dragon.getTarget());
                                                gold += storage.getResource();
                                            }
                                            if (dragon.getTarget().getType() == 4) {
                                                Storage storage = (Storage) (dragon.getTarget());
                                                elixir += storage.getResource();
                                            }
                                        }

                                    }
                                }

                            }
                        }
                    }
                }
                if(j<Constants.getHealerSpeed()) {

                    for (Healer healer : healers) {
                        if(!healer.isDamaging) {
                            if (j == Constants.getHealerSpeed() - 1) {
                                healer.setHealingtime(healer.getHealingtime() - 1);
                            }
                            ArrayList<Cell> soldierCells = new ArrayList<>();
                            for (Guardian guardian : guardians) {
                                soldierCells.add(guardian.getAttackCell());
                            }
                            for (Archer archer : archers) {
                                soldierCells.add(archer.getAttackCell());
                            }
                            for (Dragon dragon : dragons) {
                                soldierCells.add(dragon.getAttackCell());
                            }
                            for (Giant giant : giants) {
                                soldierCells.add(giant.getAttackCell());
                            }
                            for (WallBreaker wallBreaker : wallBreakers) {
                                soldierCells.add(wallBreaker.getAttackCell());
                            }
                            ArrayList<Cell> dess = processCells(soldierCells, Constants.getHealerRange());
                            healer.setDirection(gameDefender.getMap().move(healer.getAttackCell(), dess, Situation.AIR));
                            if (healer.getDirection() == Direction.REACHED) {

                                healer.isDamaging = true;
                                healer.setHealingtime(healer.getHealingtime() - 1);
                                for (Cell cell : gameDefender.getMap().getMap()) {
                                    if (cell.getY() == healer.getAttackCell().getY() && cell.getX() == healer.getAttackCell().getX()) {

                                        for (Guardian guardian : guardians) {
                                            if (findDistance(guardian.getAttackCell(), healer.getAttackCell()) <= healer.getRange() * healer.getRange()&&guardian.getHealth()<=Constants.getGuardianHealth()) {
                                                guardian.decraseHealth(-1 * healer.getHealingQuantity());

                                            }
                                        }
                                        for (Archer archer : archers) {
                                            if (findDistance(archer.getAttackCell(), healer.getAttackCell()) <= healer.getRange() * healer.getRange()) {
                                                archer.decraseHealth(-1 * healer.getHealingQuantity());

                                            }
                                        }
                                        for (WallBreaker wallBreaker : wallBreakers) {
                                            if (findDistance(wallBreaker.getAttackCell(), healer.getAttackCell()) <= healer.getRange() * healer.getRange()) {
                                                wallBreaker.decraseHealth(-1 * healer.getHealingQuantity());

                                            }
                                        }
                                        for (Giant giant : giants) {
                                            if (findDistance(giant.getAttackCell(), healer.getAttackCell()) <= healer.getRange() * healer.getRange()) {
                                                giant.decraseHealth(-1 * healer.getHealingQuantity());

                                            }
                                        }
                                        for (Dragon dragon : dragons) {
                                            if (findDistance(dragon.getAttackCell(), healer.getAttackCell()) <= healer.getRange() * healer.getRange()) {
                                                dragon.decraseHealth(-1 * healer.getHealingQuantity());

                                            }
                                        }


                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        if(time > 10000 || (gold == totalGold && elixir == totalElixir) || (possElixir <= elixir && possGold <= gold)||(wallBreakers.size()+guardians.size()+archers.size()+giants.size()+dragons.size()==0)||checkBuildings()){
            endGame();

            return;
        }
    }
    public void graphicalPassTime(){
        for (Guardian guardian : guardians) {
            guardian.graphicalPassTime();
        }
        for (Archer archer : archers) {
            archer.graphicalPassTime();
        }
        for (Giant giant : giants) {
            giant.graphicalPassTime();
        }
        for (WallBreaker wallBreaker : wallBreakers) {
            wallBreaker.graphicalPassTime();
        }
        for (Healer healer : healers) {
            healer.graphicalPassTime();
        }
        for (Dragon dragon : dragons) {
            dragon.graphicalPassTime();
        }
        if(guardianGiant!=null) {
            guardianGiant.graphicalPassTime();
        }
    }
    public void movePassTime(){
        for (Guardian guardian : guardians) {
            guardian.passTime();
            guardian.sync();
        }
        for (Archer archer : archers) {
            archer.passTime();
            archer.sync();
        }
        for (Giant giant : giants) {
            giant.passTime();
            giant.sync();
        }
        for (Healer healer : healers) {
            healer.passTime();
            healer.sync();
        }
        for (Dragon dragon : dragons) {
            dragon.passTime();
            dragon.sync();
        }
    }

    private ArrayList<Cell> getBuildingss(ArrayList<ArrayList<Cell>> allBuildings){
        ArrayList<Cell> all=new ArrayList<>();
        for (ArrayList<Cell> allBuilding : allBuildings) {
            for (Cell cell : allBuilding) {
                if(cell.getBuilding().getHealth()>0&&!(all.contains(cell))) {

                    all.add(cell);
                }
                else{
                    cell.setFree(true);

                }
            }
        }

        return all;
    }

    public int getGold() {
        return gold;
    }

    public int getElixir() {
        return elixir;
    }

    public int getPoint() {
        return point;
    }

    public void achievement(){
        gui.achivement(gold,elixir,point);
    }

    public void endGame(){
        ArrayList<Cell> cells=gameAttacker.getCamps();
        ArrayList<Camp> camps=new ArrayList<>();
        for (Cell cell : cells) {
            camps.add((Camp) cell.getBuilding());
        }
        for (Camp camp : camps) {
            int size=camp.getDragons().size()+camp.getGiants().size()+camp.getArchers().size()+camp.getGuardians().size();
            while(size<camp.getCapacity()){
                if(guardians.size()>0) {
                    camp.backSoldier(guardians.get(0));
                    guardians.remove(0);
                }
                else if(giants.size()>0){
                    camp.backSoldier(giants.get(0));
                    giants.remove(0);
                }
                else if(dragons.size()>0){
                    camp.backSoldier(dragons.get(0));
                    dragons.remove(0);
                }
                else if(archers.size()>0){
                    camp.backSoldier(archers.get(0));
                    archers.remove(0);
                }
                else if(wallBreakers.size()>0){
                    camp.backSoldier(wallBreakers.get(0));
                    wallBreakers.remove(0);
                }
                else if(healers.size()>0){
                    camp.backSoldier(healers.get(0));
                    healers.remove(0);
                }
                else {
                    break;
                }
            }

        }
        for (Cell cell : getBuildingss(gameDefender.getAllBuildings())) {
            if (cell.getBuilding().getHealth()<=0) {
                cell.getBuilding().setHealth(cell.getBuilding().getStability());

            }
        }
        gameAttacker.attackFillStorage(gold,gameAttacker.getGoldStorages());
        gameAttacker.attackFillStorage(elixir,gameAttacker.getElixirStorages());
        gameDefender.emptyStorage(gold,gameDefender.getGoldStorages());
        gameDefender.emptyStorage(elixir,gameDefender.getElixirStorages());
        gui.end(gold,elixir,point);

    }
    private ArrayList<Cell> processCells(ArrayList<Cell> cells, int range){
        ArrayList<Cell> rangeCells=new ArrayList<>();
        for (Cell cell : gameDefender.getMap().getMap()) {
            for (Cell cell1 : cells) {
                if(findDistance(cell,cell1)<=(range*range) ){
                    if(!rangeCells.contains(cell)){
                        rangeCells.add(cell);
                    }
                }
            }

        }
        return rangeCells;

    }
    private int findDistance(Cell cellDes,Cell cellStart){
        return (cellDes.getX()-cellStart.getX())*(cellDes.getX()-cellStart.getX())+(cellDes.getY()-cellStart.getY())*(cellDes.getY()-cellStart.getY());
    }
    private void updateCells(){
        for (Cell cell : gameDefender.getMap().getMap()) {
            cell.removeSoldiers();
            for (Guardian guardian : guardians) {
                if(guardian.getAttackCell()!=null) {
                    if (guardian.getAttackCell().getX() == cell.getX() && guardian.getAttackCell().getY() == cell.getY()) {
                        cell.addSoldierNorm(guardian);
                    }
                }
            }
            for (Archer archer : archers) {
                if(archer.getAttackCell()!=null) {
                    if (archer.getAttackCell().getX() == cell.getX() && archer.getAttackCell().getY() == cell.getY()) {
                        cell.addSoldierNorm(archer);
                    }
                }
            }
            for (WallBreaker wallBreaker : wallBreakers) {
                if(wallBreaker.getAttackCell()!=null) {
                    if (wallBreaker.getAttackCell().getX() == cell.getX() && wallBreaker.getAttackCell().getY() == cell.getY()) {
                        cell.addSoldierNorm(wallBreaker);
                    }
                }
            }
            for (Healer healer : healers) {
                if(healer.getAttackCell()!=null) {
                    if (healer.getAttackCell().getX() == cell.getX() && healer.getAttackCell().getY() == cell.getY()) {
                        cell.addSoldierNorm(healer);
                    }
                }
            }
            for (Dragon dragon : dragons) {
                if(dragon.getAttackCell()!=null) {
                    if (dragon.getAttackCell().getX() == cell.getX() && dragon.getAttackCell().getY() == cell.getY()) {
                        cell.addSoldierNorm(dragon);
                    }
                }
            }
            for (Giant giant : giants) {
                if(giant.getAttackCell()!=null) {
                    if (giant.getAttackCell().getX() == cell.getX() && giant.getAttackCell().getY() == cell.getY()) {
                        cell.addSoldierNorm(giant);
                    }
                }
            }
        }
    }
    private Building findTarget(Soldier soldier, ArrayList<Cell> cells, int range){
        for (Cell cell : cells) {
            if(cell.getBuilding().getHealth()>0&&findDistance(cell,soldier.getAttackCell())<=range*range){
                return cell.getBuilding();
            }
        }
        return null;
    }
    private ArrayList<Cell> removeDistructed(ArrayList<Cell> cells){
        ArrayList<Cell> targets=new ArrayList<>();
        for (Cell cell : cells) {
            if(cell.getBuilding().getHealth()>0){
                targets.add(cell);
            }
        }
        return targets;
    }
    private boolean checkBuildings(){
        for (Cell cell : getBuildingss(gameDefender.getAllBuildings())) {
            if(cell.getBuilding().getHealth()>0){
                return false;
            }
        }
        return true;
    }
    public int aliveSoldiers(){
        return totalSoldiers-(guardians.size()+healers.size()+dragons.size()+giants.size()+archers.size()+wallBreakers.size());
    }

    public Game getGameDefender() {
        return gameDefender;
    }
}
