package attack.attackStreaming;


import java.io.Serializable;

public class Event implements Serializable{
    public int allBuildingsNum;
    public int buildingsNum;
    private boolean eventType;

    public Event(int health, int allBuildingsNum, int buildingsNum) {
        this.allBuildingsNum = allBuildingsNum;
        this.buildingsNum = buildingsNum;
        this.eventType = true;
        this.health = health;
    }

    public int health;
    private int soldierType;
    /*
    1:guardian
    2:archer
    3:giant
    4:wall breaker
    5:healer
    6:dragon
     */
    private int soldierID;
    //dar vaghe shomareye sarbaz dar arrayliste marboote hast
    private int graphicalX;
    private int graphicaly;
    //jaye sarbaz dar safheye bazi
    private int soldierDirection;
    /*
    1:up
    2:down
    3:left
    4:right
    5:attack
    6:none
     */

    public int getSoldierType() {
        return soldierType;
    }

    public int getSoldierID() {
        return soldierID;
    }

    public int getGraphicalX() {
        return graphicalX;
    }

    public Event() {
    }

    public int getGraphicaly() {
        return graphicaly;
    }

    public int getSoldierDirection() {
        return soldierDirection;
    }

    public boolean isEventType() {
        return eventType;
    }

    public int getHealth() {
        return health;
    }

    public Event(boolean eventType, int health, int soldierType, int soldierID, int graphicalX, int graphicaly, int soldierDirection) {
        this.soldierType = soldierType;
        this.soldierID = soldierID;
        this.graphicalX = graphicalX;
        this.graphicaly = graphicaly;
        this.soldierDirection = soldierDirection;
        this.eventType=eventType;
        this.health=health;
    }
}
