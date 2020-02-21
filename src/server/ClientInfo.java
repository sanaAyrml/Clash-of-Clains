package server;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientInfo implements Serializable{
    private int gold;
    private int elixir;
    private String ID;

    private ArrayList<AttackRecord> attackRecords;

    public ClientInfo(int gold, String ID, int elixir, ArrayList<AttackRecord> attackRecords) {
        this.ID = ID;
        this.gold = gold;
        this.elixir = elixir;
        this.attackRecords = attackRecords;
    }

    public Integer getGold() {
        return gold;
    }

    public Integer getElixir() {
        return elixir;
    }

    public Integer getTotalPoint() {
        int point = 0;
        for (AttackRecord attackRecord : attackRecords) {
            point += attackRecord.getEarnedPoint();
        }
        return point;
    }

    public ArrayList<AttackRecord> getAttackRecords() {
        return attackRecords;
    }

    public String getID() {
        return ID;
    }

    public ClientInfo getNewInstance()
    {
        return new ClientInfo(gold, ID, elixir, getNewRecords());
    }

    private ArrayList<AttackRecord> getNewRecords()
    {
        ArrayList<AttackRecord> records = new ArrayList<>();
        for (AttackRecord r : attackRecords) {
            records.add(r.getNewInstance());
        }
        return records;
    }


}
