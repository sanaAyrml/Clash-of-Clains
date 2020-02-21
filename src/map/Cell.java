package map;

import attack.Soldier;
import building.*;
import Exceptions.PutSoldierException;

import java.io.Serializable;
import java.util.ArrayList;

public class Cell implements Serializable{
    private Building building;
    private int x;
    private int y;
    private boolean free = true;
    private ArrayList<Soldier> soldiers=new ArrayList<Soldier>();



    public void setBuilding(Building building) {
        this.building = building;
        free = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void addSoldier(Soldier soldier) throws PutSoldierException {
        if(this.soldiers==null){
            soldiers=new ArrayList<Soldier>();
            soldiers.add(soldier);
            return;
        }
        if((soldiers.size()>0&&soldiers.get(0).getTypee()!=soldier.getTypee())||soldiers.size()>4){
            throw new PutSoldierException();
        }
        soldiers.add(soldier);

    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSoldiers(ArrayList<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public Building getBuilding() {
        return building;
    }

    public void removeSoldiers(){
        for (int i = 0; i < soldiers.size(); i++) {
            soldiers.remove(i);
            i--;
        }
    }

    public void addSoldierNorm(Soldier soldier){
        soldiers.add(soldier);
    }
}

