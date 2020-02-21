package attack;

import building.Building;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import map.Cell;
import map.Constants;
import map.Direction;

import java.util.HashMap;

public abstract class Soldier {
    static Field field;
    int level;
    static int elixirCost;
    int productionTime;
    int health;
    static Building mainTarget;
    int maxSpeed;
    Building target;
    Direction direction;
    static boolean trainable;
    static Type type;
    Type typee;
    Cell cell;
    Cell attackCell;
    int damagePerHit;
    static int range;
    int graphicalX;
    int graphicalY;
    public ImageView health1;
    public ImageView health2;
    public ImageView health3;
    public Group group;
    public boolean changed=true;
    public int priviousHealth=100;

    public int getGraphicalX() {
        return graphicalX;
    }

    public void setGraphicalX(int graphicalX) {
        this.graphicalX = graphicalX;
    }

    public int getGraphicalY() {
        return graphicalY;
    }

    public void setGraphicalY(int graphicalY) {
        this.graphicalY = graphicalY;
    }

    public boolean isDamaging;

    public Type getTypee() {
        return typee;
    }

    public void setTypee(Type typee) {
        this.typee = typee;
    }

    private HashMap<Cell, Double> distances;

    public void setHealth(int health) {
        this.health = health;
    }

    public Building getTarget() {
        return target;
    }

    public void setTarget(Building target) {
        this.target = target;
    }

    public HashMap<Cell, Double> getDistances() {
        return distances;
    }

    public void setDistances(HashMap<Cell, Double> distances) {
        this.distances = distances;
    }

    public static boolean isTrainable() {
        return trainable;
    }

    public Soldier() {
    }

    public void setDamagePerHit(int damagePerHit) {
        this.damagePerHit = damagePerHit;
    }

    public int getDamagePerHit() {
        return damagePerHit;
    }

    public Building getMainTarget() {
        return mainTarget;
    }

    public Cell getAttackCell() {
        return attackCell;
    }

    public Cell getCell() {
        return cell;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getElixirCost() {
        return elixirCost;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setAttackCell(Cell attackCell) {
        this.attackCell = attackCell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public static void setElixirCost(int elixirCost) {
        Soldier.elixirCost = elixirCost;
    }

    public static void setField(Field field) {
        Soldier.field = field;
    }

    public void decraseHealth(int health) {
        this.health -= health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static Field getField() {
        return field;
    }

    public int getRange() {
        return range;
    }

    public static void setTrainable(boolean trainable) {
        Soldier.trainable = trainable;
    }

    public static void setRange(int range) {
        Soldier.range = range;
    }

    public static void setMainTarget(Building mainTarget) {
        Soldier.mainTarget = mainTarget;
    }

    public static void setType(Type type) {
        Soldier.type = type;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static Type getType() {
        return type;
    }

    protected void move(){
        if(direction==Direction.LEFT){
            attackCell=new Cell(attackCell.getX()-1,attackCell.getY());
            if(attackCell.getX()<0){
                attackCell.setX(attackCell.getX()+Constants.getMapSizeX());
            }
        }
        if(direction==Direction.RIGHT){
            attackCell=new Cell(attackCell.getX()+1,attackCell.getY());
            if(attackCell.getX()>=Constants.getMapSizeX()){
                attackCell.setX(attackCell.getX()-Constants.getMapSizeX());
            }
        }
        if(direction==Direction.UP){
            attackCell=new Cell(attackCell.getX(),attackCell.getY()-1);
            if(attackCell.getY()<0){
                attackCell.setY(attackCell.getY()+Constants.getMapSizeY());
            }
        }
        if(direction==Direction.DOWN){

            attackCell=new Cell(attackCell.getX(),attackCell.getY()+1);
            if(attackCell.getY()>=Constants.getMapSizeY()){
                attackCell.setY(attackCell.getY()-Constants.getMapSizeY());
            }
        }
    }
    public void graphicalPassTime(){
        if(direction==Direction.LEFT){
            graphicalX=graphicalX-(Constants.CELL_WIDTH/10);
            if(graphicalX<0){
                graphicalX=graphicalX+Constants.MAP_WIDTH*Constants.CELL_WIDTH;
            }
        }
        else if(direction==Direction.RIGHT){
            graphicalX=graphicalX+(Constants.CELL_WIDTH/10);
            if(graphicalX>Constants.MAP_WIDTH*Constants.CELL_WIDTH){
                graphicalX=graphicalX-Constants.MAP_WIDTH*Constants.CELL_WIDTH;
            }
        }
        else if(direction==Direction.UP){
            graphicalY=graphicalY-(Constants.CELL_HEIGHT/10);
            if(graphicalY<0){
                graphicalY=graphicalY+Constants.MAP_HEGHT*Constants.CELL_HEIGHT;
            }
        }
        else if(direction==Direction.DOWN){
            graphicalY=graphicalY+(Constants.CELL_HEIGHT/10);
            if(graphicalY>Constants.MAP_HEGHT*Constants.CELL_HEIGHT){
                graphicalY=graphicalY-Constants.MAP_HEGHT*Constants.CELL_HEIGHT;
            }
        }

    }
    public void passTime(){

        if(!(direction==Direction.REACHED)) {
            move();
        }



    }
    public boolean passEvent(){
        if (direction == Direction.NONE) {
            if(health==priviousHealth){
                return false;
            }
            else{
                return false;
            }
        }
        else{
            priviousHealth=health;
            return true;
        }
    }

    public void sync(){
        graphicalX=attackCell.getX()*Constants.CELL_WIDTH;
        graphicalY=attackCell.getY()*Constants.CELL_HEIGHT;
    }



}
