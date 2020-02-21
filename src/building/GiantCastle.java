package building;

public class GiantCastle extends Building {

    private static GiantCastle giantCastle = null;
    GuardianGiant guardianGiant;


    public GiantCastle(int x, int y) {
        super(x, y, DefenseConstants.giantCastleStability, DefenseConstants.GIANT_CASTLE_BUILD_TIME, DefenseConstants.GIANT_CASTLE_GOLD_COST, DefenseConstants.GIANT_CASTLE_ELIXIR_COST, DefenseConstants.GIANT_CASTLE_JSON_TYPE_CODE, DefenseConstants.GIANT_CASTLE_DISTRUCTION_EARNED_POINT, "giant castle");
        guardianGiant=GuardianGiant.getInstance(getX()-1,getY()+1);
    }

    public GuardianGiant getGuardianGiant() {
        return guardianGiant;
    }
}