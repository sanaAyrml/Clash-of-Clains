package map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import static map.Constants.MAP_WIDTH;
public class MapGUI {
    private ArrayList<ImageView> map = new ArrayList<>();

    MapGUI() {
        for (int i = 0; i < MAP_WIDTH * Constants.MAP_HEGHT; i++) {
            ImageView imageView = new ImageView(Images.getEmptyImage());
            imageView.setX((i % MAP_WIDTH) * Constants.CELL_WIDTH);
            imageView.setY((i / MAP_WIDTH) * Constants.CELL_HEIGHT);
            map.add(imageView);
        }
    }

    public ArrayList<ImageView> getMap() {
        return map;
    }

    public void updateImage(int cellNum, Image image)
    {
        map.get(cellNum).setImage(image);
    }
}
