package Exceptions;

public class DontHaveEnoughResourceExp extends Exception {
    String s;
    public String error() {
        s ="You don’t have enough resources.";
        return s;
    }
}
