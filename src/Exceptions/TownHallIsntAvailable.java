package Exceptions;

public class TownHallIsntAvailable extends Throwable {
    String s;
    public String error() {

        s = "townHall isn't available";
        return s;
    }
}
