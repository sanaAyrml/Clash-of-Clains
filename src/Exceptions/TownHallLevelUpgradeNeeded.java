package Exceptions;

public class TownHallLevelUpgradeNeeded extends Throwable {
    String s;
    public String error() {

        s = "Town hall level upgrade needed";
        return s;
    }
}
