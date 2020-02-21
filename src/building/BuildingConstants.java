package building;
/*
1.STABILITY
2.BUILDTIME
3.GOLDCOST
4.ELIXIRCOST
5.TYPE
6.DISTRUCTIONEARNEDPOINT

 */
public class BuildingConstants {

    public static final Integer UPGRADE_COST = 100;
    //MINE
    public static final Integer MINE_STABILITY = 200;
    public static final Integer MINE_DISTRUCTION_EARNED_POINT = 2;

    public static final Integer GOLD_MINE_JSON_TYPE_CODE = 1;
    public static final Integer GOLD_MINE_GOLD_COST = 150;
    public static final Integer GOLD_MINE_ELIXIR_COST = 5;
    public static final Integer GOLD_MINE_BUILD_TIME = 100;
    public static final Integer GOLD_MINE_EXTRACT_PER_DELTA_T = 10;

    public static final Integer ELIXIR_MINE_JSON_TYPE_CODE = 2;
    public static final Integer ELIXIR_MINE_GOLD_COST = 100;
    public static final Integer ELIXIR_MINE_ELIXIR_COST = 3;
    public static final Integer ELIXIR_MINE_BUILD_TIME = 100;
    public static final Integer ELIXIR_MINE_EXTRACT_PER_DELTA_T = 5;

    //storage
    public static final Integer STORAGE_STABILITY = 300;
    public static final Integer STORAGE_DISTRUCTION_EARNED_POINT = 3;
    public static final Integer STORAGE_GOLD_COST = 200;
    public static final Integer STORAGE_ELIXIR_COST = 0;

    public static final Integer GOLD_STORAGE_BUILD_TIME = 100;
    public static final Integer GOLD_STORAGE_JSON_TYPE_CODE = 3;
    public static final Integer GOLD_STORAGE_CAPACITY = 20000;

    public static final Integer ELIXIR_STORAGE_BUILD_TIME = 100;
    public static final Integer ELIXIR_STORAGE_JSON_TYPE_CODE = 4;
    public static final Integer ELIXIR_STORAGE_CAPACITY = 1000;

    //townhall
    public static final Integer TOWNHALL_JSON_TYPE_CODE = 5;
    public static final Integer TOWNHALL_GOLD_COST = 200;
    public static final Integer TOWNHALL_ELIXIR_COST = 0;
    public static final Integer TOWNHALL_BUILD_TIME = 100;
    public static final Integer TOWNHALL_STABILITY = 1000;
    public static final Integer TOWNHALL_DISTRUCTION_EARNED_POINT = 8;
    public static final Integer TOWNHALL_GOLD_CAPACITY = 10000;
    public static final Integer TOWNHALL_ELIXIR_CAPACITY = 5000;
    public static final Integer TOWNHALL_UPGRADE_GOLD_COST = 500;

    public static final Integer MAX_NUMBER_OF_BUILDERS = 4;

    //wall
    public static final Integer WALL_JSON_TYPE_CODE = 12;
    public static final Integer WALL_GOLD_COST = 100;
    public static final Integer WALL_ELIXIR_COST = 0;
    public static final Integer WALL_BUILD_TIME = 20;
    public static final Integer WALL_STABILITY = 100;
    public static final Integer WALL_DISTRUCTION_EARNED_POINT = 1;
    //barracks
    public static int barracksStability=300;
    public static int barracksBuildTime=100;
    public static int barracksGoldCost=200;
    public static int barracksElixirCost=0;
    public static int barracksType=6;
    public static int barracksDistructionEarnedPoint=1;

    //Camp
    public static int campStability=900;
    public static int campBuildTime=100;
    public static int campGoldCost=200;
    public static int campElixirCost=0;
    public static int campType=7;
    public static int campDistructionEarnedPoint=1;

    public static int getCampCapacity() {
        return campCapacity;
    }

    public static void setCampCapacity(int campCapacity) {
        BuildingConstants.campCapacity = campCapacity;
    }

    public static int campCapacity=50;

}
