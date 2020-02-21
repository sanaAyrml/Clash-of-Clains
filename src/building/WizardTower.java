package building;

import attack.Soldier;
import attack.Type;
import map.Cell;
import map.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WizardTower extends DefenseTower {

    private HashMap<Cell, Double> distances;
    public WizardTower(int x, int y){
        super(x,y, DefenseConstants.wizardTowerStability, DefenseConstants.WIZARDTOWER_BUILD_TIME, DefenseConstants.WIZARDTOWER_GOLD_COST,
                DefenseConstants.WIZARDTOWER_ELIXIR_COST, DefenseConstants.WIZARDTOWER_JSON_TYPE_CODE, DefenseConstants.WIZARDTOWER_DISTRUCTION_EARNED_POINT,
                DefenseConstants.wizardTowerDamagePerHit, DefenseConstants.WIZARDTOWER_MAX_DAMAGE_RANGE, "wizard tower", true, true);
        setTypee(Typee.WizardTower);
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
        int x = cells.getX();
        int y = cells.getY();
        int n = x + y*Constants.MAP_WIDTH;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int f=n + i + j * 30;
                if(f<0||f> Constants.getMapHeght()* Constants.getMapWidth()-1){
                    continue;
                }

                for (Soldier soldier : map.getMap().get(f).getSoldiers()) {
                    if (soldier.getTypee().equals(Type.ARCHER) || soldier.getTypee().equals(Type.GIANT) ||
                            soldier.getTypee().equals(Type.GUARDIAN) || soldier.getTypee().equals(Type.DRAGON)) {
                        soldiers.add(soldier);
                    }
                }

            }
        }
        return soldiers;
    }

}
