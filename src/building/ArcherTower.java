package building;

import attack.Soldier;
import attack.Type;
import map.Cell;
import map.Constants;
import map.Map;

import java.util.ArrayList;
import java.util.Random;

public class ArcherTower extends DefenseTower {
    public ArcherTower(int x, int y){
        super(x,y, DefenseConstants.archerTowerStability,DefenseConstants.ARCHERTOWER_BUILD_TIME, DefenseConstants.ARCHERTOWER_GOLD_COST,
                DefenseConstants.ARCHERTOWER_ELIXIR_COST,DefenseConstants.ARCHERTOWER_JSON_TYPE_CODE, DefenseConstants.ARCHERTOWER_DISTRUCTION_EARNED_POINT,
                DefenseConstants.archerTowerDamagePerHit, DefenseConstants.ARCHERTOWER_MAX_DAMAGE_RANGE, "archer tower", false, true);
        setTypee(Typee.ArcherTower);

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
        else
            return null;
    }

    public ArrayList<Soldier> makeSoldiersArraylist(Cell cells, ArrayList<Soldier> soldiers, Map map) {
        lastTargetCell = cells;
        int x = cells.getX();
        int y = cells.getY();
        int f = x + y * Constants.MAP_WIDTH;
        for (Soldier soldier : map.getMap().get(f).getSoldiers()){
            if(soldier.getTypee().equals(Type.ARCHER) || soldier.getTypee().equals(Type.GIANT) || soldier.getTypee().equals(Type.GUARDIAN)){
                soldiers.add(soldier);
            }
        }
        return soldiers;
    }


}
