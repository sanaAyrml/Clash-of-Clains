package server.refreshMessages;

import java.io.Serializable;

public class AttackRefreshMessage implements Serializable{
    private String attackerID = null;
    private int earnedGold;
    private int earnedElixir;
    private int earnedPoint;
    private int aliveSoldiers;
    private int deadSoldiers;
    private int distructedGoldMines;
    private int distructedElixirMines;
    private int distructedGoldStorages;
    private int distructedElixirStorages;
    private int distructedBarracks;
    private int distructedCamps;
    private int distructedWalls;
    private int distructedWizaradTowers;
    private int distructedArcherTowers;
    private int distructedAirDefenses;
    private int distructedCannons;
    private int distructedGiantCastle;
    private int distructedTownHalls;
    private String defenderID;
    private int numberOfGuardians;
    private int numberOfArchers;
    private int numberOfGinats;
    private int numberOfWallBreaker;
    private int numberOfDragons;

    public int getNumberOfGuardians() {
        return numberOfGuardians;
    }

    public void setNumberOfGuardians(int numberOfGuardians) {
        this.numberOfGuardians = numberOfGuardians;
    }

    public int getNumberOfArchers() {
        return numberOfArchers;
    }

    public void setNumberOfArchers(int numberOfArchers) {
        this.numberOfArchers = numberOfArchers;
    }

    public int getNumberOfGinats() {
        return numberOfGinats;
    }

    public void setNumberOfGinats(int numberOfGinats) {
        this.numberOfGinats = numberOfGinats;
    }

    public int getNumberOfWallBreaker() {
        return numberOfWallBreaker;
    }

    public void setNumberOfWallBreaker(int numberOfWallBreaker) {
        this.numberOfWallBreaker = numberOfWallBreaker;
    }

    public int getNumberOfDragons() {
        return numberOfDragons;
    }

    public void setNumberOfDragons(int numberOfDragons) {
        this.numberOfDragons = numberOfDragons;
    }

    public int getNumberOfHealers() {
        return numberOfHealers;
    }

    public void setNumberOfHealers(int numberOfHealers) {
        this.numberOfHealers = numberOfHealers;
    }

    private int numberOfHealers;
    public int getDistructedGoldMines() {
        return distructedGoldMines;
    }

    public int getDistructedElixirMines() {
        return distructedElixirMines;
    }

    public int getDistructedGoldStorages() {
        return distructedGoldStorages;
    }

    public int getDistructedElixirStorages() {
        return distructedElixirStorages;
    }

    public int getDistructedBarracks() {
        return distructedBarracks;
    }

    public int getDistructedCamps() {
        return distructedCamps;
    }

    public int getDistructedWalls() {
        return distructedWalls;
    }

    public int getDistructedWizaradTowers() {
        return distructedWizaradTowers;
    }

    public int getDistructedArcherTowers() {
        return distructedArcherTowers;
    }

    public int getDistructedAirDefenses() {
        return distructedAirDefenses;
    }

    public int getDistructedCannons() {
        return distructedCannons;
    }

    public int getDistructedGiantCastle() {
        return distructedGiantCastle;
    }

    public int getDistructedTownHalls() {
        return distructedTownHalls;
    }

    public String getDefenderID() {
        return defenderID;
    }

    public void setDefenderID(String defenderID) {
        this.defenderID = defenderID;
    }

    public AttackRefreshMessage(int earnedGold, int earnedElixir, int earnedPoint, int aliveSoldiers, int deadSoldiers, int distructedGoldMines, int distructedElixirMines, int distructedGoldStorages, int distructedElixirStorages, int distructedBarracks, int distructedCamps, int distructedWalls, int distructedWizaradTowers, int distructedArcherTowers, int distructedAirDefenses, int distructedCannons, int distructedGiantCastle, int distructedTownHalls, String defenderID) {
        this.defenderID=defenderID;

        this.earnedGold = earnedGold;
        this.earnedElixir = earnedElixir;
        this.earnedPoint = earnedPoint;
        this.aliveSoldiers = aliveSoldiers;
        this.deadSoldiers = deadSoldiers;
        this.distructedGoldMines = distructedGoldMines;
        this.distructedElixirMines = distructedElixirMines;
        this.distructedGoldStorages = distructedGoldStorages;
        this.distructedElixirStorages = distructedElixirStorages;
        this.distructedBarracks = distructedBarracks;
        this.distructedCamps = distructedCamps;
        this.distructedWalls = distructedWalls;
        this.distructedWizaradTowers = distructedWizaradTowers;
        this.distructedArcherTowers = distructedArcherTowers;
        this.distructedAirDefenses = distructedAirDefenses;
        this.distructedCannons = distructedCannons;
        this.distructedGiantCastle = distructedGiantCastle;
        this.distructedTownHalls = distructedTownHalls;
//        System.err.println(distructedElixirStorages);
    }

    public int getDeadSoldiers() {
        return deadSoldiers;
    }




    public int getEarnedGold() {

        return earnedGold;
    }

    public int getAliveSoldiers() {
        return aliveSoldiers;
    }

    public int getEarnedElixir() {
        return earnedElixir;
    }

    public int getEarnedPoint() {
        return earnedPoint;
    }

    public void setAttackerID(String attackerID) {
        this.attackerID = attackerID;
    }

    public String getAttackerID() {
        return attackerID;
    }

    public AttackRefreshMessage getNewInstance()
    {
        AttackRefreshMessage attackRefreshMessage = new AttackRefreshMessage(earnedGold, earnedElixir, earnedPoint, aliveSoldiers, deadSoldiers,
         distructedGoldMines, distructedElixirMines, distructedGoldStorages, distructedElixirStorages, distructedBarracks, distructedCamps, distructedWalls,
                distructedWizaradTowers, distructedArcherTowers, distructedAirDefenses, distructedCannons, distructedGiantCastle, distructedTownHalls, new String(defenderID));
        attackRefreshMessage.setAttackerID(new String(attackerID));
        return attackRefreshMessage;
    }
}
