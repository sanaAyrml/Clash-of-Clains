package building;

import attack.Soldier;
import javafx.scene.Group;
import map.Cell;
import map.Constants;
import map.Direction;
import map.Map;

import java.util.ArrayList;

public class GuardianGiant extends DefenseTower {
    private static GuardianGiant guardianGiant = null;
    public static boolean isConstructed=false;
    private Cell cell;
    private Direction direction;
    private boolean alive;
    private int speed;
    public boolean isDamaging=false;
    public Group group;
    private int graphicalX;
    private int graphicalY;


    public int getSpeed() {
        return speed;
    }

    public static GuardianGiant getGuardianGiant() {
        return guardianGiant;
    }

    public static void setGuardianGiant(GuardianGiant guardianGiant) {
        GuardianGiant.guardianGiant = guardianGiant;
    }

    public static boolean isIsConstructed() {
        return isConstructed;
    }

    public static void setIsConstructed(boolean isConstructed) {
        GuardianGiant.isConstructed = isConstructed;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static GuardianGiant getInstance(int x, int y) {
        isConstructed=true;
        if(guardianGiant == null){
            guardianGiant = new GuardianGiant(x,y);
        }
        return guardianGiant;

    }

    private GuardianGiant(int x, int y) {
        super(x,y, DefenseConstants.guardianGiantStability, DefenseConstants.GUARDIAN_GIANT_BUILD_TIME, DefenseConstants.GUARDIAN_GIANT_GOLD_COST,
                DefenseConstants.GUARDIAN_GIANT_ELIXIR_COST, DefenseConstants.GUARDIAN_GIANT_JSON_TYPE_CODE, DefenseConstants.GUARDIAN_GIANT_DISTRUCTION_EARNED_POINT,
                DefenseConstants.guardianGiantDamagePerHit, DefenseConstants.GUARDIAN_GIANT_DAMAGE_RANGE, "guardianGiant", false, true);
        group=new Group();
        setTypee(Typee.GuardianGiant);
        speed=DefenseConstants.guardianGiantSpeed;
        cell=new Cell(x,y);
        alive=true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    protected void move(){

        if(direction== Direction.LEFT){
            cell=new Cell(cell.getX()-1,cell.getY());
            if(cell.getX()<0){
                cell.setX(cell.getX()+ Constants.getMapSizeX());
            }
        }
        if(direction==Direction.RIGHT){
            cell=new Cell(cell.getX()+1,cell.getY());
            if(cell.getX()>=Constants.getMapSizeX()){
                cell.setX(cell.getX()-Constants.getMapSizeX());
            }
        }
        if(direction==Direction.UP){
            cell=new Cell(cell.getX(),cell.getY()-1);
            if(cell.getY()<0){
                cell.setY(cell.getY()+Constants.getMapSizeY());
            }
        }
        if(direction==Direction.DOWN){

            cell=new Cell(cell.getX(),cell.getY()+1);
            if(cell.getY()>=Constants.getMapSizeY()){
                cell.setY(cell.getY()-Constants.getMapSizeY());
            }
        }
    }
    public void passTime(){

        if(!(direction==Direction.REACHED)) {
            move();
        }



    }
    public void graphicalPassTime(){
        if(direction==Direction.LEFT){
            graphicalX=graphicalX-(Constants.CELL_WIDTH/10);
            if(graphicalX<0){
                graphicalX=graphicalX+Constants.MAP_WIDTH*Constants.CELL_WIDTH;
            }
        }
        if(direction==Direction.RIGHT){
            graphicalX=graphicalX+(Constants.CELL_WIDTH/10);
            if(graphicalX>Constants.MAP_WIDTH*Constants.CELL_WIDTH){
                graphicalX=graphicalX-Constants.MAP_WIDTH*Constants.CELL_WIDTH;
            }
        }
        if(direction==Direction.UP){
            graphicalY=graphicalY-(Constants.CELL_HEIGHT/10);
            if(graphicalY<0){
                graphicalY=graphicalY+Constants.MAP_HEGHT*Constants.CELL_HEIGHT;
            }
        }
        if(direction==Direction.DOWN){
            graphicalY=graphicalY+(Constants.CELL_HEIGHT/10);
            if(graphicalY>Constants.MAP_HEGHT*Constants.CELL_HEIGHT){
                graphicalY=graphicalY-Constants.MAP_HEGHT*Constants.CELL_HEIGHT;
            }
        }
    }

    public int getGraphicalX() {
        return graphicalX;
    }

    public int getGraphicalY() {
        return graphicalY;
    }

    public void sync(){
        graphicalX=cell.getX()*Constants.CELL_WIDTH;
        graphicalY=cell.getY()*Constants.CELL_HEIGHT;
    }
    @Override
    public ArrayList<Soldier> attackedsoldiers(Map map) {
        return null;
    }
}
