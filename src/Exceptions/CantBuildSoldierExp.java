package Exceptions;

public class CantBuildSoldierExp extends Exception {
    String s;
    public String error(){
        s = "You can’t build this soldier.";
        return s;
    }
}
