package building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import map.Constants;

import java.io.Serializable;

public abstract class Building implements Serializable{
    private Integer x;
    private Integer y;
    private Integer level;
    private Integer stability;
    private Integer health;
    private Integer buildOrUpgradeTime;
    private Integer goldCost;
    private Integer elixirCost;
    private Integer type;
    private Integer distructionEarnedPoint;
    private Integer upgradeGoldCost = BuildingConstants.UPGRADE_COST;
    private String name;
    private int lastHealth = 0;
    private int previousHealth=0;

    public void setPreviousHealth(int previousHealth) {
        this.previousHealth = previousHealth;
    }

    public int getPreviousHealth() {

        return previousHealth;
    }

    //moqeye upgrade shodan va heyne sakhte shodan false e
    private boolean available = false;
    private boolean upgrading = false;
    private boolean changeImage = true;
    private boolean ruined = false;

    private int passedBuildingTime = 0;

    public boolean shouldImageBeChanged() {
        return changeImage;
    }

    public void imageShouldBeChanged(boolean changeImage) {
        this.changeImage = changeImage;
    }

    public Building(int x, int y, Integer stability, Integer buildTime, Integer goldCost,
                    Integer elixirCost, Integer type, Integer distructionEarnedPoint, String name) {
        level = 1;
        this.x = x;
        this.y = y;
        this.stability = stability;
        health = stability;
        buildOrUpgradeTime = buildTime;
        this.goldCost = goldCost;
        this.elixirCost = elixirCost;
        this.type = type;
        this.distructionEarnedPoint = distructionEarnedPoint;
        this.name = name;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void setStability(Integer stability) {
        this.stability = stability;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setUpgradeGoldCost(Integer upgradeGoldCost) {
        this.upgradeGoldCost = upgradeGoldCost;
    }

    public Integer getUpgradeGoldCost() {
        return upgradeGoldCost;
    }

    public boolean isAvailable() {
        return available;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getStability() {
        return stability;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getBuildOrUpgradeTime() {
        return buildOrUpgradeTime;
    }

    public Integer getGoldCost() {
        return goldCost;
    }

    public Integer getElixirCost() {
        return elixirCost;
    }

    public Integer getType() {
        return type;
    }

    public Integer getDistructionEarnedPoint() {
        return distructionEarnedPoint;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public int getPassedBuildingTime() {
        return passedBuildingTime;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public void damage(Integer amount) {
        if (health <= amount) {
            health = 0;
        }
        else
            health -= amount;
    }

    //faqat vaghti available nis in method call mishe:
    //******bad az har passed time baraye building age available esh true shode bud builder free mishe
    public void passedTime() {
        if (passedBuildingTime < buildOrUpgradeTime) {
            passedBuildingTime++;
        }
        else
        {
            if(upgrading) {
                level++;
                upgrading = false;
                imageShouldBeChanged(true);
            }
             available = true;
             passedBuildingTime = 0;
        }
    }

    //age upgrade time sefr bashe too oon delta t gheyre faale bazam
    public void upgrade()
    {
        available = false;
        upgrading = true;
    }

    public void setRuined(boolean ruined) {
        this.ruined = ruined;
    }

    public boolean isRuined() {
        return ruined;
    }

    public Integer getLastHealth() {
        return lastHealth;
    }

    public void setLastHealth(int lastHealth) {
        this.lastHealth = lastHealth;
    }


}
