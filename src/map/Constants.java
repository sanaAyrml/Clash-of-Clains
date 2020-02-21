package map;

import building.Building;

import java.util.ArrayList;

public class Constants {
    /*  too in kelas chizayi ke az voroodi mikhunim ro mirizim.
    *   haghighat goft hatman dorost konin.
    *   masalan bara soldier mizan damage ru az ru peyvast nabayd bebinim.az ye file voroodi bayad bekhoonim.
    *   har kas chizi movajeh mishe ke bayad az voroodi khunde beshe ro inja benevise.
    *   badan bayad tu main benevisim ke ina ro set kone az file voroodi
    */
    //unit of measure : cell
    public static final Integer MAP_WIDTH = 19;
    public static final Integer MAP_HEGHT = 12;

    //unit of measure : pixle
    public static final Integer CELL_WIDTH = 88;
    public static final Integer CELL_HEIGHT = 88;


    public static final Integer CellSpeed=5;

    public static Integer TURN_TO_TIME=1;
    static final ArrayList<Coordinate> PRECIPICES = new ArrayList<>();
    static {
        PRECIPICES.add(new Coordinate(6, 1));
        PRECIPICES.add(new Coordinate(5, 2));
        PRECIPICES.add(new Coordinate(4, 4));
        PRECIPICES.add(new Coordinate(3, 4));
        PRECIPICES.add(new Coordinate(2, 4));
        PRECIPICES.add(new Coordinate(1, 4));
        PRECIPICES.add(new Coordinate(0, 4));
        PRECIPICES.add(new Coordinate(6, 2));

    }

    static final ArrayList<Coordinate> TREES = new ArrayList<>();
    static {
        TREES.add(new Coordinate(0, 5));
        TREES.add(new Coordinate(0, 11));
        TREES.add(new Coordinate(1, 11));
        TREES.add(new Coordinate(7, 0));
        TREES.add(new Coordinate(8, 0));
        TREES.add(new Coordinate(16, 0));
        TREES.add(new Coordinate(17, 0));
        TREES.add(new Coordinate(18, 2));
        TREES.add(new Coordinate(18, 3));
        TREES.add(new Coordinate(14, 11));
        TREES.add(new Coordinate(15, 11));
        TREES.add(new Coordinate(16, 10));
    }

    static final ArrayList<Coordinate> VOLCANOS = new ArrayList<>();
    static {
        VOLCANOS.add(new Coordinate(17, 9));
        VOLCANOS.add(new Coordinate(18, 9));
        VOLCANOS.add(new Coordinate(17, 10));
        VOLCANOS.add(new Coordinate(18, 10));
        VOLCANOS.add(new Coordinate(16, 11));
        VOLCANOS.add(new Coordinate(17, 11));
        VOLCANOS.add(new Coordinate(18, 11));
        VOLCANOS.add(new Coordinate(18, 0));

    }

    static final ArrayList<Coordinate> RIVER = new ArrayList<>();
    static {
        RIVER.add(new Coordinate(16, 1));
        RIVER.add(new Coordinate(17, 1));
        RIVER.add(new Coordinate(18, 1));
        RIVER.add(new Coordinate(17, 2));
        RIVER.add(new Coordinate(18, 4));

    }

    static final int GOLD_STORAGE_PREMITIVE_X = 7;
    static final int GOLD_STORAGE_PREMITIVE_Y = 4;

    static final int ELIXIR_STORAGE_PREMITIVE_X = 13;
    static final int ELIXIR_STORAGE_PREMITIVE_Y = 3;

    static final int GOLD_MINE_PREMITIVE_X = 5;
    static final int GOLD_MINE_PREMITIVE_Y = 10;

    static final int TOWN_HALL_PREMITIVE_X = 9;
    static final int TOWN_HALL_PREMITIVE_Y = 5;

    static final int MAX_NUMBER_OF_SOLDIERS = 5;

    static private int guardianHealth=100;
    static private int guardianDamage=10;
    static public int guardianCost=50;
    static private int guardianTime=10;
    static private int guardianRange=1;
    static private int guardianSpeed=1;
    static private int guardianUpHealth=5;
    static private int guardianUpDamage=1;
    static private Building guardianTarget;

    static private int giantHealth=500;
    static private int giantDamage=30;
    static public int giantCost=150;
    static private int giantTime=30;
    static private int giantRange=1;
    static private int giantSpeed=1;
    static private int giantUpHealth=5;
    static private int giantUpDamage=1;
    static private Building giantTarget;

    static private int dragonHealth=700;
    static private int dragonDamage=30;
    static public int dragonCost=200;
    static private int dragonTime=45;
    static private int dragonRange=3;
    static private int dragonSpeed=6;
    static private int dragonUpHealth=5;
    static private int dragonUpDamage=1;
    static private Building dragonTarget;

    static private int archerHealth=100;
    static private int archerDamage=10;
    static public int archerCost=75;
    static private int archerTime=10;
    static private int archerRange=4;
    static private int archerSpeed=2;
    static private int archerUpHealth=5;
    static private int archerUpDamage=1;
    static private Building archerTarget;

    static private int healerHealth=200;
    static private int healerHeal=100;
    static public int healerCost=175;
    static private int healerTime=30;
    static private int healerRange=4;
    static private int healerSpeed=3;
    static private int healerUpHealth=0;
    static private int healerUpHeal=1;
    static private int healerHealingTime=10;

    static private int wallBreakerHealth=100;

    public static int getWallBreakerHealth() {
        return wallBreakerHealth;
    }

    public static int getWallBreakerDamage() {
        return wallBreakerDamage;
    }

    public static int getWallBreakerCost() {
        return wallBreakerCost;
    }

    public static int getWallBreakerTime() {
        return wallBreakerTime;
    }

    public static int getWallBreakerRange() {
        return wallBreakerRange;
    }

    public static int getWallBreakerSpeed() {
        return wallBreakerSpeed;
    }

    public static int getWallBreakerUpHealth() {
        return wallBreakerUpHealth;
    }

    public static int getWallBreakerUpDamage() {
        return wallBreakerUpDamage;
    }

    public static Building getWallBreakerTarget() {
        return wallBreakerTarget;
    }

    static private int wallBreakerDamage=50;
    static public int wallBreakerCost=40;
    static private int wallBreakerTime=10;
    static private int wallBreakerRange=1;
    static private int wallBreakerSpeed=6;
    static private int wallBreakerUpHealth=5;
    static private int wallBreakerUpDamage=1;
    static private Building wallBreakerTarget;

    static private int mapSizeX=19;
    static private int mapSizeY=12;

    static private int soldierUoTime=0;

    public static int getSoldierUoTime() {
        return soldierUoTime;
    }

    public static void setSoldierUoTime(int soldierUoTime) {
        Constants.soldierUoTime = soldierUoTime;
    }

    public static Integer getMapWidth() {
        return MAP_WIDTH;
    }

    public static Integer getMapHeght() {
        return MAP_HEGHT;
    }

    public static int getGuardianHealth() {
        return guardianHealth;
    }

    public static void setGuardianHealth(int guardianHealth) {
        Constants.guardianHealth = guardianHealth;
    }

    public static int getGuardianDamage() {
        return guardianDamage;
    }

    public static void setGuardianDamage(int guardianDamage) {
        Constants.guardianDamage = guardianDamage;
    }

    public static int getGuardianCost() {
        return guardianCost;
    }

    public static void setGuardianCost(int guardianCost) {
        Constants.guardianCost = guardianCost;
    }

    public static int getGuardianTime() {
        return guardianTime;
    }

    public static void setGuardianTime(int guardianTime) {
        Constants.guardianTime = guardianTime;
    }

    public static int getGuardianRange() {
        return guardianRange;
    }

    public static void setGuardianRange(int guardianRange) {
        Constants.guardianRange = guardianRange;
    }

    public static int getGuardianSpeed() {
        return guardianSpeed;
    }

    public static void setGuardianSpeed(int guardianSpeed) {
        Constants.guardianSpeed = guardianSpeed;
    }

    public static int getGuardianUpHealth() {
        return guardianUpHealth;
    }

    public static void setGuardianUpHealth(int guardianUpHealth) {
        Constants.guardianUpHealth = guardianUpHealth;
    }

    public static int getGuardianUpDamage() {
        return guardianUpDamage;
    }

    public static void setGuardianUpDamage(int guardianUpDamage) {
        Constants.guardianUpDamage = guardianUpDamage;
    }

    public static Building getGuardianTarget() {
        return guardianTarget;
    }

    public static void setGuardianTarget(Building guardianTarget) {
        Constants.guardianTarget = guardianTarget;
    }

    public static int getGiantHealth() {
        return giantHealth;
    }

    public static void setGiantHealth(int giantHealth) {
        Constants.giantHealth = giantHealth;
    }

    public static int getGiantDamage() {
        return giantDamage;
    }

    public static void setGiantDamage(int giantDamage) {
        Constants.giantDamage = giantDamage;
    }

    public static int getGiantCost() {
        return giantCost;
    }

    public static void setGiantCost(int giantCost) {
        Constants.giantCost = giantCost;
    }

    public static int getGiantTime() {
        return giantTime;
    }

    public static void setGiantTime(int giantTime) {
        Constants.giantTime = giantTime;
    }

    public static int getGiantRange() {
        return giantRange;
    }

    public static void setGiantRange(int giantRange) {
        Constants.giantRange = giantRange;
    }

    public static int getGiantSpeed() {
        return giantSpeed;
    }

    public static void setGiantSpeed(int giantSpeed) {
        Constants.giantSpeed = giantSpeed;
    }

    public static int getGiantUpHealth() {
        return giantUpHealth;
    }

    public static void setGiantUpHealth(int giantUpHealth) {
        Constants.giantUpHealth = giantUpHealth;
    }

    public static int getGiantUpDamage() {
        return giantUpDamage;
    }

    public static void setGiantUpDamage(int giantUpDamage) {
        Constants.giantUpDamage = giantUpDamage;
    }

    public static Building getGiantTarget() {
        return giantTarget;
    }

    public static void setGiantTarget(Building giantTarget) {
        Constants.giantTarget = giantTarget;
    }

    public static int getDragonHealth() {
        return dragonHealth;
    }

    public static void setDragonHealth(int dragonHealth) {
        Constants.dragonHealth = dragonHealth;
    }

    public static int getDragonDamage() {
        return dragonDamage;
    }

    public static void setDragonDamage(int dragonDamage) {
        Constants.dragonDamage = dragonDamage;
    }

    public static int getDragonCost() {
        return dragonCost;
    }

    public static void setDragonCost(int dragonCost) {
        Constants.dragonCost = dragonCost;
    }

    public static int getDragonTime() {
        return dragonTime;
    }

    public static void setDragonTime(int dragonTime) {
        Constants.dragonTime = dragonTime;
    }

    public static int getDragonRange() {
        return dragonRange;
    }

    public static void setDragonRange(int dragonRange) {
        Constants.dragonRange = dragonRange;
    }

    public static int getDragonSpeed() {
        return dragonSpeed;
    }

    public static void setDragonSpeed(int dragonSpeed) {
        Constants.dragonSpeed = dragonSpeed;
    }

    public static int getDragonUpHealth() {
        return dragonUpHealth;
    }

    public static void setDragonUpHealth(int dragonUpHealth) {
        Constants.dragonUpHealth = dragonUpHealth;
    }

    public static int getDragonUpDamage() {
        return dragonUpDamage;
    }

    public static void setDragonUpDamage(int dragonUpDamage) {
        Constants.dragonUpDamage = dragonUpDamage;
    }

    public static Building getDragonTarget() {
        return dragonTarget;
    }

    public static void setDragonTarget(Building dragonTarget) {
        Constants.dragonTarget = dragonTarget;
    }

    public static int getArcherHealth() {
        return archerHealth;
    }

    public static void setArcherHealth(int archerHealth) {
        Constants.archerHealth = archerHealth;
    }

    public static int getArcherDamage() {
        return archerDamage;
    }

    public static void setArcherDamage(int archerDamage) {
        Constants.archerDamage = archerDamage;
    }

    public static int getArcherCost() {
        return archerCost;
    }

    public static void setArcherCost(int archerCost) {
        Constants.archerCost = archerCost;
    }

    public static int getArcherTime() {
        return archerTime;
    }

    public static void setArcherTime(int archerTime) {
        Constants.archerTime = archerTime;
    }

    public static int getArcherRange() {
        return archerRange;
    }

    public static void setArcherRange(int archerRange) {
        Constants.archerRange = archerRange;
    }

    public static int getArcherSpeed() {
        return archerSpeed;
    }

    public static void setArcherSpeed(int archerSpeed) {
        Constants.archerSpeed = archerSpeed;
    }

    public static int getHealerHealth() {
        return healerHealth;
    }

    public static int getHealerHeal() {
        return healerHeal;
    }

    public static int getHealerCost() {
        return healerCost;
    }

    public static int getHealerTime() {
        return healerTime;
    }

    public static int getHealerRange() {
        return healerRange;
    }

    public static int getHealerSpeed() {
        return healerSpeed;
    }

    public static int getHealerUpHealth() {
        return healerUpHealth;
    }

    public static int getHealerUpHeal() {
        return healerUpHeal;
    }

    public static int getHealerHealingTime() {
        return healerHealingTime;
    }

    public static int getArcherUpHealth() {
        return archerUpHealth;
    }

    public static void setArcherUpHealth(int archerUpHealth) {
        Constants.archerUpHealth = archerUpHealth;
    }

    public static int getArcherUpDamage() {
        return archerUpDamage;
    }

    public static void setArcherUpDamage(int archerUpDamage) {
        Constants.archerUpDamage = archerUpDamage;
    }

    public static Building getArcherTarget() {
        return archerTarget;
    }

    public static void setArcherTarget(Building archerTarget) {
        Constants.archerTarget = archerTarget;
    }

    public static int getMapSizeX() {
        return mapSizeX;
    }

    public static void setMapSizeX(int mapSizeX) {
        Constants.mapSizeX = mapSizeX;
    }

    public static int getMapSizeY() {
        return mapSizeY;
    }

    public static void setMapSizeY(int mapSizeY) {
        Constants.mapSizeY = mapSizeY;
    }
}
