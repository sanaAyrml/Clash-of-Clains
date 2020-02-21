package building;

import attack.Soldier;
import attack.Type;
import attack.soldiers.*;
import attack.soldiers.Giant;
import map.Constants;

import java.util.ArrayList;

public class Camp extends Building{
    private ArrayList<Guardian> guardians;
    private ArrayList<WallBreaker> wallBreakers;
    private ArrayList<Giant> giants;
    private ArrayList<Dragon> dragons;
    private ArrayList<Archer> archers;
    private ArrayList<Healer> healers;
    private int numberOfSodiers;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public Camp(int x, int y) {
        super(x, y, BuildingConstants.campStability,BuildingConstants.campBuildTime,BuildingConstants.campGoldCost,
                BuildingConstants.campElixirCost,BuildingConstants.campType,BuildingConstants.campDistructionEarnedPoint,"camp");
        guardians=new ArrayList<Guardian>();
        wallBreakers=new ArrayList<WallBreaker>();
        giants=new ArrayList<Giant>();
        dragons=new ArrayList<Dragon>();
        archers=new ArrayList<Archer>();
        healers=new ArrayList<>();
        numberOfSodiers=0;
        capacity=BuildingConstants.getCampCapacity();

    }

    public void addSoldier(Soldier soldier){
        if(soldier.getTypee().equals(Type.ARCHER)){
            archers.add((Archer)soldier);
            soldier.setTypee(Type.ARCHER);
        }
        else if(soldier.getTypee().equals(Type.GIANT)){
            giants.add((Giant)soldier);
            soldier.setTypee(Type.GIANT);
        }
        else if(soldier.getTypee().equals(Type.DRAGON)){
            dragons.add((Dragon) soldier);
            soldier.setTypee(Type.DRAGON);
        }
        else if(soldier.getTypee().equals(Type.GUARDIAN)){
            guardians.add((Guardian) soldier);
            soldier.setTypee(Type.GUARDIAN);
        }
        else if(soldier.getTypee().equals(Type.WALLBREAKER)){
            wallBreakers.add((WallBreaker) soldier);
            soldier.setTypee(Type.WALLBREAKER);
        }
        else if(soldier.getTypee().equals(Type.HEALER)){
            healers.add((Healer) soldier);
            soldier.setTypee(Type.HEALER);
        }
        numberOfSodiers++;
    }

    public void backSoldier(Soldier soldier){
        if(soldier.getHealth()>0){
            if(soldier.getTypee()==Type.DRAGON) {
                soldier.setHealth(Constants.getDragonHealth() + (soldier.getLevel()) * Constants.getDragonUpHealth());
                dragons.add((Dragon) soldier);
            }
            else if(soldier.getTypee()==Type.GUARDIAN){
                soldier.setHealth(Constants.getGuardianHealth() + (soldier.getLevel() ) * Constants.getGuardianUpHealth());
                guardians.add((Guardian) soldier);

            }
            else if(soldier.getTypee()==Type.WALLBREAKER){
                soldier.setHealth(Constants.getWallBreakerHealth() + (soldier.getLevel() ) * Constants.getWallBreakerUpHealth());
                wallBreakers.add((WallBreaker) soldier);

            }
            else if(soldier.getTypee()==Type.ARCHER){
                soldier.setHealth(Constants.getArcherHealth() + (soldier.getLevel() ) * Constants.getArcherUpHealth());
                archers.add((Archer) soldier);

            }
            else if(soldier.getTypee()==Type.GIANT){
                soldier.setHealth(Constants.getGiantHealth() + (soldier.getLevel() ) * Constants.getGiantUpHealth());
                giants.add((Giant) soldier);

            }
            else if(soldier.getTypee()==Type.HEALER){
                soldier.setHealth(Constants.getHealerHealth() + (soldier.getLevel() ) * Constants.getHealerUpHeal());
                healers.add((Healer) soldier);

            }
        }
    }

    public int getNumberOfSodiers() {
        return numberOfSodiers;
    }

    public ArrayList<Guardian> getGuardians() {
        return guardians;
    }

    public ArrayList<WallBreaker> getWallBreakers() {
        return wallBreakers;
    }

    public ArrayList<Giant> getGiants() {
        return giants;
    }

    public ArrayList<Dragon> getDragons() {
        return dragons;
    }

    public ArrayList<Archer> getArchers() {
        return archers;
    }


    public ArrayList<Healer> getHealers() {
        return healers;
    }

    public Soldier borrowSodier(Type type){
        Soldier soldier;
        if(type== Type.ARCHER){
            if(archers.size()>0){
                soldier=archers.get(0);
                archers.remove(0);
                return soldier;
            }


        }if (type== Type.GIANT){
            if(giants.size()>0){
                soldier=giants.get(0);
                giants.remove(0);
                return soldier;
            }

        }
        if(type== Type.DRAGON){
            if(dragons.size()>0){
                soldier=dragons.get(0);
                dragons.remove(0);
                return soldier;
            }

        }
        if(type== Type.GUARDIAN){
            if(guardians.size()>0){
                soldier=guardians.get(0);
                guardians.remove(0);
                return soldier;
            }
        }
        if(type== Type.WALLBREAKER){
            if(wallBreakers.size()>0){
                soldier=wallBreakers.get(0);
                wallBreakers.remove(0);
                return soldier;
            }
        }
        if(type==Type.HEALER){
            if(healers.size()>0){
                soldier=healers.get(0);
                healers.remove(0);
                return soldier;
            }
        }
        return new Archer(-1);
    }

}
