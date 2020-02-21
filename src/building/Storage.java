package building;

public abstract class Storage extends Building{
    private Integer capacity;
    private Integer resource=0;

    public Storage(int x, int y, Integer buildTime, Integer type, Integer capacity, String name) {

        super(x, y, BuildingConstants.STORAGE_STABILITY, buildTime, BuildingConstants.STORAGE_GOLD_COST,
                BuildingConstants.STORAGE_ELIXIR_COST, type, BuildingConstants.STORAGE_DISTRUCTION_EARNED_POINT, name);
        this.capacity = capacity;
    }
    public Integer getCapacity() {
        return capacity;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(int resource){
        this.resource = resource;
    }

    @Override
    public void upgrade()
    {
        super.upgrade();
        capacity = capacity + capacity * 16 / 10;
    }

    public void fillStorage(int amount)
    {
            resource += amount;
    }

    public void spend(int amount)
    {
        resource -= amount;
    }

    public int getFreeSpace()
    {
        return capacity - resource;
    }
}
