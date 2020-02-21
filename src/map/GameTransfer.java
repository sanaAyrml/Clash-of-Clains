package map;

import building.GuardianGiant;

import java.io.Serializable;
import java.util.ArrayList;

public class GameTransfer implements Serializable{
    private Map map = new Map();
    private ArrayList<Cell> goldMines;
    private ArrayList<Cell> elixirMines;
    private ArrayList<Cell> goldStorages;
    private ArrayList<Cell> elixirStorages;

    private ArrayList<Cell> townHalls;

    public Map getMap() {
        return map;
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

    public ArrayList<Cell> getBarrackss() {
        return barrackss;
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

    public ArrayList<Cell> getTraps() {
        return traps;
    }

    public GuardianGiant getGuardianGiant() {
        return guardianGiant;
    }

    public ArrayList<Cell> getGiantCastles() {
        return giantCastles;
    }

    private ArrayList<Cell> barrackss;
    private ArrayList<Cell> camps;

    private ArrayList<Cell> archerTowers;
    private ArrayList<Cell> cannons;
    private ArrayList<Cell> airDefenses;
    private ArrayList<Cell> wizardTowers;
    private ArrayList<Cell> walls;
    private ArrayList<Cell> traps;

    private GuardianGiant guardianGiant;

    private ArrayList<ArrayList<Cell>> allBuildings;

    private ArrayList<Cell> giantCastles = new ArrayList<>();

    public GameTransfer(Game game) {
        goldMines = game.getGoldMines();
        elixirMines = game.getElixirMines();
        goldStorages = game.getGoldStorages();
        elixirStorages = game.getElixirStorages();

        townHalls = game.getTownHalls();

        barrackss = game.getBarrackss();
        camps = game.getCamps();

        archerTowers = game.getArcherTowers();
        cannons = game.getCannons();
        airDefenses = game.getAirDefenses();
        wizardTowers = game.getWizardTowers();
        walls = game.getWalls();
        traps = game.getTraps();

        guardianGiant = game.getGuardianGiant();

        allBuildings = game.getAllBuildings();

        giantCastles = game.getGiantCastles();

        map=game.getMap();

    }

    public ArrayList<Cell> getTownHalls() {
        return townHalls;
    }

    public ArrayList<Cell> getWalls() {
        return walls;
    }

    public ArrayList<ArrayList<Cell>> getAllBuildings() {
        return allBuildings;
    }
}
