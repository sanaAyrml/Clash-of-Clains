package building;

public abstract class Mine extends Building{
    private Integer extractPerDeltaT;
    private int storage = 0;
    public Integer getExtractPerDeltaT() {
        return extractPerDeltaT;
    }

    public Mine(int x, int y, Integer buildTime, Integer goldCost, Integer elixirCost, Integer type, Integer extractPerDeltaT, String name) {
        super(x, y, BuildingConstants.MINE_STABILITY, buildTime, goldCost, elixirCost,
                type, BuildingConstants.MINE_DISTRUCTION_EARNED_POINT, name);
        this.extractPerDeltaT = extractPerDeltaT;
    }

    @Override
    public void upgrade()
    {
        super.upgrade();
        extractPerDeltaT = extractPerDeltaT * 16 / 10;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void mine()
    {
        if (storage <= 1000)
        storage += extractPerDeltaT;
    }

    public int getStorage() {
        return storage;
    }
}
