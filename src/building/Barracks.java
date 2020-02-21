package building;

import attack.Soldier;
import attack.soldiers.*;
import attack.soldiers.Giant;
import map.Constants;

import java.util.ArrayList;

import static map.Constants.getSoldierUoTime;

public class Barracks extends Building{

    private ArrayList<Soldier> soldiers=new ArrayList<>();
    private int time;

    public Barracks(int x, int y) {
        super(x, y, BuildingConstants.barracksStability, BuildingConstants.barracksBuildTime, BuildingConstants.barracksGoldCost,
                BuildingConstants.barracksElixirCost, BuildingConstants.barracksType, BuildingConstants.barracksDistructionEarnedPoint, "barracks");
        WallBreaker.set();
        Healer.set();
        Guardian.set();
        Giant.set();
        Archer.set();
        Dragon.set();
    }
    public void buildSoldier(Soldier soldier){
        if(this.soldiers.size()==0) {
            soldiers.add(soldier);
            time=soldier.getProductionTime()- getSoldierUoTime();
        }
        else{
            this.soldiers.add(soldier);
        }
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }

    //havasemoon be time bashe .age inja bug khord ehtemale balayi male passtime hast.
    public void passTime(Camp camp){
        if(soldiers.size()>0) {
            time--;
            if (time <= 0) {
                if(soldiers.size()>0) {
                    camp.addSoldier(soldiers.get(0));

                    soldiers.remove(0);
                    if(soldiers.size()>0) {
                        time = soldiers.get(0).getProductionTime() - getSoldierUoTime();
                    }
                }
            }
        }
    }


    @Override
    public void upgrade() {

            super.upgrade();
            Constants.setSoldierUoTime(getSoldierUoTime() + 1);
    }
    public Integer getTime(Soldier soldier){
        int x=soldiers.indexOf(soldier);
        int rTime=0;
        rTime+=time;
        for (int i = 1; i <= x; i++) {
            rTime+=(soldiers.get(i).getProductionTime()- getSoldierUoTime());

        }
        return rTime;
    }

}