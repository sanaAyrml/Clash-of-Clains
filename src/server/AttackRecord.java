package server;

public class AttackRecord {
    private int earnedGold;
    private int earnedElixir;
    private int earnedPoint;
    private String defenderID;

    public AttackRecord(int earnedGold, int earnedElixir, int earnedPoint, String defenderID) {
        this.earnedGold = earnedGold;
        this.earnedElixir = earnedElixir;
        this.earnedPoint = earnedPoint;
        this.defenderID = defenderID;
    }

    public Integer getEarnedGold() {
        return earnedGold;
    }

    public Integer getEarnedElixir() {
        return earnedElixir;
    }

    public Integer getEarnedPoint() {
        return earnedPoint;
    }

    public String getDefenderID() {
        return defenderID;
    }

    public AttackRecord getNewInstance()
    {
        return new AttackRecord(earnedGold, earnedElixir, earnedPoint, defenderID);
    }
}
