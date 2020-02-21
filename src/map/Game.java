package map;

import Exceptions.*;
import attack.attackStreaming.Event;
import building.*;
import server.AttackRecord;
import udp.Sender;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static map.Constants.MAP_HEGHT;
import static map.Constants.MAP_WIDTH;

public class Game extends Thread implements Serializable{
    private Map map = new Map();
    private ArrayList<Cell> goldMines = new ArrayList<>();
    private ArrayList<Cell> elixirMines = new ArrayList<>();
    private ArrayList<Cell> goldStorages = new ArrayList<>();
    private ArrayList<Cell> elixirStorages = new ArrayList<>();

    private ArrayList<Cell> townHalls = new ArrayList<>();

    private ArrayList<Cell> barrackss = new ArrayList<>();
    private ArrayList<Cell> camps = new ArrayList<>();

    private ArrayList<Cell> archerTowers = new ArrayList<>();
    private ArrayList<Cell> cannons = new ArrayList<>();
    private ArrayList<Cell> airDefenses = new ArrayList<>();
    private ArrayList<Cell> wizardTowers = new ArrayList<>();
    private ArrayList<Cell> walls = new ArrayList<>();
    private ArrayList<Cell> traps = new ArrayList<>();

    private GuardianGiant guardianGiant=null;

    private ArrayList<Building> upgradedBuildings=new ArrayList<>();
    private ArrayList<ArrayList<Cell>> allBuildings = new ArrayList<>();

    private ArrayList<Cell> giantCastles = new ArrayList<>();

    private LinkedHashMap<String, java.util.Map.Entry<Integer, Integer>> possibleBuildings = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> possibleSoldiers = new LinkedHashMap<>();

    private int turn = 1 ;
    private int second = 0;
    private int minute = 0;
    private int hour = 0;
    private boolean timeChanged = false;

    private Sender sender ;

    private ArrayList<AttackRecord> attackRecords = new ArrayList<>();

    private boolean attacked = false;

    @Override
    public void run() {
        while (true)
        {
            if (!attacked)
                passTime();
            try {
                sleep(1000 / turn);
                nextSecond();
                timeChanged = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void nextSecond()
    {
        if (second < 59)
            second++;
        else
        {
            second = 0;
            if (minute < 59)
                minute++;
            else {
                minute = 0;
                hour++;
            }
        }
    }

    public Game(){
        allBuildings.add(airDefenses);
        allBuildings.add(archerTowers);
        allBuildings.add(barrackss);
        allBuildings.add(camps);
        allBuildings.add(cannons);
        allBuildings.add(elixirMines);
        allBuildings.add(elixirStorages);
        allBuildings.add(goldMines);
        allBuildings.add(goldStorages);
        allBuildings.add(townHalls);
        allBuildings.add(wizardTowers);
        allBuildings.add(walls);
        allBuildings.add(traps);
        allBuildings.add(giantCastles);

        possibleBuildings.put("1",new AbstractMap.SimpleEntry<>(DefenseConstants.AIR_DEFENSE_GOLD_COST,DefenseConstants.AIR_DEFENSE_ELIXIR_COST));
        possibleBuildings.put("2",new AbstractMap.SimpleEntry<>(DefenseConstants.ARCHERTOWER_GOLD_COST,DefenseConstants.ARCHERTOWER_ELIXIR_COST));
        possibleBuildings.put("3",new AbstractMap.SimpleEntry<>(BuildingConstants.barracksGoldCost,BuildingConstants.barracksElixirCost));
        possibleBuildings.put("4",new AbstractMap.SimpleEntry<>(BuildingConstants.campGoldCost,BuildingConstants.campElixirCost));
        possibleBuildings.put("5",new AbstractMap.SimpleEntry<>(DefenseConstants.CANNON_GOLD_COST,DefenseConstants.CANNON_ELIXIR_COST));
        possibleBuildings.put("6",new AbstractMap.SimpleEntry<>(BuildingConstants.ELIXIR_MINE_GOLD_COST,BuildingConstants.ELIXIR_MINE_ELIXIR_COST));
        possibleBuildings.put("7",new AbstractMap.SimpleEntry<>(BuildingConstants.STORAGE_GOLD_COST,BuildingConstants.STORAGE_ELIXIR_COST));
        possibleBuildings.put("8",new AbstractMap.SimpleEntry<>(DefenseConstants.GIANT_CASTLE_GOLD_COST,DefenseConstants.GIANT_CASTLE_ELIXIR_COST));
        possibleBuildings.put("9",new AbstractMap.SimpleEntry<>(BuildingConstants.GOLD_MINE_GOLD_COST,BuildingConstants.GOLD_MINE_ELIXIR_COST));
        possibleBuildings.put("10",new AbstractMap.SimpleEntry<>(BuildingConstants.STORAGE_GOLD_COST,BuildingConstants.STORAGE_ELIXIR_COST));
        possibleBuildings.put("11",new AbstractMap.SimpleEntry<>(DefenseConstants.TRAP_GOLD_COST,DefenseConstants.TRAP_ELIXIR_COST));
        possibleBuildings.put("12",new AbstractMap.SimpleEntry<>(BuildingConstants.WALL_GOLD_COST,BuildingConstants.WALL_ELIXIR_COST));
        possibleBuildings.put("13",new AbstractMap.SimpleEntry<>(DefenseConstants.WIZARDTOWER_GOLD_COST,DefenseConstants.WIZARDTOWER_ELIXIR_COST));

        possibleSoldiers.put("archer", Constants.getArcherCost());
        possibleSoldiers.put("dragon", Constants.getDragonCost());
        possibleSoldiers.put("giant", Constants.getGiantCost());
        possibleSoldiers.put("guardian", Constants.getGuardianCost());
        possibleSoldiers.put("healer", Constants.getHealerCost());
        possibleSoldiers.put("wall breaker", Constants.getWallBreakerCost());

        buildTownHall();
        buildPremitiveGoldMine();
        buildPremitiveStorages(new GoldStorage(Constants.GOLD_STORAGE_PREMITIVE_X, Constants.GOLD_STORAGE_PREMITIVE_Y)
                , goldStorages, BuildingConstants.GOLD_STORAGE_CAPACITY);
        buildPremitiveStorages(new ElixirStorage(Constants.ELIXIR_STORAGE_PREMITIVE_X, Constants.ELIXIR_STORAGE_PREMITIVE_Y)
                , elixirStorages, BuildingConstants.ELIXIR_STORAGE_CAPACITY);

        setStuffs(Constants.PRECIPICES, Precipice.class);
        setStuffs(Constants.RIVER, River.class);
        setStuffs(Constants.TREES, Tree.class);
        setStuffs(Constants.VOLCANOS, Volcano.class);
    }

    private void buildTownHall()
    {
        TownHall townHall = new TownHall(Constants.TOWN_HALL_PREMITIVE_X, Constants.TOWN_HALL_PREMITIVE_Y);
        townHall.setAvailable(true);
        map.getMap().get(Constants.TOWN_HALL_PREMITIVE_Y * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X).setBuilding(townHall);
        townHalls.add(map.getMap().get(Constants.TOWN_HALL_PREMITIVE_Y * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X));
        map.getMap().get(Constants.TOWN_HALL_PREMITIVE_Y * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X + 1).setBuilding(townHall);
        townHalls.add(map.getMap().get(Constants.TOWN_HALL_PREMITIVE_Y * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X + 1));
        map.getMap().get((Constants.TOWN_HALL_PREMITIVE_Y + 1) * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X).setBuilding(townHall);
        townHalls.add(map.getMap().get((Constants.TOWN_HALL_PREMITIVE_Y + 1) * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X));
        map.getMap().get((Constants.TOWN_HALL_PREMITIVE_Y + 1) * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X + 1).setBuilding(townHall);
        townHalls.add(map.getMap().get((Constants.TOWN_HALL_PREMITIVE_Y + 1) * MAP_WIDTH + Constants.TOWN_HALL_PREMITIVE_X + 1));

    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Sender getSender() {
        return sender;
    }

    private void buildPremitiveStorages(Storage storage, ArrayList<Cell> buildings, int capacity)
    {
        storage.setAvailable(true);
        storage.fillStorage(capacity);
        map.getMap().get(storage.getY() * MAP_WIDTH + storage.getX()).setBuilding(storage);
        buildings.add(map.getMap().get(storage.getY() * MAP_WIDTH + storage.getX()));

    }

    private void buildPremitiveGoldMine()
    {
        GoldMine goldMine = new GoldMine(Constants.GOLD_MINE_PREMITIVE_X, Constants.GOLD_MINE_PREMITIVE_Y);
        goldMine.setAvailable(true);
        map.getMap().get(Constants.GOLD_MINE_PREMITIVE_Y * MAP_WIDTH + Constants.GOLD_MINE_PREMITIVE_X).setBuilding(goldMine);
        goldMines.add(map.getMap().get(Constants.GOLD_MINE_PREMITIVE_Y * MAP_WIDTH + Constants.GOLD_MINE_PREMITIVE_X));

    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setGoldMines(ArrayList<Cell> goldMines) {
        this.goldMines = goldMines;
    }

    public void setElixirMines(ArrayList<Cell> elixirMines) {
        this.elixirMines = elixirMines;
    }

    public void setGoldStorages(ArrayList<Cell> goldStorages) {
        this.goldStorages = goldStorages;
    }

    public void setElixirStorages(ArrayList<Cell> elixirStorages) {
        this.elixirStorages = elixirStorages;
    }

    public void setTownHalls(ArrayList<Cell> townHalls) {
        this.townHalls = townHalls;
    }

    public void setBarrackss(ArrayList<Cell> barrackss) {
        this.barrackss = barrackss;
    }

    public void setCamps(ArrayList<Cell> camps) {
        this.camps = camps;
    }

    public void setArcherTowers(ArrayList<Cell> archerTowers) {
        this.archerTowers = archerTowers;
    }

    public void setCannons(ArrayList<Cell> cannons) {
        this.cannons = cannons;
    }

    public void setAirDefenses(ArrayList<Cell> airDefenses) {
        this.airDefenses = airDefenses;
    }

    public void setWizardTowers(ArrayList<Cell> wizardTowers) {
        this.wizardTowers = wizardTowers;
    }

    public void setAllBuildings(ArrayList<ArrayList<Cell>> allBuildings) {
        this.allBuildings = allBuildings;
    }

    public HashMap<String, java.util.Map.Entry<Integer, Integer>> getPossibleBuildings() {
        return possibleBuildings;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ArrayList<Cell> getGoldMines() {
        return goldMines;
    }

    public ArrayList<Cell> getElixirMines() {
        return elixirMines;
    }

    public ArrayList<Cell> getGoldStorages() {
        return goldStorages;
    }

    public ArrayList<Cell> getElixirStorages() {
        return elixirStorages;
    }

    public ArrayList<Cell> getTownHalls() {
        return townHalls;
    }

    public ArrayList<Cell> getBarrackss() {
        return barrackss;
    }

    public ArrayList<AttackRecord> getAttackRecords() {
        return attackRecords;
    }

    public ArrayList<Cell> getCamps() {
        return camps;
    }

    public ArrayList<Cell> getArcherTowers() {
        return archerTowers;
    }

    public ArrayList<Cell> getCannons() {
        return cannons;
    }

    public ArrayList<Cell> getAirDefenses() {
        return airDefenses;
    }

    public ArrayList<Cell> getWizardTowers() {
        return wizardTowers;
    }

    public ArrayList<ArrayList<Cell>> getAllBuildings() {
        return allBuildings;
    }

    public void setWalls(ArrayList<Cell> walls) {
        this.walls = walls;
    }

    public ArrayList<Building> getUpgradedBuildings() {
        return upgradedBuildings;
    }

    public HashMap<String, Integer> getPossibleSoldiers() {
        return possibleSoldiers;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean isAttacked() {
        return attacked;
    }

    public void recieveBuildingEvent(Event event)
    {
        allBuildings.get(event.allBuildingsNum).get(event.buildingsNum).getBuilding().setHealth(event.health);
    }

    private void setStuffs(ArrayList<Coordinate> stuffs, Class className)
    {
        try {
            Constructor constructor = className.getDeclaredConstructor(int.class, int.class);
            for (Coordinate coordinate : stuffs) {
                map.getMap().get(coordinate.getY() * MAP_WIDTH + coordinate.getX()).setBuilding((Stuff) constructor.newInstance(coordinate.getX(), coordinate.getY()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getTotalGold() {
        int t = 0;
        for (Cell goldStorage : goldStorages) {
            t += ((GoldStorage) goldStorage.getBuilding()).getResource() ;
        }
        return t;
    }

    public Integer getTotalElixir() {
        int t = 0;
        for (Cell elixirStorage : elixirStorages) {
            t += ((ElixirStorage) elixirStorage.getBuilding()).getResource() ;
        }
        return t;
    }

    public ArrayList<Cell> getWalls() {
        return walls;
    }

    public void upgrade(Building building) throws DontHaveEnoughResourceExp, DontHaveAnyBuilderExp, TownHallIsntAvailable,TownHallLevelUpgradeNeeded{
        if (townHalls.get(0).getBuilding().isAvailable())
            if (((TownHall) townHalls.get(0).getBuilding()).isFreeBuilder()) {
                if ( building.getUpgradeGoldCost() <= getTotalGold()) {
                    if(building.isAvailable())
                         if (building.getType() == 5 || (building.getLevel() < townHalls.get(0).getBuilding().getLevel())) {
                            building.upgrade();
                            ((TownHall) townHalls.get(0).getBuilding()).makeABuilderWork();
                            upgradedBuildings.add(building);
                    }
                    else {
                        throw new TownHallLevelUpgradeNeeded();
                    }
                } else
                    throw new DontHaveEnoughResourceExp();
            } else
                throw new DontHaveAnyBuilderExp();
        else
            throw new TownHallIsntAvailable();

    }

    public void passTime() {

        if(GuardianGiant.isConstructed){
            guardianGiant=GuardianGiant.getInstance(0,0);
        }

        for (ArrayList<Cell> sameBuildings : allBuildings)
            for (Cell cell : sameBuildings)
                if (!cell.getBuilding().isAvailable()) {
                    cell.getBuilding().passedTime();
                    if (cell.getBuilding().isAvailable())
                        ((TownHall) townHalls.get(0).getBuilding()).setABuilderFree();
                }

                for (Cell cell: goldMines)
                    ((GoldMine) cell.getBuilding()).mine();
                for (Cell cell: elixirMines)
                    ((ElixirMine) cell.getBuilding()).mine();
        for (Cell cell1 : barrackss) {
            Barracks barracks= (Barracks) cell1.getBuilding();
            for (Cell cell2 : camps) {
                Camp camp= (Camp) cell2.getBuilding();
                if((camp.getGuardians().size() + camp.getDragons().size() + camp.getArchers().size() + camp.getGiants().size()+camp.getHealers().size()+camp.getWallBreakers().size()) < camp.getCapacity()){
                    barracks.passTime(camp);
                    break;
                }
            }

        }
        upgradedBuildings.removeIf(Building::isAvailable);

    }

    public void fillStorage(Building mine, ArrayList<Cell> storages) {
        int extractedResource =((Mine) mine).getStorage();
        ((Mine) mine).setStorage(0);
        for (Cell cell : storages) {

                if (((Storage) cell.getBuilding()).getFreeSpace() >= extractedResource) {
                    ((Storage) cell.getBuilding()).fillStorage(extractedResource);
                    break;
                } else {
                    extractedResource -= ((Storage) cell.getBuilding()).getFreeSpace();
                    ((Storage) cell.getBuilding()).fillStorage(((Storage) cell.getBuilding()).getFreeSpace());
                }
        }
    }

    public void attackFillStorage(int amount, ArrayList<Cell> storages) {

        for (Cell cell : storages) {

            if (((Storage) cell.getBuilding()).getFreeSpace() >= amount) {
                ((Storage) cell.getBuilding()).fillStorage(amount);
                amount = 0;
                break;
            } else {
                ((Storage) cell.getBuilding()).fillStorage(((Storage) cell.getBuilding()).getFreeSpace());
                amount -= ((Storage) cell.getBuilding()).getFreeSpace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void newBuilding(String className, int x, int y) throws FullCellExp,DontHaveAnyBuilderExp{
        if(!getMap().getMap().get(y * MAP_WIDTH + x).isFree())
            throw new FullCellExp();

        if(x >= MAP_WIDTH-1 || x < 1 || y >= MAP_HEGHT-1 || y < 1)
            throw new FullCellExp();

            try {
                Class building = Class.forName("building." + className);
                Constructor constructor = building.getConstructor(int.class, int.class);
                buildNewBuilding(((Building) constructor.newInstance(x, y)), ((ArrayList<Cell>) Game.class.getMethod("get" + className + "s").invoke(this)));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }

    }

    public boolean isTimeChanged() {
        return timeChanged;
    }

    public void setTimeChanged(boolean timeChanged) {
        this.timeChanged = timeChanged;
    }

    private void buildNewBuilding(Building building, ArrayList<Cell> buildings) throws DontHaveAnyBuilderExp {
        map.getMap().get(building.getY() * MAP_WIDTH + building.getX()).setBuilding(building);
        ((TownHall) townHalls.get(0).getBuilding()).makeABuilderWork();
        buildings.add(map.getMap().get(building.getY() * MAP_WIDTH + building.getX()));
    }

    public void spendGold(int amount)
    {
        for (Cell cell:goldStorages)
        {
            if (((GoldStorage) cell.getBuilding()).getResource() >= amount) {
                ((GoldStorage) cell.getBuilding()).spend(amount);
                return;
            }
            else {
                amount -= ((GoldStorage) cell.getBuilding()).getResource();
                ((GoldStorage) cell.getBuilding()).setResource(0);
            }

        }
        ((TownHall) townHalls.get(0).getBuilding()).spendGold(amount);
    }

    public void spendElixir(int amount)
    {
        for (Cell cell:elixirStorages)
        {
                if (((ElixirStorage) cell.getBuilding()).getResource() >= amount) {
                    ((ElixirStorage) cell.getBuilding()).spend(amount);
                    return;
                } else {
                    amount -= ((ElixirStorage) cell.getBuilding()).getResource();
                    ((ElixirStorage) cell.getBuilding()).setResource(0);
                }
        }
        ((TownHall) townHalls.get(0).getBuilding()).spendElixir(amount);
    }

    public GuardianGiant getGuardianGiant() {
        return guardianGiant;
    }

    public ArrayList<Cell> getTraps() {
        return traps;
    }

    public ArrayList<Cell> getGiantCastles() {
        return giantCastles;
    }

    public String getTime() {
        String time = "";
        time = setTimeDigits(hour, time);
        time += ":";
        time = setTimeDigits(minute, time);
        time += ":";
        time = setTimeDigits(second, time);
        return time;
    }

    private String setTimeDigits(int t, String time)
    {
        if (t / 10 == 0)
            time += "0";
        time += t;
        return time;
    }

    public void importGame(GameTransfer gameTransfer){
        goldMines = gameTransfer.getGoldMines();
        elixirMines = gameTransfer.getElixirMines();
        goldStorages = gameTransfer.getGoldStorages();
        elixirStorages = gameTransfer.getElixirStorages();

        townHalls = gameTransfer.getTownHalls();

        barrackss = gameTransfer.getBarrackss();
        camps = gameTransfer.getCamps();

        archerTowers = gameTransfer.getArcherTowers();
        cannons = gameTransfer.getCannons();
        airDefenses = gameTransfer.getAirDefenses();
        wizardTowers = gameTransfer.getWizardTowers();
        walls = gameTransfer.getWalls();
        traps = gameTransfer.getTraps();

        guardianGiant = gameTransfer.getGuardianGiant();

        allBuildings = gameTransfer.getAllBuildings();

        giantCastles = gameTransfer.getGiantCastles();

        map=gameTransfer.getMap();
    }

    public void emptyStorage(int resource, ArrayList<Cell> storages) {
        for (Cell cell : storages) {
            Storage storage = ((Storage) cell.getBuilding());
            if (storage.getResource() >= resource) {
                storage.spend(resource);
                break;
            } else {
                resource -= storage.getResource();
                storage.spend(storage.getResource());
            }
        }
    }

    public GameTransfer gameTransfer(){
        return new GameTransfer(this);
    }
}