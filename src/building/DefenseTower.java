package building;

import attack.Soldier;
import attack.Type;
import map.Cell;
import map.Direction;
import map.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public abstract class  DefenseTower extends Building{
    private int damagePerHit;
    private int damageRange;
    private boolean airDef;
    private boolean groundDef;
    private HashMap<Cell, Double> distances=new HashMap<>();
    Cell lastTargetCell = new Cell(0, 0);

    public HashMap<Cell, Double> getDistances() {
        return distances;
    }

    public void setDistances(HashMap<Cell, Double> distances) {
        this.distances = distances;
    }

    public Typee getTypee() {
        return typee;
    }

    public void setTypee(Typee typee) {
        this.typee = typee;
    }

    private Typee typee;
    public int getDamagePerHit() {
        return damagePerHit;
    }

    public int getDamageRange() {
        return damageRange;
    }

    public boolean isGroundDef() {
        return groundDef;
    }

    public boolean isAirDef() {
        return airDef;
    }

    public void setDamagePerHit(int damagePerHit) {
        this.damagePerHit = damagePerHit;
    }

    public void setAirDef(boolean airDef) {
        this.airDef = airDef;
    }

    public void setDamageRange(int damageRange) {
        this.damageRange = damageRange;
    }

    public void setGroundDef(boolean groundDef) {
        this.groundDef = groundDef;
    }
    public DefenseTower(int x, int y,Integer stability, Integer buildTime, Integer goldCost, Integer elixirCost,
                        Integer type,Integer distructionEarnedPoint, Integer damagePerHit, Integer damageRange, String name,Boolean airDef, Boolean groundDef){
        super(x, y, stability, buildTime, goldCost, elixirCost, type, distructionEarnedPoint, name);
        this.damagePerHit = damagePerHit;
        this.damageRange = damageRange;
        this.airDef = airDef;
        this.groundDef = groundDef;
    }
    public abstract ArrayList<Soldier> attackedsoldiers(Map map);

    public void upgrade()
    {
        super.upgrade();
        setDamagePerHit(getDamagePerHit() + 1);
        setStability(getStability() + 10);
        setHealth(getStability());
    }

    public ArrayList<Cell> defense(Map map){
        distances.clear();
        for(Cell cell : map.getMap()){
            if(cell.getSoldiers().size()!= 0){
                for (Soldier soldier : cell.getSoldiers()) {
                    if(airDef) {
                        if (soldier.getTypee().equals(Type.DRAGON)) {
                            if (findDistance(cell))
                                break;
                        }
                    }
                    if(groundDef){
                        if(soldier.getTypee().equals(Type.ARCHER) || soldier.getTypee().equals(Type.GIANT) || soldier.getTypee().equals(Type.GUARDIAN)){
                            if (findDistance(cell))
                                break;
                        }
                    }
                }
            }
        }
        if(distances.size() == 0){
            return null;
        }
        else {
            return findMinDistance(distances);
        }
    }

    public boolean findDistance(Cell cell) {
        double distance;
        distance = Math.sqrt((cell.getX() - getX()) * (cell.getX() - getX()) + (cell.getY() - getY()) * (cell.getY() - getY()));
        if (distance <= damageRange) {
            distances.put(cell, distance);
            return true;
        }
        return false;
    }

    public ArrayList<Cell> findMinDistance(HashMap<Cell , Double> distances){
        ArrayList<Double> sDistance = new ArrayList<Double>();
        for(Double i : distances.values()){
            sDistance.add(i);
        }
        Collections.sort(sDistance);
        return findDefenseCell(sDistance.get(0));
    }

    public ArrayList<Cell> findDefenseCell(Double min){
        ArrayList<Cell> defenseCell = new ArrayList<>();
        for(HashMap.Entry<Cell,Double> entry : distances.entrySet()){
            if(entry.getValue().equals(min)){
                defenseCell.add(entry.getKey());
            }
        }
        return defenseCell;
    }

    public Direction getDefenseDirection(){
        if (lastTargetCell.getY() >= f1(lastTargetCell.getX()) && lastTargetCell.getY() <= f2(lastTargetCell.getX()))
            return Direction.RIGHT;
        else if (lastTargetCell.getY() <= f1(lastTargetCell.getX()) && lastTargetCell.getY() <= f2(lastTargetCell.getX()))
            return Direction.UP;
        else if (lastTargetCell.getY() <= f1(lastTargetCell.getX()) && lastTargetCell.getY() >= f2(lastTargetCell.getX()))
            return Direction.LEFT;
        else
            return Direction.DOWN;
    }

    private int f1(int x)
    {
        return -x + getX() + getY();
    }

    private int f2(int x)
    {
        return x - getX() + getY();
    }
}
