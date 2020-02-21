package building;

public class ElixirMine extends Mine{

    public ElixirMine(int x, int y) {
        super(x, y, BuildingConstants.ELIXIR_MINE_BUILD_TIME, BuildingConstants.ELIXIR_MINE_GOLD_COST,
                BuildingConstants.ELIXIR_MINE_ELIXIR_COST, BuildingConstants.ELIXIR_MINE_JSON_TYPE_CODE, BuildingConstants.ELIXIR_MINE_EXTRACT_PER_DELTA_T, "elixir mine");
    }

}
