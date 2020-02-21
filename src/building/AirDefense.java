package building;

import attack.Soldier;
import attack.Type;
import map.Cell;
import map.Constants;
import map.Map;

import java.util.*;

public class AirDefense extends DefenseTower {


    public AirDefense(int x, int y){
        super(x,y, DefenseConstants.airDefenserStability, DefenseConstants.AIR_DEFENSE_BUILD_TIME, DefenseConstants.AIR_DEFENSE_GOLD_COST,
                DefenseConstants.AIR_DEFENSE_ELIXIR_COST, DefenseConstants.AIR_DEFENSE_JSON_TYPE_CODE, DefenseConstants.AIR_DEFENSE_DISTRUCTION_EARNED_POINT,
                DefenseConstants.airDefenseDamagePerHit, DefenseConstants.AIR_DEFENSE_MAX_DAMAGE_RANGE, "air defense", true, false);
        setTypee(Typee.AirDef);
    }

    public ArrayList<Soldier> attackedsoldiers(Map map) {
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
    else
    return null;
    }

    public ArrayList<Soldier> makeSoldiersArraylist(Cell cell, ArrayList<Soldier> soldiers, Map map) {
        int x = cell.getX();
        int y= cell.getY();
        int f = x + y* Constants.MAP_WIDTH;
        for (Soldier soldier : map.getMap().get(f).getSoldiers()){
            if(soldier.getTypee().equals(Type.DRAGON)){
                soldiers.add(soldier);
            }
        }
        return soldiers;
    }
}
