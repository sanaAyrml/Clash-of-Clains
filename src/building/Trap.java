package building;

import attack.Soldier;
import attack.Type;
import map.Constants;
import map.Map;

import java.util.ArrayList;

public class Trap extends DefenseTower {
    public Trap(int x, int y) {
        super(x, y, DefenseConstants.trapStability, DefenseConstants.TRAP_BUILD_TIME, DefenseConstants.TRAP_GOLD_COST,
                DefenseConstants.TRAP_ELIXIR_COST, DefenseConstants.TRAP_JSON_TYPE_CODE, DefenseConstants.TRAP_DISTRUCTION_EARNED_POINT,
                DefenseConstants.trapDamagePerHit, DefenseConstants.TRAP_DAMAGE_RANGE, "trap", false, true);
        setTypee(Typee.Trap);
    }

    @Override
    public ArrayList<Soldier> attackedsoldiers(Map map) {
        ArrayList<Soldier> soldiers = new ArrayList<>();
        int x = getX();
        int y = getY();
        int n = x + y * Constants.MAP_WIDTH;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int f = n + i + j * Constants.MAP_WIDTH;
                if (f < 0 || f > Constants.getMapHeght() * Constants.getMapWidth() - 1) {
                    continue;
                }
                if (map.getMap().get(f).getSoldiers().size() != 0) {
                    for (Soldier soldier : map.getMap().get(f).getSoldiers()) {
                        if (soldier.getTypee().equals(Type.ARCHER) || soldier.getTypee().equals(Type.GIANT) || soldier.getTypee().equals(Type.GUARDIAN)) {
                            soldiers.add(soldier);
                        }
                    }
                }

            }
        }
        return soldiers;
    }

}
