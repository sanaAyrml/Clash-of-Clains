package building;

public class GoldStorage extends Storage{

    public GoldStorage(int x, int y) {
        super(x, y , BuildingConstants.GOLD_STORAGE_BUILD_TIME, BuildingConstants.GOLD_STORAGE_JSON_TYPE_CODE,
                BuildingConstants.GOLD_STORAGE_CAPACITY, "gold storage");
    }

}
