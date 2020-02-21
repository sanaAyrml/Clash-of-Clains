package Exceptions;

public class FullCellExp extends Exception{
    String s;
    public String error(){
        s ="You can’t build this building here.Please choose another cell.";
        return s;
    }
}
