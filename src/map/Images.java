package map;

import javafx.scene.image.Image;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;

public class Images {
    static final int RESOURCE_IMAGEVIEW_X = (Constants.MAP_WIDTH - 1) * Constants.CELL_WIDTH - Constants.CELL_WIDTH / 2;
    static final String ADDRESS = "src/photos/";
    //every buildings except wall and townhall
    private static ArrayList<String> buildings = new ArrayList<>(Arrays.asList("AirDefense", "ArcherTower", "Barracks", "Camp", "Cannon",
            "ElixirMine", "ElixirStorage", "GoldMine", "GoldStorage", "GiantCastle", "Trap", "WizardTower"));
    private static ArrayList<Direction> directions = new ArrayList<>(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.UP, Direction.DOWN));

    private static Image emptyImage;
    //zero for ruined building
    private static HashMap<Integer, Image> levelImageAirDefense = new HashMap<>();
    private static HashMap<Integer, Image> levelImageArcherTower = new HashMap<>();
    private static HashMap<Integer, Image> levelImageBarracks = new HashMap<>();
    private static HashMap<Integer, Image> levelImageCamp = new HashMap<>();
    private static HashMap<Integer, Image> levelImageCannon = new HashMap<>();
    private static HashMap<Integer, Image> levelImageElixirMine = new HashMap<>();
    private static HashMap<Integer, Image> levelImageElixirStorage = new HashMap<>();
    private static HashMap<Integer, Image> levelImageGiantCastle = new HashMap<>();
    private static HashMap<Integer, Image> levelImageGoldMine = new HashMap<>();
    private static HashMap<Integer, Image> levelImageGoldStorage = new HashMap<>();
    private static HashMap<Integer, Image> levelImageTrap = new HashMap<>();
    private static HashMap<Integer, Image> levelImageWizardTower = new HashMap<>();

    private static HashMap<Integer, ArrayList<Image>> levelImageTownHall = new HashMap<>();

    private static HashMap<String, Image> directionImageWall = new HashMap<>();
    //just for ruined walls
    private static HashMap<Integer, Image> levelImageWall = new HashMap<>();

    private static EnumMap<Direction, Image> directionImageArcher = new EnumMap<>(Direction.class);
    private static EnumMap<Direction, Image> directionImageWizard = new EnumMap<>(Direction.class);

    static {
        try {
            emptyImage = new Image(new FileInputStream(new File(Images.ADDRESS + "empty.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        addBuildingsImages();
        addDefenseSoldiersImages();
        addTownHallImages();
    }

    private static void addBuildingsImages()
    {
        InputStream inputStream = null;
        for (String buildingsName : buildings) {
            try {
                Method add = Images.class.getMethod("addLevelImage" + buildingsName, Integer.class, Image.class);
                for (int level = 0; level <= 10; level++) {
                    inputStream = new FileInputStream(new File(ADDRESS + buildingsName + "_" + level + ".png"));
                    add.invoke(Images.class, level, new Image(inputStream));
                }

                for (int direction = 0; direction < 16; direction++) {
                    inputStream = new FileInputStream(new File(ADDRESS + "wall_" + getBinaryString(direction) + ".png"));
                    directionImageWall.put(getBinaryString(direction),new Image(inputStream));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void addTownHallImages()
    {
        InputStream inputStream = null;
        for (int level = 0; level <= 10; level++) {
            ArrayList<Image> images = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                try {
                    inputStream = new FileInputStream(new File(ADDRESS + "TownHall_" + level + "_" + i + ".png"));
                    images.add(new Image(inputStream));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            levelImageTownHall.put(level, images);
        }
    }

    private static void addDefenseSoldiersImages()
    {
        for (Direction direction : directions) {
            try {
                InputStream archerInputStream = new FileInputStream(new File(ADDRESS  + "Archer_" + direction.name() + ".png"));
                directionImageArcher.put(direction, new Image(archerInputStream));
                InputStream wizardInputStream = new FileInputStream(new File(ADDRESS  + "Wizard_" + direction.name() + ".png"));
                directionImageWizard.put(direction, new Image(wizardInputStream));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getBinaryString(int number)
    {
        if (number == 0)
            return "0000";
        String binaryStr = new String();
        for (int i = 8; i > 0; i/=2) {
            if (number / i == 0)
                binaryStr+="0";
            else break;
        }
        return binaryStr+Integer.toBinaryString(number);
    }

    public static void addLevelImageAirDefense(Integer level, Image image) {
        levelImageAirDefense.put(level, image);
    }

    public static void addLevelImageArcherTower(Integer level, Image image) {
        levelImageArcherTower.put(level, image);
    }

    public static void addLevelImageBarracks(Integer level, Image image) {
        levelImageBarracks.put(level, image);
    }

    public static void addLevelImageCamp(Integer level, Image image) {
        levelImageCamp.put(level, image);
    }

    public static void addLevelImageCannon(Integer level, Image image) {
        levelImageCannon.put(level, image);
    }

    public static void addLevelImageElixirMine(Integer level, Image image) {
        levelImageElixirMine.put(level, image);
    }

    public static void addLevelImageElixirStorage(Integer level, Image image) {
        levelImageElixirStorage.put(level, image);
    }

    public static void addLevelImageGiantCastle(Integer level, Image image) {
        levelImageGiantCastle.put(level, image);
    }

    public static void addLevelImageGoldMine(Integer level, Image image) {
        levelImageGoldMine.put(level, image);
    }

    public static void addLevelImageGoldStorage(Integer level, Image image) {
        levelImageGoldStorage.put(level, image);
    }

    public static void addLevelImageTrap(Integer level, Image image) {
        levelImageTrap.put(level, image);
    }

    public static void addLevelImageWizardTower(Integer level, Image image) {
        levelImageWizardTower.put(level, image);
    }

    public static HashMap<Integer, Image> getLevelImageAirDefense() {
        return levelImageAirDefense;
    }

    public static HashMap<Integer, Image> getLevelImageArcherTower() {
        return levelImageArcherTower;
    }

    public static HashMap<Integer, Image> getLevelImageBarracks() {
        return levelImageBarracks;
    }

    public static HashMap<Integer, Image> getLevelImageCamp() {
        return levelImageCamp;
    }

    public static HashMap<Integer, Image> getLevelImageCannon() {
        return levelImageCannon;
    }

    public static HashMap<Integer, Image> getLevelImageElixirMine() {
        return levelImageElixirMine;
    }

    public static HashMap<Integer, Image> getLevelImageElixirStorage() {
        return levelImageElixirStorage;
    }

    public static HashMap<Integer, Image> getLevelImageGiantCastle() {
        return levelImageGiantCastle;
    }

    public static HashMap<Integer, Image> getLevelImageGoldMine() {
        return levelImageGoldMine;
    }

    public static HashMap<Integer, Image> getLevelImageGoldStorage() {
        return levelImageGoldStorage;
    }

    public static HashMap<Integer, ArrayList<Image>> getLevelImageTownHall() {
        return levelImageTownHall;
    }

    public static HashMap<Integer, Image> getLevelImageTrap() {
        return levelImageTrap;
    }

    public static HashMap<Integer, Image> getLevelImageWizardTower() {
        return levelImageWizardTower;
    }

    public static HashMap<String, Image> getDirectionImageWall() {
        return directionImageWall;
    }

    public static HashMap<Integer, Image> getLevelImageWall() {
        return levelImageWall;
    }

    public static EnumMap<Direction, Image> getDirectionImageArcher() {
        return directionImageArcher;
    }

    public static EnumMap<Direction, Image> getDirectionImageWizard() {
        return directionImageWizard;
    }

    public static Image getEmptyImage() {
        return emptyImage;
    }
}
