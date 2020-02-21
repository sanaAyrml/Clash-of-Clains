package building;

import Exceptions.DontHaveAnyBuilderExp;
import java.util.ArrayList;

//bad az har hamle baghimandeye emtiaz be 5 gerefte mishe be onvane levele townhall set mishe
public class TownHall extends Building{
    private ArrayList<Builder> builders = new ArrayList<>();
    private Integer goldCapacity;
    private Integer elixirCapacity;
    private Integer gold = 0;
    private Integer elixir = 0;


    public TownHall(int x, int y) {
        super(x , y, BuildingConstants.TOWNHALL_STABILITY, BuildingConstants.TOWNHALL_BUILD_TIME, BuildingConstants.TOWNHALL_GOLD_COST,
                BuildingConstants.TOWNHALL_ELIXIR_COST, BuildingConstants.TOWNHALL_JSON_TYPE_CODE, BuildingConstants.TOWNHALL_DISTRUCTION_EARNED_POINT, "main building");
        setUpgradeGoldCost(BuildingConstants.TOWNHALL_UPGRADE_GOLD_COST);
        goldCapacity = BuildingConstants.TOWNHALL_GOLD_CAPACITY;
        elixirCapacity = BuildingConstants.TOWNHALL_ELIXIR_CAPACITY;
        builders.add(new Builder());
    }

    //az inja ta khate 60 mishe too khode controlleram mostaghim zad
    public Integer getGold() {
        return gold;
    }

    public Integer getElixir() {
        return elixir;
    }

    public void fillGoldStorage(int amount)
    {
        gold += amount;
    }

    public void fillElixirStorage(int amount)
    {
        elixir += amount;
    }

    public ArrayList<Builder> getBuilders() {
        return builders;
    }

    public Integer getGoldCapacity() {
        return goldCapacity;
    }

    public Integer getElixirCapacity() {
        return elixirCapacity;
    }

    public void spendGold(int amount)
    {
        gold -= amount;
    }

    public void spendElixir(int amount)
    {
        elixir -= amount;
    }

    public void upgrade()
    {
            super.upgrade();
            setStability(getStability() + 500);
            setHealth(getStability());
            if ((getLevel() / 3) + 1 > builders.size() && builders.size() < BuildingConstants.MAX_NUMBER_OF_BUILDERS)
                builders.add(new Builder());
    }

    //baraye upgrade ya build tooye if call mishe va dakhele if upgrade ya build mishe
    public boolean isFreeBuilder() throws DontHaveAnyBuilderExp
    {
        for (Builder builder : builders)
            if (builder.isFree())
            {
                return true;
            }
        return false;
    }

    public void makeABuilderWork() throws DontHaveAnyBuilderExp
    {
        for (Builder builder : builders)
            if (builder.isFree())
            {
                builder.setFree(false);
                return;
            }
        throw new DontHaveAnyBuilderExp();
    }

    public void setABuilderFree()
    {
        for (Builder builder : builders)
            if (!builder.isFree())
            {
                builder.setFree(true);
                return;
            }
    }

}
