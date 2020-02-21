package controllers;

import Exceptions.*;
import attack.Soldier;
import attack.Type;
import attack.soldiers.*;
import building.*;
import javafx.scene.image.Image;
import map.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuController {
    private Game g;
    private GameGUI gui;
    private Building building;
    private Cell cell;

    public MenuController(Game g, GameGUI gui){
        this.g = g;
        this.gui = gui;
    }
    public Building findBuilding(int i, int j){
        int n = i + j*Constants.MAP_WIDTH;
        cell = g.getMap().getMap().get(n);
        if(cell.isFree()){
            building = null;

        }
        else if(!cell.isFree()){
            if(cell.getBuilding() instanceof Stuff){
                building = cell.getBuilding();
            }
            else{
                building = cell.getBuilding();
            }
        }
        return building;
    }

    public Image getImage(){
        try {
            return ((HashMap<Integer, Image>) Images.class.getMethod("getLevelImage" + building.getClass().getSimpleName()).invoke(Images.class)).get(building.getLevel());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
     public String getHealth(){
        return building.getHealth().toString();
     }
     public String getLevel(){
        return building.getLevel().toString();
     }

    public String getCost(){
        return building.getGoldCost().toString();
    }

    public void upgrade() throws TownHallIsntAvailable, DontHaveEnoughResourceExp, TownHallLevelUpgradeNeeded, DontHaveAnyBuilderExp {
            g.upgrade(building);
            g.spendGold(building.getUpgradeGoldCost());
        gui.checkElixirAmount();
        gui.checkGoldAmount();


    }

    public String mainBuildingStatus() {
        String name = new String();
        for (Building building : g.getUpgradedBuildings()){
            name = name + building.getName()+":   "  + (building.getBuildOrUpgradeTime()-building.getPassedBuildingTime())+"\n";
        }
        return name;
    }

    public ArrayList<String> available(){
        ArrayList<String> s = new ArrayList<>();
        int n = 1;
        for(Map.Entry<String,java.util.Map.Entry<Integer, Integer>> entrySet : g.getPossibleBuildings().entrySet()){
            if(entrySet.getValue().getKey() > g.getTotalGold() || entrySet.getValue().getValue() > g.getTotalElixir()) {
//                v.printMainBuildingAvailable(entrySet.getKey(), n);
                s.add(entrySet.getKey());
            }
        }
        return s;
    }

    public String getGoldCost(String k){
       return g.getPossibleBuildings().get(k).getKey().toString();
    }
    public String getElixirCost(String k){
        return g.getPossibleBuildings().get(k).getValue().toString();
    }
    public void mainBuldingAvailableBuildings(String name, String k) throws DontHaveAnyBuilderExp, DontHaveEnoughResourceExp, FullCellExp {
        TownHall townHall = (TownHall) g.getTownHalls().get(0).getBuilding();


            if (townHall.isFreeBuilder()) {
                    build(name, g.getPossibleBuildings().get(k).getKey(), g.getPossibleBuildings().get(k).getValue());
            }
            else
                throw new DontHaveAnyBuilderExp();

    }

    public void mineMine(){
        if(building.getName().equalsIgnoreCase("elixir mine"))
            g.fillStorage(building, g.getElixirStorages());
        else if(building.getName().equalsIgnoreCase("gold mine"))
            g.fillStorage(building, g.getGoldStorages());
        gui.checkElixirAmount();
        gui.checkGoldAmount();
    }


    public ArrayList<String> defenceTarget() {
        DefenseTower defenseTower = null;
        if(building instanceof DefenseTower) {
            defenseTower = (DefenseTower) building;

        }
        else if(building instanceof GiantCastle){
            defenseTower = ((GiantCastle)building).getGuardianGiant();
        }
        ArrayList<String> targets = new ArrayList<>();
        makeTarget(defenseTower, targets);
        return  targets;
    }

    public String barracksStatus() {
        Barracks barracks = (Barracks) building;
        String name = new String();
        for (Soldier soldier : barracks.getSoldiers()) {
            if (soldier.getTypee().equals(Type.DRAGON))
                name= name +("Dragon:   " + barracks.getTime(soldier).toString()+"\n");
            if (soldier.getTypee().equals(Type.ARCHER))
                name= name +("Archer:   " + barracks.getTime(soldier).toString()+"\n");
            if (soldier.getTypee().equals(Type.GIANT))
                name= name +("Giant:   " +barracks.getTime(soldier).toString()+"\n");
            if (soldier.getTypee().equals(Type.GUARDIAN))
                name= name +("Guardian:   " + barracks.getTime(soldier).toString()+"\n");
            if (soldier.getTypee().equals(Type.HEALER))
                name= name +("Healer:   " + barracks.getTime(soldier).toString()+"\n");
            if (soldier.getTypee().equals(Type.WALLBREAKER))
                name= name +("WallBreaker:   " + barracks.getTime(soldier).toString()+"\n");
        }
        return name;
    }

    public HashMap<String, Integer> getNumbers(){
        HashMap<String, Integer> quantity = new HashMap<>();
        int number = 0;
        boolean flag = false;
        for(Map.Entry<String , Integer> s : g.getPossibleSoldiers().entrySet()){
            number = g.getTotalElixir()/ s.getValue();
            if(s.getKey().equalsIgnoreCase("Dragon")){
                if(g.getTownHalls().get(0).getBuilding().getLevel() < 2){
                    number = 0;
                }
            }
            quantity.put(s.getKey() , number);
        }
        return quantity;
    }

    public void barracksBuildSoldier(String enteryNumber,Integer quantity, String entery) throws  DontHaveEnoughResourceExp{
        if(Integer.parseInt(enteryNumber) > quantity) {
            throw new DontHaveEnoughResourceExp();

        }
        Barracks barracks = (Barracks) building;
        for (int i = 0; i <Integer.parseInt(enteryNumber)  ; i++) {

            if (entery.equalsIgnoreCase("Archer")) {
                Archer archer = new Archer(building.getLevel());
                g.spendElixir(Constants.getArcherCost());
                gui.checkElixirAmount();
                gui.checkGoldAmount();
                barracks.buildSoldier(archer);

            }
            else if (entery.equalsIgnoreCase("Dragon")) {
                Dragon dragon = new Dragon(building.getLevel());
                g.spendElixir(Constants.getDragonCost());
                gui.checkElixirAmount();
                gui.checkGoldAmount();
                barracks.buildSoldier(dragon);

            }
            else if (entery.equalsIgnoreCase("Giant")) {
                Giant giant = new Giant(building.getLevel());
                g.spendElixir(Constants.getGiantCost());
                gui.checkElixirAmount();
                gui.checkGoldAmount();
                barracks.buildSoldier(giant);

            }
            else if (entery.equalsIgnoreCase("Guardian")) {
                Guardian guardian = new Guardian(building.getLevel());
                g.spendElixir(Constants.getGuardianCost());
                gui.checkElixirAmount();
                gui.checkGoldAmount();
                barracks.buildSoldier(guardian);
            }
            else if (entery.equalsIgnoreCase("WallBreaker")) {
                WallBreaker wallBreaker = new WallBreaker(building.getLevel());
                g.spendElixir(Constants.getWallBreakerCost());
                gui.checkElixirAmount();
                gui.checkGoldAmount();
                barracks.buildSoldier(wallBreaker);
            }
            else if (entery.equalsIgnoreCase("Healer")) {
                Healer healer = new Healer(building.getLevel());
                g.spendElixir(Constants.getHealerCost());
                gui.checkElixirAmount();
                gui.checkGoldAmount();
                barracks.buildSoldier(healer);
            }
        }

    }

    public ArrayList<String> campCapacity(){
        ArrayList<String> s= new ArrayList<>();
        Integer numberOfSoldiers = 0;
        Integer capacity = 0;
        for (Cell cell : g.getCamps()){
            Camp camp;
            camp = (Camp)cell.getBuilding();
            numberOfSoldiers = numberOfSoldiers + camp.getNumberOfSodiers();
            capacity = capacity + camp.getCapacity();
        }
        s.add(numberOfSoldiers.toString());
        s.add(capacity.toString());
        return s;
    }


    public String getArcher(){
        Camp camp;
        camp =(Camp)building;
        String s = new String();
        s = "Archer X " + (camp.getArchers().size());
        return s;
    }
    public String getDragoons(){
        Camp camp;
        camp =(Camp)building;
        String s = new String();
        s = "Dragoon X " + (camp.getDragons().size());
        return s;
    }
    public String getGiants(){
        Camp camp;
        camp =(Camp)building;
        String s = new String();
        s = "Giant X " + (camp.getGiants().size());
        return s;
    }
    public String getGuardians(){
        Camp camp;
        camp =(Camp)building;
        String s = new String();
        s = "Guardian X " + (camp.getGuardians().size());
        return s;
    }
    public String getHealer(){
        Camp camp;
        camp =(Camp)building;
        String s = new String();
        s = "Healer X " + (camp.getHealers().size());
        return s;
    }public String getWallBreaker(){
        Camp camp;
        camp =(Camp)building;
        String s = new String();
        s = "WallBreaker X " + (camp.getWallBreakers().size());
        return s;
    }

    public String storageSource(){
        String s = new String();
        int sourceAmount = 0;
        int capacity = 0;
        if(building.getName().equalsIgnoreCase("Gold storage")){
            for (Cell cell : g.getGoldStorages()){
                Storage storage;
                storage = (Storage) cell.getBuilding();
                sourceAmount = sourceAmount + storage.getResource();
                capacity = capacity + storage.getCapacity();
            }
            s ="Your Gold Storage storage \n is "+sourceAmount+" / "+capacity+" loaded.";
        }
        if(building.getName().equalsIgnoreCase("Elixir storage")){
            for (Cell cell : g.getElixirStorages()){
                Storage storage;
                storage = (Storage) cell.getBuilding();
                sourceAmount = sourceAmount + storage.getResource();
                capacity = capacity + storage.getCapacity();
            }
            s ="Your Elixir Storage storage \n is "+sourceAmount+" / "+capacity+" loaded.";
        }
        return s;
    }

    private void build(String name, int gold, int elixir) throws  FullCellExp, DontHaveAnyBuilderExp,DontHaveEnoughResourceExp {
        if( gold <= g.getTotalGold() && elixir <= g.getTotalElixir()) {


            g.newBuilding(name, cell.getX(), cell.getY());
            g.spendGold(gold);
            g.spendElixir(elixir);
            gui.checkElixirAmount();
            gui.checkGoldAmount();
        }
        else {
            throw new DontHaveEnoughResourceExp();
        }
    }

    public void passTime(int n){
        for(int i = 0 ; i < n ;i++) {
            g.passTime();
        }
    }


    public void makeTarget(DefenseTower defenseTower, ArrayList<String> targets) {
        if(defenseTower.isAirDef()){
            targets.add("Dragon");
        }
        if(defenseTower.isGroundDef()){
            targets.add("Archer");
            targets.add("Guardian");
            targets.add("Giant");
        }
    }
}
