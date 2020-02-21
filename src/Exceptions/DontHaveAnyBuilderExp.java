package Exceptions;

public class DontHaveAnyBuilderExp extends Exception{
    String s;
    public String error() {
        s ="You don’t have any worker to build this building.";
        return s;
    }
}
