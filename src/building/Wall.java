package building;

public class Wall extends Building{
    private boolean newBuilding = true;
    public Wall(int x, int y) {
        super(x, y, BuildingConstants.WALL_STABILITY, BuildingConstants.WALL_BUILD_TIME, BuildingConstants.WALL_GOLD_COST,
                BuildingConstants.WALL_ELIXIR_COST, BuildingConstants.WALL_JSON_TYPE_CODE, BuildingConstants.WALL_DISTRUCTION_EARNED_POINT, "wall");
    }

    @Override
    public void upgrade()
    {
        super.upgrade();
        setStability(getStability() + 10);
        setHealth(getStability());
    }

    public boolean isNewBuilding() {
        return newBuilding;
    }

    public void setNewBuilding(boolean newBuilding) {
        this.newBuilding = newBuilding;
    }
}
