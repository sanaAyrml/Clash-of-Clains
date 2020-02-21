package building;

import attack.Soldier;
import attack.Type;
import map.Cell;
import map.*;

import java.util.ArrayList;
import java.util.Random;

public class Cannon extends DefenseTower {


    public Cannon(int x, int y){
        super(x,y, DefenseConstants.cannonStability, DefenseConstants.CANNON_BUILD_TIME, DefenseConstants.CANNON_GOLD_COST,
                DefenseConstants.CANNON_ELIXIR_COST, DefenseConstants.CANNON_JSON_TYPE_CODE, DefenseConstants.CANNON_DISTRUCTION_EARNED_POINT,
                DefenseConstants.cannonDamagePerHit, DefenseConstants.CANNON_MAX_DAMAGE_RANGE, "cannon", false, true);
        setTypee(Typee.Cannon);
    }

    public ArrayList<Soldier> attackedsoldiers(Map map){
        ArrayList<Cell> cells = new ArrayList<>();
        ArrayList<Soldier> soldiers = new ArrayList<>();
        if (defense(map) != null) {
            cells = defense(map);
            if (cells.size() > 1) {
                Random rand = new Random();
                int n = rand.nextInt(cells.size() - 1) + 0;
                return makeSoldiersArraylist(cells.get(n), soldiers, map);
            } else if (cells.size() == 1) {
                return makeSoldiersArraylist(cells.get(0), soldiers, map);
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public ArrayList<Soldier> makeSoldiersArraylist(Cell cell, ArrayList<Soldier> soldiers,Map map)  {
        int x = cell.getX();
        int y = cell.getY();
        int n = x + y* Constants.MAP_WIDTH;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int f = n + i + j*Constants.MAP_WIDTH;
                if(f<0||f> Constants.getMapHeght()* Constants.getMapWidth()-1){
                    continue;
                }
                for (Soldier soldier : map.getMap().get(f).getSoldiers()) {
                    if (soldier.getTypee().equals(Type.ARCHER) || soldier.getTypee().equals(Type.GIANT) || soldier.getTypee().equals(Type.GUARDIAN)) {
                        soldiers.add(soldier);
                    }
                }

            }
        }
        return soldiers;
    }

}
