package building;

public class GoldMine extends Mine {

    public GoldMine(int x, int y) {
        super(x, y, BuildingConstants.GOLD_MINE_BUILD_TIME, BuildingConstants.GOLD_MINE_GOLD_COST,
                BuildingConstants.GOLD_MINE_ELIXIR_COST, BuildingConstants.GOLD_MINE_JSON_TYPE_CODE, BuildingConstants.GOLD_MINE_EXTRACT_PER_DELTA_T, "gold mine");
    }
}
